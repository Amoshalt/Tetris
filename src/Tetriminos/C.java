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
        c[0]= new Case(false,0,0);
        c[1]= new Case(false,0,0);
        c[2]= new Case(false,0,0);
        c[3]= new Case(false,0,0);
        int[][] tab = {{0,0}, {0,1}, {1,1}, {1,0}};

        for (int i = 0; i <4 ; i++)
        {
            c[i].setCouleur(Case.Couleur.ROUGE);
            c[i].setY(tab[i][1]);
            c[i].setX(tab[i][0]);
        }

        this.setCases(c);
    }
}
