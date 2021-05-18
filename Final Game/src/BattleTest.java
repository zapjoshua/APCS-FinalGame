import java.awt.Image;
import java.util.Scanner;

import javax.swing.ImageIcon;
//currently text based too see if idea of system would even work
public class BattleTest 
{

	public static void main (String[] args)
	{
		Scanner kboard = new Scanner(System.in);
		boolean playerLost = false;
		boolean enemyLost = false;
		Image p = (new ImageIcon("rat.jpg")).getImage();
		Image e = (new ImageIcon("test.jpg")).getImage();
		String action = "";
		Entity player = new Entity(10, 2, 1, p);
		Entity enemy = new Entity(6, 1, 0, e);
		
		System.out.println("A wild Rat has appeared!");
		
		while (playerLost == false && enemyLost == false) //battle loop
		{
			if (player.getCurrentHealth() > 0) //loop will go until player health reaches zero (also checks enemy health later in loop)
			{
					System.out.println(); //block of text for showing player and enemy health pools w/ current health
					System.out.print("Player: " + player.getCurrentHealth() + "/" + player.getTotalHealth() + "     ");
					System.out.println("Enemy: " + enemy.getCurrentHealth() + "/" + enemy.getTotalHealth());
					System.out.println("Your Turn:"); //signifies player's turn begins
					System.out.println("Attack or Defend?");
					System.out.println();
					action = kboard.nextLine();
					if (action.equals("attack")) //choosing to attack
					{
						System.out.println("You attack the enemy, dealing " + player.getAttack() + " damage.");
						enemy.setCurrentHealth(player.getAttack());
					}
					else if (action.equals("defend")) //choosing to defend
					{
						System.out.println("You brace for the enemy attack.");
						playerDefending = true;
					}
					if (enemy.getCurrentHealth() > 0) //make sure the enemy still has hp to attack
					{
						System.out.println(); //block of text for showing player and enemy health pools w/ current health
						System.out.print("Player: " + player.getCurrentHealth() + "/" + player.getTotalHealth() + "     ");
						System.out.println("Enemy: " + enemy.getCurrentHealth() + "/" + enemy.getTotalHealth());
						System.out.println("Enemy Turn:");//signifies the enemy's turn
						System.out.println();
						if (playerDefending == true)
						{
							System.out.println("The enemy attacks you, dealing " + (enemy.getAttack() - player.getDefense()) + " damage");
							player.setCurrentHealth((enemy.getAttack() - player.getDefense()));
							playerDefending = false;
						}
						else
						{
							System.out.println("The enemy attacks you, dealing " +enemy.getAttack() + " damage");
							player.setCurrentHealth(enemy.getAttack());
						}
					}	
					else //when enemy loses its health
					{
						enemyLost = true;
					}
			}
			else if (player.getCurrentHealth() <= 0) //trues the boolean for player losing
				playerLost = true;
				
			else //trues the boolean for enemy losing
				enemyLost = true;					
		}
		if (playerLost == true)//displays victory or loss message
			System.out.println("You lost!");
		else if (enemyLost == true)
			System.out.println("You won!");
		kboard.close();
	}
}
