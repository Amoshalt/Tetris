import GrilleJeux.Grille;

/**
 * Created by Martial TARDY on 11/02/2017.
 */
public class Tetris {
    public static void main(String[] args) {
        Grille grid = new Grille();
/*
        affichageConsole(grid);
*/
    }
/*
    public static void affichageConsole (Grille grille)
    {
        String caract = " ";
        for (int i= 0 ; i< grille.getGrille().length; i++)
        {
            for (int j = 0 ; j < grille.getGrille().length; j++)
            {
                switch (grille.getCasegrille(i,j).getValeur().toString())
                {
                    case "VIDE" : caract = "#";
                    break;
                    case "ROUGE" : caract = "r";
                        break;
                    case "BLEU" : caract = "b";
                        break;
                    case "VERT" : caract = "v";
                        break;
                    case "ORANGE" : caract = "o";
                        break;
                }
                System.out.print(caract + " ");
            }
            System.out.println();
        }
    }
    */
}
