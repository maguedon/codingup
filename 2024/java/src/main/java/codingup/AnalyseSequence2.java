package codingup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Map.entry;

public class AnalyseSequence2 {
    private static final String motif = "MNGHNNNNNKRRBNN";

    private static final Map<Character, List<Character>> basesNucleiques = Map.ofEntries(
            entry('A', List.of('A')),
            entry('C', List.of('C')),
            entry('G', List.of('G')),
            entry('U', List.of('U')),
            entry('R', List.of('A', 'G')),
            entry('Y', List.of('C', 'U')),
            entry('K', List.of('G', 'U')),
            entry('M', List.of('A', 'C')),
            entry('S', List.of('C', 'G')),
            entry('W', List.of('A', 'U')),
            entry('B', List.of('C', 'G', 'U')),
            entry('D', List.of('A', 'G', 'U')),
            entry('H', List.of('A', 'C', 'U')),
            entry('V', List.of('A', 'C', 'G')),
            entry('N', List.of('A', 'C', 'G', 'U'))
    );

    private static boolean correspondAuMotif(String sequence) {
        for (int i = 0; i < sequence.length(); i++) {
            char cS = sequence.charAt(i);
            char cM = motif.charAt(i);

            if (cS != cM && !basesNucleiques.get(cM).contains(cS)) {
                return false;
            }
        }
        return true;
    }

    static void executer() throws IOException {
        int resultat = 0;

        BufferedReader reader = Utils.readFile("AnalyseSequence2.txt");

        for (String line; (line = reader.readLine()) != null; ) {
           if (correspondAuMotif(line)) {
               resultat++;
           }
        }

        System.out.println(resultat);
    }
}
