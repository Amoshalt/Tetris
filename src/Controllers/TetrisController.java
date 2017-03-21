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

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Brandon on 14/03/2017.
 */
public class TetrisController implements Observer{

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
                if (event.getCode().equals(KeyCode.SPACE)){
                    tourner();
                }
            }
        };

    }

    @Override
    public void update(Observable o, Object arg) {
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
        if (!modelTetris.collisionDroite()) {
            modelTetris.deplacementDroitePieceActu();
        }
    }

    public void bougerGauche(){
        if(!modelTetris.collisionGauche()){
            modelTetris.deplacementGauchePieceActu();
        }
    }

    public void descendre(){
        if (!modelTetris.collisionBas()){
            modelTetris.deplacementPieceActu();
        }
    }

    public void tourner(){
        /*
        if (!modelTetris.collisionRotation());
        */
    }

}
