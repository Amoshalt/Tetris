package Plateau;

import GrilleJeux.Case;
import GrilleJeux.Grille;
import Tetriminos.*;

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
        Piece p = this.getPieceActu();
        if (this.collisionBas())
        {
            /*System.out.println("il y a collision");*/
        }
        if (!this.collisionBas())
        {
            p.deplacementBas();
        }
        else
        {
            encrageSurGrille();
            changementPieceActu();

        }
    }

    public void deplacementDroitePieceActu()
    {
        Piece p = this.getPieceActu();
        if (!this.collisionDroite())
        {
            p.deplacementDroite();
        }

    }

    public void deplacementGauchePieceActu()
    {
        Piece p = this.getPieceActu();
        if (!this.collisionGauche())
        {
            p.deplacementGauche();
        }

    }

    public void encrageSurGrille()
    {
        int x,y;
        Piece p = this.getPieceActu();
        Case[] tabC;
        Grille g = this.getGrilleTetris();
        int i = 0;
        tabC = pieceActu.getCases();
        while (i< tabC.length)
        {

            //System.out.println(" i : "+ i);
            x = tabC[i].getX();
            y = tabC[i].getY();
            //System.out.println(" x: " + x + " y: " + y);
            g.getGrille()[x][y] = tabC[i];

            i++;
        }
    }

    public boolean collisionGauche()
    {
        boolean collision=false;
        Case[] tabP= pieceActu.getCases();
        Case[][] gril = this.getGrilleTetris().getGrille();
        int i= 0;

        int min = tabP[0].getY();
        for (int j = 0; j < tabP.length; j++)
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


    public boolean collisionBas()
    {
        boolean collision=false;
        Case[] tabP= pieceActu.getCases();
        Case[][] gril = this.getGrilleTetris().getGrille();
        int i= 0;
        int Xmax = 0;
        for (int j = 0; j < tabP.length; j++)
        {
            Xmax = Math.max(Xmax,tabP[j].getX());
        }
        //System.out.print("max: " + Xmax+ "\n");
        if (Xmax != gril.length-1)
        {
            while ( i < 4 && collision == false)
            {

                int x = tabP[i].getX();
                int y = tabP[i].getY();
                //System.out.print(" x : "+ x);
                //System.out.println(" y : "+ y);
                if (!gril[x+1][y].isVide() )
                {
                    collision = true;
                }
                i++;
            }
        }
        else
        {
            collision = true;
        }
        return collision;
    }

    public boolean collisionDroite()
    {
        boolean collision=false;
        Case[] tabP= pieceActu.getCases();
        Case[][] gril = this.getGrilleTetris().getGrille();
        int i= 0;

        int max = tabP[0].getY();
        for (int j = 0; j < tabP.length; j++)
        {
            max = Math.max(tabP[j].getY(),max);
        }

        while ( i < 4 && collision == false)
        {
            int x = tabP[i].getX();
            int y = tabP[i].getY();


            if (max==gril[x].length-1 || !gril[x][y+1].isVide())
            {
                collision = true;
            }
            i++;
        }
        return collision;
    }

    public void changementPieceActu()
    {
        Piece p = this.getPieceSuiv();
        Piece newPiece = new C(Piece.sensPiece.HAUT);
        this.setPieceActu(p);
        this.centrerPiece();
        this.setPieceSuiv(newPiece);
    }

    public Piece PieceAleatoire()
    {
        int indice = (int)(Math.random()*7);
        Piece p;


        switch (indice )
        {
            case 0: p = new C(Piece.sensPiece.HAUT);
                break;
            case 1: p = new S(Piece.sensPiece.HAUT);
                break;
            case 2: p = new Si(Piece.sensPiece.HAUT);
                break;
            case 3: p = new L(Piece.sensPiece.HAUT);
                break;
            case 4: p = new Li(Piece.sensPiece.HAUT);
                break;
            case 5: p = new I(Piece.sensPiece.HAUT);
                break;
            case 6: p = new T(Piece.sensPiece.HAUT);
                break;

            default: p = new Piece();
                break;

        }
        return p;
    }

    public void centrerPiece()
    {
        Piece p = pieceActu;
        Case[] c = p.getCases();
        for (int i = 0; i <4; i++)
        {
            c[i].setY(c[i].getY() + grilleTetris.getGrille()[0].length/2);
        }
        pieceActu.setCases(c);
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
