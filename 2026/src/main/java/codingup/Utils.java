package codingup;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    static AudioFileFormat readAudioFileFormat(String path) throws UnsupportedAudioFileException, IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(path);

        return AudioSystem.getAudioFileFormat(is);
    }

    static void saveAudioFile(byte[] bytesResultat, AudioFormat audioFormat, AudioFileFormat.Type audioFileFormatType, long length, String path) throws IOException {
        File outputFile = new File(path);
        InputStream input = new ByteArrayInputStream(bytesResultat);
        AudioInputStream ais = new AudioInputStream(input, audioFormat, length / audioFormat.getFrameSize());
        AudioSystem.write(ais, audioFileFormatType, outputFile);
    }

    static String getApiCall(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static void postApiCall(String url, String body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response : " + response.toString() + " / " + response.body());
    }
}
