package exercici4;

import java.util.Comparator;

/**
 * Clase que contiene implementaciones de algoritmos de ordenación.
 * 
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class AlgoritmosDeOrdenación {

    /**
     * Ordena un array de elementos comparables utilizando el algoritmo de
     * selección directa
     *
     * @param <T>   El tipo de elementos en el array, que debe implementar la interfaz Comparable
     * @param array El array de elementos comparables a ordenar
     */
    public static <T extends Comparable<T>> void ordenarPorComparable(T[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[indiceMinimo]) < 0) { // (array[j] < array[indiceMinimo]) < 0
                    indiceMinimo = j;
                }
            }
            T aux = array[indiceMinimo];
            array[indiceMinimo] = array[i];
            array[i] = aux;
        }

    }

    /**
     * Ordena un array de elementos utilizando el algoritmo de selección directa
     * y un comparador dado.
     * 
     * @param <T>        El tipo de elemenots en el array
     * @param array      El array de elementos a ordenar
     * @param comparador El comparador que define el orden
     */
    public static <T> void ordenarPorComparator(T[] array, Comparator<T> comparador) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            //Encontrar el indice del elemento minimo en el array
            for (int j = i; j < n; j++) {
                if (comparador.compare(array[j], array[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }

            //Intercambiar el elemento minimo con el elemento en la posicion actual (i)
            if (indiceMinimo != i) {
                T aux = array[i];
                array[i] = array[indiceMinimo];
                array[indiceMinimo] = aux;
            }
        }
    }
}
