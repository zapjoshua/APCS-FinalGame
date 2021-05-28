import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game extends Actor
{
   private static BoundedGrid<Actor> grid = new BoundedGrid<Actor>(20, 20);
   private static ActorWorld world = new ActorWorld(grid);
   private static Entity playerEntity = new Entity(10, 2, 1, "Player", "./PlayerBattle.gif");
   private static boolean inBattle = false;
   private static LockDoor door = new LockDoor();
   private static Vent v1 = new Vent();
   private static Vent v2 = new Vent();
   private static Player r = new Player();
   
   public static void play(String filename)
	{
	    try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
   
   public static void main(String[] args) 
   {
	   int num = 0;
	   Color[] colors = {Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.WHITE};
	   //Hiding unimportant things and changing name from GridWorld to The Game
       System.setProperty("info.gridworld.gui.selection", "hide");
       System.setProperty("info.gridworld.gui.tooltips", "hide");
       System.setProperty("info.gridworld.gui.frametitle", "The Game");
  
       //Adding Rat to the world
       AmongUs a = new AmongUs();
	   Dog d = new Dog();
	   Rat rat = new Rat();
	   Rat rat2 = new Rat();
	   Rat rat3 = new Rat();
	   Tree alice=new Tree(6);
	   world.add(new Location(10,10),r);
	   world.add(new Location(15,15), a);
	   world.add(new Location(5,5), d);
	   world.add(new Location(3,7), rat);
	   world.add(new Location(17,8), rat2);
	   world.add(new Location(11,16), rat3);
	   world.add(new Location(2,5), alice);
	   world.add(new Location(16, 10), door);
		for(int x = 0; x < 20; x++)
		{
			num = (int)(Math.random() * 3) + 1;
			world.add(new Location(0, x),new Rock(colors[num]));
		}
		for(int x = 0; x < 20; x++)
		{
			num = (int)(Math.random() * 3) + 1;
			world.add(new Location(19, x),new Rock(colors[num]));
		}
		for(int x = 0; x < 6; x++)
		{
			num = (int)(Math.random() * 3) + 1;
			Boulder b = new Boulder(colors[num]);
			int row = (int)(Math.random() * 20);
			int col = (int)(Math.random() * 20);
			b.placeBoulder(grid, row, col);
		}
		world.add(v1);
		world.add(v2);
       world.show();
       
       //Keyboard inputs
       java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() 
       {
    	   public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) 
    	   {
    		   String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
    		   //up
    		   if (key.equals("pressed W"))
    			   if(canMove(r.getLocation().getAdjacentLocation(0)))
    				   r.moveTo(r.getLocation().getAdjacentLocation(0));
    		   //down
    		   if (key.equals("pressed D"))
    			   if(canMove(r.getLocation().getAdjacentLocation(Location.EAST)))
    				   r.moveTo(r.getLocation().getAdjacentLocation(Location.EAST));
    		   //left
    		   if (key.equals("pressed S"))
    			   if(canMove(r.getLocation().getAdjacentLocation(Location.SOUTH)))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.SOUTH));
    		   //right
    		   if (key.equals("pressed A"))
    			   if(canMove(r.getLocation().getAdjacentLocation(Location.WEST)))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.WEST));
    		   world.show();
    		   return true;
    	   }
       });
       
       //Shows message above game window
       world.setMessage("Its Gaming Time\n" + "You have " + door.numKeys + " / 3 keys.");      
       world.show();
    }
   public static boolean canMove(Location loc) { //function for checking if the next space is valid
	   if(!grid.isValid(loc))
		   return false;
	   
	   checkCollision(loc);
	   
	   if(inBattle) {
		   return false;
	   }
	   
	   Actor thing = grid.get(loc); //gets whatever actor is at the location
	   
	   if(door.open && thing instanceof LockDoor) {
		   thing.removeSelfFromGrid();
		   world.add(loc, new Door());
		   return false;
	   }
	   
	   return(!(thing instanceof Rock || thing instanceof Dog || thing instanceof AmongUs || thing instanceof Rat || thing instanceof LockDoor || thing instanceof Vent)); //make sure to add (thing instanceof <what ever new class youre adding>)
   }
   
   public static void checkCollision(Location loc) { //checks for specific entities in the next space
	   Actor thing = grid.get(loc);
	   
	   if(thing instanceof Rat)
	   {
			try {
				inBattle = true;
				new BattleWindow2(playerEntity, new Entity(6, 2, 0, "Rat",  "./ratBattle.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thing.removeSelfFromGrid();
			world.add(loc, new Key(Color.gray)); //are we still doing keys?
	   }
	   
	   if(thing instanceof AmongUs) {
		   System.out.print("when the imposter is sus\n");
		   
		   try {
				inBattle = true;
				new BattleWindow2(playerEntity, new Entity(12, 3, 1, "Amogus",  "./amongUsBattle.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   thing.removeSelfFromGrid();
		   world.add(loc, new Key(Color.red));
	   }
	   if(thing instanceof Key) {
		   door.numKeys += 1;
		   world.setMessage("Its Gaming Time\n" + "You have " + door.numKeys + " / 3 keys.");
	   }
	   if(thing instanceof LockDoor) {
		   door.UnLock();
	   }
	   if(thing instanceof Door && door.open) {
		   //the game ends
		   JOptionPane.showMessageDialog(new JFrame(), "The game is over. Win $1.");
		   System.exit(0);
	   }
	   if(thing instanceof Tree) { //tree heal hp yes
		   playerEntity.healHP(10);
	   }
	   if(thing instanceof Vent)
	   {
		   if(thing.getLocation() == v1.getLocation())
		   {
			   if(grid.isValid(v2.teleportLoc(r.getLocation(), v1.getLocation())))
				   r.moveTo(v2.teleportLoc(r.getLocation(), v1.getLocation()));
		   }
		   else
		   {
			   if(grid.isValid(v1.teleportLoc(r.getLocation(), v2.getLocation())))
				   r.moveTo(v1.teleportLoc(r.getLocation(), v2.getLocation()));
		   }
	   }
   }
   
   public static void endBattle() {
	   inBattle = false;
   }
}
