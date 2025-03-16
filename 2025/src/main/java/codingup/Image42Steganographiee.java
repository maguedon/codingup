package codingup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image42Steganographiee {
    static void executer() throws IOException {
        BufferedImage image = Utils.readImage("C25_Image_42_encoded.png");

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);

                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                int calculRGB = 16 * red + 4 * green + blue;

                if (calculRGB % 42 == 0) {
                    image.setRGB(x, y , 0);
                } else {
                    image.setRGB(x, y , 5355);
                }
            }
        }

        File f = new File("ResultatImage42Stenographiee.png");
        ImageIO.write(image, "PNG", f);
    }
}
