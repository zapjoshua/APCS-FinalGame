
public class PlayerEntity extends Entity
{

	private int currentExp;
	private int neededExp;
	
	public PlayerEntity(int totH, int a, int d, String n, String f) 
	{
		super(totH, a, d, n, f);
		neededExp = 5; //how much exp you need for first level up
	}
	
	public void setExp(int change)
	{
		currentExp += change;
		if (currentExp >= neededExp)
		{
			currentExp -= neededExp;
			neededExp *= 2;
			levelUp();
		}
	}
	
	public void levelUp()
	{
		totalHealth += 2;
		attack += 1;
		defense += 1;
		currentHealth = totalHealth;
	}

}
