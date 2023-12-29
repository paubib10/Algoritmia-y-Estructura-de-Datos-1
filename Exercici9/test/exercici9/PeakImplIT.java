package exercici9;

import java.awt.Point;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Clase de prueba JUnit para la clase IPeak. Se utiliza para verificar el
 * correcto funcionamiento del método peak.
 *
 * Esta clase contiene casos de prueba para el método peak de la clase IPeak.
 * Cubre diversas situaciones, como arrays ascendentes, descendentes, mixtos,
 * con repeticiones, arrays vacíos, de un solo elemento, y casos con múltiples
 * picos.
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class PeakImplIT {

    private PeakImpl p = new PeakImpl();

    /**
     * Prueba el método peak con un array ascendente.
     */
    @Test
    public void testPeakAscending() {
        int[] array1 = {1, 2, 3, 4, 5};
        try {
            p.peak(array1);
        } catch (IllegalArgumentException e) {
            // Success
        }
    }

    /**
     * Prueba el método peak con un array descendente.
     */
    @Test
    public void testPeakDescending() {
        int[] array2 = {8, 10, 6, 4, 2};
        Point result3 = p.peak(array2);
        assertEquals(new Point(10, 1), result3);
    }

    /**
     * Prueba el método peak con un array mixto.
     */
    @Test
    public void testPeakMixed() {
        int[] array3 = {5, 10, 20, 15, 3};
        Point result3 = p.peak(array3);
        assertEquals(new Point(20, 2), result3);
    }

    /**
     * Prueba el método peak con un array que contiene repeticiones.
     */
    @Test
    public void testPeakWithRepetition() {
        int[] array4 = {1, 2, 3, 5, 4};
        Point result4 = p.peak(array4);
        assertEquals(new Point(5, 3), result4);
    }

    /**
     * Prueba el método peak con un array vacío.
     */
    @Test
    public void testPeakEmptyArray() {
        int[] array = {};
        try {
            p.peak(array);
        } catch (IllegalArgumentException e) {
            // Success
        }
    }

    /**
     * Prueba el método peak con un array nulo.
     */
    @Test
    public void testPeakNullArray() {
        int[] array = null;
        try {
            p.peak(array);
        } catch (IllegalArgumentException e) {
            // Success
        }
    }

    /**
     * Prueba el método peak con un array que contiene un solo elemento.
     */
    @Test
    public void testPeakSingleElementArray() {
        int[] array = {42};
        try {
            p.peak(array);
        } catch (IllegalArgumentException e) {
            // Success
        }
    }
}
