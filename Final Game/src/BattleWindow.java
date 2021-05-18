import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BattleWindow extends JPanel implements ActionListener
{

	protected JButton b1;
	
	public BattleWindow()
	{
		b1 = new JButton("Uhhh Let's go?");
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.TRAILING);
		b1.setMnemonic(KeyEvent.VK_D);
		b1.setActionCommand("disable");
		
		JLabel emptyLabel = new JLabel("HeeHeeXD");
		emptyLabel.setPreferredSize(new Dimension(100, 100));
		add(emptyLabel);
		
		add(b1);
	}
	
	
	public static void main (String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI() 
	{
		JFrame frame = new JFrame("Battle!");
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JLabel emptyLabel = new JLabel("HeeHeeXD");
		//emptyLabel.setPreferredSize(new Dimension(100, 100));
		
		
		BattleWindow newContentPane = new BattleWindow();
		newContentPane.setOpaque(true);
		frame.add(newContentPane);
		
		frame.setResizable(false);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
