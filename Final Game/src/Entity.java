import java.awt.Image;

public class Entity 
{

	//basic stats
	private int health;
	private int attack;
	private int defense;
	private Image image;
	
	//constructor for basic stats
	public Entity(int h, int a, int d, Image i)
	{
		health = h;
		attack = a;
		defense = d;
		image = i;
	}
}