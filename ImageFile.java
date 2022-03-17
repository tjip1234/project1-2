import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.IOException;

 
import javax.imageio.ImageIO;

public class ImageFile 
{
    BufferedImage outImage;
    public static int height;
    public static int width;
    public static String imagename ()  
    {
        width = 120 + (int)((Math.abs(inputReader.xt)-Math.abs(inputReader.x0))*100)*2;
        height = 120 + (int)((Math.abs(inputReader.yt)-Math.abs(inputReader.y0))*100)*2;
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = canvas.createGraphics();
        // fill all the image with white
        double n_biggest = 0;
        for (int i=0; i<canvas.getWidth(); i++)
        {
            for (int j=0; j<canvas.getHeight(); j++)
            {
                double n = (mathFunction.Function(i, j)*3.5); 
                if( n > n_biggest){
                    n_biggest = n;
                }
            }
        }
        for (int i=0; i<canvas.getWidth(); i++)
        {
            for (int j=0; j<canvas.getHeight(); j++)
            {
                double n = (mathFunction.Function(i, j)*3.5); 
                if (mathFunction.Function(i,j) < 0) {
                    canvas.setRGB(i,j,new Color(0,0,254).getRGB()); 
                }
                else if (mathFunction.CheckSand( (((double)i)-width/2.0)/100.0, -(((double)j) - height/2.0)/100.0)) {
                    canvas.setRGB(i,j,new Color(127,127,0).getRGB());
                }
                else if(Math.pow(((((double)i)-width/2.0)/100.0-inputReader.tree1.X), 2)+Math.pow((-(((double)j) - height/2.0)/100.0)-inputReader.tree1.Y, 2) <= Math.pow(inputReader.tree1.R, 2)){
                    canvas.setRGB(i,j,new Color(20,20,0).getRGB());
                }
                else{
                    canvas.setRGB(i,j,new Color(0,(int)((n/n_biggest)*240.0),0).getRGB());
                }
            }
        }


        // Save as PNG
        String link = "res/field.png";
        File f=new File (link);
        try 
        {
            ImageIO.write(canvas, "png", f);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return link;
    }
}



//     // public static String recorder() throws IOException
//     // {
//     //     writeImageToBytes ();
//     //     File file = new File("")
//     //     return "";
//     // }
// }

// import java.awt.Color;
// import java.awt.Graphics2D;
// import java.awt.image.BufferedImage;
// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.lang.reflect.InvocationTargetException;
// import java.lang.reflect.Method;
// import java.io.IOException;

 
// import javax.imageio.ImageIO;

// public class ImageFile 
// {
//     BufferedImage outImage;
//     public static String imagename ()  
//     {
//         File f = null;
//         int width = 680;
//         int height = 610;
//         int rgb = new Color(0,191,255).getRGB();
//         int rgb3 = new Color(0,177,0).getRGB();
//         int rgb2 = new Color(0,123,0).getRGB();
//         // Constructs a BufferedImage of one of the predefined image types.
//         BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//         //ByteArrayOutputStream baos = new ByteArrayOutputStream();
//         // Create a graphics which can be used to draw into the buffered image
//         Graphics2D g2d = canvas.createGraphics();
//         // fill all the image with white
//         for (int i=0; i<canvas.getWidth(); i++)
//         {
//             for (int j=0; j<canvas.getHeight(); j++)
//             {
//                 for (int x=0; x<golfField.database.length; x++)
//                 { 
                    
//                         {
//                         if (golfField.database[x]<0 )
//                         {
//                             canvas.setRGB(i, j, rgb);
//                         }
//                         if (golfField.database[x]>0 && golfField.database[x]<50)
//                         {
//                             canvas.setRGB(i, j, rgb2);
//                         }
//                         if (golfField.database[x]>50)
//                         {
//                             canvas.setRGB(i, j, rgb3);
//                         }
//                     }
//                 }
//             }
//         }
//         // Save as PNG
//         String link = "/Users/vantsevvictor/Downloads/Project 1-2/Golf/res/field.png";
//         f=new File (link);
//         try 
//         {
//             ImageIO.write(canvas, "png", f);
//         } 
//         catch (IOException e) 
//         {
//             e.printStackTrace();
//         }
//         return link;
//     }
