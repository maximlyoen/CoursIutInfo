/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main;

import io.jbotsim.core.Node;
import io.jbotsim.core.Topology;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Evan
 */
public class KADRI_THERON_MonApplicationTest {
    
    public KADRI_THERON_MonApplicationTest() {
    }

    /**
     * Test of actionPerformed method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        KADRI_THERON_MonApplication instance = new KADRI_THERON_MonApplication();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onSelection method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testOnSelection() {
        System.out.println("onSelection");
        Node selectedNode = null;
        KADRI_THERON_MonApplication instance = new KADRI_THERON_MonApplication();
        instance.onSelection(selectedNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        KADRI_THERON_MonApplication.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parcoursEnLargeur method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testParcoursEnLargeur() {
        System.out.println("parcoursEnLargeur");
        Topology tp = null;
        Node source = null;
        HashMap<Node, Node> expResult = null;
        HashMap<Node, Node> result = KADRI_THERON_MonApplication.parcoursEnLargeur(tp, source);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aShtar method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testAShtar() {
        System.out.println("aShtar");
        Node source = null;
        Node destination = null;
        HashMap<Node, Node> expResult = null;
        HashMap<Node, Node> result = KADRI_THERON_MonApplication.aShtar(source, destination);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of extraireChemin method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testExtraireChemin() {
        System.out.println("extraireChemin");
        Node source = null;
        Node destination = null;
        HashMap<Node, Node> parent = null;
        ArrayList<Node> expResult = null;
        ArrayList<Node> result = KADRI_THERON_MonApplication.extraireChemin(source, destination, parent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherChemin method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testAfficherChemin() {
        System.out.println("afficherChemin");
        ArrayList<Node> chemin = null;
        KADRI_THERON_MonApplication.afficherChemin(chemin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestination method, of class KADRI_THERON_MonApplication.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Node expResult = null;
        Node result = KADRI_THERON_MonApplication.getDestination();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
