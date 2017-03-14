package Tetriminos;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class T extends Piece {
    /**
     * Classe de la piece ressemblant à un T
     */

    public T(sensPiece sens) {
        super();
        Case[] c = new Case[4];
        int[][] tab = {{0,1}, {1,1}, {1,2}, {2,1},
                {1,0}, {1,1}, {0,1}, {1,2},
                {2,2}, {1,1}, {1,0}, {0,1},
                {1,0}, {1,1}, {2,1}, {1,2}
        };
        for( int i =0; i< 3; i++)
        {
            c[i].setCouleur(Case.Couleur.VERT);
            switch (sens)
            {
                case BAS:
                    c[i].setY(tab[i+4][1]);
                    c[i].setX(tab[i+4][0]);
                    break;
                case HAUT:
                    c[i].setY(tab[i+3*4][1]);
                    c[i].setX(tab[i+3*4][0]);
                    break;
                case DROITE:
                    c[i].setY(tab[i+2*4][1]);
                    c[i].setX(tab[i+2*4][0]);
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
