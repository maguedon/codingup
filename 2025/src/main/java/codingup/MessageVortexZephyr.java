package codingup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MessageVortexZephyr {
    static final String entree = "HFKAO ZTEIA ZPJNT VASWY FBRMO GUOYA GJFWP IIOVU KELHB " +
            "OXMAG JOLEK WHELH XEXDJ HCEWU XPHCK VBULC LEMOM HZ";

    static char decalerChar(char c, int decalage) {
        System.out.println(decalage);
        if (c + decalage > 'Z') {
            return (char) ('A' + ((c + decalage) - 'A') % 26);
        }
        return (char) (c + decalage);
    }

    static void executer() throws IOException {
        for (int decalage = 0; decalage < 26; decalage++) {
            for (int increment = 1; increment < 27; increment++) {
                System.out.println("decalage : " + decalage + " / increment : " + increment);
                StringBuilder resultat = new StringBuilder();
                int decalageCourant = decalage;
                for (int i = 0; i < entree.length(); i++) {
                    char c = entree.charAt(i);
                    if (c != ' ') {
                        resultat.append(decalerChar(c, decalageCourant));
                        decalageCourant += increment;
                        decalageCourant %= 26;
                    }
                }
                resultat.append("\n");

                Files.write(Paths.get("resultatMessageVortexZephyr.txt"), resultat.toString().getBytes(), StandardOpenOption.APPEND);
            }
        }
    }
}
