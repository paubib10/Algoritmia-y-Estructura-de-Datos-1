package backtracking;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Blanca Atienzar Martínez &amp; Pau Toni Bibiloni Martínez
 */
public class BacktrackingImplTest {

//        /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        int M = 5;
//        int a[] = {1, 3, 1, 5, 2};
//        //int a[] = {1, 5, 2};
//
//        //sumM(a, M);
//    }
    /**
     * Test of sumM method, of class BacktrackingImpl.
     */
    @Test
    public void testSumM() {
        System.out.println("sumM");
        int M = 5;
        int a[] = {1, 3, 1, 5, 2};
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<>();

        ArrayList<Integer> s = new ArrayList<>();
        s.add(5);
        expResult.add(s);

        s = new ArrayList<>();
        s.add(3);
        s.add(2);
        expResult.add(s);

        s = new ArrayList<>();
        s.add(1);
        s.add(3);
        s.add(1);
        expResult.add(s);

        BacktrackingImpl instance = new BacktrackingImpl();
        ArrayList<ArrayList<Integer>> result = instance.sumM(a, M);
        assertEquals(expResult, result);

    }

    /**
     * Hecho por nosotros Test donde el conjunto no tiene elementos que sumen M,
     * de la clase BacktrackingImpl.
     */
    @Test
    public void testNoSuma() {
        System.out.println("NoExistenElementosQueSumenM");
        int M = 5;
        int a[] = {1, 3, 3, 6, 8};
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<>();

        BacktrackingImpl instance = new BacktrackingImpl();
        ArrayList<ArrayList<Integer>> result = instance.sumM(a, M);
        assertEquals(expResult, result);
    }

    /**
     * Hecho por nosotros Test donde el conjunto no tiene elementos (esta
     * vacio), de la clase BacktrackingImpl.
     */
    @Test
    public void testVacio() {
        System.out.println("ConjuntoVacio");
        int M = 5;
        int a[] = {};
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<>();

        BacktrackingImpl instance = new BacktrackingImpl();
        ArrayList<ArrayList<Integer>> result = instance.sumM(a, M);
        assertEquals(expResult, result);
    }

    /**
     * Hecho por nosotros Test donde M no es correcto porque tiene un valor
     * menor a 0, de la clase BacktrackingImpl.
     */
    @Test
    public void testMNegativo() {
        System.out.println("ElValorDeMEsNegativo");
        int M = -2;
        int a[] = {1, 0, 3, 4};
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<>();

        BacktrackingImpl instance = new BacktrackingImpl();
        ArrayList<ArrayList<Integer>> result = instance.sumM(a, M);
        assertEquals(expResult, result);
    }

    /**
     * Hecho por nosotros Test donde M no es correcto porque tiene un valor
     * menor a 0, de la clase BacktrackingImpl.
     */
    @Test
    public void testANegativo() {
        System.out.println("ElValorDeMEsNegativo");
        int M = -2;
        int a[] = {1, -2, 3, 4};
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<>();

        ArrayList<Integer> s = new ArrayList<>();
        s.add(-2);
        expResult.add(s);

        try {
            BacktrackingImpl instance = new BacktrackingImpl();
            ArrayList<ArrayList<Integer>> result = instance.sumM(a, M);
            assertEquals(expResult, result);
        } catch (Exception e) {
            // Success
        }
    }
}
