package exercici9;

import java.awt.Point;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public interface Peak {

    /**
     * Algoritmo de inicialización. Dado un array de enteros. Los valores están
     * ordenados de manera creciente sin repetición hasta un índice, y a partir
     * de este índice, están ordenados de manera decreciente sin repetición.
     * Encontrar el elemento pico y su índice. Un elemento es el pico si es
     * mayor que sus vecinos. El pico nunca estará en los extremos y solo hay un
     * pico. (Debe encontrar el valor máximo, y solo hay un máximo).
     *
     * @param a conjunto de enteros
     * @return Point donde x es el pico, y es el índice
     */
    public Point peak(int a[]);
}
