package codingup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class VictimesTooms {

    private static final List<Float> releveTooms = asList(10f, 12f, 6f, 9f, 18.5f, 22f, 7f, 4f, 9f, 10f);

    private static boolean ecartEstConstant (List<Float> values) {
        boolean ecartEstConstant = true;
        Float ecart = null;
        int i = 0;

        while (i < values.size() && ecartEstConstant) {
            Float ecartCourant = values.get(i) - VictimesTooms.releveTooms.get(i);
            if (ecart == null) {
                ecart = ecartCourant;
            } else if (!ecartCourant.equals(ecart)){
                ecartEstConstant = false;
            }

            i++;
        }

        return ecartEstConstant;
    }

    static void executer() throws IOException {
        BufferedReader reader = Utils.readFile("victimes_tooms.txt");
        int sum = 0;

        for (String line; (line = reader.readLine()) != null; ) {
            int id = Integer.parseInt(line.split(" - ")[0]);
            List<Float> values = Arrays.stream(line.split(" - ")[1].split(", "))
                    .map(Float::parseFloat)
                    .toList();

            if (VictimesTooms.ecartEstConstant(values)) {
                sum += id;
            }
        }

        System.out.println(sum);
    }
}
