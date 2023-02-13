/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main;

import io.jbotsim.core.Node;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Evan
 */
public class KADRI_THERON_ComparateurNoeudTest {
    
    public KADRI_THERON_ComparateurNoeudTest() {
    }

    /**
     * Test of compare method, of class KADRI_THERON_ComparateurNoeud.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Node n1 = null;
        Node n2 = null;
        KADRI_THERON_ComparateurNoeud instance = new KADRI_THERON_ComparateurNoeud();
        int expResult = 0;
        int result = instance.compare(n1, n2);
        assertEquals(expResult, result);
    }
    
}
