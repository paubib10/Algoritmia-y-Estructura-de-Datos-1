package cola;

import exercici4.TAD;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementación de la Cola con cursores (usando ArrayList).
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 * @param <T> Tipo de elementos en la Cola.
 */
public class ColaConCursores<T> implements TAD<T> {

    private ArrayList<T> elementos;
    private int cursor;

    public ColaConCursores() {
        elementos = new ArrayList<>();
        cursor = 0;
    }

    @Override
    public void push(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La coa está vacía.");
        }
        T elemento = elementos.remove(cursor);
        return elemento;
    }

    @Override
    public T top() throws NoSuchElementException {
        if (estaVacia()) {
            throw new NoSuchElementException("La coa está vacía.");
        }
        return elementos.get(cursor);
    }

    @Override
    public boolean estaVacia() {
        return cursor == elementos.size();
    }

}
