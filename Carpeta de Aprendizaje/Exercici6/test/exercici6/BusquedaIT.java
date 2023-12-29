package exercici6;

import java.util.Comparator;
import org.junit.Test;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class BusquedaIT {

    public BusquedaIT() {
    }

    @Test
    public void testBusquedaBinariaComparableInteger() {
        System.out.println("\nTEST BUSQUEDA BINARIA CON COMPARABLE (INTEGER):");
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int objetivo = 8;
        int expResult = 7;
        int result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo derecho del array
        objetivo = 10;
        expResult = 9;
        result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo izquierdo del array
        objetivo = 1;
        expResult = 0;
        result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);

        // Caso de prueba para un elemento que no está en el array
        objetivo = 11;
        expResult = -1;
        result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);
    }

    @Test
    public void testBusquedaBinariaComparableString() {
        System.out.println("\nTEST BUSQUEDA BINARIA CON COMPARABLE (STRING):");
        String[] array = {"apple", "banana", "cherry", "date", "fig", "grape"};
        String objetivo = "date";
        int expResult = 3;
        int result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo derecho del array
        objetivo = "grape";
        expResult = 5;
        result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo izquierdo del array
        objetivo = "apple";
        expResult = 0;
        result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);

        // Caso de prueba para un elemento que no está en el array
        objetivo = "kiwi";
        expResult = -1;
        result = Busqueda.busquedaBinariaComparable(array, objetivo);
        assertThat(result == expResult);
    }

    @Test
    public void testBusquedaBinariaComparatorInteger() {
        System.out.println("\nTEST BUSQUEDA BINARIA CON COMPARATOR (INTEGER):");
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Comparator<Integer> comparador = Comparator.naturalOrder();

        int objetivo = 8;
        int expResult = 7;
        int result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo derecho del array
        objetivo = 10;
        expResult = 9;
        result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo izquierdo del array
        objetivo = 1;
        expResult = 0;
        result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);

        // Caso de prueba para un elemento que no está en el array
        objetivo = 11;
        expResult = -1;
        result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);
    }

    @Test
    public void testBusquedaBinariaComparatorString() {
        System.out.println("\nTEST BUSQUEDA BINARIA CON COMPARATOR (STRING):");
        String[] array = {"apple", "banana", "cherry", "date", "fig", "grape"};
        Comparator<String> comparador = Comparator.naturalOrder();

        String objetivo = "date";
        int expResult = 3;
        int result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo derecho del array
        objetivo = "grape";
        expResult = 5;
        result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);

        // Caso de prueba para un elemento en el extremo izquierdo del array
        objetivo = "apple";
        expResult = 0;
        result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);

        // Caso de prueba para un elemento que no está en el array
        objetivo = "kiwi";
        expResult = -1;
        result = Busqueda.busquedaBinariaConComparator(array, objetivo, comparador);
        assertThat(result == expResult);
    }

    static void assertThat(boolean b) {
        if (b) {
            System.out.println("NICE BRO");
        } else {
            System.out.println("MALA TUYA");
        }
    }
}
