/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saes202jegumael2;

import io.jbotsim.core.Color;
import io.jbotsim.core.Link;
import io.jbotsim.core.Node;
import io.jbotsim.core.Topology;
import io.jbotsim.core.event.SelectionListener;
import io.jbotsim.ui.icons.Icons;
import io.jbotsim.ui.JTopology;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author etd
 */
public class MonApplication implements ActionListener,SelectionListener{

    
    Topology tp;// Objet qui contient le graphe
    JTopology jtp; //Composant graphique qui affiche le graphe
    Node source;
    Node destination;
    public MonApplication() {
        //Création du graphe
        tp= new Topology();
        // Création de l'interface graphique (ci-dessous)
        creerInterfaceGraphique();
        //Initialisation des noeuds
        source = null;
        destination = null;
    }
    private void creerInterfaceGraphique(){
        //Création d'une fenêtre
        JFrame window = new JFrame("Mon application");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Création du composant graphique qui affiche le graphe
        jtp = new JTopology(tp);
        window.add(jtp);
        
        //Création d'un bouton test
        JButton button = new JButton("Renitialisation");
        window.add(button,BorderLayout.NORTH);
        //Création d'un bouton test 2
        JButton button2 = new JButton("ParcoursEnLargeur");
        window.add(button2,BorderLayout.SOUTH);
        //Abonnement aux évènements du bouton(clic, etc.)
        button.addActionListener(this);
        button2.addActionListener(this);
        tp.addSelectionListener(this);
        //Finalisation
        window.pack();
        window.setVisible(true);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Renitialisation")){
            //JOptionPane.showMessageDialog(null, "Bouton1 cliqué");
            // renitialisation de la source et de la destination
            if(source !=null){
                source.setColor(null);
                source=null;
            }
            if(destination !=null){
               destination.setIcon(Icons.DEFAULT_NODE_ICON);
               destination = null; 
            } 
            for(Link l:tp.getLinks()){
                l.setWidth(1);
            }
        }
        if(e.getActionCommand().equals("ParcoursEnLargeur")){
            if (source!=null && destination !=null){
                extraireChemin(destination,source,ParcoursEnLargeur(tp,source,destination));
            }      
        }
    }

    @Override
    public void onSelection(Node selectedNode) {
        if (source == null){
            source = selectedNode;
            source.setColor(Color.red);
        }else if(destination == null){
            destination = selectedNode;
            destination.setIcon(Icons.FLAG);
        }
        
    }/**
     * Fait le parcours en largeur d'un graphe
     * @param tp le graphe
     * @param source le noeud source
     * @param destination le noeud de destination
     * @return les parents de chaque noeud
     */
    public static HashMap<Node,Node> ParcoursEnLargeur(Topology tp, Node source, Node destination){
        HashMap<Node,Node> parent = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        for (Node n: tp.getNodes()){
            if(n!=source)parent.put(n, null); // initialisation de tout les parents des noeuds à null
        }
        Node cNode;
        queue.add(source);
        parent.put(source, source); // met le parent de la source a source
        while(!queue.isEmpty() && parent.get(destination)==null){
            cNode = queue.remove();
            for(Node nv : cNode.getNeighbors()){
                if(parent.get(nv)==null){
                    parent.replace(nv,cNode); // met un parent au noeud nv
                    queue.add(nv); // ajoute le noeud nv a la file d'attente
                    //cNode.getCommonLinkWith(nv).setWidth(4); // modifie l'épaisseur de l'arrête entre les deux noeuds
                }
            }
        }
        return parent;   
    }
    public static ArrayList<Node> extraireChemin(Node source,Node destination,HashMap<Node,Node> parent){
        ArrayList<Node> chemin = new ArrayList<>();
        chemin.add(destination);
        Node cNode = destination;
        Node last = cNode;
        while(!chemin.contains(source)){
            last = cNode;
            cNode = parent.get(cNode);
            chemin.add(cNode);
            cNode.getCommonLinkWith(last).setWidth(4);   
        }
        Collections.reverse(chemin);
        return chemin;
    }
    /**
     * Retourne une liste
     * @param list une liste
     * @return la liste a l'envers
     */
    public static ArrayList<Node> extraireChemin(ArrayList<Node> list){
        ArrayList<Node> listReverse =new ArrayList<>();
        Node n;
        while(!list.isEmpty()){
            listReverse.add(list.get(list.size()-1));
            list.remove(list.size()-1);
        }
        return listReverse;
    }

    
    
}
