/**
 * Created by Martial TARDY on 11/02/2017.
 */
public class Case {
    public enum Couleur {
        BLEU,
        ROUGE,
        VERT,
        ORANGE,
        VIDE
    }

    private Couleur valeur;
    private int x, y;

    public Case(Couleur valeur, int x, int y) {
        this.valeur = valeur;
        this.x = x;
        this.y = y;
    }

    public Couleur getValeur() {
        return valeur;
    }

    public void setValeur(Couleur valeur) {
        this.valeur = valeur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}