package Main;
import Fenêtre.*;
import GrilleJeux.Grille;

/**
 * Created by Brandon on 14/02/2017.
 */
public class main {


    public static void main(String[] args) {

        Grille g = new Grille();

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
        g.affichageGrilleConsole2();

    }

}
