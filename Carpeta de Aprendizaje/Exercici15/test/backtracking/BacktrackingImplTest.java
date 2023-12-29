package backtracking;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class BacktrackingImplTest {
    
    public BacktrackingImplTest() {
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColor() {
        System.out.println("mapColor");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapInsufficientColors() {
        System.out.println("mapColorInsufficientColors");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 2;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColor2() {
        System.out.println("mapColor2");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 4;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColor3() {
        System.out.println("mapColor3");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 1;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColorEmpty() {
        System.out.println("mapColorEmpty");
        int[][] map = {};
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
    }
       
    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColorNull() {
        System.out.println("mapColorNull");
        int[][] map = null;
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColorIterative() {
        System.out.println("mapColorIterative");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColorIterative(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapInsufficientColorsIterative() {
        System.out.println("mapColorInsufficientColorsIterative");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 2;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColorIterative(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColor2Iterative() {
        System.out.println("mapColor2Iterative");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 4;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColorIterative(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColor3Iterative() {
        System.out.println("mapColor3Iterative");
        int[][] map = {{1,3},{0,2,3,4},{1,4},{0,1},{1,2}};
        int nColors = 1;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColorIterative(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColorEmptyIterative() {
        System.out.println("mapColorEmptyIterative");
        int[][] map = {};
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColorIterative(map, nColors);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of mapColor method, of class BacktrackingImpl.
     */
    @Test
    public void testMapColorNullIterative() {
        System.out.println("mapColorNullIterative");
        int[][] map = null;
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColorIterative(map, nColors);
        assertEquals(expResult, result);
    }
}
