import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

class ImportanceNom implements Comparable<ImportanceNom> {
    String nom;
    Double value;

    public ImportanceNom(String nom, Double value) {
        this.nom = nom;
        this.value = value;
    }

    @Override
    public int compareTo(ImportanceNom o) {
        if (this.value < o.value) {
            return -1;
        }
        if (this.value > o.value) {
            return 1;
        }
        return this.nom.compareTo(o.nom);
    }

    @Override
    public String toString() {
        return this.nom;
    }
}

class Main {
    private void etoileChaudes() {
        BufferedImage image = null;
        int cpt = 0;

        try {
            File input_file = new File("ciel.png");
  
            // Reading input file
            image = ImageIO.read(input_file);
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        if (image != null) {
            int width = image.getWidth();
            int height = image.getHeight();

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Color c = new Color(image.getRGB(x, y));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();

                    if (b > r && b > g) {
                        cpt++;
                    }
                }
            }
        }

        System.out.println(cpt);
    }

    private int suite(int n) {
        if (n == 0) {
            return 13;
        }
        return (47 * suite(n-1) + 35) % 11587;
    }

    private void theLibrary() {
        System.out.println(suite(2023));
    }

    private int getNbLetters(String word) {
        Set<Character> letters = new HashSet<>();
        for (char c : word.toLowerCase().toCharArray()) {
            letters.add(c);
        }
        return letters.size();
    }

    private void lesNomsOntDeLImportance() {
        List<ImportanceNom> list = new ArrayList<>();

        try {
            File myObj = new File("nomsImportance.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String dataWithoutSpaces = data.replace(" ", "");

                double nbLetters = getNbLetters(dataWithoutSpaces);
                
                list.add(new ImportanceNom(data, nbLetters / dataWithoutSpaces.length()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Collections.sort(list);
        System.out.println(list.subList(0, 12).toString());
    }

    private int getNbSymbolesChiffre(int chiffre) {
        if (chiffre < 5) {
            return chiffre;
        }
        return chiffre - 4;
    }
    
    private int getNbSymboles(int number) {
        String nbStr = String.valueOf(number);
        int nbSymboles = nbStr.length() + 1;

        for (int i = 0; i < nbStr.length(); i++) {
            char t = nbStr.charAt(i);
            int chiffre = t - 48;

            nbSymboles += getNbSymbolesChiffre(chiffre);
        }

        return nbSymboles;
    }

    private boolean isRond(int number) {
        return (number % getNbSymboles(number)) == 0;
    }

    private void pointsFixes() {
        int n2999 = 0;
        int n9999 = 0;

        for (int i = 2000; i < 10000; i++) {
            if (isRond(i)) {
                n9999++;
                if (i < 3000) {
                    n2999++;
                }
            }
        }
        System.out.println(n2999+", "+n9999);
    }

    private void ordreTemporel() {
        // Map<String, List<String>> annees = new HashMap<>();
        List<String> annees = new ArrayList<>();
        try {
            File myObj = new File("annees.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().replace("Visiter ", "").replace("avant ", "");
                String[] split = data.split(" ");

                // List<String> values = annees.get(split[0]);
                // if (values == null) {
                //     annees.put(split[0], new ArrayList<>(Arrays.asList(split[1])));
                // } else {
                //     values.add(split[1]);
                //     annees.put(split[0], values);
                // }

                if (annees.isEmpty()) {
                    annees.add(split[0]);
                    annees.add(split[1]);
                } else {
                    if (!annees.contains(split[0])) {
                        if (!annees.contains(split[1])) {
                            annees.add(split[0]);
                            annees.add(split[1]);
                        } else {
                            int ind = annees.indexOf(split[1]);
                            annees.add(ind, split[0]);
                        }
                    } else {
                        if (!annees.contains(split[1])) {
                            annees.add(split[1]);
                        } else {
                            int ind0 = annees.indexOf(split[0]);
                            int ind1 = annees.indexOf(split[1]);
                            if (ind0 > ind1) {
                                annees.remove(ind1);
                                if (ind0 < annees.size() - 1) {
                                    annees.add(ind0 + 1, split[1]);
                                } else {
                                    annees.add(split[1]);
                                }
                            } 
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // annees.forEach((key) -> System.out.println(key));
        System.out.println(String.join(", ", annees));

        // List<String> listeFinale = new ArrayList<>();
        // while (!annees.isEmpty()) {
        //     // System.out.println(entry.getKey() + ":" + entry.getValue());
        //     String annee1 = annees.;
            
        // }
    }

    public static void main(String[] args) {
        Main main = new Main();

        // main.etoileChaudes();
        // main.theLibrary();
        main.lesNomsOntDeLImportance();
        // main.pointsFixes();
        // main.ordreTemporel();
    }
}