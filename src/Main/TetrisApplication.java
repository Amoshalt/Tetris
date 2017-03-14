package Main;
import Fenêtre.*;

import javafx.application.Application;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by Brandon on 14/02/2017.
 */

public class TetrisApplication extends Application {

    private final int nbCol = 15 ;
    private final int nbLigne = 10;

    private final int graphicWidth = 800 ;
    private final int graphicHeigh = 800 ;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        /*

        Group root = new Group();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));


        /**
         * Contrainte des lignes et colones de notre grille
         */
        /*
        ColumnConstraints columnConstraints = new ColumnConstraints(50);
        RowConstraints rowConstraints = new RowConstraints(50);

        gridPane.getColumnConstraints().setAll(columnConstraints);
        gridPane.getRowConstraints().setAll(rowConstraints);


        BackgroundFill backgroundFill = new BackgroundFill(Color.DARKGREY,CornerRadii.EMPTY,Insets.EMPTY);
        Background labelBackground = new Background(backgroundFill);

        for (int ligne = 0 ; ligne < nbLigne ; ligne++ ){
            for ( int col = 0 ; col< nbCol ; col++ ){

                javafx.scene.shape.Rectangle rectangle = new Rectangle(30  ,30);
                rectangle.setFill(Color.WHITE);
                gridPane.add(rectangle,ligne,col);
                /*
                Label label = new Label(" ");
                label.resize(50,50);
                label.setBackground(labelBackground);
                gridPane.add(label,ligne,col);

            }
        }

        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER_LEFT);


        Label title = new Label();
        title.setBackground(labelBackground);
        title.setAlignment(Pos.TOP_CENTER);
        title.setText("TETRIS");
        title.setFont(new Font(35));
        
        root.getChildren().add(gridPane);
        root.getChildren().add(title);


        Scene scene = new Scene(gridPane,graphicWidth,graphicHeigh, Color.GRAY);

        stage.setTitle("TETRIS");
        stage.setScene(scene);
        stage.show();
*/

        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.show();
    }
}
