package Tetriminos;

/**
 * Created by Martial TARDY on 22/03/2017.
 */
public class PieceFactory {



    public Piece[] PieceFactory(String forme) {

        Piece[] piece= new Piece[4];

        switch (forme)
        {
            case "C": piece[0] = new C(Piece.sensPiece.HAUT);
                piece[1] = new C(Piece.sensPiece.GAUCHE);
                piece[2] = new C(Piece.sensPiece.BAS);
                piece[3] = new C(Piece.sensPiece.DROITE);
                break;
            case "S": piece[0] = new S(Piece.sensPiece.HAUT);
                piece[1] = new S(Piece.sensPiece.GAUCHE);
                piece[2] = new S(Piece.sensPiece.BAS);
                piece[3] = new S(Piece.sensPiece.DROITE);
                break;
            case "Si": piece[0] = new Si(Piece.sensPiece.HAUT);
                piece[1] = new Si(Piece.sensPiece.GAUCHE);
                piece[2] = new Si(Piece.sensPiece.BAS);
                piece[3] = new Si(Piece.sensPiece.DROITE);
                break;
            case "Li": piece[0] = new Li(Piece.sensPiece.HAUT);
                piece[1] = new Li(Piece.sensPiece.GAUCHE);
                piece[2] = new Li(Piece.sensPiece.BAS);
                piece[3] = new Li(Piece.sensPiece.DROITE);
                break;
            case "L": piece[0] = new L(Piece.sensPiece.HAUT);
                piece[1] = new L(Piece.sensPiece.GAUCHE);
                piece[2] = new L(Piece.sensPiece.BAS);
                piece[3] = new L(Piece.sensPiece.DROITE);
                break;
            case "I": piece[0] = new I(Piece.sensPiece.HAUT);
                piece[1] = new I(Piece.sensPiece.GAUCHE);
                piece[2] = new I(Piece.sensPiece.BAS);
                piece[3] = new I(Piece.sensPiece.DROITE);
                break;
            case "T": piece[0] = new T(Piece.sensPiece.HAUT);
                piece[1] = new T(Piece.sensPiece.GAUCHE);
                piece[2] = new T(Piece.sensPiece.BAS);
                piece[3] = new T(Piece.sensPiece.DROITE);
                break;
            default: piece[0] = new Piece();
                piece[1] = new Piece();
                piece[2] = new Piece();
                piece[3] = new Piece();
        }

        return piece;
    }


}
