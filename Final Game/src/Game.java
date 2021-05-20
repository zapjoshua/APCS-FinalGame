import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
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
    	World2 w2 = new World2();
    	
    	BoundedGrid grid = new BoundedGrid(20, 20);
        //ActorWorld world = new ActorWorld();
        w2.setGrid(grid);
        w2.show();
    }
}
