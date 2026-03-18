package codingup;

import codingup.modeles.Noeud;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DossiersWarren {
    private static final List<Noeud> noeuds = new ArrayList<>();
    private static int nbNoeuds = 0;
    private static List<Integer> sequence;

    private static void initialiserNoeuds() throws IOException {
        BufferedReader reader = Utils.readFile("dossiers_warren.txt");

        reader.readLine(); // "Nombres de noeuds"

        // Nb Noeuds
        String line = reader.readLine();
        nbNoeuds = Integer.parseInt(line);

        reader.readLine(); // "Puissances"

        // Puissances
        line = reader.readLine();
        List<String> puissances = Arrays.stream(line.split(", ")).toList();

        for (int i = 0; i < puissances.size(); i++) {
            noeuds.add(
                    new Noeud(i, Integer.parseInt(puissances.get(i))));
        }

        reader.readLine(); // "Voisins"

        // Voisins
        for (int i = 0; i < nbNoeuds; i++) {
            line = reader.readLine();

            List<String> params = Arrays.stream(line.split(" : ")).toList();
            int index = Integer.parseInt(params.getFirst());
            Noeud noeudCourant = noeuds.get(index);

            Arrays.stream(params.get(1).split(", "))
                    .map(Integer::parseInt)
                    .forEach(indexVoisin -> {
                        noeudCourant.addVoisin(noeuds.get(indexVoisin));
                    });
        }

        reader.readLine(); // "Sequence"

        // Sequence
        line = reader.readLine();
        sequence = Arrays.stream(line.split(", "))
                .map(Integer::parseInt)
                .toList();

    }

    private static List<Integer> chercherSequenceDossiers(List<Noeud> noeuds, List<Integer> sequence) {
        List<Noeud> noeudsCorrespondants = noeuds.stream()
                .filter(noeud -> noeud.getValeur() == sequence.getFirst())
                .toList();

        if (sequence.size() == 1) {
            if (noeudsCorrespondants.size() == 1) {
                return List.of(noeudsCorrespondants.getFirst().getIndex());
            } else {
                return null;
            }
        }
        
        for (Noeud noeud : noeudsCorrespondants) {
            List<Noeud> voisins = noeud.getVoisins();
            List<Integer> sequenceTronquee = sequence.subList(1, sequence.size());

            List<Integer> resultat = chercherSequenceDossiers(voisins, sequenceTronquee);

            if (resultat != null) {
                List<Integer> retour = new ArrayList<>();
                retour.add(noeud.getIndex());
                retour.addAll(resultat);

                return retour;
            }
        }

        return null;
    }

    public static void executer() throws IOException {
        initialiserNoeuds();

        List<Integer> resultat = chercherSequenceDossiers(noeuds, sequence);

        System.out.println(resultat);
    }
}
