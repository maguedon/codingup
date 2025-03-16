package codingup;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class GargleBlastersCipher {
    private static final String messageChiffre = "1jlXmyHooOo5Sfxrq7TyinEG2bHU67R.sv 3AJICAavmdbHjeWCpHvx0CHRyACcn";
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 .";

    private static List<Integer> recupererCleDansSequence() throws IOException {
        LinkedHashMap<String, Integer> sequence = new LinkedHashMap<>();

        BufferedReader reader = Utils.readFile("sequenceGargleBlastersCipher.txt");

        for (String line; (line = reader.readLine()) != null;) {
            List<String> nombres = Arrays.stream(line.split(",")).toList();
            nombres.forEach(nombre -> {
                if (sequence.containsKey(nombre)) {
                    sequence.computeIfPresent(nombre, (k, v) -> v + 1);
                } else {
                    sequence.put(nombre, 1);
                }
            });
        }

        return sequence.keySet().stream()
                .filter(key -> sequence.get(key) == 1)
                .map(Integer::parseInt)
                .toList();
    }

    private static List<Integer> transformerEnNombre(String message) {
        List<Integer> resultat = new ArrayList<>();

        for (int i = 0; i < message.length(); i++) {
            resultat.add(alphabet.indexOf(message.charAt(i)));
        }

        return resultat;
    }

    private static List<Integer> dechiffrer(List<Integer> messageChiffre, List<Integer> cle) {
        List<Integer> resultat = new ArrayList<>();
        int indexCle = 0;

        for (Integer nombre : messageChiffre) {
            resultat.add(nombre ^ cle.get(indexCle));

            if (indexCle < cle.size() - 1) {
                indexCle++;
            } else {
                indexCle = 0;
            }
        }

        return resultat;
    }

    private static String transformerEnString(List<Integer> messageEnNombre) {
        StringBuilder str = new StringBuilder();

        for (Integer nombre : messageEnNombre) {
            str.append(alphabet.charAt(nombre));
        }

        return str.toString();
    }

    public static void executer() throws IOException {
        List<Integer> cle = recupererCleDansSequence();

        List<Integer> messageChiffreEnNombres = transformerEnNombre(messageChiffre);
        List<Integer> messageDeChiffreEnNombres = dechiffrer(messageChiffreEnNombres, cle);
        String resultat = transformerEnString(messageDeChiffreEnNombres);

        System.out.println(resultat);
    }
}
