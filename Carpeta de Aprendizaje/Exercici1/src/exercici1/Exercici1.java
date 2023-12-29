package exercici1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase implementa un programa que genera un conjunto de números
 * aleatorios, lo ordena y luego realiza una búsqueda binaria para encontrar un
 * elemento específico.
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Exercici1 {

    /**
     * El método principal que inicia la ejecución del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        int N = 5;
        int[] conjunto = new int[N];
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Llenar el conjunto con N elementos aleatorios en el rango [0, N]
        for (int i = 0; i < N; i++) {
            conjunto[i] = rand.nextInt(N);
            System.out.println(conjunto[i]);
        }

        // Ordenar el conjunto
        Arrays.sort(conjunto);

        // Solicitar al usuario el elemento a buscar
        System.out.print("Introduce el elemento que deseas buscar: ");
        int elementoBuscado = scanner.nextInt();

        // Buscar el elemento y obtener su posición (si existe)
        int posicion = busquedaBinaria(conjunto, elementoBuscado);

        if (posicion >= 0) {
            System.out.println("El elemento " + elementoBuscado + " se encuentra en la posición " + posicion);
        } else {
            System.out.println(posicion);
            System.out.println("El elemento " + elementoBuscado + " no se encuentra en el conjunto.");
        }
    }

    /**
     * Realiza una búsqueda binaria en un array ordenado para encontrar la
     * posición de un elemento.
     *
     * @param array El array ordenado en el que realizar la búsqueda.
     * @param objetivo El elemento que se está buscando.
     * @return La posición del elemento si se encuentra, o -1 si no se
     * encuentra.
     */
    private static int busquedaBinaria(int[] array, int objetivo) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            // Calculamos posición media
            int medio = (inicio + fin) / 2;

            if (array[medio] == objetivo) {
                return medio; // Elemento encontrado, devolver posición
            } else if (array[medio] < objetivo) {
                inicio = medio + 1; // Descartar la mitad izquierda
            } else {
                fin = medio - 1; // Descartar la mitad derecha
            }
        }

        return -1; // Elemento no encontrado
    }
}
