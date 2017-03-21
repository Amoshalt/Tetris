package Controllers;

import Fenêtre.FenetreTetris;
import GrilleJeux.Case;
import Plateau.PlateauTetris;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Brandon on 14/03/2017.
 */
public class TetrisController {

    private FenetreTetris fenetreTetris;
    EventHandler<KeyEvent> listener;
    private GridPane grilleVue;

    private PlateauTetris modelTetris;
    private Case[][] grilleTetris;

    public TetrisController(FenetreTetris fenetreTetris, PlateauTetris plateauTetris){
        this.fenetreTetris = fenetreTetris;
        this.grilleVue = fenetreTetris.getGridPane();
        this.modelTetris = plateauTetris;

        listener = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.RIGHT)){
                    bougerDroite();
                }
                if(event.getCode().equals(KeyCode.LEFT)){
                    bougerGauche();
                }
                if(event.getCode().equals(KeyCode.DOWN)){
                    descendre();
                }
            }
        };

    }

    public void update(){
        grilleTetris = modelTetris.getGrillePartielle();

        int lignes = grilleTetris.length;
        int colones = grilleTetris[1].length;

        ObservableList<Node> listeRectangles = grilleVue.getChildren();

        for(int ligne=0 ; ligne < lignes ; ligne ++ ){
            for(int col = 0 ; col < colones ; col ++){
                int indice = ligne*colones + col;

                Rectangle rectangle = (Rectangle)listeRectangles.get(indice);
                if (grilleTetris[ligne][col].isVide()){
                    rectangle.setFill(Color.WHITE);
                }
                else {
                    switch (grilleTetris[ligne][col].getCouleur()){
                        case BLEU:rectangle.setFill(Color.BLUE);break;
                        case CYAN:rectangle.setFill(Color.CYAN);break;
                        case JAUNE:rectangle.setFill(Color.YELLOW);break;
                        case ORANGE:rectangle.setFill(Color.ORANGE);break;
                        case ROUGE:rectangle.setFill(Color.RED);break;
                        case VERT:rectangle.setFill(Color.GREEN);break;
                        case VIOLET:rectangle.setFill(Color.PURPLE);break;
                        default:rectangle.setFill(Color.WHITE);break;
                    }
                }

            }
        }



    }

    public void bougerDroite(){
        boolean possible = checkPossible("droite");
        if (possible){

        }
    }

    public void bougerGauche(){
        boolean possible = checkPossible("gauche");
        if (possible){

        }
    }

    public void descendre(){
        boolean possible = checkPossible("bas");
        if (possible){

        }
    }

    public boolean checkPossible(String direction){
        return true;
    }

}
