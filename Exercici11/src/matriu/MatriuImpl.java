package matriu;

/**
 *
 * @author Pau Tobi Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class MatriuImpl<E extends Comparable<E>> implements Matriu<E> {

    private E[] matrix;
    private int rows;
    private int cols;

    /**
     * Constructor para crear una matriz a partir de un array existente.
     *
     * @param matriz Array que representa la matriz.
     * @param rows Número de filas.
     * @param cols Número de columnas.
     * @throws IllegalArgumentException Si el tamaño del array no coincide con
     * las dimensiones de la matriz.
     */
    public MatriuImpl(E[] matriz, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = (E[]) new Comparable[rows * cols];

        if (matriz.length != rows * cols) {
            throw new IllegalArgumentException("El tamaño del array no coincide con las dimensiones de la matriz.");
        }

        for (int i = 0; i < matriz.length; i++) {
            this.matrix[i] = matriz[i];
        }
    }

    /**
     * Establece el valor en la posición dada.
     *
     * @param e Valor a establecer.
     * @param row Fila.
     * @param col Columna.
     */
    @Override
    public void set(E e, int row, int col) {
        int index = row * cols + col;
        matrix[index] = e;
    }

    /**
     * Obtiene el valor en la posición dada.
     *
     * @param row Fila.
     * @param col Columna.
     * @return Valor en la posición dada.
     */
    @Override
    public E get(int row, int col) {
        int index = row * cols + col;
        return matrix[index];
    }

    /**
     * <p>
     * <b>Comprueba si la matriz es simétrica de forma recursiva.</b>
     * </p>
     *
     * @return true si la matriz es simétrica, false en caso contrario.
     * @pre La matriz debe ser cuadrada.
     * @post El método devuelve true si la matriz es simétrica y false si no lo
     * es.
     * <br><br><br>
     * <p>
     * Este método comprueba de forma recursiva si la matriz es simétrica. La
     * matriz se considera simétrica si la comparación de cada elemento con su
     * correspondiente reflejado en la diagonal principal es igual.
     * </p>
     * <br>
     * <p>
     * <b>La complejidad temporal de esta operación es cuadrática O(n^2), donde
     *    "n" es el número de filas o columnas de la matriz cuadrada. Esto se puede
     *     visualizar como un árbol binario completo de altura "cols", donde cada
     *     nodo representa una llamada recursiva y cada rama representa una elección
     *     entre avanzar a la siguiente columna o la siguiente fila.
     * </p>
     * <br>
     * <p>
     * <b>Casos posibles:</b>
     * <li>
     * - La matriz es simétrica: En este caso, el método devuelve true.
     * </li>
     * <li>
     * - La matriz no es simétrica: En este caso, el método devuelve false.
     * </li>
     * </p>
     * <br>
     * <p>
     * <b>Proof</b>
     * <li>
     * La precondición asegura que la matriz es cuadrada, lo cual es necesario
     * para determinar simetría.
     * </li>
     * <li>
     * El método se detiene cuando ha recorrido todas las filas y columnas sin
     * encontrar discrepancias.
     * </li>
     * <li>
     * Las llamadas recursivas se realizan con submatrices más pequeñas,
     * reduciendo gradualmente el tamaño del problema.
     * </li>
     * <li>
     * La postcondición garantiza que el resultado es correcto.
     * </li>
     * </p>
     *
     */
    @Override
    public boolean isSymmetricalRecursiu() {
        return isSymmetricalRecursiu(0, 0);
    }

    private boolean isSymmetricalRecursiu(int row, int col) {
        if (row >= rows) {
            return true; // Hemos alcanzado el final de la matriz sin encontrar diferencias.
        }

        if (col >= cols || rows != cols) {
            return false; // La matriz no es simétrica si no es cuadrada o hemos superado el límite de filas/columnas.
        }

        int index1 = row * cols + col;
        int index2 = col * rows + row;

        if (matrix[index1].compareTo(matrix[index2]) != 0) {
            return false; // No es simétrica.
        }

        if (col == cols - 1) {
            return isSymmetricalRecursiu(row + 1, 0);
        } else {
            return isSymmetricalRecursiu(row, col + 1);
        }
    }

    /**
     * Complejidad:O(n), donde n es el número de filas a repetir.
     *
     * @return true si la matriz es simétrica, false en caso contrario.
     */
    @Override
    public boolean isSymmetricalIteratiu() {
        int row = 0, col = 0;
        for (int i = 0; i < rows; i++) {
            if (row >= rows) {
                return true;
            }

            if (col >= cols || rows != cols) {
                return false;
            }

            int index1 = row * cols + col;
            int index2 = col * rows + row;

            if (!matrix[index1].equals(matrix[index2])) {
                return false;
            }

            if (col == cols - 1) {
                row++;
                col = 0;
            } else {
                col++;
            }
        }
        return true;
    }

}
