package Fenêtre;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

/**
 * Created by Brandon on 14/02/2017.
 */
public class FenetrePrincipale extends Stage {

    private GridPane gridPane;
    private Group groupeRacine;

    private static int RowNumber = 20 ;
    private static int ColsNumber = 10 ;

    public FenetrePrincipale(){

        this.setWidth(500);
        this.setHeight(1000);
        this.setTitle("TETRIS");

        this.groupeRacine = new Group();

        this.gridPane = new GridPane();
        gridPane.getColumnConstraints().add(new ColumnConstraints(25));
        gridPane.getRowConstraints().add(new RowConstraints(25));

        for (int r=0 ; r < 20 ; r++ ){
            for (int c=0 ; c < 10 ; c++){
            }
        }

        this.show();
    }



}
