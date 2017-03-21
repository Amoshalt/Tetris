package Controllers;

import Fenêtre.FenetreTetris;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by Brandon on 14/03/2017.
 */
public class TetrisController {

    private FenetreTetris fenetreTetris;

    EventHandler<KeyEvent> listener;

    public TetrisController(FenetreTetris fenetreTetris){
        this.fenetreTetris = fenetreTetris;

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
