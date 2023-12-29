package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implementación de la interfaz Motxilla utilizando enfoques de backtracking
 * tanto recursivo como iterativo para resolver el problema de la mochila.
 */
public class MotxillaImpl implements Motxilla {

    /**
     * Resuelve el problema de la mochila utilizando un enfoque recursivo de
     * backtracking con funciones de poda.
     *
     * Este método utiliza backtracking para explorar todas las combinaciones
     * posibles de elementos, incorporando funciones de poda para optimizar el
     * rendimiento. La complejidad temporal es exponencial, O(2^n), debido a la
     * exploración exhaustiva. La complejidad espacial es O(n), determinada por
     * la profundidad máxima de la recursión.
     *
     * Funciones de Poda: 
     * - Poda por Exceso de Peso: Evita la exploración de
     * ramas que exceden los límites de peso establecidos en W1 y W2.
     *
     * - Poda por Beneficio Máximo: No explora ramas cuyo beneficio potencial no
     * supera el mejor beneficio actual.
     *
     * @param a Elementos disponibles para la mochila.
     * @param W1 Peso máximo permitido en la dimensión 1.
     * @param W2 Peso máximo permitido en la dimensión 2.
     * @return Una lista de elementos que maximizan el beneficio.
     */
    @Override
    public ElementMotxilla[] recursiu(ElementMotxilla[] a, double W1, double W2) {
        List<ElementMotxilla> bestSolution = new ArrayList<>();
        List<ElementMotxilla> currentSolution = new ArrayList<>();
        double[] currentWeights = new double[]{0, 0};  // {W1, W2}
        double currentProfit = 0.0;
        int index = 0;

        backtracking(a, W1, W2, index, currentSolution, bestSolution, currentWeights, currentProfit);

        return bestSolution.toArray(new ElementMotxilla[0]);
    }

    /**
     * Resuelve el problema de la Mochila de manera recursiva utilizando
     * backtracking.
     *
     * @param elements Conjunto de elementos disponibles.
     * @param W1 Límite de peso 1.
     * @param W2 Límite de peso 2.
     * @param index Índice actual en el conjunto de elementos.
     * @param currentSolution Solución parcial actual.
     * @param bestSolution Mejor solución encontrada hasta ahora.
     * @param currentWeights Peso acumulado actual {W1, W2}.
     * @param currentProfit Beneficio acumulado actual.
     */
    private void backtracking(ElementMotxilla[] elements, double W1, double W2, int index,
            List<ElementMotxilla> currentSolution, List<ElementMotxilla> bestSolution,
            double[] currentWeights, double currentProfit) {

        if (index == elements.length) {
            // Podar si la solución actual es mejor que la mejor solución encontrada hasta ahora
            if (currentProfit > ElementMotxilla.profit(bestSolution.toArray(new ElementMotxilla[0]))) {
                bestSolution.clear();
                bestSolution.addAll(currentSolution);
            }
            return;
        }

        // Podar por exceso de peso y beneficio máximo
        if (currentWeights[0] + elements[index].getWeigth1() <= W1
                && currentWeights[1] + elements[index].getWeigth2() <= W2
                && currentProfit + ElementMotxilla.profit(Arrays.copyOfRange(elements, index, elements.length))
                > ElementMotxilla.profit(bestSolution.toArray(new ElementMotxilla[0]))) {

            // Incluir el elemento actual y continuar recursivamente
            currentSolution.add(elements[index]);
            currentWeights[0] += elements[index].getWeigth1();
            currentWeights[1] += elements[index].getWeigth2();
            currentProfit += elements[index].getProfit();

            backtracking(elements, W1, W2, index + 1, currentSolution, bestSolution, currentWeights, currentProfit);

            // Deshacer los cambios realizados en la solución actual
            currentSolution.remove(currentSolution.size() - 1);
            currentWeights[0] -= elements[index].getWeigth1();
            currentWeights[1] -= elements[index].getWeigth2();
            currentProfit -= elements[index].getProfit();
        }

        // Continuar recursivamente excluyendo el elemento actual
        backtracking(elements, W1, W2, index + 1, currentSolution, bestSolution, currentWeights, currentProfit);
    }

    /**
     * Resuelve el problema de la Mochila de manera iterativa utilizando
     * programación dinámica.
     *
     * @param a Conjunto de elementos disponibles.
     * @param W1 Límite de peso 1.
     * @param W2 Límite de peso 2.
     * @return Arreglo de elementos que maximiza el beneficio sin exceder los
     * límites de peso.
     */
    @Override
    public ElementMotxilla[] iteratiu(ElementMotxilla[] a, double W1, double W2) {
        int n = a.length;
        double[][][] dp = new double[n + 1][(int) (W1 + 1)][(int) (W2 + 1)];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W1; j++) {
                for (int k = 0; k <= W2; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                    } else if (a[i - 1].getWeigth1() <= j && a[i - 1].getWeigth2() <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                dp[i - 1][(int) (j - a[i - 1].getWeigth1())][(int) (k - a[i - 1].getWeigth2())] + a[i - 1].getProfit());
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        // Reconstruir la solución
        int i = n;
        int j = (int) W1;
        int k = (int) W2;
        List<ElementMotxilla> result = new ArrayList<>();

        while (i > 0 && (j > 0 || k > 0)) {
            if (dp[i][j][k] != dp[i - 1][j][k]) {
                result.add(a[i - 1]);
                j -= a[i - 1].getWeigth1();
                k -= a[i - 1].getWeigth2();
            }
            i--;
        }

        // Invertir la lista de resultados para obtener el orden correcto
        Collections.reverse(result);

        return result.toArray(new ElementMotxilla[0]);
    }

}
