

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BlackAndWhite {

	public static void main(String[] args) {
		BufferedImage img = null;
		File f = null;
		//read image
		try{
			f = new File("raw-1.png");
			img = ImageIO.read(f);
			
//			InputStream inputStream = BlackAndWhite.class.getResourceAsStream("/src/main/.txt");
//			File file;
//			OutputStream outputStream = new FileOutputStream(file);
//			IOUtils.copy(inputStream, outputStream);
//			outputStream.close();
			
		}catch(IOException e){
			System.out.println(e);
		}
		

	    //get image width and height
	    int width = img.getWidth();
	    int height = img.getHeight();
	    System.out.println(img.getRGB(1,1));
    
	    //convert to grayscale
	    for(int y = 0; y < height; y++){
	    		for(int x = 0; x < width; x++){
		        int p = img.getRGB(x,y);
		        int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;
		
		        //calculate average
		        int avg = (r+g+b)/3;
		        if (p>-16000000){
		        		img.setRGB(x,y,-1);
		        }
	    		}
	    }

	    //write image
	    try{
	    		f = new File("initial-1.jpg");
	    		ImageIO.write(img, "jpg", f);
	    }catch(IOException e){
	    		System.out.println(e);
	    }
	}	

}