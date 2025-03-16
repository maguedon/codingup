package codingup;

public class JourDeLaServiette {
    static Triplet triplet = null;
    static int nb4 = 0;


    private static boolean estValide(int somme) {
        String sommeStr = String.valueOf(somme);
        return sommeStr.matches("[42]+");
    }

    private static int calculerNb4(int nb) {
        int calcul = 0;
        String nbStr = String.valueOf(nb);

        for (int i = 0; i < nbStr.length(); i++) {
            if (nbStr.charAt(i) == '4') {
                calcul++;
            }
        }

        return calcul;
    }

    private static boolean tripletEstMeilleur(int a, int b, int c) {
        int nb4 = calculerNb4(a) + calculerNb4(b) + calculerNb4(c);

        if (nb4 > JourDeLaServiette.nb4) {
            JourDeLaServiette.nb4 = nb4;
            return true;
        }

        return false;
    }

    static void executer() {
        for (int a = 1; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                for (int c = b ; c < 1000; c++) {
                    int somme = a + b + c;
                    int produit = a * b * c;

                    if (estValide(somme) && estValide(produit)) {
                        if (triplet == null || tripletEstMeilleur(a, b, c)) {
                            triplet = new Triplet(a, b, c);
                        }
                    }
                }
            }
        }

        System.out.println(triplet);
    }
}
