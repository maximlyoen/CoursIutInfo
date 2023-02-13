package towa;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Joueur implémentant les actions possibles à partir d'un plateau, pour un
 * niveau donné.
 */
public class JoueurTowa implements IJoueurTowa {

    /**
     * Cette méthode renvoie, pour un plateau donné et un joueur donné, toutes
     * les actions possibles pour ce joueur.
     *
     * @param plateau le plateau considéré
     * @param joueurNoir vrai si le joueur noir joue, faux si c'est le blanc
     * @param niveau le niveau de la partie à jouer
     * @return l'ensemble des actions possibles
     */
    @Override
    public String[] actionsPossibles(Case[][] plateau, boolean joueurNoir, int niveau) {
        // Afficher l'heure de lancement
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        System.out.println("actionsPossibles : lancement le " + format.format(new Date()));
        // On compte le nombre de pions sur le plateau avant action
        final int nbPionsNoirs = nbPions(plateau, true);
        final int nbPionsBlancs = nbPions(plateau, false);
        // Calculer les actions possibles
        String actions[] = new String[1028];
        int nbActions = 0;
        // Pour chaque ligne
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            // Pour chaque colonne
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                Coordonnees coord = new Coordonnees(lig, col);
                // Si la pose d'un pion de cette couleur est possible sur cette case
                if (posePossible(plateau, coord, joueurNoir)) {
                    // On ajoute l'action dans les actions possibles
                    if (joueurNoir == false) {
                        actions[nbActions] = chaineActionPose(coord, nbPionsNoirs, nbPionsBlancs + calculPose(plateau, coord, joueurNoir));
                        nbActions++;
                    } 
                    else {
                        actions[nbActions] = chaineActionPose(coord, nbPionsNoirs + calculPose(plateau, coord, joueurNoir), nbPionsBlancs);
                        nbActions++;
                    }
                }
                // Si l'activation d'un pion de cette couleur est possible sur cette case
                if (activationPossible(plateau, coord, joueurNoir)) {
                    if (joueurNoir == true) {
                        actions[nbActions] = chaineActionActivation(coord, nbPionsNoirs, nbPionsBlancs - activation(plateau, coord, joueurNoir));
                        nbActions++;
                    } 
                    else {
                        actions[nbActions] = chaineActionActivation(coord, nbPionsNoirs - activation(plateau, coord, joueurNoir), nbPionsBlancs);
                        nbActions++;
                    }
                }
            }
        }
        System.out.println("actionsPossibles : fin");
        return Utils.nettoyerTableau(actions);
    }

    /**
     * Indique s'il est possible de poser un pion sur une case pour ce plateau,
     * ce joueur, dans ce niveau.
     *
     * @param plateau le plateau
     * @param coord coordonnées de la case à considérer
     * @param estNoir vrai s'il s'agit du tour du joueur noir
     * @return vrai si la pose d'un pion sur cette case est autorisée dans ce
     * niveau
     */
    boolean posePossible(Case[][] plateau, Coordonnees coord, boolean estNoir) {
        return (plateau[coord.ligne][coord.colonne].hauteur < 4
                && plateau[coord.ligne][coord.colonne].tourPresente == true
                && plateau[coord.ligne][coord.colonne].estNoire == estNoir
                || plateau[coord.ligne][coord.colonne].tourPresente == false);
    }

    /**
     * Indique s'il est possible d'activer un pion pour ce plateau, ce joueur, dans ce niveau.
     *
     * @param plateau le plateau
     * @param coord coordonnées de la case à considérer
     * @param estNoir vrai s'il s'agit du tour du joueur noir
     * @return vrai si la destruction est possible pour des pions du joueur
     * concerné.
     *
     * @author Félix Chabellard
     */
    boolean activationPossible(Case[][] plateau, Coordonnees coord, boolean estNoir) {
        return (plateau[coord.ligne][coord.colonne].tourPresente == true
                && plateau[coord.ligne][coord.colonne].estNoire == estNoir);
    }

    /**
     * Détruit les pions adversaires alentours ainsi que les premiers situés
     * dans chaque direction pour ce plateau, ce joueur, dans ce niveau.
     *
     * @param plateau le plateau
     * @param coord coordonnées de la case à considérer
     * @param estNoir vrai s'il s'agit du tour du joueur noir, faux s'il s'agit du joueur blanc
     * @return la destruction des tours concernées quand cela est possible
     *
     * @author Félix Chabellard
     */
    int activation(Case[][] plateau, Coordonnees coord, boolean estNoir) {
        int degats = 0;
        int lig = coord.ligne;
        int col = coord.colonne;
        // On créer un tableau des cases adjacentes du pion joueur
        int[][] voisins = new int[][] { {lig - 1, col - 1}, {lig + 1, col + 1}, {lig + 1, col - 1}, {lig - 1, col + 1}, {lig, col +1}, {lig, col - 1}, {lig + 1, col}, {lig - 1, col} };
        
        // On parcourt la ligne sur laquelle le pion activé se situe
        for (lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            // Si une tour est trouvée...
            if (plateau[lig][coord.colonne].tourPresente) { 
                // On applique les dégâts que s'il s'agit d'une tour ennemie
                if (plateau[lig][coord.colonne].estNoire != estNoir && plateau[coord.ligne][coord.colonne].hauteur > plateau[lig][coord.colonne].hauteur) {
                    degats += plateau[lig][coord.colonne].hauteur;
                }
            }
        }
        
        // On parcourt la colonne sur laquelle le pion activé se situe
        for (col = 0; col < Coordonnees.NB_COLONNES; col++) {
            // Si une tour est trouvée...
            if (plateau[coord.ligne][col].tourPresente) { 
                // On applique les dégâts que s'il s'agit d'une tour ennemie
                if (plateau[coord.ligne][col].estNoire != estNoir && plateau[coord.ligne][coord.colonne].hauteur > plateau[coord.ligne][col].hauteur) {
                    degats += plateau[coord.ligne][col].hauteur;
                }
            }
        }
        
        // VOISINS DIRECTS (coins):
        // On parcourt les cases adjacentes (les coins) du pion activé et on détruit les tours ennemies présentes
        for (int[] voisin : voisins) {
            Coordonnees coordVoisin = new Coordonnees((voisin[0]), (voisin[1]));
            if (coordVoisin.estDansPlateau() && plateau[coord.ligne][coord.colonne].hauteur > plateau[voisin[0]][voisin[1]].hauteur
                                             && plateau[voisin[0]][voisin[1]].estNoire != estNoir) {
                degats += plateau[voisin[0]][voisin[1]].hauteur;
            }
        }
        return degats;
    }

    /**
     * Lors d'une pose, si le pion est adjacent à un pion adverse, pose deux pions (soit un pion d'une hauteur de 2)
     * 
     * @param plateau le plateau
     * @param coord coordonnées de la case à considérer
     * @param estNoir vrai s'il s'agit du tour du joueur noir, faux s'il s'agit du joueur blanc
     * @return la hauteur du pion posé (AKA le nombre de pions)
     *
     * @author Félix Chabellard
     */
    static int calculPose(Case[][] plateau, Coordonnees coord, boolean estNoir) {
        int nbPosePions = 1;
        int lig = coord.ligne;
        int col = coord.colonne;
        // On créer un tableau des voisins du pions du joueur
        int[][] voisins = new int[][]{{lig - 1, col - 1}, {lig - 1, col + 0}, {lig + 0, col - 1}, {lig + 0, col + 1},
        {lig + 1, col + 0}, {lig + 1, col + 1}, {lig + 1, col - 1}, {lig - 1, col + 1}};
        // On vérfie que la case où l'on veut poser notre pion est vide
        if (plateau[coord.ligne][coord.colonne].tourPresente == false) {
            // On vérifie qu'il y a un pion adverse voisin
            for (int[] voisin : voisins) {
                Coordonnees coordVoisin = new Coordonnees((voisin[0]), (voisin[1]));
                if (coordVoisin.estDansPlateau()) {
                    if (plateau[voisin[0]][voisin[1]].tourPresente == true && plateau[voisin[0]][voisin[1]].estNoire != estNoir) {
                        nbPosePions = 2;
                    }
                }
            }
        }
        return nbPosePions;
    }

    /**
     * Nombre de pions d'une couleur donnée sur le plateau.
     *
     * @param plateau le plateau
     * @param estNoir vrai si l'on compte les pions noirs, faux sinon
     * @return le nombre de pions de cette couleur sur le plateau
     */
    static int nbPions(Case[][] plateau, boolean estNoir) {
        int cpt = 0;
        // Pour chaque lignes
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++) {
            // Pour chaque colonnes
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++) {
                Coordonnees coord = new Coordonnees(lig, col);
                if (plateau[coord.ligne][coord.colonne].tourPresente == true && plateau[coord.ligne][coord.colonne].estNoire == estNoir) {
                    cpt += plateau[coord.ligne][coord.colonne].hauteur;
                }
            }
        }
        return cpt;
    }

    /**
     * Chaîne de caractères correspondant à une action-mesure de pose.
     *
     * @param coord coordonnées de la case où poser le pion
     * @param nbPionsNoirs nombre de pions noirs si cette action était jouée
     * @param nbPionsBlancs nombre de pions blancs si cette action était jouée
     * @return la chaîne codant cette action-mesure
     */
    static String chaineActionPose(Coordonnees coord, int nbPionsNoirs, int nbPionsBlancs) {
        return "P" + coord.carLigne() + coord.carColonne() + "," + nbPionsNoirs + "," + nbPionsBlancs;
    }

    /**
     * Chaîne de caractères correspondant à une action-mesure d'activation.
     *
     * @param coord coordonnées de la case où poser le pion
     * @param nbPionsNoirs nombre de pions noirs si cette action était jouée
     * @param nbPionsBlancs nombre de pions blancs si cette action était jouée
     * @return la chaîne codant cette action-mesure
     *
     * @author Félix Chabellard
     */
    static String chaineActionActivation(Coordonnees coord, int nbPionsNoirs, int nbPionsBlancs) {
        return "A" + coord.carLigne() + coord.carColonne() + "," + nbPionsNoirs + "," + nbPionsBlancs;
    }

}
