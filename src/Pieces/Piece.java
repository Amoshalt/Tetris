package Pieces;

import GrilleJeux.Case;

/**
 * Created by Brandon on 14/02/2017.
 */
public class Piece {

    private Case[] cases;

    public Piece() {
        this.cases = new Case[4];
    }

    public Case[] getCases() {
        return cases;
    }

    public void setCases(Case[] cases) {
        this.cases = cases;
    }
}
