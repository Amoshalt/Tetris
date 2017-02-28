package Tetriminos;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class L extends Piece {
    /**
     * Classe de la piece ressemblant à un L
     */

    public L() {
        super();
        Case[] c = new Case[4];
        c[0].setX(0);
        c[0].setY(0);

        c[1].setX(1);
        c[1].setY(0);

        c[2].setX(2);
        c[2].setY(0);

        c[3].setX(2);
        c[3].setY(1);

        this.setCases(c);
    }
}
