package peak;

import java.awt.Point;

/**
 *
 * @author antoni
 */
public interface Peak {
    
    /**
      * Algoritmo de inicialización.
      * Dado un array de enteros.
      * Los valores van con orden creciente sin repetición hasta un índice, y en
      * partir de este índice van con orden decreciente sin repetición.
      * Encontrar el elemento cima y su índice. Un elemento es la cima, si es más
      * grande que sus vecindarios. La cima nunca estará en los extremos y sólo
      * hay una cima. (Debe encontrar el valor máximo, y sólo hay un máximo).
      * @param a conjunto de enteros
      * @return Point x es el peak, y es el índice
    */
    public Point peak(int a[]);
}
