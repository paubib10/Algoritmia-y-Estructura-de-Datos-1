package heap;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoni
 */
public class HeapSortImplTest {

    public HeapSortImplTest() {
    }

    /**
     * Test of heapSort method, of class HeapSortImpl.
     */
    @Test
    public void testHeapSort() {
        System.out.println("heapSort");

        // Crear un array de enteros aleatorios
        Integer a[] = new Integer[100];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }

        // Aplicar Heap Sort al array
        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        // Verificar si el array está ordenado correctamente
        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    @Test
    public void testHeapSortOrdered() {
        System.out.println("testHeapSortOrdered");

        // Crear un array ya ordenado
        Integer[] a = new Integer[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        // Aplicar Heap Sort al array
        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        // Verificar si el array está ordenado correctamente
        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
                break;
            }
        }

        // Afirmar que el resultado es verdadero (el array está ordenado)
        assertEquals(true, result);
    }

    @Test
    public void testHeapSortReverseOrdered() {
        System.out.println("testHeapSortReverseOrdered");

        // Crear un array ordenado en orden inverso
        Integer[] a = new Integer[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i - 1;
        }

        // Aplicar Heap Sort al array
        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        // Verificar si el array está ordenado correctamente
        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
                break;
            }
        }

        // Afirmar que el resultado es verdadero (el array está ordenado)
        assertEquals(true, result);
    }

    @Test
    public void testHeapSortWithDuplicates() {
        System.out.println("testHeapSortWithDuplicates");

        // Crear un array con elementos duplicados
        Integer[] a = new Integer[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = 42;
        }

        // Aplicar Heap Sort al array
        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        // Verificar si el array está ordenado correctamente
        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
                break;
            }
        }

        // Afirmar que el resultado es verdadero (el array está ordenado)
        assertEquals(true, result);
    }
}
