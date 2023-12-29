package exercici2;

public class PilaCursores<T> {
    private Object[] elementos;
    private int top;

    public PilaCursores(int capacidad) {
        elementos = new Object[capacidad];
        top = -1;
    }

    public boolean estaVacia() {
        return top == -1;
    }

    public boolean estaLlena() {
        return top == elementos.length - 1;
    }

    public void push(T dato) {
        if (estaLlena()) {
            throw new IllegalStateException("La pila está llena");
        }
        elementos[++top] = dato;
        System.out.println("Push-> " + dato);
    }

    public T pop() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = (T) elementos[top];
        elementos[top--] = null;
        System.out.println("Pop-> " + dato);
        return dato;
    }

    public T cima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = (T) elementos[top];
        return dato;
    }
}
