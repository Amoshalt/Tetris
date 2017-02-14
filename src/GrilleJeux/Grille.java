package GrilleJeux;

import GrilleJeux.Case;

import java.util.ArrayList;

/**
 * Created by Martial TARDY on 11/02/2017.
 */
public class Grille {
    private Case[][] grille;

    public Grille() {
        this.grille = new Case[10][10];
    }

    public Case[][] getGrille() {
        return grille;
    }

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    public Case getCasegrille(int i, int j)
    {
        return this.grille[i][j];
    }

    public ArrayList EvaluerGrille()
    {
        int i=0,j=0;
        ArrayList tabLignePleines = new ArrayList();
        Case[][] g = this.grille;
        boolean forme= true;
        while (i<g.length)
        {
            forme= true;
            while ((j<g[i].length) && forme)
            {
                /*if (g[i][j].getValeur()== Case.Couleur.VIDE)
                {
                    forme = false;
                }*/
                j++;
            }
            if (forme)
            {
                tabLignePleines.add(i);
            }
            i++;
        }
        return tabLignePleines;
    }
}
