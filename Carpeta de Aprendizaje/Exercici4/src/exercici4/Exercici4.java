package exercici4;

import cola.ColaConCursores;
import cola.ColaConPunteros;
import pila.PilaConCursores;
import pila.PilaConPunteros;

/**
 * Clase principal que demuestra el uso de algoritmos de ordenación, Pila y Cola
 * con implementaciones específicas (punteros y cursores).
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class Exercici4 {

    /**
     * Imprime los elementos de un array en una línea, separados por comas.
     *
     * @param array Array a imprimir.
     */
    public static void imprimirArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", "); // Agrega una coma y espacio después de cada elemento, excepto el último
            }
        }
        System.out.println(); // Imprime una nueva línea al final para separar la salida.
    }

    /**
     * Método principal que desmuestra el uso de algoritmos de ordenación, Pila
     * y Cola con implementaciones específicas.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Ordenación por Comparable
        Integer[] arrComparable = {5, 2, 9, 1, 7};
        System.out.println("Array sin ordenar: ");
        imprimirArray(arrComparable);

        exercici4.AlgoritmosDeOrdenación.ordenarPorComparable(arrComparable);
        System.out.println("Array ordenado por Comparable: ");
        imprimirArray(arrComparable);

        //Ordenación con Comparator
        String[] arrComparator = {"Zebra", "Apple", "Banana", "Orange"};
        System.out.println("\nArray sin ordenar: ");
        imprimirArray(arrComparator);

        exercici4.AlgoritmosDeOrdenación.ordenarPorComparator(arrComparator, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Array ordenado con Comparator: ");
        imprimirArray(arrComparator);

        //Pila con punteros
        TAD<Integer> pilaPunteros = new PilaConPunteros<>();
        pilaPunteros.push(5);
        pilaPunteros.push(2);
        pilaPunteros.push(9);
        pilaPunteros.push(1);
        pilaPunteros.push(7);

        System.out.println("\nPila con punteros: ");
        System.out.println("Top -> " + pilaPunteros.top());
        while (!pilaPunteros.estaVacia()) {
            System.out.println(pilaPunteros.pop());
        }
                
        //Pila con cursores
        TAD<String> pilaCursores = new PilaConCursores<>();
        pilaCursores.push("Zebra");
        pilaCursores.push("Apple");
        pilaCursores.push("Banana");
        pilaCursores.push("Orange");

        System.out.println("\nPila con cursores: ");
        System.out.println("Top -> " + pilaCursores.top());
        while (!pilaCursores.estaVacia()) {
            System.out.println(pilaCursores.pop());
        }
        
        //Cola con punteros
        TAD<Double> colaPunteros = new ColaConPunteros<>();
        colaPunteros.push(5.5);
        colaPunteros.push(2.2);
        colaPunteros.push(9.9);
        colaPunteros.push(1.1);
        colaPunteros.push(7.7);

        System.out.println("\nCola con punteros: ");
        System.out.println("Top -> " + colaPunteros.top());
        while (!colaPunteros.estaVacia()) {
            System.out.println(colaPunteros.pop());
        }
        
        //Cola con cursores
        TAD<Character> colaCursores = new ColaConCursores<>();
        colaCursores.push('Z');
        colaCursores.push('A');
        colaCursores.push('B');
        colaCursores.push('O');       
        
        System.out.println("\nCola con cursores: ");
        System.out.println("Top -> " + colaCursores.top());
        while (!colaCursores.estaVacia()) {
            System.out.println(colaCursores.pop());
        }
        
        
    }
}
