package GrilleJeux;

import GrilleJeux.Case;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Martial TARDY on 11/02/2017.
 */
public class Grille {
    private Case[][] grille;

    public Grille() {
        this.grille = new Case[10][10];
        for (int i = 0 ; i< this.grille.length;i++)
        {
            for (int j = 0 ; j< this.grille[i].length;j++)
            {
                this.grille[i][j] = new Case(true,i,j);
            }
        }
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
        boolean ligne= true;
        for(i=0;i<g.length;i++)
        {
            ligne= true;
            while ((j<g[i].length) && ligne)
            {
                if (g[i][j].isVide())
                {
                    ligne = false;
                }
                j++;
            }
            if (ligne)
            {
                tabLignePleines.add(i);
                System.out.println(i);

            }
            j = 0;
        }
        return tabLignePleines;
    }

    public void suppLignes()
    {
        ArrayList ligneASupp = EvaluerGrille();
        Case[][] g = this.grille;
        int numLigne = 0;
        int numArray = ligneASupp.size()- 1;
        int nbLigne = 0;//1; //nombre courant du décalage
        if (ligneASupp.size() >= 1)
        {
            numLigne = (int) ligneASupp.get(numArray);
            //nbLigne = 9 - numLigne;
            for (int i = g.length - 1; i >= 0; i--)
            {
                System.out.println("i: " + i +" nbLigne: " + nbLigne + " numLigne: " + numLigne + " numArray: " + numArray);
                if (i != numLigne)
                {
                    if(nbLigne != 0)
                    {
                        for (int j =g[i].length - 1 ; j >= 0; j--)
                        {
                            g[i+nbLigne][j] = new Case(g[i][j].isVide(),i+nbLigne,j);
                            g[i][j].setVide(true);
                        }
                    }

                    affichageGrilleConsole();


                }
                else
                {

                    System.out.println("On a trouvé une ligne pleine");
                    for (int j =g[i].length - 1 ; j >= 0; j--)
                    {
                        g[i][j].setVide(true);
                    }
                    if (numArray > 0)
                    {numArray--;}
                    nbLigne++;
                    numLigne = (int) ligneASupp.get(numArray);
                }



            }
        }

    }

    public void affichageGrilleConsole()
    {
        Case[][] g = this.getGrille();

        for (int i = 0; i < g.length; i++)
        {
            for (int j = 0 ; j <g[i].length ; j++) {

                if (g[i][j].isVide())
                {
                    System.out.print(" v ");
                }
                else
                {
                    System.out.print(" p ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    public void affichageGrilleConsole2()
    {
        Case[][] g = this.getGrille();

        for (int i = 0; i < g.length; i++)
        {
            for (int j = 0 ; j <g[i].length ; j++) {

                System.out.print(" " +g [i][j].getX());
                System.out.print(g [i][j].getY() + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }
}
