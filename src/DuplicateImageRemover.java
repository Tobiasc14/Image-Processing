import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class DuplicateImageRemover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Made a temporary desktop folder so original images are safe from accidental deletion
		//Accessing that temporary directory and making array containing all files within
		File baseFilePath = new File("C:/Users/hjctj/Desktop/JavaPictureComparer");
		File[] listOfFiles = baseFilePath.listFiles();
		//Some variables for printing progress metrics:
		int total = listOfFiles.length;
		int fileNumber = 0;
		int percentDone;
		int numFilesRemoved = 0;
		//Declaring variables to store the images to be compared
		BufferedImage baseImage;
		BufferedImage tempImage;
		//Declaring colors to store the pixel RGB values
		Color baseColor;
		Color tempColor;	
		//First, iterate through each image in the specified folder
		for (File file : listOfFiles) {
			//Print progress metrics to console
			percentDone = fileNumber*100/total;
			System.out.println("On File number " + fileNumber);
			System.out.println(percentDone + " Percent Done");
			//System.out.println("Number of Size Checks: " + numSizeChecks);
			//numSizeChecks = 0;
			//Read in the first image
			try {
				baseImage = ImageIO.read(file.getAbsoluteFile());

				//Iterate through the entire list of images again (Not efficient but easier to code)
				for(int i = fileNumber+1; i< listOfFiles.length; i++) {	
					
					try {
						tempImage = ImageIO.read(listOfFiles[i]);
						//numSizeChecks++;
						//For each image, check to see if the heights and widths are the same. If they aren't,
						//Images can't be the same, so skip and move to the next one 
						if((baseImage.getHeight()) == (tempImage.getHeight()) && (baseImage.getWidth()) == (tempImage.getWidth())){
							//System.out.println("Found images of same size");
							//System.out.println(baseImage.getWidth()*baseImage.getHeight());
							//System.out.println(tempImage.getWidth()*tempImage.getHeight());
							
							//Makes arrays to store the red, green, and blue pixel values
							int[] basePixelsR = new int[baseImage.getWidth()*baseImage.getHeight()];
							int[] basePixelsG = new int[baseImage.getWidth()*baseImage.getHeight()];
							int[] basePixelsB = new int[baseImage.getWidth()*baseImage.getHeight()];
							int[] tempPixelsR = new int[tempImage.getWidth()*tempImage.getHeight()];
							int[] tempPixelsG = new int[tempImage.getWidth()*tempImage.getHeight()];
							int[] tempPixelsB = new int[tempImage.getWidth()*tempImage.getHeight()];
							
							//Iterates through every pixel, recording its RGB values in the arrays
							int pos = 0;
							for (int y = 0; y < baseImage.getHeight(); y++){
								for (int x = 0; x < baseImage.getWidth(); x++){								
									baseColor = new Color(baseImage.getRGB(x,y));
									tempColor = new Color(tempImage.getRGB(x, y));

									basePixelsR[pos]=(baseColor.getRed());
									basePixelsG[pos]=(baseColor.getGreen());
									basePixelsB[pos]=(baseColor.getBlue());
									tempPixelsR[pos]=tempColor.getRed();
									tempPixelsG[pos]=tempColor.getGreen();
									tempPixelsB[pos]=tempColor.getBlue();
									pos++;
								}
							}

							//If the Red, Green, and Blue arrays are equal for both images, its the same image
							if(Arrays.equals(basePixelsR, tempPixelsR) && Arrays.equals(basePixelsG, tempPixelsG) && Arrays.equals(basePixelsB, tempPixelsB)) {
								System.out.println("Found duplicate Image, deleting " + file.getAbsolutePath());
								listOfFiles[i].delete();
								i--;
								numFilesRemoved++;
								
							}
						}
						else {
							//Image heights/widths aren't the same, move to the next image
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
			fileNumber++;

		}
		System.out.println("Number of Files Removed: " + numFilesRemoved);
	}
	
	public boolean SameImage(BufferedImage baseImage, BufferedImage tempImage) {
		if(baseImage.getHeight() != (tempImage.getHeight()) || baseImage.getWidth() != (tempImage.getWidth())){
			return false;
		}
		int pos = 0;
		for (int y = 0; y < baseImage.getHeight(); y++){
			for (int x = 0; x < baseImage.getWidth(); x++){
				if(baseImage.getRGB(x, y) != tempImage.getRGB(x, y)) {
					return false;
				}
			}
		}
		return true;
		
		//changing for gits sake again
		
	}
	
	
	
	
	
}


