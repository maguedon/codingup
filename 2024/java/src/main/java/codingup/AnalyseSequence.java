package codingup;

import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class AnalyseSequence {
    private static final String entree = "NDNKCNVNUGYWRGCNABGSNCRACGSHWNNCYBCSNVUAAGDCMNKNYNNBNCGUBHUNRANDGDMDRSYMGSNWHNDNCVCMAMCANWKYRKVMWMKC";

    private static final Map<Character, Integer> basesNucleiques = Map.ofEntries(
            entry('A', 1),
            entry('C', 1),
            entry('G', 1),
            entry('U', 1),
            entry('R', 2),
            entry('Y', 2),
            entry('K', 2),
            entry('M', 2),
            entry('S', 2),
            entry('W', 2),
            entry('B', 3),
            entry('D', 3),
            entry('H', 3),
            entry('V', 3),
            entry('N', 4)
    );

    static void executer() throws IOException {
        Long resultat = 1L;

        for (int i = 0; i < entree.length(); i++) {
            resultat *= basesNucleiques.get(entree.charAt(i));

            if (resultat > 99999) {
                String tmp = resultat.toString();
                resultat = Long.valueOf(tmp.substring(tmp.length()-5));
            }
        }

        System.out.println(resultat);
    }
}
