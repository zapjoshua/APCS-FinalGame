import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Vent extends Actor
{
	public Vent()
	{
		setColor(null);
	}
	
	public Location teleportLoc(Location playerLoc, Location ventLoc)
	{
		int vRow = ventLoc.getRow();
		int vCol = ventLoc.getCol();
		int pRow = playerLoc.getRow();
		int pCol = playerLoc.getCol();
		int newRow = this.getLocation().getRow();
		int newCol = this.getLocation().getCol();
		
		if (pRow > vRow)
			newRow -= 1;
		else if (pRow < vRow)
			newRow += 1;
		else if (pCol > vCol)
			newCol -= 1;
		else if (pCol < vCol)
			newCol += 1;
		return new Location(newRow, newCol);
	}
}
