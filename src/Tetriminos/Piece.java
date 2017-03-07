package Tetriminos;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class Piece {

    public enum sensPiece
    {
        HAUT,
        BAS,
        GAUCHE,
        DROITE
    }

    private Case[] cases;

    private sensPiece sens;

    public Piece() {
        this.cases = new Case[4];
        this.cases[0].setVide(false);
        this.cases[1].setVide(false);
        this.cases[2].setVide(false);
        this.cases[3].setVide(false);
        this.sens = sensPiece.HAUT;
    }

    public Case[] getCases() {
        return cases;
    }

    public void setCases(Case[] cases) {
        this.cases = cases;
    }

    public sensPiece getSens() {
        return sens;
    }

    public void setSens(sensPiece sens) {
        this.sens = sens;
    }

    public void rotationDroite()
    {
        switch (this.getSens())
        {
            case BAS: this.setSens(sensPiece.GAUCHE);
                break;
            case DROITE: this.setSens(sensPiece.BAS);
                break;
            case GAUCHE: this.setSens(sensPiece.HAUT);
                break;
            case HAUT: this.setSens(sensPiece.DROITE);
                break;
        }
    }
}
