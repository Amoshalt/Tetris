package Main;
import Controllers.MenuController;
import Fenêtre.*;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Brandon on 14/02/2017.
 */

public class TetrisApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FenetreMenu fenetreMenu = new FenetreMenu();
        MenuController menuController = new MenuController(fenetreMenu);

    }



}
