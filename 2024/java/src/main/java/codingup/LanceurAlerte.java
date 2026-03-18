package codingup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LanceurAlerte {
    public static void executer() throws IOException {
        BufferedImage bufferedImage = Utils.readImage("image_tv_glitch.png");

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            if ((y+1) % 8 == 0) {
                for (int x = 0; x < bufferedImage.getWidth() - 25; x++) {
                    int rgb = bufferedImage.getRGB(x + 25, y);
                    bufferedImage.setRGB(x, y, rgb);
                }
            } else if ((y+2) % 8 == 0) {
                for (int x = 0; x < bufferedImage.getWidth() - 20; x++) {
                    int rgb = bufferedImage.getRGB(x + 20, y);
                    bufferedImage.setRGB(x, y, rgb);
                }
            } else if ((y+1) % 4 == 0) {
                for (int x = 0; x < bufferedImage.getWidth() - 5; x++) {
                    int rgb = bufferedImage.getRGB(x + 5, y);
                    bufferedImage.setRGB(x, y, rgb);
                }
            }
        }

        File f = new File("ResultatLanceurAlerte.png");
        ImageIO.write(bufferedImage, "PNG", f);
    }
}
