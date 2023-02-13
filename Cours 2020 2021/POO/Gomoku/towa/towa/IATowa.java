package towa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Votre IA pour le jeu Towa.
 */
public class IATowa {

    /**
     * Hôte du grand ordonnateur.
     */
    String hote = null;

    /**
     * Port du grand ordonnateur.
     */
    int port = -1;

    /**
     * Indique si ce joueur (l'IA) est le joueur noir.
     */
    final boolean estNoir;

    /**
     * Interface pour le protocole du grand ordonnateur.
     */
    TcpGrandOrdonnateur grandOrdo = null;

    /**
     * Taille du plateau.
     */
    static final int TAILLE = 16;

    /**
     * Nombre maximal de tours de jeu.
     */
    static final int NB_TOURS_JEU_MAX = 40;

    /**
     * Constructeur.
     *
     * @param hote Hôte.
     * @param port Port.
     * @param estNoir Indique si ce joueur (l'IA) est le joueur noir.
     */
    public IATowa(String hote, int port, boolean estNoir) {
        this.hote = hote;
        this.port = port;
        this.grandOrdo = new TcpGrandOrdonnateur();
        this.estNoir = estNoir;
    }

    /**
     * Connexion au Grand Ordonnateur.
     *
     * @throws IOException exception sur les entrées/sorties
     */
    void connexion() throws IOException {
        System.out.print(
                "Connexion au Grand Ordonnateur : " + hote + " " + port + "...");
        System.out.flush();
        grandOrdo.connexion(hote, port);
        System.out.println(" ok.");
        System.out.flush();
    }

    /**
     * Boucle de jeu : envoi des actions que vous souhaitez jouer, et réception
     * des actions de l'adversaire.
     *
     * @throws IOException exception sur les entrées/sorties
     */
    void toursDeJeu() throws IOException {
        // Paramètres
        System.out.println("Je suis le joueur " + couleur() + ".");
        // Le plateau initial
        System.out.println("Réception du plateau initial...");
        Case[][] plateau = grandOrdo.recevoirPlateauInitial();
        System.out.println("Plateau reçu.");
        // Compteur de tours de jeu (entre 1 et 40)
        int nbToursJeu = 1;
        // Indique si le joueur courant est le noir, ou pas. Change à chaque tour de jeu.
        boolean courantEstNoir = true;
        // Booléen pour détecter la fin du jeu
        boolean fin = false;

        while (!fin) {
            boolean disqualification = false;
            if (courantEstNoir == estNoir) {
                // à nous de jouer !
                String actionJouee = jouer(plateau, nbToursJeu);
                System.out.println("On joue : " + actionJouee);
                grandOrdo.envoyerAction(actionJouee);
                mettreAJour(plateau, actionJouee, estNoir);
            } else {
                // à l'adversaire de jouer : on récupère son action
                System.out.println("Attente de réception action adversaire...");
                String actionAdversaire = grandOrdo.recevoirAction();
                System.out.println("Action adversaire reçue : " + actionAdversaire);
                if ("Z".equals(actionAdversaire)) {
                    System.out.println("L'adversaire est disqualifié.");
                    disqualification = true;
                } else if (!fin) {
                    System.out.println("L'adversaire joue : " + actionAdversaire + ".");
                    mettreAJour(plateau, actionAdversaire, courantEstNoir);
                }
            }
            if (nbToursJeu == NB_TOURS_JEU_MAX || disqualification) {
                // Fini
                fin = true;
            } else {
                // Au suivant
                nbToursJeu++;
                courantEstNoir = !courantEstNoir;
            }
        }
    }
    
