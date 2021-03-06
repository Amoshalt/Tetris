package GrilleJeux;

import javafx.scene.paint.*;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * Created by Martial TARDY on 11/02/2017.
 */
public class Case {

    /**
     * Classe de la case.
     */
    public enum Couleur
    {
        ROUGE(Color.RED),
        BLEU(Color.BLUE),
        VERT(Color.GREEN),
        CYAN(Color.CYAN),
        VIOLET(Color.PURPLE),
        ORANGE(Color.ORANGE),
        JAUNE(Color.YELLOW),
        GRIS(Color.GRAY);

        private Color codeCouleur;
        Couleur(Color codeCouleur){
            this.codeCouleur = codeCouleur;
        }

        public Color getCouleur(){
            return this.codeCouleur;
        }
    }

    private boolean vide;
    private int x, y;
    private Couleur couleur;


    public Case(boolean vide, int x, int y) {
        this.vide = vide;
        this.x = x;
        this.y = y;
        this.couleur = Couleur.GRIS;
    }

    public boolean isVide() {
        return vide;
    }

    public void setVide(boolean vide) {
        this.vide = vide;
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

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

}