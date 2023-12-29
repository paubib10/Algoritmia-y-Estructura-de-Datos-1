package backtracking;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoni
 */
public class BacktrackingImplTest {

    public BacktrackingImplTest() {
    }

    /**
     * Test of knapSack method, of class BacktrackingImpl.
     */
    @Test
    public void testKnapSack() {
        System.out.println("knapSack");
        int W = 3;
        int w[] = {2, 3, 2, 1};
        int p[] = {3, 3, 1, 10};
        int[] expResult = {1, 0, 0, 1};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testKnapSackOther() {
        System.out.println("knapSackOther");
        int W = 2;
        int w[] = {2, 3, 2, 1, 45, 78};
        int p[] = {3, 3, 1, 10, 16, 78};

        int[] expResult = {0, 0, 0, 1, 0, 0};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testKnapSackNotEqual() {
        System.out.println("knapSackOtherNotEqual");
        int W = 1;
        int w[] = {2, 60, 4, 1, 45};
        int p[] = {3, 3, 1, 10, 16, 78};

        int[] expResult = {0, 0, 0, 1, 0};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testKnapSackEqual() {
        System.out.println("knapSackOtherEqual");
        int W = 3;
        int w[] = {100, 80, 50, 40};
        int p[] = {100, 80, 50, 40};

        int[] expResult = {0, 0, 0, 0};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testKnapSackEmpty() {
        System.out.println("knapSackOtherEmpty");
        int W = 3;
        int w[] = {};
        int p[] = {};

        int[] expResult = {};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testKnapSackNull() {
        System.out.println("knapSackOtherNull");
        int W = 3;
        int w[] = {2, 10, 98};
        int p[] = null;
        int[] expResult = null;

        try {
            BacktrackingImpl instance = new BacktrackingImpl();
            int[] result = instance.knapSack(W, w, p);
            assertArrayEquals(expResult, result);
        } catch (Exception e) {
            // Success
        }
    }
}
