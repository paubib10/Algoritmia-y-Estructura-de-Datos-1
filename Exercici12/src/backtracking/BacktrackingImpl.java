    package backtracking;

import java.util.ArrayList;

/**
 * Classe implementació Backtracking
 *
 * @author Blanca Atienzar Martínez &amp; Pau Toni Bibiloni Martínez
 */
public class BacktrackingImpl implements Backtracking {

    /**
     * <p>
     * <b>Algoritmo para encontrara todos los subconjuntos que sumen M.</b>
     * </p>
     *  
     * @param a Array de enters.
     * @param M Valor objectiu de la suma.
     * @return Conjunt dels subconjunts que sumen M.
     * @pre Q: a != null ∧ (∀ i: 0 ≤ i ≤ |a|, a[i] ∈ Z) ∧ (M ∈ Z ∧ M ≥ 0)
     * @post R:{∀x,y: x,y∈a ^ x+y=M}
     * <br><br><br>
     * <p>
     * Este método comprueba de forma recursiva si en el conjunto a, existe
     * algun subconjunto el qual la suma de sus elementos sea igual al valor del
     * entero M.
     * </p>
     * <br>
     * <p>
     * El orden de complejidad de este algoritmo es O(2^n), donde 'n' es la longitud del array 'a'.
     * En términos de árboles binarios, esto se puede visualizar como un árbol binario de altura 'n'.
     * Cada nivel del árbol representa una llamada recursiva, y en cada nivel hay dos ramas,
     * correspondientes a las dos opciones de inclusión o exclusión de un elemento en el conjunto.
     * La cantidad total de nodos en el árbol es 2^n, lo que refleja la naturaleza exponencial del algoritmo.
     * Este enfoque puede volverse ineficiente para conjuntos de datos más grandes debido a la
     * profundidad del árbol y la cantidad de nodos que deben explorarse
     * </p>
     * <br>
     * <p>
     * <b>Casos posibles:</b>
     * <li>
     * - El conjunto contiene elementos que sumen M: En este caso, el metodo
     * devuelve un conjunto con los subconjuntos correspondientes, los cuales
     * contendran sus respectivos elementos.
     * </li>
     * <li>
     * - El conjunto no contiene elementos que sumen M: En este caso, el método
     * devolvera un conjunto vacio sin subconjuntos correspondientes.
     * </li>
     * </p>
     * <br>
     * <p>
     * <b>Proof</b>
     * <li>
     * La precondición asegura que existen todos los elementos y que no son
     * negativos, lo cual es necesario para la busqueda.
     * </li>
     * <li>
     * El método se detiene cuando ha recorrido todo el conjunto 'a' sin
     * encontrar discrepancias.
     * </li>
     * <li>
     * Las llamadas recursivas se realizan con el elemento a buscar, el cual es
     * el resultado de M menos otro elemento del conjunto.
     * </li>
     * <li>
     * La postcondición garantiza que el resultado es correcto.
     * </li>
     * </p>
     *
     */
    @Override
    public ArrayList<ArrayList<Integer>> sumM(int[] a, int M) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reversedResult = new ArrayList<>(); // Lista adicional

        backtrack(a, M, 0, new ArrayList<>(), result);

        // Revertir el orden de las soluciones antes de devolver el resultado
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }

    /**
     * Utiliza el algoritmo de backtracking para explorar todas las
     * combinaciones posibles que suman un valor específico en un array dado.
     *
     * @param a Array de enteros
     * @param target Valor objetivo a alcanzar con las combinaciones
     * @param start Índice de inicio en el array
     * @param current Conjunto actual en construcción
     * @param result Lista que almacena todas las combinaciones válidas
     */
    private void backtrack(int[] a, int target, int start, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            // Se encontró una combinación que suma M
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < a.length; i++) {
            // Prueba agregar el elemento actual al conjunto
            current.add(a[i]);
            // Llama recursivamente con el nuevo objetivo y la próxima posición de inicio
            backtrack(a, target - a[i], i + 1, current, result);
            // Retrocede para probar otras combinaciones
            current.remove(current.size() - 1);
        }
    }
}
