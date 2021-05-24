
import info.gridworld.actor.*;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Door extends Actor
{
	
	protected boolean open;
	
	public Door()
	{
		setColor(null);
		open = false;
	}
	
	public void Open()
	{
		open = true; 
	}
	
	public void Close()
	{
		open = false;
	}
}

