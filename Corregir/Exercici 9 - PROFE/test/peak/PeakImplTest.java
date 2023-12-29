/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package peak;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoni
 */
public class PeakImplTest {
    
    /**
     * Test of peak method, of class PeakImpl.
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
    
}