    /**
     * Fonction qui renvoie l'écart entre le nombre de pions de chaque joueur.
     * 
     * @param chaine  la chaîne d'actions possibles étudiées
     * @return ecart  l'écart entre les nombres de pions des joueurs
     * 
     * @author Félix Chabellard, Anna Briançon
     */
    int calculEcart(String chaine) {
        int ecart;
        String tab[];
        tab = chaine.split(",");
        // Partie de la chaîne représentant le nombre de pions noirs
        String chaineNbNoirs = tab[1];
        // Partie de la chaîne représentant le nombre de pions blancs
        String chaineNbBlancs = tab[2];
        // Conversion des nombres (chaines) en entiers
        Integer NbPionsNoirs = Integer.valueOf(tab[1]);
        Integer NbPionsBlancs = Integer.valueOf(tab[2]);
        // On compare les deux valeurs pour obtenir l'écart
        if (NbPionsNoirs > NbPionsBlancs && estNoir) {
            ecart = NbPionsNoirs - NbPionsBlancs;
        } 
        else if (NbPionsNoirs < NbPionsBlancs && !estNoir) {
            ecart = NbPionsBlancs - NbPionsNoirs;
        } 
        else {
            ecart = 0;
        }
        return ecart;
}

/**
 * Fonction exécutée lorsque c'est à notre tour de jouer. Cette fonction renvoie
 * l'action que l'on choisit de jouer.
 *
 * @param plateau le plateau de jeu
 * @param nbToursJeu numéro du tour de jeu
 * @return l'action que l'on souhaite jouer
 * @throws IOException exception sur les entrées / sorties
 */
String jouer(Case[][] plateau, int nbToursJeu) throws IOException {
        String actionJouee;
        // Ecart entre les nombres de pions des joueurs
        int ecart; 
        // Ecart maximum
        int ecartMax = 0; 
        // ...
        int x = 0;
        
        // On instancie votre implémentation du niveau 5
        JoueurTowa joueurTowa = new JoueurTowa();
        // Choisir une action possible
        String[] actionsPossibles = Utils.nettoyerTableau(joueurTowa.actionsPossibles(plateau, estNoir, 5));
        // Tableau des actions avec le plus grand écart
        String tabAction[] = new String[actionsPossibles.length]; 
        
        if (actionsPossibles.length > 0) {
            // On parcours le tableau d'actions possibles et on compare les écarts
            for (String actionsPossible : actionsPossibles) {
                ecart = calculEcart(actionsPossible);
                if (ecart > ecartMax) {
                    ecartMax = ecart;
                }
            }
            for (String actionsPossible : actionsPossibles) {
                ecart = calculEcart(actionsPossible);
                // Lorsqu'on obtient un écart maximum on l'ajoute à notre tableau d'actions
                if (ecart == ecartMax) {
                    tabAction[x] = actionsPossible;
                    x++;
                }
            }
            // On joue une des actions possibles parmis tabAction[]
            Random r = new Random();
            int indiceAleatoire = r.nextInt(x);
            actionJouee = enleverNbPions(tabAction[indiceAleatoire]);
        } 
        else {
            // Problème : le serveur vous demande une action alors que vous n'en trouvez plus...
            System.out.println("Aucune action trouvée : abandon...");
            actionJouee = "ABANDON";
        }
        return actionJouee;
    }

    /**
     * Retourne l'action sans les nombres de pions. 
     * Par exemple, sur "PfL,4,5", cela renvoit "PfL".
     *
     * @param actionMesure l'action-mesure
     * @return l'action sans les nombres de pions
     */
    static String enleverNbPions(String actionMesure) {
        int posVirgule = actionMesure.indexOf(",");
        return posVirgule == -1 ? actionMesure : actionMesure.substring(0, posVirgule);
    }

    /**
     * Mettre à jour le plateau suite à une action, supposée valide.
     *
     * @param plateau le plateau
     * @param action l'action à appliquer
     * @param courantEstNoir indique si le joueur courant est le joueur noir
     */
    static void mettreAJour(Case[][] plateau, String action, boolean courantEstNoir) {
        // Vérification des arguments
        if (plateau == null) {
            return;
        }
        Coordonnees coord;
        switch (action.charAt(0)) {
            case 'P':
                coord = Coordonnees.depuisCars(action.charAt(1), action.charAt(2));
                poser(coord, plateau, courantEstNoir);
                break;
            case 'A':
                coord = Coordonnees.depuisCars(action.charAt(1), action.charAt(2));
                activer(coord, plateau, courantEstNoir);
                break;
            default:
                System.out.println("Type d'action incorrect : " + action);
        }
    }

    /**
     * Poser un pion sur une case donnée (vide ou pas).
     *
     * @param coord coordonnées de la case
     * @param plateau le plateau de jeu
     * @param courantEstNoir indique si le joueur courant est le joueur noir
     */
    static void poser(Coordonnees coord, Case[][] plateau, boolean courantEstNoir) {
        Case laCase = plateau[coord.ligne][coord.colonne];
        if (laCase.tourPresente) {
            laCase.hauteur++;
        } 
        else {
            laCase.tourPresente = true;
            laCase.estNoire = courantEstNoir;
            if (ennemiVoisine(coord, plateau, courantEstNoir)) {
                laCase.hauteur = 2;
            } 
            else {
                laCase.hauteur = 1;
            }
        }
    }

    /**
     * Activer une tour.
     *
     * @param coord coordonnées de la case où se situe la tour à activer
     * @param plateau le plateau de jeu
     * @param courantEstNoir indique si le joueur courant est le joueur noir
     */
    static void activer(Coordonnees coord, Case[][] plateau, boolean courantEstNoir) {
        final int hauteurTourJoueur = plateau[coord.ligne][coord.colonne].hauteur;
        List<Case> aDetruire
                = porteeActivation(coord)
                        .map(aPortee -> plateau[aPortee.ligne][aPortee.colonne])
                        .filter(c -> c.tourPresente) // une tour
                        .filter(c -> c.estNoire != courantEstNoir) // ennemie
                        .filter(c -> c.hauteur < hauteurTourJoueur) // plus basse
                        .collect(Collectors.toList());
        for (Case tourADetruire : aDetruire) {
            detruireTour(tourADetruire);
        }
    }

