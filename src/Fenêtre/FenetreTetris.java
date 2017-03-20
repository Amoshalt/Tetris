package Fenêtre;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Brandon on 14/02/2017.
 */
public class FenetreTetris extends Stage {

    private GridPane gridPane;
    private Group groupeRacine;
    private Scene scene;

    private static int nbLignes = 20 ;
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

        for (int ligne = 0; ligne < nbLignes; ligne++ ){
            for ( int col = 0 ; col< nbCol ; col++ ){

                javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(30  ,30);
                rectangle.setFill(Color.WHITE);
                gridPane.add(rectangle,col,ligne);

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
