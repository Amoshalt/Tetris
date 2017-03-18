package Fenêtre;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

/**
 * Created by Brandon on 14/02/2017.
 */
public class FenetreTetris extends Stage {

    private GridPane gridPane;
    private Group groupeRacine;
    private Scene scene;

    private static int nbLigne = 10 ;
    private static int nbCol = 10 ;

    private final int graphicWidth = 800 ;
    private final int graphicHeigh = 1000 ;


    public FenetreTetris(){

        this.setWidth(graphicWidth);
        this.setHeight(graphicHeigh);
        this.setTitle("TETRIS");

        this.groupeRacine = new Group();
        this.gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(5));

        BackgroundFill backgroundFill = new BackgroundFill(javafx.scene.paint.Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background labelBackground = new Background(backgroundFill);

        for (int ligne = 0 ; ligne < nbLigne ; ligne++ ){
            for ( int col = 0 ; col< nbCol ; col++ ){

                javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(30  ,30);
                rectangle.setFill(Color.WHITE);
                gridPane.add(rectangle,ligne,col);

            }
        }

        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane,graphicWidth,graphicHeigh, Color.GRAY);

        this.setTitle("TETRIS");
        this.setScene(scene);
        this.show();
    }



}