    /**
     * Détruire une tour.
     *
     * @param laCase la case dont on doit détruire la tour
     */
    static void detruireTour(Case laCase) {
        laCase.tourPresente = false;
        laCase.hauteur = 0;
        laCase.estNoire = false;
    }

    /**
     * Indique si une case possède une case voisine avec une tour ennemie.
     *
     * @param coord la case dont on souhaite analyser les voisines
     * @param plateau le plateau courant
     * @param courantEstNoir indique si le joueur courant est le joueur noirt :
     * 1=noir, 2=blanc
     * @return vrai ssi la case possède une voisine avec une tour ennemie
     */
    static boolean ennemiVoisine(Coordonnees coord, Case[][] plateau, boolean courantEstNoir) {
        return voisines(coord)
                .map(v -> plateau[v.ligne][v.colonne])
                .filter(c -> c.tourPresente)
                .anyMatch(c -> c.estNoire != courantEstNoir);
    }

    /**
     * Les coordonnées des cases voisines dans le plateau.
     *
     * @param coord les coordonnées de la case d'origine
     * @return les coordonnées des cases voisines
     */
    static Stream<Coordonnees> voisines(final Coordonnees coord) {
        return IntStream.rangeClosed(-1, 1).boxed()
                .flatMap(l -> IntStream.rangeClosed(-1, 1)
                .filter(c -> !(l == 0 && c == 0))
                .mapToObj(c -> new Coordonnees(coord.ligne + l, coord.colonne + c)))
                .filter(v -> 0 <= v.ligne && v.ligne < TAILLE)
                .filter(v -> 0 <= v.colonne && v.colonne < TAILLE);
    }

    /**
     * Coordonnées des cases à portée d'activation.
     *
     * @param coord les coordonnées de la case activée
     * @return les coordonnées des cases à portée d'activation
     */
    static Stream<Coordonnees> porteeActivation(final Coordonnees coord) {
        return Stream.concat(voisines(coord), Stream.concat(memeLigne(coord), memeColonne(coord)));
    }

    /**
     * Les coordonnées des cases sur la même ligne (sans celles de la case
     * d'origine).
     *
     * @param coord les coordonnées de la case d'origine
     * @return les coordonnées des cases sur la même ligne
     */
    static Stream<Coordonnees> memeLigne(final Coordonnees coord) {
        return IntStream.rangeClosed(0, TAILLE - 1).boxed()
                .filter(col -> col != coord.colonne)
                .map(col -> new Coordonnees(coord.ligne, col));
    }

    /**
     * Les coordonnées des cases sur la même colonne (sans celles de la case
     * d'origine).
     *
     * @param coord les coordonnées de la case d'origine
     * @return les coordonnées des cases sur la même colonne
     */
    static Stream<Coordonnees> memeColonne(final Coordonnees coord) {
        return IntStream.rangeClosed(0, TAILLE - 1).boxed()
                .filter(lig -> lig != coord.ligne)
                .map(lig -> new Coordonnees(lig, coord.colonne));
    }

    /**
     * La couleur du joueur, sous forme de chaîne.
     *
     * @return couleur du joueur, sous forme de chaîne
     */
    String couleur() {
        String couleur;
        if (estNoir) {
            couleur = "noir";
        } 
        else {
            couleur = "blanc";
        }
        return couleur;
    }

    /**
     * Programme principal. Il sera lancé automatiquement, ce n'est pas à vous
     * de le lancer.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        System.out.println("Démarrage le " + format.format(new Date()));
        System.out.flush();
        // « create » du protocole du grand ordonnateur.
        final String

USAGE
                = System.lineSeparator()
                + "\tUsage : java " + IATowa.class  

    .getName()
                + " <hôte> <port> <ordre>";
    if (args.length

    
        != 3) {
            System.out.println("Nombre de paramètres incorrect." + USAGE);
        System.out.flush();
        System.exit(1);
    }
    String hote = args[0];
    int port = -1;

    
        try {
            port = Integer.valueOf(args[1]);
    }
    catch (NumberFormatException e

    
        ) {
            System.out.println("Le port doit être un entier." + USAGE);
        System.out.flush();
        System.exit(1);
    }
    int ordre = -1;

    
        try {
            ordre = Integer.valueOf(args[2]);
    }
    catch (NumberFormatException e

    
        ) {
            System.out.println("L'ordre doit être un entier." + USAGE);
        System.out.flush();
        System.exit(1);
    }

    
        try {
            final boolean joueurEstNoir = (ordre == 1);
        IATowa iaTowa = new IATowa(hote, port, joueurEstNoir);
        iaTowa.connexion();
        iaTowa.toursDeJeu();
    }
    catch (IOException e

    
        ) {
            System.out.println("Erreur à l'exécution du programme : \n" + e);
        System.out.flush();
        System.exit(1);
    }
}
}
