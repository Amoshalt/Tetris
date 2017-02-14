package Pieces;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class S extends Piece {
    /**
     * Classe de la piece ressemblant à un S
     */

    public S() {
        super();
        Case[] c = new Case[4];
        c[0].setX(0);
        c[0].setY(0);

        c[1].setX(1);
        c[1].setY(0);

        c[2].setX(1);
        c[2].setY(1);

        c[3].setX(2);
        c[3].setY(1);

        this.setCases(c);
    }
}
