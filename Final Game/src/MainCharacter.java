import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import com.sun.prism.Image;

public class MainCharacter extends Entity
{
	
	public MainCharacter(int totH, int a, int d) {
		super(totH, a, d);
		// TODO Auto-generated constructor stub
	}

	
	//i have no clue if this is gonna work once we get a window and a basic graphic set up but its a compile of what ive seen online and a change of data to better reflect what we wanna do 
	
	
	private int dx;
    private int dy;
    private int x = 40;
    private int y = 60;
    private int w;
    private int h;
    private java.awt.Image image;

    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("rat.png");
        image = ii.getImage(); 
        
        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {
        
        x += dx;
        y += dy;
    }

    public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public java.awt.Image getImage() {
        
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = -2;
        }

        if (key == KeyEvent.VK_D) {
            dx = 2;
        }

        if (key == KeyEvent.VK_W) {
            dy = -2;
        }

        if (key == KeyEvent.VK_S) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}

