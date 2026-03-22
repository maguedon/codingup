package codingup;

import com.google.gson.Gson;
import org.apache.commons.lang3.ArrayUtils;

import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static void testJson() throws IOException, InterruptedException {
        String data = Utils.getApiCall("https://codingup.univ-poitiers.fr/adler/defis/SampleJson2026/get/Jollymah/9d7c9");

        Gson gson = new Gson();
        DataTest2 dataTest = gson.fromJson(data , DataTest2.class);

        ResultTest2 resultTest2 = new ResultTest2(dataTest.getA() + dataTest.getB(), dataTest.getSignature());

        Utils.postApiCall("https://codingup.univ-poitiers.fr/adler/defis/SampleJson2026/post/Jollymah/9d7c9", gson.toJson(resultTest2));
    }

    static void cambriolage1() throws FileNotFoundException {
        BufferedReader reader = Utils.readFile("cambriolage1.txt");

        List<String> lines = reader.lines().toList();

        long nbMusees = lines.stream().filter(String::isEmpty).count() + 1;

        List<String> suspects = new ArrayList<>();

        int i = 0;
        while (!lines.get(i).isEmpty()) {
            int finalI = i;
            long nbApparitions = lines.stream().filter(line -> line.equals(lines.get(finalI))).count();
            if (nbApparitions == nbMusees) {
                suspects.add(lines.get(i));
            }

            i++;
        }

        System.out.println(String.join(",", suspects));
    }

    static void rideauPixels() throws IOException {
        BufferedImage bufferedImage = Utils.readImage("message.png");

        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 0; y < height; y++) {
            int cpt = 0;
            for (int x = 0; x < width; x++) {
                System.out.println(bufferedImage.getRGB(x, y));
                if (bufferedImage.getRGB(x, y) == -16777216) {
                    cpt++;
                }
            }

            stringBuilder.append((char) cpt);
        }

        System.out.println(stringBuilder.toString());
    }

    static void chercherCalendrier() throws FileNotFoundException {
        //        _a_l_aube_pres_de_l_etang_de_surrey_gardens

        int annee = 2018;
        for (int i = 0; i < 12 * 7; i++) {
            if (i % 12 == 0) {
                annee++;
            }
            int mois = i % 12;
            System.out.println(calendrier(mois + 1, annee));
        }
    }

    static String calendrier(int startMonth, int year) throws FileNotFoundException {
        BufferedReader reader = Utils.readFile("calendrier.txt");

        StringBuilder stringBuilder = new StringBuilder();

        List<String> lines = reader.lines().toList();

        int currentMonth = startMonth;
        int currentYear = year;
        int nbChar = 0;

        for (String line : lines) {
            for (int i = 0; i < line.length(); i += 2) {
                if (nbChar == 10) {
                    nbChar = 0;
                    if (currentMonth == 12) {
                        currentMonth = 1;
                        currentYear++;
                    } else {
                        currentMonth++;
                    }
                }

                char chiffre = line.charAt(i);
                char lettre = line.charAt(i + 1);

                int res = calculateDayOfMonth(chiffre - '0', lettre, startMonth, currentYear);
                if (res == 27) {
                    stringBuilder.append("_");
                } else if (res == 28) {
                    stringBuilder.append(".");
                } else {
                    char res2 = (char) ('a' + res - 1);
                    stringBuilder.append(res2);
                }

                nbChar++;
            }
        }

        return stringBuilder.toString();
    }

    static int calculateDayOfMonth(int chiffre, char lettre, int month, int year) {
        return 7 * (chiffre - 1) + getPositionJour(lettre) - getSizeWeekOne(month, year) + 1;

    }

    static int getPositionJour(char lettre) {
        List<Character> days = List.of('L', 'M', 'N', 'J', 'V', 'S', 'D');

        return days.indexOf(lettre) + 1;
    }

    static int getSizeWeekOne(int month, int year) {
        LocalDate dayOne = LocalDate.of(year, month, 1);

        return dayOne.getDayOfWeek().getValue();
    }

    static void combinaison() {
        int annee = 1927;

        for (int i = 0; i <= 99999; i++) {
            int combinaison = i * annee;
            if (estPalydromeAvec7(combinaison)) {
                System.out.println(i);
            }
        }
    }

    static boolean estPalydromeAvec7(int nombre) {
        String str = String.valueOf(nombre);
        if (str.length() %2 == 0) {
            return false;
        }

        int moitie = str.length()/2;

        if (str.charAt(moitie) != '7') {
            return false;
        }

        String debut = str.substring(0,moitie);
        String fin = str.substring(moitie+1);
        StringBuilder stringBuilder = new StringBuilder(fin);

        return debut.contentEquals(stringBuilder.reverse());
    }

    static void entretienStage() throws IOException {
        BufferedReader bufferedReader = Utils.readFile("dictionnaire.txt");
        int nbMots12 = 0;
        int nbMotsE = 0;
        int nbMotsL = 0;

        for (String line; (line = bufferedReader.readLine()) != null;) {
            if (line.length() == 12) {
                nbMots12++;
            }
            if (line.charAt(2) == 'e') {
                nbMotsE++;
            }
            if (line.chars().filter(c -> c == 'l').count() == 2) {
                nbMotsL++;
            }
        }

        System.out.println(nbMots12 + "," + nbMotsE + "," + nbMotsL);
    }

    static void surEcoute() throws FileNotFoundException {
        BufferedReader reader = Utils.readFile("message.txt");
        List<String> lines = reader.lines().toList();

        Map<Integer, String> positions = new TreeMap<>();

        for (int i = 0; i < lines.size(); i += 3) {
            int pos = Integer.parseInt(lines.get(i).split("=")[1]);
            String letter = lines.get(i + 1).split("=")[1];
            positions.put(pos, letter);
        }

        System.out.println(String.join("",positions.values()));
    }

    static void messageAudioTranspose1() throws UnsupportedAudioFileException, IOException {
        AudioInputStream audioInputStream = Utils.readAudioFile("chiffre_message_B.wav");

        List<Integer> tableReference = List.of( 15, 103, 144, 224, 209, 205, 196, 130, 128, 191,  25,  90,  70,  48, 229, 161,
                219,  92,   9, 134, 186, 121, 238,  12, 118, 139, 184, 231, 108, 160, 162,  42,
                154, 233, 133, 204, 253, 129, 132,  93, 137, 251, 235, 167,  98,  52, 115, 201,
                61, 177, 126, 216,  27, 142, 234, 245, 168,   2,  60, 105, 147,  87, 155, 116,
                172,  57, 206, 189, 176, 114,  21,  64, 101, 179, 212, 195, 249, 171,  78, 146,
                192,  99, 199,   4, 241, 106,  14, 242,  94, 169, 131,  82,  86, 158, 136,  77,
                89,  72, 138, 210,  22,  62,  83, 181,  17,  80, 180, 113, 237,  58,  63,  53,
                40, 166, 243, 140,  10, 203, 239,  23,  32, 211, 175, 220,  33, 152,  31,   5,
                110, 149, 254,   1, 185, 255,  59, 246, 107,  18,  50,  36, 240, 188, 244,  45,
                150, 193,  51, 232, 174, 165,  35,  68,  47,  20, 247, 222, 123,  39,  43, 187,
                44,   7,  66, 157,  96, 112,   8, 164, 218, 111, 127,  38, 252, 102, 230,  91,
                225, 182,  54,  16, 213,  24, 117, 170, 100, 141, 156,  81, 202,  19,  30, 250,
                145, 173,  95, 208, 207, 223, 124,   3, 143,  49,   0,  11, 104, 125, 215,  88,
                28,  55,  85, 226, 120, 248,  76,  46, 135, 236, 200,   6, 178, 228,  34,  56,
                69, 190, 194, 122, 148,  67,  37, 153,  65,  97, 214,  75, 217,  29, 198,  74,
                221,  79, 159, 197,  41, 151,  13, 109,  84,  26, 163, 227, 119,  73, 183,  71);

//        System.out.println(tableReference.size());

        List<Byte> bytes = new ArrayList<Byte>();

        for (int currentByte; (currentByte = audioInputStream.read()) != -1;) {
            int pos = tableReference.indexOf(currentByte);
//            System.out.println(currentByte + " -> " + pos + " / " + (byte) pos);
            bytes.add((byte) pos);
        }

//        System.out.println(bytes);

//        FileOutputStream fileOutputStream = new FileOutputStream("result_message_audio_transpose_1.wav");
        Byte[] tableauBytes = bytes.toArray(new Byte[0]);
        byte[] tableauBytes2 = ArrayUtils.toPrimitive(tableauBytes);
//        System.out.println(bytes.getFirst() + " / " + tableauBytes[0] + " / " + tableauBytes2[0]);
//
//        fileOutputStream.write(tableauBytes2);

        AudioFileFormat fileFormat = Utils.readAudioFileFormat("chiffre_message_B.wav");

//        try (AudioInputStream audioInputStreamResult = new AudioInputStream(
//                new ByteArrayInputStream(tableauBytes2), fileFormat.getFormat(), tableauBytes2.length / audioInputStream.getFrameLength())) {
//            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File("result_message_audio_transpose_1.wav"));
//        }

        ByteArrayInputStream bais = new ByteArrayInputStream(tableauBytes2);
        long length = (long)(tableauBytes2.length / audioInputStream.getFrameLength());
        AudioInputStream audioInputStreamTemp = new AudioInputStream(bais, fileFormat.getFormat(), length);
        File fileOut = new File("result_message_audio_transpose_1.wav");
        AudioFileFormat.Type fileType = fileFormat.getType();
        if (AudioSystem.isFileTypeSupported(fileType,
                audioInputStreamTemp)) {
            System.out.println("Trying to write");
            AudioSystem.write(audioInputStreamTemp, fileType, fileOut);
            System.out.println("Written successfully");
        }
    }

    static void messageCarbonise() throws FileNotFoundException {
        BufferedReader reader = Utils.readFile("message_carbonise.txt");
        List<String> lines = reader.lines().toList();

        Map<Integer, String> positions = new TreeMap<>();

        for (int i = 0; i < lines.size(); i++) {
            String character = String.valueOf(lines.get(i).charAt(0));
            List<Integer> currentPositions = Arrays.stream(lines.get(i)
                    .substring(3)
                    .split(", "))
                    .map(Integer::parseInt)
                    .toList();

            currentPositions.forEach(pos -> positions.put(pos, character));

        }

        System.out.println(String.join("",positions.values()));
    }

    static void sismographe() {

    }

    static String bobyLapointe() {
        String entree = "3973 1805 2627 167 22 52 11415 21170 39 3760 43 244 1078 37571 124 65 134 244 455 203 219 5163 940 141 940 180 160 144 151 40868 99 37500 1519 1665 2571 52 107 3435 3049 135 224 20 3849 45 133 1515 201 147 26655 227";

        List<String> listeBibiBinaire =  Arrays.stream(entree.split(" "))
                .map(Integer::parseInt)
                .map(Main::convertToBibiBinaire).toList();


        String bibiBinaire = String.join(" ",listeBibiBinaire);
//        System.out.println(bibiBinaire);

        List<String> positions = new ArrayList<>();

        for (int i = 0; i < listeBibiBinaire.size(); i++) {
            List<Integer> anomalies = getAnomalies(listeBibiBinaire.get(i));
//            System.out.println("anomalies " + anomalies);
            for (int j = 0; j < anomalies.size(); j++) {
                positions.add(String.valueOf((i + j) % 180));
            }
        }

        return String.join(", ", positions);
    }

    static List<Integer> getAnomalies(String mot) {
//        System.out.println(mot);
        Character derniereConsonne = null;
        List<Character> voyelles = new ArrayList<>();
        List<Integer> anomalies = new ArrayList<>();
        for (int i = 0; i < mot.length(); i++) {
            char currentChar = mot.charAt(i);
            if (i%2 == 0) {
                if (derniereConsonne == null) {
                    derniereConsonne = currentChar;
                } else if (derniereConsonne == currentChar) {
                    System.out.println("dernierConsonne " + derniereConsonne + " / " + currentChar);
                    anomalies.add(i);
                } else {
                    derniereConsonne = currentChar;
                }
            } else {
                if (voyelles.contains(currentChar)) {
                    System.out.println("voyelles " + voyelles + " / " + currentChar);
                    anomalies.add(i);
                } else {
                    voyelles.add(currentChar);
                }
            }
        }

        return anomalies;
    }

    static String convertToBibiBinaire(int number) {
        Map<String, String> left = new HashMap<>();
        left.put("00", "H");
        left.put("01", "B");
        left.put("10", "K");
        left.put("11", "D");

        Map<String, String> right = new HashMap<>();
        right.put("00", "O");
        right.put("01", "A");
        right.put("10", "E");
        right.put("11", "I");

        String binaryStr = Integer.toBinaryString(number);
        StringBuilder result = new StringBuilder();

        if (binaryStr.length() % 4 != 0) {
            int numberOfZeroToAdd = 4 - binaryStr.length() % 4;
            int finalSize = numberOfZeroToAdd + binaryStr.length();
            binaryStr = String.format("000%s", binaryStr);
            binaryStr = binaryStr.substring(binaryStr.length() - finalSize);
        }

        for (int i = 0; i < binaryStr.length(); i+=4) {
            String substr = binaryStr.substring(i, i+4);
            String subStrLeft = substr.substring(0,2);
            String subStrRight = substr.substring(2);

//            System.out.println(number + " / " + binaryStr + " / " + substr + " / " + subStrLeft + " / " + subStrRight);
//            System.out.println(left.get(subStrLeft) + " / " + right.get(subStrRight));

            result.append(left.get(subStrLeft));
            result.append(right.get(subStrRight));
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException {
//        System.out.println("Hello");
//        rideauPixels();
//        chercherCalendrier();

//        combinaison();
//        entretienStage();
//        surEcoute();

//        messageAudioTranspose1();
//        messageCarbonise();

//        System.out.println(convertToBibiBinaire(3973));
//        1111 1000 0101
//        DI KO BA

        System.out.println(bobyLapointe());
    }
}