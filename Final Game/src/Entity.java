import java.awt.Image;

public class Entity 
{

	//basic stats
	private int totalHealth;
	private int currentHealth;
	private int attack;
	private int defense;
	private Image image;
	
	//constructor for basic stats
	public Entity(int totH, int a, int d, Image i)
	{
		totalHealth = totH;
		currentHealth = totH;
		attack = a;
		defense = d;
		image = i;
	}
	
	public int setCurrentHealth(int change)
	{
		return currentHealth -= change;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
	public int getTotalHealth()
	{
		return totalHealth;
	}
}