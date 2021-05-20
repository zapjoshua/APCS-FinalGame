
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class Boss extends Actor
{
	public void turn() {
		int count = 0;
		count ++;
		if (count %10 == 0)
			setDirection(getDirection() + Location.RIGHT);
		else
			setDirection(getDirection() + Location.HALF_RIGHT);
	}
}
