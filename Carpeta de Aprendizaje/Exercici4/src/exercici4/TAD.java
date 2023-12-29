package exercici4;

import java.util.NoSuchElementException;

/**
 * Interfaz para el TAD tipo Pila y Cola.
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 * @param <T> Tipo de elementos almacenados en la estructura.
 */
public interface TAD<T> {

    /**
     * Agrega un elemento a la cima de la pila. 
     * Agrega un elemento al final de la cola.
     *
     * @param elemento Elemento que se va a agregar.
     */
    public void push(T elemento);

    /**
     * Elimina y devuelve el elemento en la cima de la pila. Elimina y devuelve
     * el elemento al inicio de la cola.
     *
     * @return Elemento en la cima/inicio de la estructura.
     * @throws NoSuchElementException Si la pila/cola está vacía.
     */
    public T pop() throws NoSuchElementException;

    /**
     * Devuelve el elemento en la cima de la pila sin retirarlo.
     * Devuelve el elmento al incio de la cola sin retirarlo.
     * 
     * @return Elemento en la cima/inicio de la estructura.
     * @throws NoSuchElementException Si la pila/cola está vacía.
     */
    public T top() throws NoSuchElementException;

    /**
     * Verifica si la pila está vacía. 
     * Verifica si la cola está vacía.
     *
     * @return true si la estructura está vacía, false en caso contrario.
     */
    public boolean estaVacia();

}
