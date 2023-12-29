package exercici7;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar
 */
public interface TAD<E> {
    
    /**
     * Añade un elemento a la lista de manera ordenada.
     *
     * @param e Elemento a añadir a la lista.
     */
    public void add(E e);
    
    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    public void clear();
    
    /**
     * Verifica si la lista contiene un elemento específico.
     *
     * @param e Elemento a buscar en la lista.
     * @return true si la lista contiene el elemento, false en caso contrario.
     */
    public boolean contains(E e);
    
    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public Boolean isEmpty();
    
    /**
     * Elimina la primera aparición del elemento de la colección, si está presente.
     *
     * @param e Elemento a eliminar de la colección.
     */
    public void remove(E e);

}
