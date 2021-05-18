package workplsgame;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;

public class BossRunner 
{
	public static void main(String[] args)
	{
		int num = 0;
		BoundedGrid grid = new BoundedGrid<Actor>(13, 14);
		ActorWorld world = new ActorWorld(grid);
		Color[] colors = {Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.WHITE, Color.ORANGE};
		for (int x = 0; x < 2; x++)
		{
			world.add(new Dog());
		}
		world.show();
	}
}
