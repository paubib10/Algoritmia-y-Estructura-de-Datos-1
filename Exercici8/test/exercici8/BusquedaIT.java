package exercici8;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class BusquedaIT {
    
    Comparable<Integer>[] arrayOrdenado = new Comparable[1000000];

    @Test
    public void testBusquedaLinealRecursiva() {
        System.out.println("BLR: ");
        for (int i = 0; i < arrayOrdenado.length; i++) {
            arrayOrdenado[i] = i;
        }
        
        assertEquals(0, Busqueda.busquedaLinealRecursiva(arrayOrdenado, 0));
        System.out.println(Busqueda.getConsultasLinealRecursiva());
        assertThrows(StackOverflowError.class,()->Busqueda.busquedaLinealRecursiva(arrayOrdenado, 100000));
        System.out.println(Busqueda.getConsultasLinealRecursiva());
        assertThrows(StackOverflowError.class,()->Busqueda.busquedaLinealRecursiva(arrayOrdenado, 10000000));
        System.out.println(Busqueda.getConsultasLinealRecursiva());
    }

    @Test
    public void testBusquedaLinealIterativa() {
        System.out.println("BLI: ");
        for (int i = 0; i < arrayOrdenado.length; i++) {
            arrayOrdenado[i] = i;
        }

        assertEquals(0, Busqueda.busquedaLinealIterativa(arrayOrdenado, 0));
        System.out.println(Busqueda.getConsultasLinealIterativa());
        assertEquals(100000, Busqueda.busquedaLinealIterativa(arrayOrdenado, 100000));
        System.out.println(Busqueda.getConsultasLinealIterativa());
        assertEquals(-1, Busqueda.busquedaLinealIterativa(arrayOrdenado, 10000000));
        System.out.println(Busqueda.getConsultasLinealIterativa());
    }

    @Test
    public void testBusquedaBinariaRecursiva() {
        System.out.println("BBR: ");
        for (int i = 0; i < arrayOrdenado.length; i++) {
            arrayOrdenado[i] = i;
        }
        
        assertEquals(0, Busqueda.busquedaBinariaRecursiva(arrayOrdenado, 0));
        System.out.println(Busqueda.getConsultasBinariaRecursiva());
        assertEquals(100000, Busqueda.busquedaBinariaRecursiva(arrayOrdenado, 100000));
        System.out.println(Busqueda.getConsultasBinariaRecursiva());
        assertEquals(-1, Busqueda.busquedaBinariaRecursiva(arrayOrdenado, 10000000));
        System.out.println(Busqueda.getConsultasBinariaRecursiva());
    }

    @Test
    public void testBusquedaBinariaIterativa() {
        System.out.println("BBI: ");
        for (int i = 0; i < arrayOrdenado.length; i++) {
            arrayOrdenado[i] = i;
        }

        assertEquals(0, Busqueda.busquedaBinariaIterativa(arrayOrdenado, 0));
        System.out.println(Busqueda.getConsultasBinariaIterativa());
        assertEquals(100000, Busqueda.busquedaBinariaIterativa(arrayOrdenado, 100000));
        System.out.println(Busqueda.getConsultasBinariaIterativa());
        assertEquals(-1, Busqueda.busquedaBinariaIterativa(arrayOrdenado, 10000000));
        System.out.println(Busqueda.getConsultasBinariaIterativa());
    }
}
