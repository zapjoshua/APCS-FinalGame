import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class BattleWindow2 extends JFrame implements ActionListener
{
	private static Entity player; //= new Entity(10, 2, 1, "Player", "./PlayerBattle.gif");
	private static Entity enemy; //= new Entity(6, 2, 0, "Rat",  "./ratBattle.gif");
	private static Game g;
	
	public BattleWindow2(Entity p, Entity e) throws IOException
	{
		player = p;
		enemy = e;
		
		JFrame frame = new JFrame("Battle!");
		JPanel panel = new JPanel();
		frame.getContentPane();
		
		JButton button = new JButton("Attack");
		JButton button2 = new JButton("Defend");
		//Dimension size = button.getPreferredSize();
		//Dimension size2 = button2.getPreferredSize();
		button.setBounds(125,200, 90, 20);
		button2.setBounds(275,200, 90, 20);
		
		//sets images for the battle
		BufferedImage image = ImageIO.read(new File(player.getFileName()));
		BufferedImage image2 = ImageIO.read(new File(enemy.getFileName()));
		JLabel enemyImage = new JLabel(new ImageIcon(image2));
		JLabel playerImage = new JLabel(new ImageIcon(image));
		
		//makes health "bars" for you and enemy
		JLabel ratHealth = new JLabel(showHealth(enemy.getName(),enemy.getCurrentHealth(), enemy.getTotalHealth()));
		JLabel playerHealth = new JLabel(showHealth(player.getName(),player.getCurrentHealth(), player.getTotalHealth()));
		
		//places images and labels in jPanel
		playerImage.setBounds(80, 50, 100, 100);
		enemyImage.setBounds(300, 50, 155, 100);
		ratHealth.setBounds(330, 5, 100, 50);
		playerHealth.setBounds(80, 5, 100, 50);
		
		
		//setups the panel
		panel.setLayout(null);
		panel.add(button);
		panel.add(button2);
		panel.add(playerImage);
		panel.add(enemyImage);
		panel.add(ratHealth);
		panel.add(playerHealth);
		panel.setBackground(Color.LIGHT_GRAY);

		
		//setsup the frame
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.add(panel);
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (enemy.getCurrentHealth() > 0 && player.getCurrentHealth() > 0)
				{
					enemy.setCurrentHealth(player.getAttack());
					ratHealth.setText(showHealth(enemy.getName(),enemy.getCurrentHealth(), enemy.getTotalHealth()));
					if (enemy.getCurrentHealth() > 0)
					{
						player.setCurrentHealth(enemy.getAttack());
						playerHealth.setText(showHealth(player.getName(),player.getCurrentHealth(), player.getTotalHealth()));
						if(player.getCurrentHealth() == 0)
						{
							battleLose(frame);
						}
					}
					else
					{
						battleWin(frame);
					}
				}
				else if (enemy.getCurrentHealth() <= 0)
				{
					battleWin(frame);
				}
				else if (player.getCurrentHealth() <= 0)
				{
					battleLose(frame);
				}
					
				
			}	
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (player.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0)
				{
					player.setCurrentHealth(enemy.getAttack() - player.getDefense());
					playerHealth.setText(showHealth(player.getName(),player.getCurrentHealth(), player.getTotalHealth()));
					if (player.getCurrentHealth() == 0) //check if health reached 0 to display loss message
					{
						battleLose(frame);
					}
				}
				else if (player.getCurrentHealth() == 0)
				{
					battleLose(frame);
				}
				else
				{
					battleWin(frame);
				}
			}
			
		});
			
	}
	
	public static void battleWin(JFrame frame) { //player wins
		play("fatality.wav");
		JOptionPane.showMessageDialog(frame, "You Won!");
		player.setExp(5);
		if (player.checkLevelUp() == true)
			JOptionPane.showMessageDialog(frame, "Level Up!\n+1 Attack\n+1 Defense\n+2 HP\nHealth Restored");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.dispose();
		g.endBattle(); //ignore the yellow underline it works
	}
	
	public static void battleLose(JFrame frame) { //player loses
		play("OOF.wav");
		JOptionPane.showMessageDialog(frame, "GAME OVER: You Lost!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.exit(0);
	}

	public static String showHealth(String name, int cHealth, int totHealth)
	{
		return 	name + ":   " + cHealth + " / " + totHealth;
	}
	
	public static void play(String filename)
	{
	    try
	    {
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(new File(filename)));
		clip.start();
	    }
	    catch (Exception exc)
	    {
		exc.printStackTrace(System.out);
	    }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
