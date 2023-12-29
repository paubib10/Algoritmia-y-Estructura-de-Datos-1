package exercici6;

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
public class Main {

    /**
     * El método principal que inicia la ejecución del programa.
     *
     */
    public static void main(String[] args) {
        int N = 1000;
        Integer[] conjunto = new Integer[N];
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        // Llenar el conjunto con N elementos aleatorios en el rango [0, N]
        for (int i = 0; i < N; i++) {
            conjunto[i] = rand.nextInt(N);
//            System.out.println(conjunto[i]);
        }

        // Ordenar el conjunto
        Arrays.sort(conjunto);

        // Solicitar al usuario el elemento a buscar
        System.out.print("Introduce el elemento que deseas buscar: ");
        int elementoBuscado = scanner.nextInt();

        // Buscar el elemento y obtener su posición (si existe)
        int posicion = Busqueda.busquedaBinariaComparable(conjunto, elementoBuscado);

        if (posicion >= 0) {
            System.out.println("El elemento " + elementoBuscado + " se encuentra en la posición " + posicion);
        } else {
            System.out.println(posicion);
            System.out.println("El elemento " + elementoBuscado + " no se encuentra en el conjunto.");
        }
    }
}
