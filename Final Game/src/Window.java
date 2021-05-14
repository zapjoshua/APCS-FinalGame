import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Dimension;

public class Window {
	public Window(Game g) {
		JFrame w = new JFrame("The game"); 
	    w.setSize(new Dimension(1000, 500)); //feel free to change anything btw
	    
	    w.add(g);
	    w.setResizable(false);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.setLocationRelativeTo(null);
	    w.setVisible(true);
	}
}
