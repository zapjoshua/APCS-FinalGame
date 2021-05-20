import info.gridworld.actor.*;

import info.gridworld.grid.*;
import java.awt.Color;

public class Key extends Actor
{
	
	int n = 0;
	
	public Key(Color color)
	{
		this.setColor(color);
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