package codingup;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Utils {
    static BufferedReader readFile(String path) throws FileNotFoundException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);

        if (is == null) {
            throw new FileNotFoundException("Fichier " + path + " non trouvé");
        }

        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        return new BufferedReader(streamReader);
    }

    static BufferedImage readImage(String path) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);

        if (is == null) {
            throw new FileNotFoundException("Fichier " + path + " non trouvé");
        }

        return ImageIO.read(is);
    }

    static AudioInputStream readAudioFile(String path) throws UnsupportedAudioFileException, IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);

        return AudioSystem.getAudioInputStream(is);
    }

    static void saveAudioFile(byte[] bytesResultat, AudioFormat audioFormat, AudioFileFormat.Type audioFileFormatType, long length, String path) throws IOException {
        File outputFile = new File(path);
        InputStream input = new ByteArrayInputStream(bytesResultat);
        AudioInputStream ais = new AudioInputStream(input, audioFormat, length / audioFormat.getFrameSize());
        AudioSystem.write(ais, audioFileFormatType, outputFile);
    }
}
