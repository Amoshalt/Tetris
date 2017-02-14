package Pieces;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class I extends Piece {
    /**
     * Classe de la piece ressemblant à une barre
     */

    public I() {
        super();
        Case[] c = new Case[4];
        c[0].setX(0);
        c[0].setY(0);

        c[1].setX(1);
        c[1].setY(0);

        c[2].setX(2);
        c[2].setY(0);

        c[3].setX(3);
        c[3].setY(0);

        this.setCases(c);
    }
}
