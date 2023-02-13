package towa;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
    public String[] actionsPossibles(Case[][] plateau, boolean joueurNoir, int niveau)
    {
        // afficher l'heure de lancement
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        System.out.println("actionsPossibles : lancement le " + format.format(new Date()));
        // on compte le nombre de pions sur le plateau avant action
        final int nbPionsNoirs = nbPions(plateau, true);
        final int nbPionsBlancs = nbPions(plateau, false);
        // calculer les actions possibles
        String actions[] = new String[1028];
        int nbActions = 0;
        // pour chaque ligne
        for (int lig = 0; lig < Coordonnees.NB_LIGNES; lig++)
        {
            // pour chaque colonne
            for (int col = 0; col < Coordonnees.NB_COLONNES; col++)
            {
                Coordonnees coord = new Coordonnees(lig, col);
                // si la pose d'un pion de cette couleur est possible sur cette case
                if (posePossible(plateau, coord, joueurNoir))
                {
                    // on ajoute l'action dans les actions possibles
                    if(joueurNoir)
                    {
                        actions[nbActions] = chaineActionPose(coord, nbPionsNoirs + nbPionsPosse(plateau, coord, joueurNoir), nbPionsBlancs);
                    }
                    else
                    {
                        actions[nbActions] = chaineActionPose(coord, nbPionsNoirs, nbPionsBlancs + nbPionsPosse(plateau, coord, joueurNoir));
                    }
                    nbActions++;
                }
                if (destructionPossible(plateau, coord, joueurNoir))
                {
                    // on ajoute l'action dans les actions possibles
                    if(joueurNoir)
                    {
                        actions[nbActions] = chaineActionDestruction(coord, nbPionsNoirs, nbPionsBlancs - nbPionsDestruction(plateau, coord, joueurNoir));
                    }
                    else
                    {
                        actions[nbActions] = chaineActionDestruction(coord, nbPionsNoirs - nbPionsDestruction(plateau, coord, joueurNoir), nbPionsBlancs);
                    }
                    nbActions++;
                }
            }
        }
        return Utils.nettoyerTableau(actions);
    }

    /**
     * Indique s'il est possible de poser un pion sur une case pour ce plateau,
     * ce joueur, dans ce niveau.
     *
     * @param plateau le plateau
     * @param coord coordonnées de la case à considérer
     * @param estNoir vrai ssi il s'agit du tour du joueur noir
     * @return vrai ssi la pose d'un pion sur cette case est autorisée dans ce
     * niveau
     */
    boolean posePossible(Case[][] plateau, Coordonnees coord, boolean estNoir)
    {    
        return (!plateau[coord.ligne][coord.colonne].tourPresente || (plateau[coord.ligne][coord.colonne].tourPresente==plateau[coord.ligne][coord.colonne].estNoire==estNoir) && plateau[coord.ligne][coord.colonne].hauteur<4);
    }
    
    boolean destructionPossible(Case[][] plateau, Coordonnees coord, boolean estNoir)
    {    
        return (plateau[coord.ligne][coord.colonne].tourPresente && plateau[coord.ligne][coord.colonne].estNoire==estNoir);
    }
    
    /**
     * Indique le nombre de pionts a detruire
     *
     * @param plateau le plateau
     * @param coord coordonnées de la case à considérer
     * @param estNoir vrai ssi il s'agit du tour du joueur noir
     * @return le nombre de pionts detruit si un pion est poser sur unecse de sa couleur est si les case autour sont inferieur
     */
    static int nbPionsDestruction (Case[][] plateau, Coordonnees coord, boolean estNoir)
    {
        int nbPionDestruction=0;   
        Case[] tableau = caseVoisines(plateau,coord);
        for (Case tableau1 : tableau ) {
            if (tableau1.estNoire != estNoir && tableau1.hauteur < plateau[coord.ligne][coord.colonne].hauteur)
            {
                nbPionDestruction = nbPionDestruction + tableau1.hauteur;
            }
        }
        return nbPionDestruction;
    }

    /**
     * Pose 2 pions si casse adjacente contien 1 pions enemis.
     *
     * @param plateau le plateau
     * @param coord coordonnées de la case à considérer
     * @param estNoir vrai si on compte les pions noirs, faux sinon
     * @return le nombre de pions de cette couleur sur le plateau
     */
    int nbPionsPosse (Case[][] plateau, Coordonnees coord, boolean estNoir)
    {
        int nbPionsPosse = 1;
        Case[] tableau = caseVoisines(plateau,coord);
        for (Case tableau1 : tableau)
        {
            if (tableau1.estNoire != estNoir && tableau1.tourPresente && !plateau[coord.ligne][coord.colonne].tourPresente)
            {
                nbPionsPosse = 2;
            }
        }
        return nbPionsPosse;
    }
    
    /**
     * Nombre de pions d'une couleur donnée sur le plateau.
     *
     * @param plateau le plateau
     * @param estNoir vrai si on compte les pions noirs, faux sinon
     * @return le nombre de pions de cette couleur sur le plateau
     */
    static int nbPions(Case[][] plateau, boolean estNoir) 
    {
        int nbPion=0;
        for(int i=0;i<Coordonnees.NB_LIGNES;i++)
        {
            for(int u=0;u<Coordonnees.NB_COLONNES;u++)
            {
                if(plateau[i][u].tourPresente==true && plateau[i][u].estNoire==estNoir )
                {
                        nbPion = nbPion + plateau[i][u].hauteur;  
                }
            }
        }
        return nbPion;
    }
    
    /**
     * Indique les nombres de case voisines.
     *
     * @param plateau le plateau et 
     * @param coord qui donne les coordonnees
     * @return le nombres de case adjacente
     */
    static Case[] caseVoisines(Case[][] plateau, Coordonnees coord) 
    {
        Case [] tableau =new Case[8];
        int caseVoisines=0;
        for (int i = coord.ligne - 1; i <= coord.ligne + 1; i++)
        {
            for (int j = coord.colonne - 1; j <= coord.colonne + 1; j++)
            {
                if (!(i <= -1 || j <= -1 || i >= Coordonnees.NB_LIGNES || j >= Coordonnees.NB_COLONNES || (i == coord.ligne && j == coord.colonne)))
                {
                    tableau[caseVoisines] = plateau[i][j];
                    caseVoisines++;
                }
            }
        }
        return Arrays.copyOf(tableau, caseVoisines);
    }
    
    /**
     * Chaîne de caractères correspondant à une action-mesure de pose.
     *
     * @param coord coordonnées de la case où poser le pion
     * @param nbPionsNoirs nombre de pions noirs si cette action était jouée
     * @param nbPionsBlancs nombre de pions blancs si cette action était jouée
     * @return la chaîne codant cette action-mesure
     */
    static String chaineActionPose(Coordonnees coord,int nbPionsNoirs, int nbPionsBlancs) 
    {
        return "P" + coord.carLigne() + coord.carColonne() + ","
                + nbPionsNoirs + "," + nbPionsBlancs;
    }
    
    /**
     * Chaîne de caractères correspondant à une action-mesure de pose.
     *
     * @param coord coordonnées de la case où poser le pion
     * @param nbPionsNoirs nombre de pions noirs si cette action était jouée
     * @param nbPionsBlancs nombre de pions blancs si cette action était jouée
     * @return la chaîne codant cette action-mesure
     */
    static String chaineActionDestruction(Coordonnees coord,int nbPionsNoirs, int nbPionsBlancs) 
    {
        return "A" + coord.carLigne() + coord.carColonne() + "," + nbPionsNoirs + "," + nbPionsBlancs;
    } 
}
