package exercici7;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar
 */
public class Nodo<E extends Comparable<E>> {
        public E elemento;
        public Nodo<E> siguiente;

        public Nodo(E dato) {
            this.elemento = dato;
            this.siguiente = null;
        }
    }
