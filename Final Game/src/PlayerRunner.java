import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import info.gridworld.actor.*;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.*;

public class PlayerRunner extends Actor
{
   public static ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20, 20));
   
   public static void main(String[] args) 
   {
	   //Hiding unimportant things and changing name from GridWorld to Rat Game
       System.setProperty("info.gridworld.gui.selection", "hide");
       System.setProperty("info.gridworld.gui.tooltips", "hide");
       System.setProperty("info.gridworld.gui.frametitle", "The Game");
       
       //Test Popup for fighting sequence
       JFrame text = new JFrame();

       //Adding Rat to the world
	   Player r = new Player();
	   world.add(new Location(10,10),r);
	   world.add(new Location (5,5),new Rock());
       world.show();
       
       //Keyboard inputs
       java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher() 
       {
    	   public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) 
    	   {
    		   String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
    		   //up
    		   if (key.equals("pressed W"))
    			   r.moveTo(r.getLocation().getAdjacentLocation(0));
    		   //down
    		   if (key.equals("pressed D"))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.EAST));
    		   //left
    		   if (key.equals("pressed S"))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.SOUTH));
    		   //right
    		   if (key.equals("pressed A"))
    			   r.moveTo(r.getLocation().getAdjacentLocation(Location.WEST));
    		   //pick up
    		   if (key.equals("pressed E"))
    			   JOptionPane.showMessageDialog(text, "You grabbed an item");
    		   //fight
    		   if (key.equals("pressed F"))
    			   JOptionPane.showMessageDialog(text, "FIGHT");
    		   world.show();
    		   return true;
    	   }
       });
       
       //Shows message above game window
       world.setMessage("Its Gaming Time");      
       world.show();
    }
}
