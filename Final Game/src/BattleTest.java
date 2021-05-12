import java.util.Scanner;
//currently text based too see if idea of system would even work
public class BattleTest 
{

	public static void main (String[] args)
	{
		Scanner kboard = new Scanner(System.in);
		boolean playerLost = false;
		boolean enemyLost = false;
		boolean playerTurn = true;
		boolean enemyTurn = false;
		String action = "";
		Entity player = new Entity(10, 2, 1);
		Entity enemy = new Entity(6, 1, 0);
		
		System.out.println("A wild Rat has appeared!");
		
		while (playerLost == false || enemyLost == false) //battle loop
		{
			if (player.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0)
			{
				do
				{
					System.out.println(); //block of text for showing player and enemy health pools w/ current health
					System.out.print("Player: " + player.getCurrentHealth() + "/" + player.getTotalHealth() + "     ");
					System.out.print("Enemy: " + enemy.getCurrentHealth() + "/" + enemy.getTotalHealth());
					System.out.println();
					action = kboard.nextLine();
				} while (playerTurn != true);			
			}
			else if (player.getCurrentHealth() <= 0) //trues the boolean for player losing
				playerLost = true;
			else //trues the boolean for enemy losing
				enemyLost = true;
		}
	}
}
