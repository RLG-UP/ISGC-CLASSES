package edu.up.isgc.paint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x, y, Color.white.getRGB());
            }
        }
        image.setRGB(400,400, Color.red.getRGB());
        File outputfile = new File("MMCG_image.png");
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            System.err.println("Error while writing image to file" + outputfile);

        }
    }
}
