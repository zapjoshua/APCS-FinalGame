

import info.gridworld.actor.*;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class AmongUs extends Actor
{
	public AmongUs()
	{
		setColor(null);
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