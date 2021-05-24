
public class Entity 
{

	//basic stats
	private int totalHealth;
	private int currentHealth;
	private int attack;
	private int defense;
	private String name;
	private String fileName;
	
	//constructor for basic stats
	public Entity(int totH, int a, int d, String n, String f)
	{
		totalHealth = totH;
		currentHealth = totH;
		attack = a;
		defense = d;
		name = n;
		fileName = f;
	}
	
	public void setCurrentHealth(int change)
	{
		if (change < 0)
			change = 0;
		else if (change > currentHealth)
			change = currentHealth;
		currentHealth -= change;
	}
	
	public void healHP(int change) {
		currentHealth += change;
		if(currentHealth > totalHealth) {
			currentHealth = totalHealth;
		}
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
	
	public String getName()
	{
		return name;
	}
	
	public String getFileName()//used for getting image during battle
	{
		return fileName;
	}
}
