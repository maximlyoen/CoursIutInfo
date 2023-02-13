package main;


import io.jbotsim.core.Node;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yanis
 */
public class KADRI_THERON_ComparateurNoeud implements Comparator<Node> {
      
    @Override
    public int compare(Node n1, Node n2){
        Node destination = KADRI_THERON_MonApplication.getDestination();
        
        int res = 0;
        if (n1 == null && n2 == null) {
            return 0;
        }
        if (n1 == null) {
            return 1;
        }
        if (n2 == null) {
            return -1;
        }
        if (n1.distance(destination) < n2.distance(destination)) {
            return -1;
        }
        if (n1.distance(destination) > n2.distance(destination)) {
            return 1;
        }
        return res;
    }
}
