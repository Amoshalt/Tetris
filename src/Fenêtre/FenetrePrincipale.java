package Fenêtre;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brandon on 14/02/2017.
 */
public class FenetrePrincipale extends Stage {

    private GridPane gridPane;

    public FenetrePrincipale(){

        this.setWidth(500);
        this.setHeight(1000);
        this.setTitle("TETRIS");

        this.gridPane = new GridPane();
        for (int r=0 ; r < 20 ; r++ ){
            for (int c=0 ; c < 10 ; c++){

            }
        }
    }



}
