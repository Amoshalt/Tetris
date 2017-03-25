package Fenêtre;

import GrilleJeux.Case;
import Plateau.PlateauTetris;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Brandon on 24/03/2017.
 */
public class TEST extends Stage {


    private PlateauTetris model;
    private Pane grid;

    private Case[][] gameGrid;

    private static int nbLignes = 20 ;
    private static int nbCol = 10 ;
    private static int tailleRect = 28;
    private static int tailleCase = 30;

    private final int graphicWidth = 600 ;
    private final int graphicHeigh = 850 ;

    private EventHandler<KeyEvent> listener;

    public TEST(){

        this.model = new PlateauTetris();
        this.model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                fillPane();
            }
        });
        this.listener = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.RIGHT)){
                    model.deplacementDroitePieceActu();
                }
                if(event.getCode().equals(KeyCode.LEFT)){
                    model.deplacementGauchePieceActu();
                }
                if(event.getCode().equals(KeyCode.DOWN)){
                    model.deplacementPieceActu();
                }
                if (event.getCode().equals(KeyCode.SPACE)){

                }
            }
        };
        this.grid = new Pane();
        this.grid.addEventHandler(KeyEvent.KEY_PRESSED,listener);
        this.gameGrid = model.getGrillePartielle();
        this.setHeight(graphicHeigh);
        this.setWidth(graphicWidth);
        this.setTitle("TETRIS");

        Pane mainPane = new Pane();
        mainPane.getChildren().addAll(grid);

        grid.setPadding(new Insets(5));
        grid.setPrefSize(nbCol*tailleCase,nbLignes*tailleCase);
        grid.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        Scene scene = new Scene(mainPane, graphicWidth, graphicHeigh);
        this.setScene(scene);
        this.show();
    }



    public void fillPane(){
        grid.getChildren().clear();
        for (int line = 0; line < nbLignes; line++ ) {
            for (int col = 0; col < nbCol; col++) {
                if (!gameGrid[line][col].isVide()){
                    Rectangle rectangle = new Rectangle(tailleRect,tailleRect);
                    rectangle.setX(col*tailleCase);
                    rectangle.setY(line*tailleCase);
                    rectangle.setFill(gameGrid[line][col].getCouleur().getCouleur());
                    grid.getChildren().addAll(rectangle);
                }
            }
        }
    }

}
