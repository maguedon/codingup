package codingup;

public class Nombres42Compatibles {

    private static boolean produitDivisiblePar42(String str) {
        int produit = 1;

        for (int i = 0; i < str.length(); i++) {
            produit *= (str.charAt(i) - '0');
        }

        return (produit % 42) == 0;
    }

    private static boolean sommeDivisiblePar42(String str) {
        int somme = 0;

        for (int i = 0; i < str.length(); i++) {
            somme += (str.charAt(i) - '0');
        }

        return (somme % 42) == 0;
    }

    private static boolean contientDesZeros(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    static void executer() {
        int nbNombres42Compatibles = 0;


        for (int i = 178899; i <= 999762; i++) {
            String str = String.valueOf(i);
            if (!contientDesZeros(str) && sommeDivisiblePar42(str) && produitDivisiblePar42(str)) {
                nbNombres42Compatibles++;
            }
        }

        System.out.println(nbNombres42Compatibles);
    }
}
