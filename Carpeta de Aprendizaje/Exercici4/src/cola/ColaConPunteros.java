package cola;

import exercici4.TAD;
import java.util.NoSuchElementException;

/**
 * Implementación de Cola con punteros (usando nodos).
 * 
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 * @param <T> Tipo de elementos en la Cola.
 */
public class ColaConPunteros<T> implements TAD<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;

    /**
     * Clase interna que representa un nodo en la implementación de una
     * estructura de datos con punteros. Cada nodo contiene un dato y una
     * referencia al siguiente nodo en la secuencia.
     *
     * @param <E> Tipo de elemento almacenado en el nodo.
     */
    private static class Nodo<T> {

        T dato;
        Nodo<T> next;

        /**
         * Constructor para crear un nuevo nodo con dato y siguiente nodo
         * especificados.
         *
         * @param dato El dato alamcenado en el nodo.
         * @param siguiente El siguiente nodo en la secuencia.
         */
        Nodo(T dato) {
            this.dato = dato;
        }
    }

    @Override
    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.next = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        T dato = inicio.dato;
        inicio = inicio.next;
        if (inicio == null) {
            fin = null;
        }
        return dato;
    }

    @Override
    public T top() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return inicio.dato;
    }

    @Override
    public boolean estaVacia() {
        return inicio == null;
    }
}
