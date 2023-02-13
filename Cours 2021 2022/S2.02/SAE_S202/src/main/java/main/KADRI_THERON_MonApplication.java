package main;

import io.jbotsim.core.Color;
import io.jbotsim.core.Link;
import io.jbotsim.core.Node;
import io.jbotsim.core.Topology;
import io.jbotsim.core.event.SelectionListener;
import io.jbotsim.ui.JTopology;
import io.jbotsim.ui.icons.Icons;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Classe permettant de réaliser différents parcours de graphes avec une
 * interface graphique. Les algorithmes utilisés sont le BFS et A*.
 *
 * @author Yanis Kadri & Evan Théron
 */
public class KADRI_THERON_MonApplication implements ActionListener, SelectionListener {

    Topology tp; // Objet qui contient le graphe
    JTopology jtp; // Composant graphique qui affiche le graphe
    private static Node source = null; //Objet noeud qui sera la source
    private static Node destination = null; //Objet noeud qui sera la destination
    static HashSet<Node> obstacleNoeud; //Contient les obstacles de noeuds

    public KADRI_THERON_MonApplication() {
        // Création du graphe
        tp = new Topology();

        // Initialisation des noeuds à éviter
        obstacleNoeud = new HashSet<>();

        // Création de l'interface graphique (ci-dessous)
        creerInterfaceGraphique();
    }

    private void creerInterfaceGraphique() {
        // Création d'une fenêtre
        JFrame window = new JFrame("Yanis Kadri & Evan Théron");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création du composant graphique qui affiche le graphe
        jtp = new JTopology(tp);

        // Abonnement aux évènements des Noeuds (voir si on clique sur un noeud)
        tp.addSelectionListener(this);

        window.add(jtp);

        // Création d'un bouton test
        JButton button = new JButton("Réinitialiser les affichages");
        window.add(button, BorderLayout.NORTH);

        // Création d'un deuxième bouton pour le chemin fait par le parcours en largeur
        JButton buttonParcoursLargeur = new JButton("Recherche de chemin parcours largeur");
        window.add(buttonParcoursLargeur, BorderLayout.SOUTH);

        // Création d'un troisème bouton pour le chemin fait par A*
        JButton buttonAShtar = new JButton("Recherche de chemin A*");
        window.add(buttonAShtar, BorderLayout.EAST);

        // Abonnement aux évènements du bouton (clic, etc.)
        button.addActionListener(this);
        buttonParcoursLargeur.addActionListener(this);
        buttonAShtar.addActionListener(this);

        // Finalisation
        window.pack();
        window.setVisible(true);
    }

    /**
     * Méthode appelée lorsqu'un bouton est cliqué.
     *
     * @param e le bouton cliqué
     * @author Evan Théron & Yanis Kadri
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Réinitialiser les affichages")) {
            reinitialiser(tp);
        }

        if (e.getActionCommand().equals("Recherche de chemin parcours largeur")) {
            if (source == null || destination == null) {
                messageOublie();
            } else {
                reinitialiseAretes(tp);
                afficherChemin(extraireChemin(source, destination, parcoursEnLargeur(tp, source)));
            }
        }
        if (e.getActionCommand().equals("Recherche de chemin A*")) {
            if (source == null || destination == null) {
                messageOublie();
            } else {
                reinitialiseAretes(tp);
                afficherChemin(extraireChemin(source, destination, aShtar(source, destination)));
            }
        }
    }

    /**
     * Réinitialiser les affichages. Noeuds source et destination,
     * arbre recouvrant...
     * 
     * @author Evan Théron
     */
    private void reinitialiser(Topology tp) {
        reinitialiseAretes(tp);

        if (source != null) {
            source.setColor(null);
            source = null;
        }

        if (destination != null) {
            destination.setIcon(null);
            destination = null;
        }

        for (Node n : obstacleNoeud) {
            n.setColor(null);
        }

        obstacleNoeud.clear();
    }
    
    /**
     * Affiche un message d'erreur s'il manque le noeud source, le noeud
     * destination ou les deux.
     *
     * @author Yanis Kadri & Evan Théron
     */
    private void messageOublie() {
        JOptionPane.showMessageDialog(null, "Pas de source/destination, le chemin n'a pas pu être généré");
    }

    /**
     * Permet récupérer l'évènement du clic molette sur un sommet
     *
     * @param selectedNode le sommet sélectionné
     */
    @Override
    public void onSelection(Node selectedNode) {
        /*On regarde si le sommet sélectionné est déjà source, destination
        ou obstacle. Dans ce cas, il redevient un sommet normal*/
        if (selectedNode == destination || selectedNode == source 
                || obstacleNoeud.contains(selectedNode)) {
            if (selectedNode == destination) {
                destination.setIcon(null);
                destination = null;
            } else if (source == selectedNode) {
                source.setColor(null);
                source = null;
            } else {
                obstacleNoeud.remove(selectedNode);
                selectedNode.setColor(null);
            }
        }
        
        //On regarde s'il n'y a pas de source
        else if (source == null) {
            source = selectedNode;
            source.setColor(Color.BLACK);
        
        //On regarde s'il n'y a pas de destination
        } else if (destination == null && source != selectedNode) {
            destination = selectedNode;
            destination.setIcon(Icons.FLAG);
            
        //Sinon on met les obstacles
        } else if (source != null && destination != null) {
            obstacleNoeud.add(selectedNode);
            selectedNode.setColor(Color.red);
        }
    }

