import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.Image;
import java.net.*;

public class ImgResize {

    public static void main(String args[]) {

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        String path = args[2];

        BufferedImage newImage;
        Image image;

        try {
            if (path.substring(0, 4).equals("http")) {
                URL url = new URL(path);
                image = ImageIO.read(url);
            } else {
                File file = new File(path);
                image = ImageIO.read(file);
            }
            newImage = getScaledImage(image, width, height);
            File outputfile = new File("background.png");
            ImageIO.write(newImage, "png", outputfile);
	        System.exit(0);
        } catch (IOException e) {
            System.out.println("Image could not be found / resized");
	        System.exit(1);
        }
    }

    private static BufferedImage getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, Transparency.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
}
