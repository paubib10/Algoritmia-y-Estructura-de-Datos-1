package exercici7.Listas;

import exercici7.Nodo;
import org.junit.Test;

/**
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class ListaReferenciasIT {
    
    /**
     * Prueba agregar elementos a una lista vacía.
     */
    @Test
    public void testAdd() {
        ListaReferencias<Integer> lista = new ListaReferencias<>();
        lista.add(5);
        lista.add(2);
        lista.add(3);
        assertThat(isSorted(lista));
    }
    
    /**
     * Prueba limpiar una lista no vacía.
     */
    @Test
    public void testClear() {
        ListaReferencias<Integer> lista = new ListaReferencias<>();
        lista.add(5);
        lista.add(2);
        lista.add(3);
        lista.clear();
        assertThat(lista.isEmpty());
    }
    
    /**
     * Prueba verificar la presencia de un elemento en la lista (caso verdadero).
     */
    @Test
    public void testContainsTrue() {
        ListaReferencias<Integer> lista = new ListaReferencias<>();
        lista.add(5);
        lista.add(2);
        lista.add(3);
        assertThat(lista.contains(2));
    }
    
    /**
     * Prueba verificar la presencia de un elemento en la lista (caso falso).
     */
    @Test
    public void testContainsFalse() {
        ListaReferencias<Integer> lista = new ListaReferencias<>();
        lista.add(5);
        lista.add(2);
        lista.add(3);
        assertThat(!lista.contains(4));
    }
    
    /**
     * Prueba verificar si una lista está vacía inicialmente.
     */
    @Test
    public void testIsEmptyInitially() {
        ListaReferencias<Integer> lista = new ListaReferencias<>();
        assertThat(lista.isEmpty());

    }
    
    /**
     * Prueba verificar si una lista deja de estar vacía después de agregar un elemento.
     */
    @Test
    public void testNotEmptyAfterAdding() {
        ListaReferencias<Integer> lista = new ListaReferencias<>();
        lista.add(5);
        assertThat(!lista.isEmpty());
    }
    
    /**
     * Prueba eliminar un elemento de la lista.
     */
    @Test
    public void testRemove() {
        ListaReferencias<Integer> lista = new ListaReferencias<>();

        lista.add(5);
        lista.add(2);
        lista.add(3);
        lista.remove(2);
        assertThat(!lista.contains(2));
    }
    
    // METODOS AUXILIARES
    
    boolean isSorted(ListaReferencias<Integer> lista) {
        Nodo<Integer> actual = lista.inicio;

        while (actual != null && actual.siguiente != null) {
            if (actual.elemento.compareTo(actual.siguiente.elemento) > 0) {
                return false;
            }
            actual = actual.siguiente;
        }

        return true;
    }

    static void assertThat(boolean b) {
        if (b) {
            System.out.println("NICE BRO");
        } else {
            System.out.println("MALA TUYA");
        }
    }

}
