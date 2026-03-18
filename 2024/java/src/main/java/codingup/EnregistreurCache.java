package codingup;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class EnregistreurCache {
    public static void executer() throws UnsupportedAudioFileException, IOException {
        AudioInputStream audioInputStreamA = Utils.readAudioFile("enregistrement_01a.wav");
        AudioInputStream audioInputStreamB = Utils.readAudioFile("enregistrement_01b.wav");

        long length = audioInputStreamA.getFrameLength() * audioInputStreamA.getFormat().getFrameSize();

        byte[] bytesA = new byte[(int) length];
        audioInputStreamA.read(bytesA);

        byte[] bytesB = new byte[(int) length];
        audioInputStreamB.read(bytesB);

        byte[] bytesResultat = new byte[(int) length];

        for (int i = 0; i < length; i++) {
            bytesResultat[i] = (byte)(bytesA[i] + bytesB[i]);
        }

        // Process audio bytes here
        audioInputStreamA.close();
        audioInputStreamB.close();

        AudioFormat audioFormat = audioInputStreamA.getFormat();

        Utils.saveAudioFile(bytesResultat, audioFormat, AudioFileFormat.Type.WAVE, length, "resultat.wav");
    }
}
