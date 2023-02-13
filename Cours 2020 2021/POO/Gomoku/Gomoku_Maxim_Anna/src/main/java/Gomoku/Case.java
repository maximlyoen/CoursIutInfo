package Gomoku;

/**
 * Case du plateau.
 * 
 * VOUS NE DEVEZ PAS MODIFIER CE FICHIER.
 */
public final class Case {

    /**
     * Caractère pour afficher une tour noire sur le plateau "texte".
     */
    public final static char CAR_NOIR = 'N';

    /**
     * Caractère pour afficher une tour blanche sur le plateau "texte".
     */
    public final static char CAR_BLANC = 'B';

    /**
     * Caractère indiquant la nature "Terre" de la case (dans l'attribut nature
     * de Case).
     */
    public final static char CAR_TERRE = 'T';

    /**
     * Indique s'il y a une tour sur cette case.
     */
    boolean tourPresente;
    
    /**
     * Indique si la tour sur cette case (s'il y en a une) est noire.
     */
    boolean estNoire;

    /**
     * Constructeur d'une case.
     * 
     * @param uneTourPresente indique s'il y a une tour sur cette case
     * @param estElleNoire idque si cette tour est noire (le cas échéant)
     */
    public Case(boolean uneTourPresente, boolean estElleNoire) {
        this.tourPresente = uneTourPresente;
        this.estNoire = estElleNoire;
    }
    
    
}
