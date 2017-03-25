package Plateau;

import GrilleJeux.Case;
import GrilleJeux.Grille;
import Tetriminos.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Created by Martial TARDY on 14/03/2017.
 */
public class PlateauTetris implements Runnable{
    private Grille grilleTetris;
    private int score;
    private Piece[] pieceActu;
    private Piece[] pieceSuiv;
    private int idPieceActu;
    private int idPieceSuiv;
    public Timeline timeline;

    public PlateauTetris() {
        this.grilleTetris = new Grille(20,10);
        this.score = 0;
        this.pieceActu = PieceAleatoire();
        this.pieceSuiv = PieceAleatoire();
        idPieceActu = 0;
        idPieceSuiv = 0;
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

    public Piece[] getPieceActu() {
        return pieceActu;
    }

    public void setPieceActu(Piece[] pieceActu) {
        this.pieceActu = pieceActu;
    }

    public Piece[] getPieceSuiv() {
        return pieceSuiv;
    }

    public void setPieceSuiv(Piece[] pieceSuiv) {
        this.pieceSuiv = pieceSuiv;
    }

    public int getIdPieceActu() {
        return idPieceActu;
    }

    public void setIdPieceActu(int idPieceActu) {
        this.idPieceActu = idPieceActu;
    }

    public int getIdPieceSuiv() {
        return idPieceSuiv;
    }

    public void setIdPieceSuiv(int idPieceSuiv) {
        this.idPieceSuiv = idPieceSuiv;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public void deplacementPieceActu()
    {
        Piece[] p = this.getPieceActu();
        if (this.collisionBas())
        {
            /*System.out.println("il y a collision");*/
        }
        if (!this.collisionBas()) {
            for (int i = 0; i < 4; i++) {
                p[i].deplacementBas();
            }
        }
        else
        {
            encrageSurGrille();
            changementPieceActu();

        }
    }

    public void deplacementDroitePieceActu()
    {
        Piece[] p = this.getPieceActu();
        if (!this.collisionDroite())
        {
            for (int i = 0; i < 4; i++)
                {
                    p[i].deplacementDroite();
                }
        }

    }

    public void deplacementGauchePieceActu()
    {
        Piece[] p = this.getPieceActu();
        if (!this.collisionGauche())
        {
            for (int i = 0; i < 4; i++)
            {
                p[i].deplacementGauche();
            }
        }

    }

    public void encrageSurGrille()
    {
        int x,y;
        Piece[] p = this.getPieceActu();
        Case[] tabC;
        Grille g = this.getGrilleTetris();
        int i = 0;
        tabC = pieceActu[idPieceActu].getCases();
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
        Case[] tabP= pieceActu[idPieceActu].getCases();
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
        Case[] tabP= pieceActu[idPieceActu].getCases();
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
        Case[] tabP= pieceActu[idPieceActu].getCases();
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

    public boolean collisionRotation(int idPieceRotation)
    {
        boolean collision = false;
        int j = 0;
        Case[][] g = this.getGrilleTetris().getGrille();

        while (!collision && j<4 )
        {
            int x = this.getPieceActu()[idPieceRotation].getCases()[j].getX();
            int y = this.getPieceActu()[idPieceRotation].getCases()[j].getY();


            if(!g[x][y].isVide())
            {
                collision = true;
            }
            j++;
        }


        return collision;
    }

    public Case[][]getGrillePartielle()
    {
        Case[][] grille = this.getGrilleTetris().getGrille();
        for (int i = 0; i< 4; i++)
        {
            int x = this.getPieceActu()[this.getIdPieceActu()].getCases()[i].getX();
            int y = this.getPieceActu()[this.getIdPieceActu()].getCases()[i].getY();

            grille[x][y] = this.getPieceActu()[idPieceActu].getCases()[i];
        }
        return grille;
    }

    public void changementPieceActu()
    {
        Piece[] p = this.getPieceSuiv();
        Piece[] newPiece = new Piece[4];
        newPiece = PieceAleatoire();
        this.setPieceActu(p);
        this.centrerPiece();
        this.setPieceSuiv(newPiece);
    }

    public Piece[] PieceAleatoire()
    {
        int indice = (int)(Math.random()*7);
        Piece[] p = new Piece[4];


        switch (indice )
        {
            case 0: p[0] = new C(Piece.sensPiece.HAUT);
                p[1] = new C(Piece.sensPiece.BAS);
                p[2] = new C(Piece.sensPiece.GAUCHE);
                p[3] = new C(Piece.sensPiece.DROITE);
                break;
            case 1: p[0] = new S(Piece.sensPiece.HAUT);
                p[1] = new S(Piece.sensPiece.BAS);
                p[2] = new S(Piece.sensPiece.GAUCHE);
                p[3] = new S(Piece.sensPiece.DROITE);
                break;
            case 2: p[0] = new Si(Piece.sensPiece.HAUT);
                p[1] = new Si(Piece.sensPiece.BAS);
                p[2] = new Si(Piece.sensPiece.GAUCHE);
                p[3] = new Si(Piece.sensPiece.DROITE);
                break;
            case 3: p[0] = new L(Piece.sensPiece.HAUT);
                p[1] = new L(Piece.sensPiece.BAS);
                p[2] = new L(Piece.sensPiece.GAUCHE);
                p[3] = new L(Piece.sensPiece.DROITE);
                break;
            case 4: p[0] = new Li(Piece.sensPiece.HAUT);
                p[1] = new Li(Piece.sensPiece.BAS);
                p[2] = new Li(Piece.sensPiece.GAUCHE);
                p[3] = new Li(Piece.sensPiece.DROITE);
                break;
            case 5: p[0] = new I(Piece.sensPiece.HAUT);
                p[1] = new I(Piece.sensPiece.BAS);
                p[2] = new I(Piece.sensPiece.GAUCHE);
                p[3] = new I(Piece.sensPiece.DROITE);
                break;
            case 6: p[0] = new T(Piece.sensPiece.HAUT);
                p[1] = new T(Piece.sensPiece.BAS);
                p[2] = new T(Piece.sensPiece.GAUCHE);
                p[3] = new T(Piece.sensPiece.DROITE);
                break;

            default: p[0] = new Piece();
                p[1] = new Piece();
                p[2] = new Piece();
                p[3] = new Piece();
                break;

        }
        return p;
    }

    public void centrerPiece()
    {
        Piece[] p = pieceActu;
        Case[][] c = new Case[4][4];
        c[0] = p[0].getCases();
        c[1] = p[1].getCases();
        c[2] = p[2].getCases();
        c[3] = p[3].getCases();
        for (int j = 0; j< 4 ; j++)
        {
            for (int i = 0; i <4; i++)
            {
                c[j][i].setY(c[j][i].getY() + grilleTetris.getGrille()[0].length/2);
            }
        }
        for (int j = 0; j< 4 ; j++)
        {
            pieceActu[j].setCases(c[j]);
        }
    }

    public void rotationPieceActuDroite()
    {
        if ( !collisionRotation((this.getIdPieceActu() +1 ) %4) ) {
            for (int i = 0; i < this.getPieceActu().length; i++) {
                this.getPieceActu()[i].deplacementDroite();
            }

            this.setIdPieceActu((getIdPieceActu() + 1) % 4);
        }
    }

    public void rotationPieceActuGauche()
    {
        if ( !collisionRotation((this.getIdPieceActu() -1 ) %4) )
        {
            for (int i = 0; i < this.getPieceActu().length; i++)
            {
                this.getPieceActu()[i].deplacementGauche();
            }
            this.setIdPieceActu(( getIdPieceActu() - 1 ) % 4);
        }
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

    @Override
    public void run()
    {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000 - 100 ), ae -> assemblage()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void assemblage()
    {
        this.deplacementPieceActu();

        notify();
    }
}
