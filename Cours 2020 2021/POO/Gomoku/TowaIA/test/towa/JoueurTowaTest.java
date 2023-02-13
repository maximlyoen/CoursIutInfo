package towa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests sur la classe JoueurTowa.
 */
public class JoueurTowaTest {

    /**
     * Test de la fonction actionsPossibles. Commentez les appels aux tests des
     * niveaux inférieurs, n'activez que le test du niveau à valider.
     */
    @Test
    public void testActionsPossibles() {
        // testActionsPossibles_niveau1();
        // testActionsPossibles_niveau2();
        // testActionsPossibles_niveau3();
        // testActionsPossibles_niveau4();
        // testActionsPossibles_niveau5();
        // testActionsPossibles_niveau6();
    }

    /**
     * Test de la fonction actionsPossibles, au niveau 1.
     */
    public void testActionsPossibles_niveau1() {
        JoueurTowa joueur = new JoueurTowa();
        // Un plateau sur lequel on veut tester actionsPossibles()
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU1);
        // On choisit la couleur du joueur
        boolean estNoir = true;
        // On choisit le niveau
        int niveau = 1;
        // On lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        // On peut afficher toutes les actions possibles calculées :
        Utils.afficherActionsPossibles(actionsPossibles);
        // On peut aussi tester si une action est dans les actions possibles :
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PaB,1,0"));
        // On peut aussi tester si une action n'est pas dans les actions possibles :
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles, "PaQ,1,0"));
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles, "PaA,0,0"));
        // Testons les 4 coins :
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PaA,1,0"));
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PpA,1,0"));
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PaP,1,0"));
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PpP,1,0"));
        // Vérifions s'il y a le bon nombre d'actions possibles :
        assertEquals(Coordonnees.NB_LIGNES * Coordonnees.NB_COLONNES, actionsPossibles.length);
    }

    /**
     * Test de la fonction actionsPossibles, au niveau 2.
     */
    public void testActionsPossibles_niveau2() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        boolean estNoir = true;
        int niveau = 2;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // On lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // Pose sur case vide : possible
        coord = Coordonnees.depuisCars('a', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose sur case de même couleur : possible
        coord = Coordonnees.depuisCars('b', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose sur case de couleur opposée : impossible
        coord = Coordonnees.depuisCars('a', 'G');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                    JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose sur case de même couleur et hauteur > 1 : possible
        coord = Coordonnees.depuisCars('c', 'K');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
    }

    /**
     * Test de la fonction actionsPossibles au niveau 3
     */
    public void testActionsPossibles_niveau3() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU3);
        boolean estNoir = true;
        int niveau = 3;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // On lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // Pose sur case vide : possible
        coord = Coordonnees.depuisCars('a', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose sur case de même couleur : possible
        coord = Coordonnees.depuisCars('b', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose sur case de couleur opposée : impossible
        coord = Coordonnees.depuisCars('a', 'G');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                    JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose sur case de même couleur et hauteur < 4 : impossible
        coord = Coordonnees.depuisCars('c', 'K');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                    JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
    }
    
    /*
     * Test de la fonction actionsPossibles au niveau 4
     */
    public void testActionsPossibles_niveau4() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU3);
        boolean estNoir = true;
        int niveau = 4;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // On lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // Pose (correcte)
        coord = Coordonnees.depuisCars('a', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose (incorrecte)
        coord = Coordonnees.depuisCars('i', 'C');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose double (correcte)
        coord = Coordonnees.depuisCars('g', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 2, nbPionsBlancs)));
        // Pose double (incorrecte)
        coord = Coordonnees.depuisCars('f', 'E');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 2, nbPionsBlancs)));
        // Destruction (correcte)
        coord = Coordonnees.depuisCars('c', 'K');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionActivation(coord, nbPionsNoir, nbPionsBlancs - 2)));
        // Destruction (incorrecte)
        coord = Coordonnees.depuisCars('g', 'J');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir, nbPionsBlancs - 1)));
    }
    
    /*
     * Test de la fonction actionsPossibles au niveau 5
     */
    public void testActionsPossibles_niveau5() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU3);
        boolean estNoir = true;
        int niveau = 5;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // On lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // Pose (correcte)
        coord = Coordonnees.depuisCars('a', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose (incorrecte)
        coord = Coordonnees.depuisCars('i', 'C');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose double (correcte)
        coord = Coordonnees.depuisCars('g', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 2, nbPionsBlancs)));
        // Pose double (incorrecte)
        coord = Coordonnees.depuisCars('f', 'E');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 2, nbPionsBlancs)));
    }
    
    /*
     * Test de la fonction actionPossibles au niveau 6
     */
    public void testActionsPossibles_niveau6() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU3);
        boolean estNoir = true;
        int niveau = 6;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // On lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // Pose (correcte)
        coord = Coordonnees.depuisCars('a', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose (incorrecte)
        coord = Coordonnees.depuisCars('i', 'C');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // Pose double (correcte)
        coord = Coordonnees.depuisCars('g', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 2, nbPionsBlancs)));
        // Pose double (incorrecte)
        coord = Coordonnees.depuisCars('f', 'E');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 2, nbPionsBlancs)));
        // Activation (correcte)
        coord = Coordonnees.depuisCars('j', 'H');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                   JoueurTowa.chaineActionActivation(coord, nbPionsNoir, nbPionsBlancs - 2)));
        // Activation (incorrecte)
        coord = Coordonnees.depuisCars('i', 'A');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                    JoueurTowa.chaineActionActivation(coord, nbPionsNoir, nbPionsBlancs - 10)));
    }
    
    /**
     * Test de la fonction posePossible()
     */
    @Test
    public void testPosePossible() {
        Case[][] plateau7 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU6);
        JoueurTowa joueur = new JoueurTowa();
        // Pose possible (aucun pion)
        assertTrue(joueur.posePossible(plateau7, Coordonnees.depuisCars('b', 'B'), true));
        // Pose possible (pion allié présent)
        assertTrue(joueur.posePossible(plateau7, Coordonnees.depuisCars('k', 'B'), true));
        // Pose impossible (pion ennemi présent)
        assertFalse(joueur.posePossible(plateau7, Coordonnees.depuisCars('c', 'J'), true));
    }
    
    /*
     * Test de la fonction activationPossible()
     */
    @Test
    public void testActivationPossible() {
        Case[][] plateau7 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU6);
        JoueurTowa joueur = new JoueurTowa();
        // Activation possible
        assertTrue(joueur.activationPossible(plateau7, Coordonnees.depuisCars('g', 'L'), true));
        // Activation impossible
        assertFalse(joueur.activationPossible(plateau7, Coordonnees.depuisCars('m', 'G'), true));
        
    }
    
    /*
     * Test de la fonction calculPose()
     */
    @Test
    public void testCalculPose() {
        Case[][] plateau7 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU6);
        // Il y a un pion ennemi adjacent a celui du joueur (2 pions posés)
        assertEquals(2, JoueurTowa.calculPose(plateau7, Coordonnees.depuisCars('c', 'I'), true));
        assertEquals(2, JoueurTowa.calculPose(plateau7, Coordonnees.depuisCars('f', 'A'), true));
        // Il n'y a pas de pion ennemi adjacent à celui du joueur (1 pion posé)
        assertEquals(1, JoueurTowa.calculPose(plateau7, Coordonnees.depuisCars('a', 'A'), true));
        assertEquals(1, JoueurTowa.calculPose(plateau7, Coordonnees.depuisCars('j', 'H'), true));
    }
    
    /**
     * Test de la fonction nbPions()
     */
    @Test
    public void testNbPions() {
        // plateau1 : 0 noir, 0 blanc
        Case[][] plateau1 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU1);
        assertEquals(0, JoueurTowa.nbPions(plateau1, true));
        assertEquals(0, JoueurTowa.nbPions(plateau1, false));
        // plateau2 : 27 noirs, 20 blancs
        Case[][] plateau2 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        assertEquals(27, JoueurTowa.nbPions(plateau2, true));
        assertEquals(20, JoueurTowa.nbPions(plateau2, false));
        // plateau3 : 27 noirs, 20 blancs
        Case[][] plateau3 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU3);
        assertEquals(27, JoueurTowa.nbPions(plateau3, true));
        assertEquals(20, JoueurTowa.nbPions(plateau3, false));
    }
    
    /**
     * Test de la fonction chaineActionPose()
     */
    @Test
    public void testChaineActionPose() {
        assertEquals("PfK,3,8",
                JoueurTowa.chaineActionPose(Coordonnees.depuisCars('f', 'K'), 3, 8));
        assertEquals("PaA,0,0",
                JoueurTowa.chaineActionPose(Coordonnees.depuisCars('a', 'A'), 0, 0));
        assertEquals("PpP,10,10",
                JoueurTowa.chaineActionPose(Coordonnees.depuisCars('p', 'P'), 10, 10));
    }
    
    /**
     * Test de la fonction chaineActionActivation()
     */
    @Test
    public void testChaineActionActivation() {
        assertEquals("AcK,5,5",
                JoueurTowa.chaineActionActivation(Coordonnees.depuisCars('c', 'K'), 5, 5));
        assertEquals("AnD,2,7",
                JoueurTowa.chaineActionActivation(Coordonnees.depuisCars('n', 'D'), 2, 7));
        assertEquals("ApA,0,0",
                JoueurTowa.chaineActionActivation(Coordonnees.depuisCars('p', 'A'), 0, 0));
    }

    /**
     * Un plateau de base, sous forme de chaîne. Pour construire une telle
     * chaîne depuis votre sortie.log, déclarez simplement : final String
     * MON_PLATEAU = ""; puis copiez le plateau depuis votre sortie.log, et
     * collez-le entre les guillemets. Puis Alt+Shift+f pour mettre en forme.
     */
    final String PLATEAU_NIVEAU1
            = "   A   B   C   D   E   F   G   H   I   J   K   L   M   N   O   P \n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "a|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "b|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "c|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "d|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "e|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "f|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "g|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "h|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "k|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "m|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "n|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "o|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "p|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+";

    final String PLATEAU_NIVEAU2
            = "   A   B   C   D   E   F   G   H   I   J   K   L   M   N   O   P \n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "a|   |   |   |   |   |   |B1 |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "b|N1 |   |   |   |   |   |   |B1 |   |   |   |B1 |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "c|   |   |B1 |   |B1 |   |   |   |   |   |N5 |B1 |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "d|   |   |   |   |   |   |   |   |B1 |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "e|B1 |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "f|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "g|   |   |B1 |   |   |   |   |   |   |N1 |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "h|   |   |   |   |   |   |   |   |   |   |N1 |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "i|   |N1 |N1 |   |   |   |   |   |   |   |   |   |N1 |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "j|   |   |   |   |   |   |   |N1 |   |   |   |B1 |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "k|   |   |   |   |N1 |   |   |   |   |N2 |   |   |   |   |B1 |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "l|   |   |   |   |N3 |B4 |B1 |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "m|   |   |   |   |B1 |B2 |N1 |   |   |N1 |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "n|   |   |   |   |N1 |N1 |N2 |   |   |N1 |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "o|   |N1 |   |   |   |   |   |N1 |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "p|   |   |   |   |   |   |B1 |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n";
    
    final String PLATEAU_NIVEAU3
            = "   A   B   C   D   E   F   G   H   I   J   K   L   M   N   O   P \n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "a|   |   |   |   |   |   |B1 |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "b|N1 |   |   |   |   |   |   |B1 |   |   |   |B1 |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "c|   |   |B1 |   |B1 |   |   |   |   |   |N5 |B1 |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "d|   |   |   |   |   |   |   |   |B1 |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "e|B1 |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "f|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "g|   |   |B1 |   |   |   |   |   |   |N1 |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "h|   |   |   |   |   |   |   |   |   |   |N1 |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "i|   |N1 |N1 |   |   |   |   |   |   |   |   |   |N1 |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "j|   |   |   |   |   |   |   |N1 |   |   |   |B1 |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "k|   |   |   |   |N1 |   |   |   |   |N2 |   |   |   |   |B1 |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "l|   |   |   |   |N3 |B4 |B1 |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "m|   |   |   |   |B1 |B2 |N1 |   |   |N1 |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "n|   |   |   |   |N1 |N1 |N2 |   |   |N1 |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "o|   |N1 |   |   |   |   |   |N1 |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "p|   |   |   |   |   |   |B1 |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n";
    
    final String PLATEAU_NIVEAU6
            = "   A   B   C   D   E   F   G   H   I   J   K   L   M   N   O   P \n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "a|   |   |   |   |   |   |   |   |   |   |B1 |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "b|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "c|   |   |   |   |   |   |   |   |   |B1 |   |   |N1 |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "d|   |   |   |   |   |   |B1 |   |   |   |   |   |   |B2 |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "e|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |N1 |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "f|   |B1 |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "g|   |   |   |   |   |   |   |   |   |   |   |N1 |N1 |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "h|B1 |   |   |   |   |   |   |   |   |   |   |   |   |B2 |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "i|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |B1 |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "j|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "k|   |N1 |   |N1 |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "l|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "m|   |   |N1 |   |   |   |B1 |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "n|B1 |   |   |   |   |   |   |   |   |   |   |   |   |N1 |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "o|   |   |N1 |   |   |   |   |   |   |   |   |   |N1 |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n"
            + "p|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |\n"
            + " +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\n";
    
}
