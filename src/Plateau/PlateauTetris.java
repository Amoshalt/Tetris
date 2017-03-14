package Plateau;

import GrilleJeux.Grille;
import Tetriminos.Piece;

/**
 * Created by Martial TARDY on 14/03/2017.
 */
public class PlateauTetris {
    private Grille grille;
    private int score;
    private Piece pieceActu;
    private Piece pieceSuiv;

    public PlateauTetris(Grille grille, Piece pieceActu, Piece pieceSuiv) {
        this.grille = grille;
        this.pieceActu = pieceActu;
        this.pieceSuiv = pieceSuiv;
        this.score = 0;
    }




}
