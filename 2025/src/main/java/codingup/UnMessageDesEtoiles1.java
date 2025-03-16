package codingup;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnMessageDesEtoiles1 {
    public static void executer() throws IOException {
        List<BufferedImage> bufferedImages = new ArrayList<>();
        BufferedImage resultat = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < 29; i++) {
            bufferedImages.add(Utils.readImage("telescope01/telescope_img_"+String.format("%03d", i)+".png"));
        }

        for (int y = 0; y < 800; y++) {
            for (int x = 0; x < 800; x++) {
                int rgbBase = bufferedImages.getFirst().getRGB(x, y);

                int i = 1;
                while (i < bufferedImages.size() &&
                        rgbBase == bufferedImages.get(i).getRGB(x, y)) {
                    i++;
                }

                if (i != bufferedImages.size()) {
                    resultat.setRGB(x, y, Color.white.getRGB());
                }
            }
        }

        File f = new File("ResultatUnMessageDesEtoiles.png");
        ImageIO.write(resultat, "PNG", f);
    }
}
