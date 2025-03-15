package codingup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Hybrides {
    private static final List<String> bases = asList(
            "0001",
            "1010",
            "1100",
            "0011"
    );

    private static boolean contientAutreBase(String sequence) {
        int i = 0;

        while (i < sequence.length()) {
            String base = sequence.substring(i, i+4);
            if (!bases.contains(base)) {
                return true;
            }
            i+= 4;
        }

        return false;
    }

    static void executer() throws IOException {
        BufferedReader reader = Utils.readFile("hybrides.txt");
        List<Integer> resultat = new ArrayList<>();


        for (String line; (line = reader.readLine()) != null; ) {
            int num = Integer.parseInt(line.split(" : ")[0].replace("N° ", ""));

            if (Hybrides.contientAutreBase(line.split(" : ")[1])) {
                resultat.add(num);
            }
        }

        System.out.println(resultat);
    }
}
