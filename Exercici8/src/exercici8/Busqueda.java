package exercici8;

/**
 * Clase que proporciona métodos de búsqueda en arrays.
 */
public class Busqueda {

    private static int consultasLinealRecursiva, consultasLinealIterativa, 
                      consultasBinariaRecursiva, consultasBinariaIterativa;

    /**
     * Realiza una búsqueda lineal recursiva en un array.
     *
     * @param <E>     Tipo genérico de los elementos en el conjunto.
     * @param array Conjunto de elementos comparables.
     * @param valor   Valor a buscar.
     * @return Índice del elemento si se encuentra, -1 si no está en el conjunto.
     */
    public static <E> int busquedaLinealRecursiva(Comparable<E>[] array, E valor) {
        if (array == null) return -1;
        consultasLinealRecursiva = 0;
        return busquedaLinealRecursivaAux(array, valor, 0);
    }

    private static <E> int busquedaLinealRecursivaAux(Comparable<E>[] array, E valor, int indice) {
        consultasLinealRecursiva++;
        if (indice == array.length) return -1;
        if (array[indice].compareTo(valor) == 0) {
            return indice;
        }
        return busquedaLinealRecursivaAux(array, valor, indice + 1);
    }

    /**
     * Realiza una búsqueda lineal iterativa en un arreglo.
     *
     * @param <E>     Tipo genérico de los elementos en el conjunto.
     * @param array Conjunto de elementos comparables.
     * @param valor   Valor a buscar.
     * @return Índice del elemento si se encuentra, -1 si no está en el conjunto.
     */
    public static <E> int busquedaLinealIterativa(Comparable<E>[] array, E valor) {
        if (array == null) return -1;
        consultasLinealIterativa = 0;
        for (int indice = 0; indice < array.length; indice++) {
            consultasLinealIterativa++;
            if (array[indice].compareTo(valor) == 0) return indice;
        }
        return -1;
    }

    /**
     * Realiza una búsqueda binaria recursiva en un arreglo ordenado.
     *
     * @param <E>     Tipo genérico de los elementos en el conjunto.
     * @param array Conjunto de elementos comparables ordenados.
     * @param valor   Valor a buscar.
     * @return Índice del elemento si se encuentra, -1 si no está en el conjunto.
     */
    public static <E> int busquedaBinariaRecursiva(Comparable<E>[] array, E valor) {
        if (array == null)  return -1;
        consultasBinariaRecursiva = 0;
        return busquedaBinariaRecursivaAux(array, valor, 0, array.length - 1);
    }

    private static <E> int busquedaBinariaRecursivaAux(Comparable<E>[] array, E valor, int inicio, int fin) {
        consultasBinariaRecursiva++;
        if (inicio == fin) {
            return (array[inicio].compareTo(valor) == 0) ? inicio : -1;
        } else {
            int medio = (inicio + fin) / 2;
            if (array[medio].compareTo(valor) == 0) {
                return medio;
            }
            if (array[medio].compareTo(valor) < 0) {
                return busquedaBinariaRecursivaAux(array, valor, medio + 1, fin);
            }
            return busquedaBinariaRecursivaAux(array, valor, inicio, medio - 1);
        }
    }

    /**
     * Realiza una búsqueda binaria iterativa en un arreglo ordenado.
     *
     * @param <E>     Tipo genérico de los elementos en el conjunto.
     * @param array Conjunto de elementos comparables ordenados.
     * @param valor   Valor a buscar.
     * @return Índice del elemento si se encuentra, -1 si no está en el conjunto.
     */
    public static <E> int busquedaBinariaIterativa(Comparable<E>[] array, E valor) {
        if (array == null) return -1;
        consultasBinariaIterativa = 0;
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio <= fin) {
            consultasBinariaIterativa++;
            int medio = (inicio + fin) / 2;
            if (array[medio].compareTo(valor) == 0) {
                return medio;
            }
            if (array[medio].compareTo(valor) > 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return -1;
    }

    /**
     * Obtiene el número de consultas para la Búsqueda Lineal Recursiva.
     *
     * @return Número de consultas.
     */
    public static int getConsultasLinealRecursiva() {
        return consultasLinealRecursiva;
    }

    /**
     * Obtiene el número de consultas para la Búsqueda Lineal Iterativa.
     *
     * @return Número de consultas.
     */
    public static int getConsultasLinealIterativa() {
        return consultasLinealIterativa;
    }

    /**
     * Obtiene el número de consultas para la Búsqueda Binaria Recursiva.
     *
     * @return Número de consultas.
     */
    public static int getConsultasBinariaRecursiva() {
        return consultasBinariaRecursiva;
    }

    /**
     * Obtiene el número de consultas para la Búsqueda Binaria Iterativa.
     *
     * @return Número de consultas.
     */
    public static int getConsultasBinariaIterativa() {
        return consultasBinariaIterativa;
    }
}
