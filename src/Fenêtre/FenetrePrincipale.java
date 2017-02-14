package Fenêtre;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brandon on 14/02/2017.
 */
public class FenetrePrincipale extends JFrame {

    public FenetrePrincipale(){
        this.setTitle("TETRIS");
        this.setSize(500, 750 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

}
