package exercici8;

/**
 * Clase que representa una matriz y realiza la multiplicación de matrices.
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class Matriz {

    private int[][] matriz;
    private int filas;
    private int columnas;

    /**
     * Constructor que inicializa la matriz con los datos proporcionados.
     * 
     * @param filas     Número de filas de la matriz.
     * @param columnas  Número de columnas de la matriz.
     * @param datos     Datos para inicializar la matriz.
     * @throws IllegalArgumentException Si los datos no coinciden con el tamaño de la matriz.
     */
    public Matriz(int filas, int columnas, int[][] datos) {
        if (datos == null || datos.length != filas || datos[0].length != columnas) {
            throw new IllegalArgumentException("Datos incorrectos para inicializar la matriz");
        }
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = datos;
    }

    /**
     * Obtiene los datos de la matriz.
     * 
     * Pre: La matriz debe estar inicializada.
     * Post: Se devuelve una copia de los datos de la matriz.
     * 
     * @return Los datos de la matriz.
     * @complexity O(filas * columnas)
     */
    public int[][] getDatos() {
        int[][] datosCopia = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            System.arraycopy(matriz[i], 0, datosCopia[i], 0, columnas);
        }
        return datosCopia;
    }

    /**
     * Realiza la multiplicación de dos matrices.
     * 
     * Pre: Ambas matrices deben estar inicializadas. El número de columnas de la
     *      primera matriz debe ser igual al número de filas de la segunda matriz.
     * Post: La matriz resultante tiene un tamaño de filas igual al número de filas
     *       de la primera matriz y columnas igual al número de columnas de la
     *       segunda matriz. Los elementos de la matriz resultante son el resultado
     *       de la multiplicación de las matrices originales. Devuelve una nueva
     *       instancia de Matriz con los datos del resultado.
     * 
     * @param otraMatriz Matriz a multiplicar.
     * @return Matriz resultante de la multiplicación.
     * @throws IllegalArgumentException Si las matrices no son compatibles para la multiplicación.
     * @complexity O(filas * columnas * columnasOtraMatriz)
     */
    public Matriz multiplicar(Matriz otraMatriz) {
        if (this.columnas != otraMatriz.filas) {
            throw new IllegalArgumentException("Las matrices no son compatibles para la multiplicación");
        }

        int[][] resultado = new int[this.filas][otraMatriz.columnas];
        int numMultiplicaciones = 0;

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < otraMatriz.columnas; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < this.columnas; k++) {
                    resultado[i][j] += this.matriz[i][k] * otraMatriz.matriz[k][j];
                    numMultiplicaciones++;
                }
            }
        }

        System.out.println("Número de multiplicaciones: " + numMultiplicaciones);
        return new Matriz(this.filas, otraMatriz.columnas, resultado);
    }
}
