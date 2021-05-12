import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener{
	public Window() {
	
	}
	
	public void actionPerformed(ActionEvent e) {
	    
	    
	}
	
	public static void main(String[] args) {
		JFrame w = new JFrame("The game"); 
	    w.setSize(500, 500); //feel free to change anything btw
	    
	    Container c = w.getContentPane();
	    c.add(new Window()); 

	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setResizable(false);
	    w.setVisible(true);
	    //yeee yeee test
	}
}
