package hanoi;

import java.util.Stack;

/**
 * Implementación de la interfaz Hanoi utilizando el método recursivo.
 * @param <E> Tipo de elementos en las torres.
 * @author Juan Francisco Riera
 * @author Sergi Villalonga
 */
public class HanoiImpl<E extends Comparable<E>> implements Hanoi<E> {

    /**
     * Método recursivo para resolver el problema de las Torres de Hanoi.
     *
     * @param h Altura de la torre que se desea mover.
     * @param a Torre de origen.
     * @param b Torre auxiliar.
     * @param c Torre de destino.
     *
     * Este algoritmo utiliza la técnica de divide y vencerás para
     * mover la torre de altura 'h' desde la torre 'a' hasta la torre 'c',
     * utilizando la torre 'b' como torre auxiliar.
     *
     * El orden de complejidad de este algoritmo es O(2^n),
     * donde 'n' es la altura de la torre a mover.
     *
     * La recursión se realiza 'h' veces, donde en cada llamada
     * se resuelve un subproblema reduciendo la altura en 1.
     * Cada llamada se divide en dos llamadas recursivas,
     * lo que lleva a una complejidad exponencial.
     */
    @Override
    public void recursiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {
        if (h > 0) {
            recursiuHanoi(h - 1, a, c, b);     // Mueve la torre de altura h-1 de 'a' a 'b'
            c.push(a.pop());                   // Mueve el disco superior de 'a' a 'c'
            recursiuHanoi(h - 1, b, a, c);     // Mueve la torre de altura h-1 de 'b' a 'c'
        }
    }

}

/**
 * En general, el proyecto esta bien elaborado y acapara todos los requisitos que se pedía, solo le ha faltado poner la especificación formal (pre y post condición) y en el algoritmo recursivo de hanoi le faltado poner el caso en el que solo hay un 1 disco, tambien le ha faltado poner en el javadoc analizando los diversos casos que puede haber y el proof.
 */