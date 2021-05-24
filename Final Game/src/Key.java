import info.gridworld.actor.*;

import info.gridworld.grid.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Key extends Actor
{
	
	int n = 0;
	
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
	public Key(Color color)
	{
		this.setColor(color);
		play("SM64Key.wav");
	}
	
	public void act()
	{
		if (n%2 != 0) {
			this.setColor(Color.CYAN);
		n++;
		}
		else {
			n++;
			this.setColor(Color.YELLOW);
		}
	}
}
