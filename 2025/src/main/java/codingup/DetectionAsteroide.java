package codingup;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetectionAsteroide {
    static final int xDecalage = 7;
    static final int yDecalage = 5;

    private static BufferedImage shiftImage(BufferedImage original, int x, int y) {
        BufferedImage result = new BufferedImage(original.getWidth() + x,
                original.getHeight() + y, original.getType());
        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(original, 0, 0, null);
        return result;
    }

    private static void drawImage(BufferedImage src, BufferedImage dest, int x, int y) {
        Graphics2D g2d = dest.createGraphics();
        g2d.drawImage(src, x, y, null);
    }

    private static int getMoy(int x, int y, List<BufferedImage> bufferedImageList) {
        int sumR = 0;
        int sumG = 0;
        int sumB = 0;

        for (int i = 0; i < bufferedImageList.size(); i++) {
            int tmpX = x - i * xDecalage;
            int tmpY = y - i * yDecalage;
            if (tmpX >= 0 && tmpX < bufferedImageList.get(i).getWidth() &&
                    tmpY >= 0 && tmpY < bufferedImageList.get(i).getHeight()) {
                int rgb = bufferedImageList.get(i).getRGB(tmpX, tmpY);
                sumR += (rgb >> 16) & 0xFF;
                sumG += (rgb >> 8) & 0xFF;
                sumB += rgb & 0xFF;
            }
        }

        int moyR = sumR/bufferedImageList.size();
        int moyG = sumG/bufferedImageList.size();
        int moyB = sumB/bufferedImageList.size();

        return (moyR << 16) + (moyG << 8) + moyB;
    }

    public static void executer() throws IOException {
        List<BufferedImage> bufferedImageList = new ArrayList<>();

        BufferedImage resultat = new BufferedImage(512 + 100 * xDecalage, 512 + 100 * yDecalage, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < 100; i++) {
            bufferedImageList.add(Utils.readImage("imgs_celestes/ciel" + String.format("%04d", i) + ".png"));
        }

        for (int y = 0; y < resultat.getHeight(); y++) {
            for (int x = 0; x < resultat.getWidth(); x++) {
                int moy = getMoy(x, y, bufferedImageList);

                resultat.setRGB(x, y, moy);
            }
        }

        File f = new File("ResultatDetectionAsteroide2.png");
        ImageIO.write(resultat, "PNG", f);
    }
}
