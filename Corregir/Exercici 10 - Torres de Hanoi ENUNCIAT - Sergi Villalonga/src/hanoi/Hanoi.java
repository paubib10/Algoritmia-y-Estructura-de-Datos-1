package hanoi;

import java.util.Stack;

/**
 * Interface que define el problema de las Torres de Hanoi.
 * @param <E> Tipo de elementos en las torres.
 * @author Juan Francisco Riera
 * @author Sergi Villalonga
 */
public interface Hanoi<E extends Comparable<E>> {

    /**
     * Mètode recursiu que resol Hanoi.
     * @param h Altura de las torres.
     * @param a Torre A.
     * @param b Torre B.
     * @param c Torre C.
     */
    void recursiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c);
}
