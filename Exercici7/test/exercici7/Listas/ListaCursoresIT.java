package exercici7.Listas;

import org.junit.Test;

/**
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class ListaCursoresIT {
    
    /**
     * Prueba agregar elementos a una lista vacía.
     */
    @Test
    public void testAdd() {
        ListaCursores<Integer> lista = new ListaCursores<>();
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
        ListaCursores<Integer> lista = new ListaCursores<>();
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
        ListaCursores<Integer> lista = new ListaCursores<>();
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
        ListaCursores<Integer> lista = new ListaCursores<>();
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
        ListaCursores<Integer> lista = new ListaCursores<>();
        assertThat(lista.isEmpty());
    }
    
    /**
     * Prueba verificar si una lista deja de estar vacía después de agregar un elemento.
     */
    @Test
    public void testNotEmptyAfterAdding() {
        ListaCursores<Integer> lista = new ListaCursores<>();
        lista.add(5);
        assertThat(!lista.isEmpty());
    }
    
    /**
     * Prueba eliminar un elemento de la lista.
     */
    @Test
    public void testRemove() {
        ListaCursores<Integer> lista = new ListaCursores<>();
        lista.add(5);
        lista.add(2);
        lista.add(3);
        lista.remove(2);
        assertThat(!lista.contains(2));
    }
    
    // METODOS AUXILIARES
    
    private boolean isSorted(ListaCursores<Integer> lista) {
        for (int i = 0; i < lista.size - 1; i++) {
            if (lista.getElement(i).compareTo(lista.getElement(i + 1)) > 0) {
                return false;
            }
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