    public static void main(String[] args) {
        new KADRI_THERON_MonApplication();
    }

    /**
     * Applique l'algorithme du parcours en largeur à partir d'un graphe et une
     * source spécifiés. Renvoie un tableau associatif de (noeud enfant, noeud
     * parent). .
     *
     * @param tp le graphe
     * @param source la source (noeud)
     * @return un tableau associatif de (noeud enfant, noeud parent)
     * @author Evan Théron & Yanis Kadri
     */
    public static HashMap<Node, Node> parcoursEnLargeur(Topology tp, Node source) {
        // déclaration/initialisation de variables nécessaires
        HashMap<Node, Node> parent = new HashMap<>();// (enfant,parent)
        Node cNode; // noeud courant
        LinkedList<Node> f = new LinkedList<>(); // file de noeuds

        // initialisation du tableau associatif
        for (Node noeud : tp.getNodes()) {
            parent.put(noeud, null);
        }

        parent.replace(source, source);
        f.add(source);

        while (f.peek() != null) { // tant que la file n'est pas vide
            cNode = f.remove();
            for (Node nb : cNode.getNeighbors()) { // pour chaque voisin du noeud courant
                if (!parent.containsValue(nb) && !obstacleNoeud.contains(nb)) {
                    parent.replace(nb, cNode);
                    f.add(nb);
                }
            }
        }
        return parent;
    }

    /**
     * Applique l'algorithme A shtar (A*) à partir d'un graphe et une source et
     * destination spécifiés. Renvoie un tableau associatif de (noeud enfant,
     * noeud parent).
     *
     * @param source la source (noeud)
     * @param destination la destination (noeud)
     * @return un tableau associatif de (noeud enfant, noeud parent)
     * @author Evan Théron & Yanis Kadri
     */
    public static HashMap<Node, Node> aShtar(Node source, Node destination) {
        HashMap<Node, Node> parent = new HashMap<>();// (enfant,parent)
        PriorityQueue<Node> f = new PriorityQueue<>(new KADRI_THERON_ComparateurNoeud());// file de priorité de noeuds
        Node s;// noeud courant
        f.add(source);

        while (f.peek() != null && !parent.containsKey(destination)) {// tant que la file de proirité n'est pas vide

            s = f.remove();
            for (Node v : s.getInNeighbors()) {// pour chaque voisin du noeud courant
                if (!parent.containsKey(v) && !obstacleNoeud.contains(v)) {
                    parent.put(v, s);
                    f.add(v);
                }
            }
        }
        return parent;
    }

    /**
     * Methode réinitialisant toutes les épaisseurs des arêtes
     *
     * @param topo le graphe
     * @author Evan Théron & Yanis Kadri
     */
    private static void reinitialiseAretes(Topology topo) {
        for (Link l : topo.getLinks()) {
            l.setWidth(1);
        }
    }

    /**
     * Extrait le chemin allant de la source jusqu'à la destination spécifiées à
     * partir d'un arbre.
     *
     * @param source le début du chemin
     * @param destination la fin du chemin
     * @param parent les liens de parenté entre noeuds
     * @return une liste de noeuds représentant le chemin
     * @author Evan Théron & Yanis Kadri
     */
    static ArrayList<Node> extraireChemin(Node source, Node destination, HashMap<Node, Node> parent) {
        ArrayList<Node> path = new ArrayList<>();
        Node e = destination;
        Node p;
        while (parent.get(destination) != null && !path.contains(source)) {
            p = parent.get(e);
            path.add(e);
            e = p;
        }
        Collections.reverse(path);
        System.out.println("La liste du chemin dans l'ordre : " + path);
        return path;
    }

    /**
     * Afficher le chemin correspondant à la liste de sommets passée en
     * paramètre.
     *
     * @param chemin la liste de sommets correspondant au chemin
     * @author Yanis Kadri & Evan Théron
     */
    public static void afficherChemin(ArrayList<Node> chemin) {
        for (int i = 0; i < chemin.size() - 1; i++) {
            chemin.get(i).getCommonLinkWith(chemin.get(i + 1)).setWidth(4);
        }
    }

    /**
     * Permet de voir le noeud de destination
     *
     * @return le noeud de destination
     * @author Yanis Kadri & Evan Théron
     */
    public static Node getDestination() {
        return destination;
    }

}
