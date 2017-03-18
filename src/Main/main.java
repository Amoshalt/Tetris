package Main;
import Fenêtre.*;
import GrilleJeux.Grille;
import Plateau.PlateauTetris;
import Tetriminos.C;
import Tetriminos.Piece;
import Tetriminos.S;

/**
 * Created by Brandon on 14/02/2017.
 */
public class main {


    public static void main(String[] args) {

        Grille g = new Grille(10,10);
/*
        g.affichageGrilleConsole();
        for (int j = 0; j < g.getGrille()[1].length; j++)
        {

            g.getGrille()[9][j].setVide(false);

            g.getGrille()[5][j].setVide(false);
            g.getGrille()[0][j].setVide(false);
        }

        g.getGrille()[5][6].setVide(true);
        g.getGrille()[6][0].setVide(false);
        g.getGrille()[7][1].setVide(false);
        g.getGrille()[8][2].setVide(false);
        g.getGrille()[9][3].setVide(false);

        g.affichageGrilleConsole();
        g.suppLignes();
        g.affichageGrilleConsole();
        g.affichageGrilleConsole2();*/

        PlateauTetris p = new PlateauTetris(g,new Piece(),new Piece());
        p.setPieceActu(p.PieceAleatoire());
        p.setPieceSuiv(p.PieceAleatoire());
        g.getGrille()[9][1].setVide(false);
        for(int i = 0; i< 70; i++)
        {
            if(i%10 == 0)
            {
                p.affichePlateau();
                //System.out.println("\n piece suiv = " + p.getPieceActu().getClass());

            }
            /*System.out.print(p.getPieceActu().getCases()[0].getX());
            System.out.println(p.getPieceActu().getCases()[0].getY());
            System.out.print(p.getPieceActu().getCases()[1].getX());
            System.out.println(p.getPieceActu().getCases()[1].getY());
            System.out.print(p.getPieceActu().getCases()[2].getX());
            System.out.println(p.getPieceActu().getCases()[2].getY());
            System.out.print(p.getPieceActu().getCases()[3].getX());
            System.out.println(p.getPieceActu().getCases()[3].getY()+ "\n");*/
            p.deplacementDroitPieceActu();
            p.deplacementPieceActu();

        }


    }

}
