package codingup.modeles;

import java.util.ArrayList;
import java.util.List;

public class Noeud {
    int index;
    int valeur;
    List<Noeud> voisins = new ArrayList<>();

    public Noeud(int index, int valeur) {
        this.index = index;
        this.valeur = valeur;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public List<Noeud> getVoisins() {
        return voisins;
    }

    public void addVoisin(Noeud voisin) {
        this.voisins.add(voisin);
    }
}
