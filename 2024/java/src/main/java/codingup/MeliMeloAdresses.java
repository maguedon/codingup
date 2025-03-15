package codingup;

import java.io.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class MeliMeloAdresses {
    private static final String entree = "1a6e1g1i1l1m1n1o2r2s2u1y";

    private static String calculerEmpreinte(String adresse) {
        SortedMap<String, Integer> empreinte = new TreeMap<>();

        for (int i = 0; i < adresse.length(); i++) {
            char c = adresse.charAt(i);

            if (c >= 'a' && c <= 'z') {
                String cStr = String.valueOf(c);
                if (empreinte.containsKey(cStr)) {
                    empreinte.put(cStr, empreinte.get(cStr) + 1);
                } else {
                    empreinte.put(cStr, 1);
                }
            }
        }

        StringBuilder resultat = new StringBuilder();

        empreinte.keySet().forEach(key ->
                resultat
                        .append(empreinte.get(key))
                        .append(key));

        return resultat.toString();
    }

    static void executer() throws IOException {
        BufferedReader reader = Utils.readFile("liste_adresses.txt");
        
        for (String line; (line = reader.readLine()) != null; ) {
            String empreinte = calculerEmpreinte(line);
            if (empreinte.equals(MeliMeloAdresses.entree)) {
                System.out.println(line);
                break;
            }
        }
    }
}
