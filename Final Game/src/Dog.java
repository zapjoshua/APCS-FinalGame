

import info.gridworld.actor.*;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
