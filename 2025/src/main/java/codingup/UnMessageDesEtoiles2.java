package codingup;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnMessageDesEtoiles2 {
    public static void executer() throws IOException {
        List<BufferedImage> bufferedImages = new ArrayList<>();
        BufferedImage resultat = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < 148; i++) {
            bufferedImages.add(Utils.readImage("telescope02/telescope_img_"+String.format("%03d", i)+".png"));
        }

        for (int y = 0; y < 800; y++) {
            for (int x = 0; x < 800; x++) {
                Map<Integer, Integer> listeRGB = new HashMap<>();

                for (BufferedImage bufferedImage : bufferedImages) {
                    int rgb = bufferedImage.getRGB(x, y);
                    if (listeRGB.containsKey(rgb)) {
                        listeRGB.compute(rgb, (k, v) -> v + 1);
                    } else {
                        listeRGB.put(rgb, 1);
                    }
                }

                if (!listeRGB.keySet().stream().filter(key -> listeRGB.get(key) == 1).toList().isEmpty()) {
                    resultat.setRGB(x, y, Color.white.getRGB());
                }
            }
        }

        File f = new File("ResultatUnMessageDesEtoiles2.png");
        ImageIO.write(resultat, "PNG", f);
    }
}
