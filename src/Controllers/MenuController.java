package Controllers;

import Fenêtre.FenetreMenu;
import Fenêtre.FenetreTetris;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by Brandon on 19/03/2017.
 */
public class MenuController {

    FenetreMenu fenetreMenu;
    FenetreTetris fenetreTetris;
    Button toTetris;


    public MenuController(FenetreMenu fenetreMenu){
        this.fenetreMenu = fenetreMenu;
        toTetris = fenetreMenu.getBtnTetris();
        toTetris.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tetrisButtonClick();
            }
        });
    }

    public void tetrisButtonClick(){
        fenetreTetris = new FenetreTetris();
        fenetreMenu.close();
    }

}
