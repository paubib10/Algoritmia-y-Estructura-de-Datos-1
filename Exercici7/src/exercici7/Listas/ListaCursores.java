package exercici7.Listas;

import exercici7.TAD;

/**
 * Implementación de una lista ordenada utilizando cursores.
 *
 * @param <E> Tipo de elemento en la lista.
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar
 */
public class ListaCursores<E extends Comparable<E>> implements TAD<E> {

    private static final int CAPACIDAD = 50;
    Object[] lista;
    int size;

    public ListaCursores() {
        this.lista = new Object[CAPACIDAD];
        this.size = 0;
    }
    
    /**
     * Pre: El elemento 'e' no debe ser nulo. 
     * Post: El elemento 'e' se añade en la posición adecuada y la lista está ordenada.
     * O(n), tiempo lineal
     */
    @Override
    public void add(E e) {
        aumentarCapacidad();
        int indice = 0;
        
        while(indice < size && e.compareTo((E) lista[indice]) > 0) {
            indice++;
        }
        
        for (int i = size - 1; i >= indice; i--) {
            lista[i + 1] = lista[i];
        }
        lista[indice] = e;
        size++;
    }
    
    /**
     * Pre: La lista tiene elementos o está vacía. 
     * Post: La lista queda vacía después de la operación.
     * O(1), tiempo constante
     */
    @Override
    public void clear() {
        lista = new Object[CAPACIDAD];
        size = 0;
    }
    
    /**
     * Pre: La lista tiene elementos. 
     * Post: La lista no se modifica y devuelve true si contiene el elemento 
     * 'e'; false si no lo contiene.
     * O(n * log n), 
     */
    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (lista[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Pre: La lista está vacía o tiene elementos. 
     * Post: La lista no se modifica y devuelve true si está vacía; false 
     * si tiene elementos.
     * O(1), tiempo constante
     */
    @Override
    public Boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Pre: La lista tiene el elemento 'e'. 
     * Post: La lista se modifica eliminando la primera aparición del 
     * elemento 'e'.
     * O(n), tiempo lineal
     */
    @Override
    public void remove(E e) {
        for (int i = 0; i < size; i++) {
            if (lista[i].equals(e)) {
                for (int j = i; j < size - 1; j++) {
                    lista[j] = lista[j + 1];
                }
                lista[size - 1] = null;
                size--;
                return;
            }
        }
    }
    
    /**
     * Pre: La lista debe tener el elemento 'e' en el indice indicado. 
     * Post: La lista no se modifica y devuelve el elemento 'e' en el
     * indice indicado.
     * O(1), tiempo constante
     */
    public E getElement(int i) {
        return (E) lista[i];
    }
    
    /**
     * Pre: -
     * Post: Duplica la capacidad de la lista y copia los elementos si está llena.
     * O(n), tiempo lineal
     */
    public void aumentarCapacidad() {
        if (size == lista.length) {
            E[] nuevaLista = (E[]) new Comparable[lista.length * 2];
            for (int i = 0; i < 10; i++) {
                nuevaLista[i] = (E) lista[i];
            }
            lista = nuevaLista;
        }
    }
}
