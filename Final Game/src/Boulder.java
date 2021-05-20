import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Boulder extends Rock
{	
	Color color;
	
	public Boulder()
	{
		setColor(null);
		color = null;
	}
	
	public Boulder(Color c)
	{
		setColor(c);
		color = c;
	}
	
	public void placeBoulder(Grid<Actor> gr, int row, int col)
	{
		if(gr.isValid(new Location(row, col)) &&
				gr.isValid(new Location(row, col + 1)) &&
				gr.isValid(new Location(row + 1, col + 1)) &&
				gr.isValid(new Location(row + 1, col)))
		{
			this.putSelfInGrid(gr, new Location(row, col));
			
			Boulder boulderTR = new Boulder(color);
			boulderTR.setDirection(Location.RIGHT);
			boulderTR.putSelfInGrid(gr, new Location(row, col + 1));
			
			Boulder boulderBR = new Boulder(color);
			boulderBR.setDirection(Location.HALF_CIRCLE);
			boulderBR.putSelfInGrid(gr, new Location(row + 1, col + 1));
			
			Boulder boulderBL = new Boulder(color);
			boulderBL.setDirection(Location.LEFT);
			boulderBL.putSelfInGrid(gr, new Location(row + 1, col));
		}
	}
}
