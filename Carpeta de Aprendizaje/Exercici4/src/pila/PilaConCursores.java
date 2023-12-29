package pila;

import exercici4.TAD;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementación de la Pila con cursores (usando ArrayList).
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 * @param <T> Tipo de elementos en la Pila.
 */
public class PilaConCursores<T> implements TAD<T> {
    
    private ArrayList<T> elementos;
    private int cursor;
    
    public PilaConCursores() {
        elementos = new ArrayList<>();
        cursor = -1;
    }
    
    @Override
    public void push(T elemento) {
        elementos.add(elemento);
        cursor++;
    }
    
    @Override
    public T pop() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila está vacía.");
        }
        T elemento = elementos.remove(cursor);
        cursor--;
        return elemento;
    }
    
    @Override
    public T top() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila está vacía.");
        }
        return elementos.get(cursor);
    }
    
    @Override
    public boolean estaVacia() {
        return cursor == -1;
    }
}
