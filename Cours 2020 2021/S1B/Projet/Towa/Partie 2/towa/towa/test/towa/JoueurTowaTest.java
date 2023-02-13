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
    public void testActionsPossibles()
    {
        //testActionsPossibles_niveau1();
        //testActionsPossibles_niveau2();
        //testActionsPossibles_niveau3();
        //testActionsPossibles_niveau4();
        testActionsPossibles_niveau5();
        testNbPions();
        testChaineActionPose();
        testPosePossible();
        testNbPionsDestruction();
        testCasesVoisines();
        nbPionsPosseTest();
    }

    /**
     * Test de la fonction actionsPossibles, au niveau 1.
     */
    public void testActionsPossibles_niveau1()
    {
        JoueurTowa joueur = new JoueurTowa();
        // un plateau sur lequel on veut tester actionsPossibles()
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU1);
        // on choisit la couleur du joueur
        boolean estNoir = true;
        // on choisit le niveau
        int niveau = 1;
        // on lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        // on peut afficher toutes les actions possibles calculées :
        Utils.afficherActionsPossibles(actionsPossibles);
        // on peut aussi tester si une action est dans les actions possibles :
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PaB,1,0"));
        // on peut aussi tester si une action n'est pas dans les actions 
        // possibles :
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles, "PaQ,1,0"));
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles, "PaA,0,0"));
        // testons les 4 coins :
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PaA,1,0"));
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PpA,1,0"));
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PaP,1,0"));
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles, "PpP,1,0"));
        // vérifions s'il y a le bon nombre d'actions possibles :
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
        // on lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // pose sur case vide : possible
        coord = Coordonnees.depuisCars('a', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de même couleur : possible
        coord = Coordonnees.depuisCars('b', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de couleur opposée : impossible
        coord = Coordonnees.depuisCars('a', 'G');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de même couleur et hauteur > 1 : possible
        coord = Coordonnees.depuisCars('c', 'K');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 3.
     */
    public void testActionsPossibles_niveau3() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        boolean estNoir = true;
        int niveau = 3;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // on lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // pose sur case vide : possible
        coord = Coordonnees.depuisCars('a', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de même couleur : possible
        coord = Coordonnees.depuisCars('b', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de couleur opposée : impossible
        coord = Coordonnees.depuisCars('a', 'G');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de même couleur et hauteur >  : possible
        coord = Coordonnees.depuisCars('c', 'K');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 4.
     */
    public void testActionsPossibles_niveau4() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        boolean estNoir = true;
        int niveau = 4;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // on lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // pose sur case vide : possible
        coord = Coordonnees.depuisCars('b', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionDestruction(coord, nbPionsNoir, nbPionsBlancs)));
        // pose sur case de même couleur : possible
        coord = Coordonnees.depuisCars('l', 'E');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionDestruction(coord, nbPionsNoir, nbPionsBlancs - JoueurTowa.nbPionsDestruction(plateau, coord, estNoir))));
        // pose sur case de couleur opposée : impossible
        coord = Coordonnees.depuisCars('m', 'F');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionDestruction(coord, nbPionsNoir, nbPionsBlancs)));
    }
    
    /**
     * Test de la fonction actionsPossibles, au niveau 5.
     */
    public void testActionsPossibles_niveau5() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        boolean estNoir = true;
        int niveau = 2;
        int nbPionsNoir = JoueurTowa.nbPions(plateau, true);
        int nbPionsBlancs = JoueurTowa.nbPions(plateau, false);
        // on lance actionsPossibles
        String[] actionsPossibles = joueur.actionsPossibles(plateau, estNoir, niveau);
        Coordonnees coord;
        // pose sur case vide : possible
        coord = Coordonnees.depuisCars('a', 'B');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de même couleur : possible
        coord = Coordonnees.depuisCars('b', 'A');
        assertTrue(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de couleur opposée : impossible
        coord = Coordonnees.depuisCars('a', 'G');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
        // pose sur case de même couleur et hauteur > 1 : possible
        coord = Coordonnees.depuisCars('c', 'K');
        assertFalse(Utils.actionsPossiblesContient(actionsPossibles,
                JoueurTowa.chaineActionPose(coord, nbPionsNoir + 1, nbPionsBlancs)));
    }

    @Test
    public void testNbPions() {
        // à décommenter le moment venu...
        
        //plateau1 : 0 noir, 0 blanc
        Case[][] plateau1 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU1);
        assertEquals(0, JoueurTowa.nbPions(plateau1, true));
        assertEquals(0, JoueurTowa.nbPions(plateau1, false));
        // plateau2 : 27 noirs, 20 blancs
        Case[][] plateau2 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        assertEquals(26, JoueurTowa.nbPions(plateau2, true));
        assertEquals(20, JoueurTowa.nbPions(plateau2, false));        
       
    }
    
    @Test
    public void testChaineActionPose() {
        assertEquals("PfK,3,8", 
                JoueurTowa.chaineActionPose(Coordonnees.depuisCars('f', 'K'), 3, 8));
        assertEquals("PaA,0,0", 
                JoueurTowa.chaineActionPose(Coordonnees.depuisCars('a', 'A'), 0, 0));
        assertEquals("PpP,10,10", 
                JoueurTowa.chaineActionPose(Coordonnees.depuisCars('p', 'P'), 10, 10));
    }
    
    @Test
    public void testPosePossible() {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau2 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        Coordonnees coord=Coordonnees.depuisCars('p','P');
        assertTrue(joueur.posePossible(plateau2, coord, true));
        coord=Coordonnees.depuisCars('c','K');
        assertFalse(joueur.posePossible(plateau2, coord, true));
        coord=Coordonnees.depuisCars('d','I');
        assertFalse(joueur.posePossible(plateau2, coord, true));
        coord=Coordonnees.depuisCars('i','B');
        assertTrue(joueur.posePossible(plateau2, coord, true));
    }
    
    @Test
    public void testNbPionsDestruction() {
        JoueurTowa joueur1 = new JoueurTowa();
        Case[][] plateau2 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        Coordonnees coord=Coordonnees.depuisCars('n','G');
        assertEquals(0,joueur1.nbPionsDestruction(plateau2, coord, true));
        Coordonnees.depuisCars('i','M');
        assertEquals(0,joueur1.nbPionsDestruction(plateau2, coord, true));
    }
    
    @Test
    public void testCasesVoisines()
    {
        Case[][] plateau2 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        Coordonnees coord;
        //Case en Haut a Gauche
        coord=Coordonnees.depuisCars('a','A');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 3);
        //Case en Haut a Droit
        coord=Coordonnees.depuisCars('a','P');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 3);
        //Case en Bas a Droit
        coord=Coordonnees.depuisCars('p','P');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 3);
        //Case en Bas a Gauche
        coord=Coordonnees.depuisCars('p','A');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 3);
        //Case coté Droit
        coord=Coordonnees.depuisCars('h','P');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 5);
        //Case coté Haut
        coord=Coordonnees.depuisCars('a','H');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 5);
        //Case coté Gauche
        coord=Coordonnees.depuisCars('h','A');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 5);
        //Case coté Bas
        coord=Coordonnees.depuisCars('p','H');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 5);
        //Case milieux
        coord=Coordonnees.depuisCars('h','H');
        assertTrue(JoueurTowa.caseVoisines(plateau2, coord).length == 8);
    }
    
    @Test
    public void nbPionsPosseTest ()
    {
        JoueurTowa joueur = new JoueurTowa();
        Case[][] plateau2 = Utils.plateauDepuisTexte(PLATEAU_NIVEAU2);
        Coordonnees coord=Coordonnees.depuisCars('j','O');
        assertTrue(joueur.nbPionsPosse(plateau2, coord, true)==2);
        coord=Coordonnees.depuisCars('a','A');
        assertTrue(joueur.nbPionsPosse(plateau2, coord, true)==1);
        coord=Coordonnees.depuisCars('f','F');
        assertTrue(joueur.nbPionsPosse(plateau2, coord, true)==1);
        coord=Coordonnees.depuisCars('i','N');
        assertTrue(joueur.nbPionsPosse(plateau2, coord, false)==2);
        coord=Coordonnees.depuisCars('c','E');
        assertTrue(joueur.nbPionsPosse(plateau2, coord, true)==1);
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
            + "c|   |   |B1 |   |B1 |   |   |   |   |   |N4 |B1 |   |   |   |   |\n"
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
}
