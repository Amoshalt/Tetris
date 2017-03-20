package Fenêtre;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Brandon on 14/03/2017.
 */
public class FenetreMenu extends Stage {

    private Button btnTetris;
    private Group racine;
    private GridPane main;
    private Scene scene;

    private final int graphicWidth = 400;
    private final int graphicHeight = 500;


    public FenetreMenu(){

        this.racine = new Group();
        this.main = new GridPane();
        this.scene = new Scene(racine);

        this.setTitle("Projet Info Encadré");
        this.setWidth(graphicWidth);
        this.setHeight(graphicHeight);


        this.btnTetris = new Button("Tetris");

        btnTetris.setAlignment(Pos.CENTER);

        main.setAlignment(Pos.CENTER);
        main.getChildren().add(btnTetris);

        racine.getChildren().add(main);

        this.setScene(scene);
        this.show();
    }

    public Button getBtnTetris() {
        return btnTetris;
    }
}
