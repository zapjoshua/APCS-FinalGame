

import info.gridworld.actor.*;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Dog extends Actor
{
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
	public Dog()
	{
		setColor(null);
		play("DogPant.wav");
	}
	public void act()
	{
		turn();
	}
	
	private void turn() {
		int count = 0;
		count ++;
		if (count %10 == 0)
			setDirection(getDirection() + Location.RIGHT);
		else
			setDirection(getDirection() + Location.HALF_RIGHT);
	}
}
