package exercici2;

public class PilaPunteros<T> {

    private Nodo<T> top;

    public PilaPunteros() {
        this.top = null;
    }

    public boolean estaVacia() {
        return top == null;
    }

    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = top;
        top = nuevoNodo;
        System.out.println("Push-> " + dato);
    }

    public T pop() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = top.dato;
        top = top.siguiente;
        System.out.println("Pop-> " + dato);
        return dato;
    }

    public T cima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return top.dato;
    }
}
