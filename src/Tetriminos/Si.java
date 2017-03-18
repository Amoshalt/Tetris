package Tetriminos;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class Si extends Piece {
    /**
     * Classe de la piece ressemblant à un S inversé
     */

    public Si(sensPiece sens) {
        super();
        Case[] c = new Case[4];
        int[][] tab = {{2,1}, {1,1}, {1,2}, {0,2},
                {1,0}, {1,1}, {2,1}, {2,2},
        };
        c[0]= new Case(false,0,0);
        c[1]= new Case(false,0,0);
        c[2]= new Case(false,0,0);
        c[3]= new Case(false,0,0);
        for( int i =0; i< 4; i++)
        {
            c[i].setCouleur(Case.Couleur.ORANGE);
            switch (sens)
            {
                case BAS:
                    c[i].setY(tab[i+4][1]);
                    c[i].setX(tab[i+4][0]);
                    break;
                case HAUT:
                    c[i].setY(tab[i+4][1]);
                    c[i].setX(tab[i+4][0]);
                    break;
                case DROITE:
                    c[i].setY(tab[i][1]);
                    c[i].setX(tab[i][0]);
                    break;
                case GAUCHE:
                    c[i].setY(tab[i][1]);
                    c[i].setX(tab[i][0]);
                    break;
                default:
            }
        }
        this.setCases(c);
    }
}
