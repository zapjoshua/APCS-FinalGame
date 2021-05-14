import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class Game
{
    public static void main(String[] args)
    {
    	BoundedGrid grid = new BoundedGrid(20, 20);
        ActorWorld world = new ActorWorld();
        world.setGrid(grid);
        world.show();
    }
}
