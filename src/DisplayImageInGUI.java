import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayImageInGUI extends JFrame{
	
	public JPanel imageDisplay;
	public JLabel image;
	public ImageIcon dave;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DisplayImageInGUI();

	}
	
	public DisplayImageInGUI(){
		JPanel panel = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();		
		Dimension dim = tk.getScreenSize();
		
		
		//useful to get the size of the screen
		//System.out.println(dim);
		
		this.setSize(350,200);		
		int xPos = (dim.width/2)-(this.getWidth()/2);
		int yPos = 0+(dim.height/2)-(this.getHeight()/2);
		
		this.setLocation(xPos,yPos);
		this.setResizable(true);	
				
		this.setTitle("Image Display");
			
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		
		
		
		
		
		this.add(panel);
		
		try {  
			
			//Some image Stuff with buffered images
			BufferedImage start = ImageIO.read(this.getClass().getResource("beakers.jpg"));
			//Turning Buffered image into image icon and adding it to the JLabel
			dave = new ImageIcon();			
			dave.setImage(start);
			//This sets the size of the gui to the size of the image icon
			this.setSize(dave.getIconWidth(),dave.getIconHeight() +40);
			image = new JLabel();
			image.setIcon(dave);
			System.out.println(start);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panel.add(image);
		
		
		
		
		this.setVisible(true);
		
	}

}
