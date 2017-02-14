package Pieces;

/**
 * Created by Martial TARDY on 11/02/2017.
 */
public class Forme {
    public enum etatForme{
        L,
        T,
        C,
        NULL
    }
    public enum sensForme
    {
        HAUT,
        BAS,
        GAUCHE,
        DROITE
    }

    private etatForme forme;

    private sensForme sens;

    public Forme(etatForme forme, sensForme sens) {
        this.forme = forme;
        this.sens = sens;
    }

    public etatForme getForme() {
        return forme;
    }

    public void setForme(etatForme forme) {
        this.forme = forme;
    }

    public sensForme getSens() {
        return sens;
    }

    public void setSens(sensForme sens) {
        this.sens = sens;
    }
}
