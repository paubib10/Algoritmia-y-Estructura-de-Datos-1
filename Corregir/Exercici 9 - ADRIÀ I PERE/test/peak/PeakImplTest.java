/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package peak;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Conjunt de proves del mètode peak, de la classe PeakImpl.
 * 
 * @author antoni
 * @author Adrià Serra Martín
 * @author Pere Garcias Miralles
 */
public class PeakImplTest {
    
    /**
     * Test del mètode peak, de la classe PeakImpl.
     * Test proporcionat pel professor.
     */
    @Test
    public void testPeak() {
        System.out.println("peak");
        int[] a = {1,3,5,7,8,5,2,1};
        Point expResult = new Point(8,4);
        Peak p = new PeakImpl();
        Point result = p.peak(a);
        assertEquals(expResult, result);
    }
    
    // TESTS PROPORCIONATS PELS AUTORS //
    
    /**
     * Test que comprova el cas trivial.
     */
    @Test
    public void testPeak1() {
        System.out.println("\n***CAS TRIVIAL***");
        int[] b = {1,5,4,3,2,1};
        Point esperat = new Point(5,1);
        Peak p = new PeakImpl();
        Point resultat = p.peak(b);
        System.out.println("Esperat: " + esperat + "\nResultat: " + resultat);
        assertEquals(esperat,resultat);
    }
    
    /**
     * Cas amb longitud de l'array igual a 3.
     */
    @Test
    public void testPeak2() {
        System.out.println("\n***LENGTH = 3***");
        int[] a = {1,5,2};
        Point expResult = new Point(5,1);
        Peak p = new PeakImpl();
        Point result = p.peak(a);
        System.out.println("Esperat: " + expResult + "\nResultat: " + result);
        assertEquals(expResult, result);
    }
    
    /**
     * Cas amb longitud senar i el pic situat just al centre.
     */
    @Test
    public void testPeak3() {
        System.out.println("\n***LONGITUD SENAR AMB CIM CENTRAL***");
        int[] a = {1,2,4,5,9,8,7,4,3};
        Point expResult = new Point(9,4);
        Peak p = new PeakImpl();
        Point result = p.peak(a);
        System.out.println("Esperat: " + expResult + "\nResultat: " + result);
        assertEquals(expResult, result);
    }
    
    /**
     * Cas amb longitud senar i el pic situat a la part dreta de l'array.
     */
     @Test
    public void testPeak4() {
        System.out.println("\n***LONGITUD SENAR I PIC A LA DRETA***");
        int[] a = {1,2,4,5,9,10,11,4,3};
        Point expResult = new Point(11,6);
        Peak p = new PeakImpl();
        Point result = p.peak(a);
        System.out.println("Esperat: " + expResult + "\nResultat: " + result);
        assertEquals(expResult, result);
    }
    
    /**
     * Cas amb longitud senar i el pic situat a la part esquerra de l'array.
     */
     @Test
    public void testPeak5() {
        System.out.println("\n***LONGITUD SENAR I PIC A L'ESQUERRA***");
        int[] a = {1,2,4,12,9,8,7,4,3};
        Point expResult = new Point(12,3);
        Peak p = new PeakImpl();
        Point result = p.peak(a);
        System.out.println("Esperat: " + expResult + "\nResultat: " + result);
        assertEquals(expResult, result);
    }
    
    /**
     * Cas amb longitud parell i el pic situat a la part dreta de l'array.
     */
     @Test
    public void testPeak6() {
        System.out.println("\n***LONGITUD PARELL I PIC A LA DRETA***");
        int[] a = {1,2,4,5,8,7,4,3};
        Point expResult = new Point(8,4);
        Peak p = new PeakImpl();
        Point result = p.peak(a);
        System.out.println("Esperat: " + expResult + "\nResultat: " + result);
        assertEquals(expResult, result);
    }
    
    /**
     * Cas amb longitud parell i el pic situat a la part esquerra de l'array.
     */
    @Test
    public void testPeak7() {
        System.out.println("\n***LONGITUD PARELL I EL PIC A L'ESQUERRA***");
        int[] a = {1,2,10,7,4,3};
        Point expResult = new Point(10,2);
        Peak p = new PeakImpl();
        Point result = p.peak(a);
        System.out.println("Esperat: " + expResult + "\nResultat: " + result);
        assertEquals(expResult, result);
    }
    
}
