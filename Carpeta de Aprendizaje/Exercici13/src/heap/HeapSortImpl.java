package heap;

/**
 * Implementación del algoritmo de ordenación Heap Sort utilizando un montículo.
 * Este algoritmo ordena un array de elementos comparables en orden ascendente.
 *
 * @param <E> El tipo de elementos en el array, debe ser comparable.
 */
public class HeapSortImpl<E extends Comparable<E>> implements HeapSort<E> {

    /**
     * Ordena un array de elementos comparables utilizando el algoritmo de Heap
     * Sort.
     *
     * @param h Array de elementos comparables que se va a ordenar.
     *
     * El orden de complejidad de tiempo (CPU) en el peor caso es O(n
     * log n), donde 'n' es la longitud del array. Heap Sort es eficiente para
     * grandes conjuntos de datos y tiene un rendimiento estable en términos de
     * tiempo de ejecución en el peor caso.
     *
     * El orden de complejidad de memoria es O(1), ya que Heap Sort es un
     * algoritmo in-place y no requiere memoria adicional más allá del array de
     * entrada.
     */
    @Override
    public void heapSort(E[] h) {
        int n = h.length;

        // Construir el montículo (heap)
        for (int i = n; i >= 0; i--) {
            heapify(h, n, i);
        }

        // Extraer elementos del montículo uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz (elemento más grande) al final
            E temp = h[0];
            h[0] = h[i];
            h[i] = temp;

            // Llamar a heapify en el montículo reducido
            heapify(h, i, 0);
        }
    }

    /**
     * Realiza la operación de heapify en un subárbol dado en un array de
     * elementos comparables.
     *
     * @param h Array de elementos comparables que representa el subárbol.
     * @param n Longitud del subárbol.
     * @param i Índice de la raíz del subárbol.
     *
     * La operación de heapify se utiliza para mantener la propiedad
     * de heap durante la construcción y extracción de elementos en Heap Sort.
     */
    private void heapify(E[] h, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Verificar si el hijo izquierdo es más grande que la raíz
        if (left < n && h[left].compareTo(h[largest]) > 0) {
            largest = left;
        }

        // Verificar si el hijo derecho es más grande que la raíz o el hijo izquierdo
        if (right < n && h[right].compareTo(h[largest]) > 0) {
            largest = right;
        }

        // Si el mayor no es la raíz, intercambiar y volver a llamar a heapify
        if (largest != i) {
            E intercambio = h[i];
            h[i] = h[largest];
            h[largest] = intercambio;

            // Llamar recursivamente a heapify en el subárbol afectado
            heapify(h, n, largest);
        }
    }
}
