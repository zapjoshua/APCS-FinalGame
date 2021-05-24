import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class LockDoor extends Door
{
	private boolean lock;
	public int numKeys = 0;
	
	public LockDoor()
	{
		lock = true;
	}
	
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
	public void Lock()
	{
		if (numKeys != 3)
		{
			if(open == false)
			{
				lock = true;
				play("DoorLock.wav");
			}
			else
				System.out.print("You don't have all the keys!");
		}
	}
	
	public void UnLock()
	{
		if (numKeys >= 3)
		{
			if(lock = true)
			{
				lock = false;
				open = true;
				play("DoorLock.wav");
			}
			else
				System.out.print("You have already gathered all the keys!");
			
		}
	}	
}
