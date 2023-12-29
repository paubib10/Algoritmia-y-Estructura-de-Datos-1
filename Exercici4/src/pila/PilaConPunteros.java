package pila;

import exercici4.TAD;
import java.util.NoSuchElementException;

/**
 * Implementación de Pila con punteros (usando nodos).
 * 
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 * @param <T> Tipo de elementos en la Pila.
 */
public class PilaConPunteros<T> implements TAD<T> {

    private Nodo<T> top;

    /**
     * Clase interna que representa un nodo en la implementación de una
     * estructura de datos con punteros. Cada nodo contiene un dato y una
     * referencia al siguiente nodo en la secuencia.
     *
     * @param <T> Tipo de elemento almacenado en el nodo.
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
        nuevoNodo.next = top;
        top = nuevoNodo;
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila está vacía.");
        }
        T dato = top.dato;
        top = top.next;
        return dato;
    }

    @Override
    public T top() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila está vacía.");
        }
        return top.dato;
    }

    @Override
    public boolean estaVacia() {
        return top == null;
    }

}
