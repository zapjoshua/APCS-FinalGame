import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

//new world, use this instead of actorwold for the grid
public class World2 extends info.gridworld.actor.ActorWorld{
	private String key;
	public World2() {
		super();
	}
	public World2(Grid T) {
		super();
	}
	
	public boolean keyPressed(String s, Location loc) {
		key = s;
		System.out.println(s);
		return true;
	}
	
	public void step() {
		//does nothing
	}
	
	public String setMessage() {
		return "I have no idea what I did";
	}
	public String getKey() {
		return key;
	}
}
