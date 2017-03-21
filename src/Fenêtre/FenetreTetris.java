package Fenêtre;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by Brandon on 14/02/2017.
 */
public class FenetreTetris extends Stage {

    private GridPane gridPane;
    private Group groupeRacine;
    private Scene scene;
    private Label titre;
    private javafx.scene.text.Font fontTitre;
    private StackPane panePrincipal;
    private Pane paneTitre;

    private static int nbLignes = 20 ;
    private static int nbCol = 10 ;

    private final int graphicWidth = 600 ;
    private final int graphicHeigh = 850 ;


    public FenetreTetris(){

        this.setWidth(graphicWidth);
        this.setHeight(graphicHeigh);
        this.setTitle("TETRIS");
        this.titre = new Label("TETRIS");
        this.fontTitre = new Font(25);
        this.titre.setFont(fontTitre);


        this.groupeRacine = new Group();
        this.panePrincipal = new StackPane();
        this.gridPane = new GridPane();
        this.paneTitre = new Pane();

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

        titre.setAlignment(Pos.CENTER);

        paneTitre.getChildren().add(titre);

        panePrincipal.getChildren().addAll(paneTitre,gridPane);

        scene = new Scene(panePrincipal,graphicWidth,graphicHeigh, Color.GRAY);


        this.setTitle("TETRIS");
        this.setScene(scene);
        this.show();
    }


}
