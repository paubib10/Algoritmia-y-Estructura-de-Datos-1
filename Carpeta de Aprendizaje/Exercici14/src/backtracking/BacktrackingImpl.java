package backtracking;

/**
 * Implementación de la técnica de backtracking para resolver el problema de la
 * mochila. Utiliza un enfoque recursivo para explorar todas las posibles
 * combinaciones de elementos.
 * 
 * @author Pau Toni Bibiloni Martinez
 */
public class BacktrackingImpl implements Backtracking {

    // Arreglo para almacenar la mejor solución encontrada
    private int[] bestSolution;

    // Variable para realizar un seguimiento del beneficio máximo
    private int maxProfit;

    /**
     * Encuentra la mejor combinación de elementos que maximiza el beneficio en
     * la mochila.
     *
     * @param W Capacidad total de la mochila.
     * @param w Array de pesos de los elementos.
     * @param p Array de beneficios de los elementos.
     * @return Array binario que indica qué elementos se incluyen en la
     * solución óptima.
     * 
     * @Especificacion formal:
     *  - pre: {(W > 0) âˆ§ () âˆ§ (w.length == p.length)
     *           (âˆ€i: 0 â‰¤ i &lt; w.length: (w[i] > 0) âˆ§ (p[i] > 0)}
     * 
     *  - post: {(âˆ€i: 0 â‰¤ i &lt; solucion.length: 
     *            (0 &lt;= solucion[i] &lt;= 1)) âˆ§ (maxp &lt;= W)}
     *
     * @analysis 
     * - Caso 1: W = 0, w y p son arrays vacíos. Debería devolver un
     *   array vacío ya que la mochila no tiene capacidad. 
     * - Caso 2: w y p son arrays no vacíos, pero W = 0. Debería devolver un 
     *   array vacío ya que la mochila no tiene capacidad. 
     * - Caso 3: Todos los elementos tienen un peso mayor que la capacidad de 
     *   la mochila (W). Debería devolver un array vacío. 
     * - Caso 4: Todos los elementos tienen un beneficio igual.
     *   Debería devolver un array que incluya o excluya elementos según la
     *   capacidad de la mochila.
     *
     * @proof 
     * - Check 1: La solución final tiene una longitud igual a la
     *   cantidad de elementos. 
     * - Check 2: La capacidad total de la mochila no se
     *   excede en la solución final. 
     * - Check 3: El beneficio de la solución final
     *   es el máximo posible.
     *
     * La complejidad de tiempo en el peor caso es exponencial: O(2^n), donde
     * "n" es el número de elementos. Esto se relaciona con un árbol binario de
     * decisiones, donde cada nivel representa la elección de incluir o excluir
     * un elemento. El número total de nodos en el árbol es 2^n, coincidiendo
     * con la complejidad de tiempo del algoritmo.
     */
    @Override
    public int[] knapSack(int W, int[] w, int[] p) {
        // Inicializar variables de la mejor solución y beneficio máximo
        bestSolution = new int[w.length];
        maxProfit = Integer.MIN_VALUE;

        // Llamar a la función recursiva para encontrar la mejor solución
        knapSackUtil(W, w, p, 0, new int[w.length], 0, 0);

        // Devolver la mejor solución encontrada
        return bestSolution;
    }

    private void knapSackUtil(int W, int[] w, int[] p, int currentWeight, int[] currentSolution, int currentIndex, int currentProfit) {
        // Caso base: se alcanzó el final de los elementos
        if (currentIndex == w.length) {
            // Verificar si la solución actual es mejor y cumple con la capacidad de la mochila
            if (currentProfit > maxProfit && currentWeight <= W) {
                // Se encontró una solución mejor
                maxProfit = currentProfit;
                System.arraycopy(currentSolution, 0, bestSolution, 0, currentSolution.length);
            }
            return;
        }

        // Incluir el elemento actual y recursión
        if (currentWeight + w[currentIndex] <= W) {
            currentSolution[currentIndex] = 1;
            knapSackUtil(W, w, p, currentWeight + w[currentIndex], currentSolution, currentIndex + 1, currentProfit + p[currentIndex]);
        }

        // Excluir el elemento actual y recursión
        currentSolution[currentIndex] = 0;
        knapSackUtil(W, w, p, currentWeight, currentSolution, currentIndex + 1, currentProfit);
    }

    public int[] knapSackIterative(int W, int[] w, int[] p) {
        int n = w.length;

        // Inicializar matriz para almacenar resultados parciales
        int[][] dp = new int[n + 1][W + 1];

        // Llenar la matriz con los resultados parciales
        for (int i = 1; i <= n; i++) {
            for (int weight = 1; weight <= W; weight++) {
                if (w[i - 1] <= weight) {
                    dp[i][weight] = Math.max(p[i - 1] + dp[i - 1][weight - w[i - 1]], dp[i - 1][weight]);
                } else {
                    dp[i][weight] = dp[i - 1][weight];
                }
            }
        }

        // Reconstruir la solución a partir de la matriz
        int[] result = new int[n];
        int i = n, weight = W;
        while (i > 0 && weight > 0) {
            if (dp[i][weight] != dp[i - 1][weight]) {
                result[i - 1] = 1;
                weight -= w[i - 1];
            }
            i--;
        }

        return result;
    }

}
