package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implementación de la interfaz Motxilla utilizando enfoques de backtracking
 * tanto recursivo como iterativo para resolver el problema de la mochila.
 * @author @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class MotxillaImpl implements Motxilla {
        
    /**
     * Resuelve el problema de la mochila utilizando un enfoque recursivo de
     * backtracking con funciones de poda.
     *
     * <p>Este método utiliza backtracking para explorar todas las combinaciones
     * posibles de elementos, incorporando funciones de poda para optimizar el
     * rendimiento.</p>
     * 
     * <p><b>Especificación formal:</b>
     * <blockquote>pre: {(a!=null) ∧ (W1≥0) ∧ (W2≥0)}</blockquote>
     * <blockquote>post: devuelve la selección más óptima como un conjunto, maximizando 
     * el beneficio dentro de los límites dados por W1 y W2, en que la solución 
     * devuelta cumple con la suma de los pesos 1 y 2 de los elementos incluidos
     * no supera los límites W1 y W2. Además, la solución devuelta es máximo 
     * entre todas las combinaciones posibles de elementos que cumplen con las 
     * restricciones de peso.</blockquote></p>
     * 
     * <p><b>Analisis de casos:</b>
     *
     * <blockquote>Caso 1: En el conjunto ('a') no hay elementos, en este caso se 
     * devuelve un arreglo vacio, , ya que no se puede incluir ningún elemento 
     * en la mochila.</blockquote>
     *
     * <blockquote>Caso 2: Conjunto de elementos no vacío y límites de peso dados, el 
     * algoritmo debe explorar recursivamente todas las combinaciones posibles 
     * de elementos para encontrar la que maximice el beneficio dentro de los 
     * límites de peso especificados. </blockquote>
     * 
     * <blockquote>Caso 3: Los límites de peso (W1 y W2) son ambos cero, ado que no se 
     * permite peso en la mochila (límites cero), la única solución posible es 
     * un arreglo vacío.</blockquote>
     * 
     * <blockquote>Caso 4: Varios elementos tienen el mismo beneficio, debe ser capaz 
     * de manejar la igualdad de beneficios entre elementos y elegir una 
     * combinación que maximice el beneficio total.</blockquote></p>
     * 
     * <p><b>Orden de complejidad:</b>
     * <blockquote>El orden de complejidad de este algoritmo es exponencial, O(2^n), 
     * donde n es el número de elementos en el conjunto. Por que en cada llamada 
     * recursiva, el algoritmo considera dos opciones: incluirlo o no incluirlo 
     * el elemento en la solución. Por lo que hace un árbol de recursión binario
     * con una altura igual al número de elementos en el conjunto.</blockquote></p>
     *
     * <p><b>Funciones de Poda:</b>
     *      <blockquote>- Poda por Exceso de Peso: Evita la exploración de ramas que 
     *      exceden los límites de peso establecidos en W1 y W2.</blockquote>
     *
     *      <blockquote>- Poda por Beneficio Máximo: No explora ramas cuyo beneficio 
     *      potencial no supera el mejor beneficio actual.</blockquote></p>
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
     * Resuelve el problema de la mochila utilizando un enfoque recursivo de
     * backtracking con funciones de poda.
     *
     * <p>Este método utiliza backtracking para explorar todas las combinaciones
     * posibles de elementos, incorporando funciones de poda para optimizar el
     * rendimiento.</p>
     * 
     * <p><b>Especificación formal:</b>
     * <blockquote>pre: {(a!=null) ∧ (W1≥0) ∧ (W2≥0)}</blockquote>
     * <blockquote>post: devuelve la selección más óptima como un conjunto, maximizando 
     * el beneficio dentro de los límites dados por W1 y W2, en que la solución 
     * devuelta cumple con la suma de los pesos 1 y 2 de los elementos incluidos
     * no supera los límites W1 y W2. Además, la solución devuelta es máximo 
     * entre todas las combinaciones posibles de elementos que cumplen con las 
     * restricciones de peso.</blockquote></p>
     * 
     * <p><b>Analisis de casos:</b>
     * 
     * <blockquote>Caso 1: En el el conjunto ('a') no hay elementos, en este caso se 
     * devuelve un arreglo vacio, , ya que no se puede incluir ningún elemento 
     * en la mochila.</blockquote>
     * 
     * <blockquote>Caso 2:  Conjunto de elementos no vacío y límites de peso dados, el 
     * algoritmo debe explorar recursivamente todas las combinaciones posibles 
     * de elementos para encontrar la que maximice el beneficio dentro de los 
     * límites de peso especificados. </blockquote>
     * 
     * <blockquote>Caso 3: Los límites de peso (W1 y W2) son ambos cero, ado que no se 
     * permite peso en la mochila (límites cero), la única solución posible es 
     * un arreglo vacío.</blockquote>
     * 
     * <blockquote>Caso 4: Varios elementos tienen el mismo beneficio, debe ser capaz 
     * de manejar la igualdad de beneficios entre elementos y elegir una 
     * combinación que maximice el beneficio total.</blockquote></p>
     * 
     * <p><b>Orden de complejidad:</b>
     * <blockquote>El orden de complejidad de este algoritmo es lineal, O(2^n*n), donde 
     * n es la longitud del array de elementos a. El bucle externo ejecuta 2^n 
     * veces, ya que hay 2^n combinaciones posibles (cada elemento puede estar 
     * presente o ausente en una combinación). Dentro de este bucle, hay un 
     * bucle interno que recorre los n elementos para construir cada 
     * combinación. </blockquote></p>
     *
     * <p><b>Funciones de Poda:</b>
     *      <blockquote>- Poda por Exceso de Peso: Evita la exploración de ramas que 
     *      exceden los límites de peso establecidos en W1 y W2.</blockquote>
     *
     *      <blockquote>- Poda por Beneficio Máximo: No explora ramas cuyo beneficio 
     *      potencial no supera el mejor beneficio actual.</blockquote></p>
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
        double maxProfit = 0.0;
        List<ElementMotxilla> maxCombination = new ArrayList<>();

        // Enumerar todas las combinaciones posibles de elementos
        for (int mask = 0; mask < (1 << n); mask++) {
            List<ElementMotxilla> currentCombination = new ArrayList<>();
            double currentWeight1 = 0.0;
            double currentWeight2 = 0.0;
            double currentProfit = 0.0;

            // Verificar cada bit para decidir si incluir el elemento
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentCombination.add(a[i]);
                    currentWeight1 += a[i].getWeigth1();
                    currentWeight2 += a[i].getWeigth2();
                    currentProfit += a[i].getProfit();
                }
            }

            // Verificar si la combinación es válida y mejora el beneficio máximo
            if (currentWeight1 <= W1 && currentWeight2 <= W2 && currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxCombination = new ArrayList<>(currentCombination);
            }
        }

        return maxCombination.toArray(new ElementMotxilla[0]);
    }

}
