package exercici7.Listas;

import exercici7.Nodo;
import exercici7.TAD;

/**
 * Implementación de una lista ordenada utilizando referencias.
 * @param <E> Tipo de elemento en la lista.
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar
 */
public class ListaReferencias<E extends Comparable<E>> implements TAD<E> {

    Nodo<E> inicio;

    public ListaReferencias() {
        this.inicio = null;
    }

    /**
     * Pre: El elemento 'e' no debe ser nulo. 
     * Post: El elemento 'e' se añade en la posición adecuada y la lista está ordenada.
     * O(n)
     */
    @Override
    public void add(E e) {
        Nodo<E> nuevoNodo = new Nodo<>(e);
        
        if (isEmpty() || e.compareTo(inicio.elemento) < 0) {
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        } else {
            Nodo<E> nodoActual=  inicio;

            while (nodoActual.siguiente != null && e.compareTo(nodoActual.siguiente.elemento) > 0) {
                nodoActual = nodoActual.siguiente;
            }

            nuevoNodo.siguiente = nodoActual.siguiente;
            nodoActual.siguiente = nuevoNodo;
        }
    }
    
    /**
     * Pre: La lista tiene elementos o está vacía. 
     * Post: La lista queda vacía después de la operación.
     * O(1), constante
     */
    @Override
    public void clear() {
        inicio = null;
    }
    
    /**
     * Pre: La lista tiene elementos. 
     * Post: La lista no se modifica y devuelve true si contiene el elemento 
     * 'e'; false si no lo contiene.
     * O(n)
     */
    @Override
    public boolean contains(E e) {
        Nodo<E> actual = inicio;

        while (actual != null) {
            if (actual.elemento.equals(e)) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }
    
    /**
     * Pre: La lista está vacía o tiene elementos. 
     * Post: La lista no se modifica y devuelve true si está vacía; false si tiene elementos.
     * O(1), constante
     */
    @Override
    public Boolean isEmpty() {
        return inicio == null;
    }
    
    /**
     * Pre: La lista tiene el elemento 'e'. 
     * Post: La lista se modifica eliminando la primera aparición del elemento 'e'.
     * O(n)
     */
    @Override
    public void remove(E e) {
        Nodo<E> actual = inicio;
        Nodo<E> anterior = null;

        while (actual != null && !actual.elemento.equals(e)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            if (anterior == null) {
                inicio = actual.siguiente;
            } else {
                anterior.siguiente = actual.siguiente;
            }
        }
    }

}
