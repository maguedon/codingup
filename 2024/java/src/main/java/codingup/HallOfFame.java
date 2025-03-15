package codingup;

import java.util.List;

import static java.util.Arrays.asList;

public class HallOfFame {
    private static void decalerLettres(int decalage) {
        String mot = "UHMRLJQHC-QRXV";

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) != '-') {
                int c = mot.charAt(i);
                if (c + decalage > 90) {
                    c = 65 + c + decalage - 90;
                } else {
                    c += decalage;
                }
//                System.out.print((char) (mot.charAt(i) + decalage));
                System.out.print((char)c);
            } else {
                System.out.print(mot.charAt(i));
            }
        }
    }

    private static void dechiffrer() {
        List<Integer> liste = asList(0x45, 0x54, 0x20, 0x50, 0x41, 0x52, 0x54, 0x41, 0x47, 0x45, 0x5A, 0x20, 0x56, 0x4F, 0x54, 0x52, 0x45);

        for (Integer nb : liste) {
            System.out.print((char)((int)nb));
        }
    }

    public static void executer() {
        decalerLettres(22);
        System.out.println();

        dechiffrer();
        System.out.println();

        // Braille
        System.out.println("passion pour");

        // nombre à 7 bits (blanc = 0, noir = 1)
        List<Integer> code = asList(
                0B1001100,
                0B1000001,
                (int) ' ',
                0B1010000,
                0B1010010,
                0B1001111,
                0B1000111,
                0B1000001,
                0B1001101,
                0B1001101,
                0B1000001,
                0B1010100,
                0B1001111,
                0B1001110
        );

        code.forEach(s -> System.out.print((char)s.intValue()));
        System.out.println();

        // Morse
        System.out.println("ajoutez votre nom");

        // cryptographie de substitution
        System.out.println("au hall of fame");

        // Superposition des parties de gauche et de droite
        System.out.println("des plus fins");

        // emoticones
        // Poubelle
        // Reddit
        // Ordinateur
        // Gateau
        // Route
        // Avion
        // Maison
        // Micro
        // Entonnoir
        // USB
        // Reddit
        // Sapin
        System.out.println("programmeurs");

        String resultat = "REJOIGNEZ-NOUS" +
                "ET PARTAGEZ VOTRE" +
                "passion pour" +
                "LA PROGRAMMATION" +
                "ajoutez votre nom" +
                "au hall of fame" +
                "des plus fins" +
                "programmeurs";

        resultat = resultat.toLowerCase();
        int val = 0;
        for (int i = 0; i < resultat.length(); i++) {
            char c = resultat.charAt(i);
            if (c != ' ' && c != '-') {
                val += (c - 'a' + 1);
            }
        }
        System.out.println(val);

    }
}
