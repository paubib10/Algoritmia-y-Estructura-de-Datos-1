package backtracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Implementación de la interfaz Backtracking para resolver el problema de coloreado de mapas.
 * Utiliza la técnica de backtracking para encontrar una asignación de colores válida para los nodos del mapa.
 * 
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class BacktrackingImpl implements Backtracking {

    /**
     * Intenta colorear el mapa dado con el número especificado de colores.
     *
     * @param map      Matriz de adyacencia que representa las conexiones entre nodos del mapa.
     * @param nColors  Número de colores disponibles para el coloreado.
     * @return         true si se encontró una solución, false si no es posible colorear el mapa.
     * 
     * @Especificacion formal:
     * - pre: {map != null && nColors > 0 && colors.length == map.length && ∀i (0 <= i < map.length => (∀j (0 <= j < map[i].length => (map[i][j] == 0 || map[i][j] == 1))))}
     * - post: (∀i (mapColor(map, nColors, colors, 0) == true) => (∀i (0 <= i < colors.length => colors[i])))
     *        && (∀i (mapColor(map, nColors, colors, 0) == false) => (¬∃i))
     * 
     * @Análisis de casos:
     * Caso 1: Matriz de adyacencia con conexiones simples y suficientes colores.
     * La función debería devolver true, indicando un coloreado exitoso.
     *
     * Caso 2: Matriz de adyacencia con conexiones complejas y número insuficiente de colores.
     * La función debería devolver false, ya que no hay suficientes colores para el coloreado.
     *
     * Caso 3: Mapa nulo.
     * La función debería devolver false, ya que el mapa es nulo y no se puede colorear.
     *
     * Caso 4: Mapa vacío.
     * La función debería devolver true, ya que no hay nodos para colorear en un mapa vacío.
     * 
     * @Proof:
     * Check 1: En cada caso con resultado true, la asignación de colores tiene una longitud igual al número de nodos en el mapa.
     * Check 2: En cada caso con resultado true, la asignación de colores respeta las restricciones de conexiones en el mapa.
     * Check 3: En cada caso con resultado false, no existe una asignación válida de colores para los nodos en el mapa.
     * 
     * El orden de complejidad en el peor caso es exponencial: O(2^n), donde 'n' es el número de nodos en el mapa. 
     * Esto se debe a que el algoritmo utiliza la técnica de backtracking para explorar todas las posibles asignaciones 
     * de colores en el mapa, generando un árbol de decisiones con una altura exponencial en relación con el número de nodos.
     */
    @Override
    public boolean mapColor(int[][] map, int nColors) {
        if (map == null) {
            return false; // Mapa nulo o vacío, no se puede colorear
        }

        int[] colors = new int[map.length];
        return mapColor(map, nColors, colors, 0);
    }

    /**
     * Función auxiliar recursiva para realizar el coloreado del mapa.
     *
     * @param map      Matriz de adyacencia que representa las conexiones entre nodos del mapa.
     * @param nColors  Número de colores disponibles para el coloreado.
     * @param colors   Arreglo que almacena los colores asignados a cada nodo.
     * @param i        Índice del nodo actual.
     * @return         true si se encontró una solución, false si no es posible colorear el mapa.
     */
    private boolean mapColor(int[][] map, int nColors, int[] colors, int i) {
        if (i == map.length) { 
            return true; // Todos los nodos coloreados con éxito
        }
        
        for (int color = 1; color <= nColors; color++) { 
            if (isSafe(map, colors, i, color)) {
                colors[i] = color;
                if (mapColor(map, nColors, colors, i + 1)) {
                    return true;
                }
                colors[i] = 0; // Retroceder si no se puede colorear con este color
            }
        }
        return false; // No se pudo encontrar una solución con los colores actuales
    }

    /**
     * Verifica si es seguro asignar un color a un nodo dado en función de los colores asignados a sus nodos adyacentes.
     *
     * @param map      Matriz de adyacencia que representa las conexiones entre nodos del mapa.
     * @param colors   Arreglo que almacena los colores asignados a cada nodo.
     * @param i        Índice del nodo actual.
     * @param color    Color a verificar para el nodo actual.
     * @return         true si es seguro asignar el color, false si no es seguro.
     */
    private boolean isSafe(int[][] map, int[] colors, int i, int color) {
        for (int j = 0; j < map[i].length; j++) {
            int neighbor = map[i][j];
            if (colors[neighbor] == color) {
                return false; // Verificar conflictos de color con nodos adyacentes
            }
        }
        return true; // Es seguro asignar el color al nodo actual
    } 
    
    public boolean mapColorIterative(int[][] map, int nColors) {
        if (map == null) {
            return false; // Mapa nulo o vacío, no se puede colorear
        }

        int[] colors = new int[map.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int i = stack.peek();

            if (i == map.length) {
                return true; // Todos los nodos coloreados con éxito
            }

            boolean foundColor = false;
            for (int color = colors[i] + 1; color <= nColors; color++) {
                if (isSafe(map, colors, i, color)) {
                    colors[i] = color;
                    stack.push(i + 1);
                    foundColor = true;
                    break;
                }
            }

            if (!foundColor) {
            colors[i] = 0; // Retroceder si no se puede colorear con este color
            stack.pop();
            }
        }

        return false; // No se pudo encontrar una solución con los colores actuales
    }
    
}
