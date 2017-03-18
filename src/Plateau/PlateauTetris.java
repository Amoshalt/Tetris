package Plateau;

import GrilleJeux.Case;
import GrilleJeux.Grille;
import Tetriminos.Piece;
import Tetriminos.S;

/**
 * Created by Martial TARDY on 14/03/2017.
 */
public class PlateauTetris {
    private Grille grilleTetris;
    private int score;
    private Piece pieceActu;
    private Piece pieceSuiv;

    public PlateauTetris(Grille grille, Piece pieceActu, Piece pieceSuiv) {
        this.grilleTetris = grille;
        this.pieceActu = pieceActu;
        this.pieceSuiv = pieceSuiv;
        this.score = 0;
    }


    public Grille getGrilleTetris() {
        return grilleTetris;
    }

    public void setGrilleTetris(Grille grille) {
        this.grilleTetris = grille;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Piece getPieceActu() {
        return pieceActu;
    }

    public void setPieceActu(Piece pieceActu) {
        this.pieceActu = pieceActu;
    }

    public Piece getPieceSuiv() {
        return pieceSuiv;
    }

    public void setPieceSuiv(Piece pieceSuiv) {
        this.pieceSuiv = pieceSuiv;
    }

    public void deplacementPieceActu()
    {
        int x,y;
        Piece p = this.getPieceActu();
        Case[] tabC = new Case[4];
        Grille g = this.getGrilleTetris();
        int i = 0;
        tabC = pieceActu.getCases();
        if (this.collisionBas())
        {
            System.out.println("il y a collision");
        }
        if (!this.collisionBas())
        {
            while (i< tabC.length)
            {


                x = tabC[i].getX();
                y = tabC[i].getY();
                System.out.println(" x: " + x + " y: " + y);
                tabC[i].setX(x+1);
                tabC[i].setY(y);

                i++;
            }
        }
        else
        {
            while (i< tabC.length)
            {

                System.out.println(" i : "+ i);
                x = tabC[i].getX();
                y = tabC[i].getY();
                System.out.println(" x: " + x + " y: " + y);
                g.getGrille()[x][y] = tabC[i];

                i++;
            }

        }


        p.setCases(tabC);
    }

    boolean collisionGauche()
    {
        boolean collision=false;
        Case[] tabP= pieceActu.getCases();
        Case[][] gril = this.getGrilleTetris().getGrille();
        int i= 0;

        int min = tabP[0].getY();
        for (int j = 0; j < tabP.length-1; j++)
        {
            min = Math.min(tabP[j].getY(),min);
        }

        while ( i < 4 && collision == false)
        {
            int x = tabP[i].getX();
            int y = tabP[i].getY();


            if (min==0 || !gril[x][y-1].isVide())
            {
                collision = true;
            }
            i++;
        }
        return collision;
    }


    boolean collisionBas()
    {
        boolean collision=false;
        Case[] tabP= pieceActu.getCases();
        Case[][] gril = this.getGrilleTetris().getGrille();
        int i= 0;
            while ( i < 4 && collision == false)
        {
            int x = tabP[i].getX();
            int y = tabP[i].getY();
            int max = 0;
            for (int j = 0; j < tabP.length-1; j++)
            {
                max = Math.max(tabP[j].getX(),max);
            }

            if (!gril[x+1][y].isVide() || max==gril.length-1)
            {
                collision = true;
            }
            i++;
        }
        return collision;
    }

    public void affichePlateau()
    {
        /*for (int i = 0; i < this.pieceActu.getCases().length; i++)
        {
            int x = this.getPieceActu().getCases()[i].getX();
            int y = this.getPieceActu().getCases()[i].getY();

            Grille g = this.getGrilleTetris();
            g.getGrille()[x][y] = this.getPieceActu().getCases()[i];
        }*/
        for (int i = 0; i < this.grilleTetris.getGrille().length;i++)
        {
            for (int j = 0; j < this.grilleTetris.getGrille()[0].length;j++)
            {
                this.grilleTetris.afficheCase(i,j);
            }
            System.out.println();
        }
        System.out.println();

        //System.out.println(this.getPieceActu().getCases()[2].getX() + " " + this.getPieceActu().getCases()[2].getY());
    }
}
