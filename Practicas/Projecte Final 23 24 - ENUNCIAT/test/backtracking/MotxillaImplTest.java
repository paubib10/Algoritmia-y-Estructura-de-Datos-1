package backtracking;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas para la implementación de Motxilla. Se utilizan diferentes casos para
 * los métodos recursivo e iterativo.
 *
 * @author antoni
 */
public class MotxillaImplTest {

    private ElementMotxilla<String> a[];
    private Motxilla m;

    @Before
    public void setUp() {
        a = new ElementMotxilla[5];
        a[0] = new ElementMotxilla("A", 1.0, 2.0, 3.0);
        a[1] = new ElementMotxilla("B", 3.0, 1.0, 7.0);
        a[2] = new ElementMotxilla("C", 2.0, 1.0, 5.0);
        a[3] = new ElementMotxilla("D", 2.0, 1.0, 6.0);
        a[4] = new ElementMotxilla("E", 1.0, 2.0, 5.0);
        m = new MotxillaImpl();
    }

    /**
     * Prueba del método recursivo con un caso específico.
     */
    @Test
    public void testRecursiu() {
        System.out.println("recursiu");
        test(m.recursiu(a, 3.0, 5.0));
    }

    /**
     * Prueba del método iterativo con un caso específico.
     */
    @Test
    public void testIteratiu() {
        System.out.println("iteratiu");
        test(m.iteratiu(a, 3.0, 5.0));
    }

    private void test(ElementMotxilla[] result) {
        assertEquals(3.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(3.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(11.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(2, result.length);
        assertEquals("D", result[0].getElement());
        assertEquals("E", result[1].getElement());
    }

    /**
     * Prueba el método recursivo con límites de peso de 0.0. Se espera que el
     * resultado tenga un peso y un beneficio de 0.0 y que no contenga
     * elementos. Esta prueba verifica el comportamiento cuando la capacidad de
     * la mochila es cero, independientemente de los elementos disponibles.
     */
    @Test
    public void testRecursiuZeroWeights() {
        System.out.println("recursiu - zero weights");
        ElementMotxilla[] result = m.recursiu(a, 0.0, 0.0);
        assertEquals(0.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(0.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(0.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(0, result.length);
    }

    /**
     * Prueba el método iterativo con límites de peso de 0.0. Se espera que el
     * resultado tenga un peso y un beneficio de 0.0 y que no contenga
     * elementos. Esta prueba verifica el comportamiento cuando la capacidad de
     * la mochila es cero, independientemente de los elementos disponibles.
     */
    @Test
    public void testIteratiuZeroWeights() {
        System.out.println("iteratiu - zero weights");
        ElementMotxilla[] result = m.iteratiu(a, 0.0, 0.0);
        assertEquals(0.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(0.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(0.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(0, result.length);
    }

    /**
     * Prueba el método recursivo con altos límites de peso. Se espera que el
     * resultado tenga un peso y un beneficio específicos y que contenga un
     * número específico de elementos.
     */
    @Test
    public void testRecursiuHighWeights() {
        System.out.println("recursiu - high weights");
        ElementMotxilla[] result = m.recursiu(a, 100.0, 100.0);
        assertEquals(9.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(7.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(26.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(5, result.length);
    }

    /**
     * Prueba el método iterativo con altos límites de peso. Se espera que el
     * resultado tenga un peso y un beneficio específicos y que contenga un
     * número específico de elementos.
     */
    @Test
    public void testIteratiuHighWeights() {
        System.out.println("iteratiu - high weights");
        ElementMotxilla[] result = m.iteratiu(a, 100.0, 100.0);
        assertEquals(9.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(7.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(26.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(5, result.length);
    }

    /**
     * Prueba el método recursivo con un solo elemento. Se espera que el
     * resultado tenga un peso y un beneficio específicos y que contenga
     * exactamente ese elemento.
     */
    @Test
    public void testRecursiuSingleElement() {
        System.out.println("recursiu - single element");
        ElementMotxilla[] singleElement = {a[0]};
        ElementMotxilla[] result = m.recursiu(singleElement, 2.0, 3.0);
        assertEquals(1.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(2.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(3.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(1, result.length);
        assertEquals("A", result[0].getElement());
    }

    /**
     * Prueba el método iterativo con un solo elemento. Se espera que el
     * resultado tenga un peso y un beneficio específicos y que contenga
     * exactamente ese elemento.
     */
    @Test
    public void testIteratiuSingleElement() {
        System.out.println("iteratiu - single element");
        ElementMotxilla[] singleElement = {a[0]};
        ElementMotxilla[] result = m.iteratiu(singleElement, 2.0, 3.0);
        assertEquals(1.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(2.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(3.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(1, result.length);
        assertEquals("A", result[0].getElement());
    }

    /**
     * Prueba el método recursivo con elementos que tienen un peso y un
     * beneficio de 0.0. Se espera que el resultado tenga un peso y un beneficio
     * de 0.0 y que no contenga elementos. Esta prueba verifica el
     * comportamiento cuando todos los elementos disponibles para la mochila no
     * tienen peso ni beneficio, independientemente de la capacidad de la
     * mochila.
     */
    @Test
    public void testRecursiuZeroProfitAndWeight() {
        System.out.println("recursiu - zero profit and weight");
        ElementMotxilla[] zeroProfitAndWeight = new ElementMotxilla[5];
        for (int i = 0; i < 5; i++) {
            zeroProfitAndWeight[i] = new ElementMotxilla("Z", 0.0, 0.0, 0.0);
        }
        ElementMotxilla[] result = m.recursiu(zeroProfitAndWeight, 5.0, 5.0);
        assertEquals(0.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(0.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(0.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(0, result.length);
    }

    /**
     * Prueba el método iterativo con elementos que tienen un peso y un
     * beneficio de 0.0. Se espera que el resultado tenga un peso y un beneficio
     * de 0.0 y que no contenga elementos. Esta prueba verifica el
     * comportamiento cuando todos los elementos disponibles para la mochila no
     * tienen peso ni beneficio, independientemente de la capacidad de la
     * mochila.
     */
    @Test
    public void testIteratiuZeroProfitAndWeight() {
        System.out.println("iteratiu - zero profit and weight");
        ElementMotxilla[] zeroProfitAndWeight = new ElementMotxilla[5];
        for (int i = 0; i < 5; i++) {
            zeroProfitAndWeight[i] = new ElementMotxilla("Z", 0.0, 0.0, 0.0);
        }
        ElementMotxilla[] result = m.iteratiu(zeroProfitAndWeight, 5.0, 5.0);
        assertEquals(0.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(0.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(0.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(0, result.length);
    }

}
