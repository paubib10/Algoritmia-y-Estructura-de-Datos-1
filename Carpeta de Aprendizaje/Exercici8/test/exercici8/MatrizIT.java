package exercici8;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class MatrizIT {

    @Test
    public void testMultiplicarMatrices() {
        // Datos para la primera matriz
        int[][] datosMatriz1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Datos para la segunda matriz
        int[][] datosMatriz2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        // Resultado esperado de la multiplicación
        int[][] resultadoEsperado = {
            {58, 64},
            {139, 154}
        };

        // Crear instancias de Matriz
        Matriz matriz1 = new Matriz(2, 3, datosMatriz1);
        Matriz matriz2 = new Matriz(3, 2, datosMatriz2);

        // Realizar la multiplicación
        Matriz resultado = matriz1.multiplicar(matriz2);

        // Verificar que el resultado sea el esperado
        assertArrayEquals(resultadoEsperado, resultado.getDatos());
    }

    @Test
    public void testMatricesIncompatibles() {
        // Datos para la primera matriz
        int[][] datosMatriz1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Datos para la segunda matriz
        int[][] datosMatriz2 = {
            {7, 8},
            {9, 10}
        };

        // Crear instancias de Matriz
        Matriz matriz1 = new Matriz(2, 3, datosMatriz1);
        Matriz matriz2 = new Matriz(2, 2, datosMatriz2);

        try {
            // Intentar multiplicar matrices incompatibles
            matriz1.multiplicar(matriz2);
            
        } catch (IllegalArgumentException e) {
            // La excepción es esperada, la prueba es exitosa
            assertEquals("Las matrices no son compatibles para la multiplicación", e.getMessage());
        }
    }

}
