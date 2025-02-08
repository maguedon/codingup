import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

class Sommet {
    private int x,y;
    private Color color;
    private Set<Color> couleursRencontrees = new HashSet<>();
    private int distance = 1;
    private Sommet prev;

    public Sommet(int x, int y, Set<Color> couleursRencontrees, Sommet prev, Color color) {
        this.x = x;
        this.y = y;
        this.prev = prev;
        this.color = color;

        if (couleursRencontrees != null) {
            this.couleursRencontrees = new HashSet<>(couleursRencontrees);
        } else {
            this.couleursRencontrees = new HashSet<>();
        }
        if (this.couleursRencontrees.contains(color)) {
            this.distance = 0;
        }
        this.couleursRencontrees.add(this.color);

        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDistance() {
        return distance;
    }

    public Sommet getPrev() {
        return prev;
    }

    public Set<Color> getCouleursRencontrees() {
        return couleursRencontrees;
    }

    public String toString() {
        return this.x+"/"+this.y+"/"+this.couleursRencontrees.size();
    }
}

public class PisteBlocsLaines {

    // For storing image in RAM
    private BufferedImage image = null;
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    private Sommet getPath() {
        int x = 0;
        int y = this.image.getHeight()/2;
        Sommet deb = new Sommet(x, y, null, null, this.getColor(x,y));
        ArrayDeque<Sommet> file = new ArrayDeque<>();
        file.addFirst(deb);
        Sommet fin = null;
        
        while (!file.isEmpty()) {
            Sommet s = file.removeFirst();
            if (s.getX() == this.image.getWidth() - 1) {
                fin = s;
                break;
            }
            List<Sommet>voisins = getVoisins(s);
            for (Sommet v: voisins) {
                if (s.getPrev() == null || v.getX() != s.getPrev().getX() || v.getY() != s.getPrev().getY()) {
                    if (v.getDistance() == 0) {
                        file.addFirst(v);
                    } else {
                        file.addLast(v);
                    }
                }
            }
        }
        
        return fin;
    }

    private Color getColor(int x, int y) {
        return new Color(this.image.getRGB(x, y));
    }

    private List<Sommet> getVoisins(Sommet s) {
        List<Sommet> voisins = new ArrayList<Sommet>();

        if (s.getX() < this.image.getWidth() - 1) {
            int x = s.getX()+1;
            int y = s.getY();
            Sommet v = new Sommet(x, y, s.getCouleursRencontrees(), s, this.getColor(x,y));
            voisins.add(v);
        }
        if (s.getY() > 0) {
            int x = s.getX();
            int y = s.getY()-1;
            Sommet v = new Sommet(x, y, s.getCouleursRencontrees(), s, this.getColor(x,y));
            voisins.add(v);
        }
        if (s.getY() < this.image.getHeight() - 1) {
            int x = s.getX();
            int y = s.getY()+1;
            Sommet v = new Sommet(x, y, s.getCouleursRencontrees(), s, this.getColor(x,y));
            voisins.add(v);
        }

        return voisins;
    }
    
    public static void main(String[] args) {
        PisteBlocsLaines pbl = new PisteBlocsLaines();
  
        // READ IMAGE
        try {
            File input_file = new File("map_color.png");
  
            // Reading input file
            pbl.setImage(ImageIO.read(input_file));

            String chemin = "";
            Sommet s = pbl.getPath();
            Sommet prev = s.getPrev();

            while (s != null && prev != null) {
                chemin = pbl.getDirection(prev, s) + chemin;
                s = prev;
                prev = prev.getPrev();
            }

            System.out.println(chemin);
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private char getDirection(Sommet src, Sommet dest) {
        if (src.getX() + 1 == dest.getX()) {
            return 'D';
        }
        if (src.getY() + 1 == dest.getY()) {
            return 'B';
        }
        return 'H';
    }
}