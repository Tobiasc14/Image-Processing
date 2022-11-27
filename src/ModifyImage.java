import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModifyImage extends JFrame{
	
	int [] [] pixels; 
	int [] red; 
	int [] green;
	int [] blue;
	Color pixelColor; 
	
	public ModifyImage(String imageTitle){
		
		
		Scanner sc = new Scanner(System.in);
		
		
	
		//This loads the provided image into data that these methods can access
		try{
		Image dave = ImageIO.read(this.getClass().getResource(imageTitle));
		Image original = ImageIO.read(this.getClass().getResource(imageTitle));
		BufferedImage image =  (BufferedImage) dave;
		pixels = new int [image.getWidth()][image.getHeight()];
		red = new int [(image.getWidth()*image.getHeight())];
		green = new int [(image.getWidth()*image.getHeight())];
		blue = new int [(image.getWidth()*image.getHeight())];
		
		
		//This is where I put the methods which can actually modify the image
		image = invertColor(image);	
		//image = grayScale(image);
		//image = RGBGBR(image);
		//image = randomColorShift(image);
		//image = randomColorRotation(image);
		
		//This is how you can save whatever image you just made to the computer
		//ImageIO.write(image, "png", new File( "C:/Users/Tobias/Pictures/Made By Java","RGBGBR " + imageTitle));
	//This is COOOL!!!!!!!
		
		//This displays what has just happened
		JPanel panel = new JPanel();
		JLabel image1;
		JLabel image2;
		Toolkit tk = Toolkit.getDefaultToolkit();		
		Dimension dim = tk.getScreenSize();
	
		
		//useful to get the size of the screen
		//System.out.println(dim);
		
		//this.setSize(image.getWidth()*2+55,image.getHeight()+60);		
		int xPos = (dim.width/2)-(this.getWidth()/2);
		int yPos = 0+(dim.height/2)-(this.getHeight()/2);
		
		this.setLocation(xPos,yPos);
		this.setResizable(true);	
				
		this.setTitle("Image Display");
			
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		
		//image = new JLabel(getScreenshot());
		
		//System.out.println(Arrays.deepToString(pixels));
		//System.out.println(image);
		//System.out.println("Width " +  pixels.length + ", Height " +  pixels[0].length);
		
		image1 = new JLabel(new ImageIcon(original));
		image2 = new JLabel(new ImageIcon(image));
		
		
		panel.add(image1);
		panel.add(image2);
		
		
		
		
		this.add(panel);
		
		this.setVisible(true);
		
		
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public BufferedImage grayScale(BufferedImage image){
		int i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				
				pixels[x][y] = image.getRGB(x, y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
			}
		}
		System.out.println("First Loop Finished");
		i = 0;
		int avgRGB;
		
		for (int y=0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				avgRGB = (red[i]+green[i]+blue[i])/3;
				red[i] = avgRGB;
				green[i] = avgRGB;
				blue[i] = avgRGB;
				Color color = new Color(red[i], green[i], blue[i]);
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
	}
	
	public BufferedImage invertColor(BufferedImage image){
		//Colect image data from each pixel
		int i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				pixels[x][y] = image.getRGB(x, y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
			}
		}
		System.out.println("First Loop Finished");
		i = 0;
		
		//inverting the colors	
		
		for (int y=0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				red[i] = 255-red[i];
				green[i] = 255-green[i];
				blue[i] = 255-blue[i];
				Color color = new Color(red[i], green[i], blue[i]);
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
	}
	
	public BufferedImage RGBGBR(BufferedImage image){
		int i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				pixels[x][y] = image.getRGB(x, y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
			}
		}
		System.out.println("First Loop Finished");
		i = 0;
		
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
							
				Color color = new Color(green[i],blue[i],red[i]);
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
	}
	public BufferedImage RGBBRG(BufferedImage image){
		int i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				pixels[x][y] = image.getRGB(x, y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
			}
		}
		System.out.println("First Loop Finished");
		i = 0;
		
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
							
				Color color = new Color(blue[i],red[i],green[i]);
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
	}
	public BufferedImage RGBBGR(BufferedImage image){
		int i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				pixels[x][y] = image.getRGB(x, y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
			}
		}
		System.out.println("First Loop Finished");
		i = 0;
		
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
							
				Color color = new Color(blue[i],green[i],red[i]);
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
	}
	public BufferedImage RGBGRB(BufferedImage image){
		int i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				pixels[x][y] = image.getRGB(x, y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
			}
		}
		System.out.println("First Loop Finished");
		i = 0;
		
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
							
				Color color = new Color(green[i],red[i],blue[i]);
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
	}
	public BufferedImage RGBRBG(BufferedImage image){
		int i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				pixels[x][y] = image.getRGB(x, y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
			}
		}
		System.out.println("First Loop Finished");
		i = 0;
		
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
							
				Color color = new Color(red[i],blue[i],green[i]);
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
	}
	public BufferedImage randomColorShift(BufferedImage image){
		int i = 0;
		for (int y =0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				pixels[x][y] = image.getRGB(x,y);
				pixelColor = new Color(pixels[x][y]);
				red[i] = pixelColor.getRed();
				green[i] = pixelColor.getGreen();
				blue[i] = pixelColor.getBlue();
				i++;
				
			}
		}
		i=0;
		int shiftRed = (int) (120*Math.random());
		int shiftGreen = (int) (120*Math.random());
		int shiftBlue = (int) (120*Math.random());
		for (i = 0; i < red.length; i++){
			if (red[i] - shiftRed <= 0){
				red[i] = red[i]+shiftRed;
			}
			else if (red[i] + shiftRed >=255){
				red[i] = red[i]-shiftRed;
			}
			else{
				if (shiftRed%2==0){
					red[i] = red[i]+shiftRed;
				}
				else {
					red[i] = red[i]-shiftRed;
				}
			}
			if (green[i] - shiftGreen < 0){
				green[i] = green[i]+shiftGreen;
			}
			else if (green[i] + shiftGreen >255){
				green[i] = green[i]-shiftGreen;
			}
			else{
				if (shiftGreen%2==0){
					green[i] = green[i]+shiftGreen;
				}
				else {
					green[i] = green[i]-shiftGreen;
				}
			}
			if (blue[i] - shiftBlue < 0){
				red[i] = red[i]+shiftRed;
			}
			else if (blue[i] + shiftBlue >255){
				blue[i] = blue[i]-shiftBlue;
			}
			else{
				if (shiftBlue%2==0){
					blue[i] = blue[i]+shiftBlue;
				}
				else {
					blue[i] = blue[i]-shiftBlue;
				}
			}
			if (red[i] > 255){
				red[i] = 255;
			}
			if (green[i] > 255){
				green[i] = 255;
			}
			if (blue[i] > 255){
				blue[i] = 255;
			}
		}
		i = 0;
		for (int y = 0; y < image.getHeight(); y++){
			for (int x = 0; x < image.getWidth(); x++){
				Color color = new Color(red[i],green[i],blue[i]);				
				image.setRGB(x, y, color.getRGB());
				i++;
			}
		}
		System.out.println("Second Loop Finished");
		return image;
		
	}
	public BufferedImage randomColorRotation(BufferedImage image){
		int choice = (int) (5*Math.random());
		if (choice == 0){
			return RGBBRG(image);
		}
		if (choice == 1){
			return RGBBGR(image);
		}
		if (choice == 2){
			return RGBGRB(image);
		}
		if (choice == 3){
			return RGBGBR(image);
		}
		return RGBRBG(image);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ModifyImage pic = new ModifyImage("smallWaterfall.png");
		
		

	}

}
