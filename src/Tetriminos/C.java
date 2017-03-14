package Tetriminos;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class C extends Piece {
    /**
     * Classe de la piece cubique
     */


    public C(sensPiece sens) {
        super();
        Case[] c = new Case[4];
        int[][] tab = {{0,0}, {0,1}, {1,1}, {1,0}};

        for (int i = 0; i <3 ; i++)
        {
            c[i].setCouleur(Case.Couleur.ROUGE);
            c[i].setY(tab[i][1]);
            c[i].setX(tab[i][0]);
        }

        this.setCases(c);
    }
}
