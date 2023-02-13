package jump;

/**
 * Un joueur.
 */
class Joueur {

    /**
     * Nom du joueur.
     */
    String nom;

    /**
     * Colonne où se trouve le joueur.
     */
    int colonne;

    /**
     * Le client utilisé par ce joueur.
     */
    ICallback client;

    /**
     * Score.
     */
    int score;

    /**
     * Statut du joueur en cours de partie.
     */
    StatutJoueur statut;

    /**
     * Séparateur de champs pour la sérialisation/désérialisation.
     */
    final static String SEPARATEUR = "!";

    /**
     * Constructeur, sans client associé.
     *
     * @param unNom nom du joueur
     */
    Joueur(String unNom) {
        this(unNom, null);
    }

    /**
     * Constructeur.
     *
     * @param unNom nom du joueur
     * @param unClient client du joueur
     */
    Joueur(String unNom, ICallback unClient) {
        if(unNom.length()>10){
            nom=unNom.substring(0,10);
        }
        else{ nom = unNom; }
        client = unClient;
        score = 0;
        statut = StatutJoueur.A_JOUE;
    }

    /**
     * Caractère représentant ce joueur sur le plateau.
     *
     * @return caractère représentant ce joueur sur le plateau
     */
    char caracterePlateau() {
        return nom.charAt(0);
    }

    /**
     * Indique si le nom du joueur est correct, c'est-à-dire s'il commence par
     * une lettre majuscule non accentuée.
     *
     * @return vrai ssi le nom du joueur est correct
     */
    boolean nomCorrect() {
        if(!nom.isEmpty()){
            char premierLettre;
            boolean majPresente=false;
            premierLettre=nom.charAt(0);
            int c=0;
            char[] maj= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            while(c<26 && !majPresente){
                if(maj[c]==premierLettre){
                    majPresente=true;
                }
                c++;
            }
            return ((majPresente) &&
                    (!nom.contains(Partie.SEPARATEUR)) && 
                    (!nom.contains(Joueur.SEPARATEUR)) && 
                    (!nom.contains(Plateau.SEPARATEUR)));
        }
        return false;
    }

    /**
     * Sérialiser un joueur.
     *
     * @return une chaîne représentant ce joueur
     */
    String serialiser() {
        return "";
    }

    /**
     * Désérialiser un joueur.
     *
     * @param serial la sérialisation du joueur
     * @return le joueur obtenu à partir d'une sérialisation donnée.
     */
    static Joueur deserialiser(String serial) {
        return null;
    }
    
    /**
     * Ligne correspondant à ce joueur dans le fichier de scores.
     * 
     * @return la ligne correspondant à ce joueur dans le fichier de scores
     */
    String ligneFichierScore() {
        return "";
    }
}
