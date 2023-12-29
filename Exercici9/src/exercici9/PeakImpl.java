package exercici9;

import java.awt.Point;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class PeakImpl implements Peak {

    /**
     * Encuentra el pico en el array dado utilizando búsqueda binaria.
     *
     * <p>
     * <strong>Precondiciones:</strong> El array {@code a} no debe ser nulo, no
     * debe estar vacío y debe cumplir la propiedad para todo índice {@code i}
     * en el array {@code a}: {@code a[i] > a[i - 1] && a[i] > a[i + 1]}.</p>
     *
     * <p>
     * <strong>Postcondiciones:</strong> El resultado es un objeto {@code Point}
     * con el valor del pico en x y el índice del pico en y.</p>
     *
     * @param a Array de enteros ordenado de manera creciente hasta un índice, y
     * a partir de este índice, ordenado de manera decreciente.
     * @return Point donde x es el valor del pico y y es el índice del pico.
     * @throws IllegalArgumentException Si el array es nulo o vacío, o no cumple
     * con las condiciones requeridas.
     *
     * @complexity La complejidad del algoritmo es O(log n), donde n es la
     * longitud del array.
     */
    @Override
    public Point peak(int[] a) {
        if (a == null || a.length < 3) {
            throw new IllegalArgumentException("El array no debe estar vacío y debe tener al menos 3 elementos.");
        }

        int left = 1;
        int right = a.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return new Point(a[mid], mid);
            } else if (a[mid] < a[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        throw new IllegalArgumentException("El array no cumple con las condiciones requeridas");
    }

    /*
    El algoritmo es eficiente y tiene una complejidad logarítmica, lo que significa que su
    rendimiento no crece de manera significativa a medida que el tamaño del array aumenta.
     */
}
