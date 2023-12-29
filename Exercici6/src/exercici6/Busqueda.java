package exercici6;

import java.util.Comparator;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Busqueda {

    /**
     * Realiza una búsqueda binaria en un array ordenado para encontrar la
     * posición de un elemento, utilizando la interfaz Comparable.
     *
     * @param <T> El tipo de elemento a buscar, debe implementar Comparable.
     * @param array El array ordenado en el que realizar la búsqueda.
     * @param objetivo El elemento que se está buscando.
     * @return La posición del elemento si se encuentra, o -1 si no se
     * encuentra.
     */
    public static <T extends Comparable<T>> int busquedaBinariaComparable(T[] array, T objetivo) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            // Calculamos posición media
            int medio = inicio + (fin - inicio) / 2;

            int comparacion = array[medio].compareTo(objetivo);

            if (comparacion == 0) {
                return medio; // Elemento encontrado, devolver posición
            } else if (comparacion < 0) {
                inicio = medio + 1; // Descartar la mitad izquierda
            } else {
                fin = medio - 1; // Descartar la mitad derecha
            }
        }

        return -1; // Elemento no encontrado
    }

    /**
     * Realiza una búsqueda binaria en un array ordenado para encontrar la
     * posición de un elemento, utilizando un comparador personalizado.
     *
     * @param <T> El tipo de elemento a buscar.
     * @param array El array ordenado en el que realizar la búsqueda.
     * @param objetivo El elemento que se está buscando.
     * @param comparator El comparador personalizado.
     * @return La posición del elemento si se encuentra, o -1 si no se
     * encuentra.
     */
    public static <T> int busquedaBinariaConComparator(T[] array, T elemento, Comparator<T> comparator) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            // Calculamos posición media
            int medio = inicio + (fin - inicio) / 2;

            int comparacion = comparator.compare(array[medio], elemento);
            
//            System.out.println("Inicio: " + inicio + ", Fin: " + fin + ", Medio: " + medio + ", Comparación: " + comparacion);
            
            if (comparacion == 0) {
                return medio; // Elemento encontrado, devolver posición
            } else if (comparacion < 0) {
                inicio = medio + 1; // Descartar la mitad izquierda
            } else {
                fin = medio - 1; // Descartar la mitad derecha
            }
        }

        return -1; // Elemento no encontrado
    }

}
