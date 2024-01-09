package backtrackingUFC;

import backtracking.ElementMotxilla;
import backtracking.Motxilla;
import backtracking.MotxillaImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase UFCDataLoader.
 * 
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class UFCDataLoaderTest {

    private ElementMotxilla[] elementosUFC;

    @Before
    public void setUp() {
        // Cargar datos de UFC utilizando UFCDataLoader
        UFCDataLoader ufcDataLoader = new UFCDataLoader("ufc-fighters-statistics.txt");
        elementosUFC = ufcDataLoader.loadUFCData();
    }

    @Test
    public void testRecursiu() {
        Motxilla motxilla = new MotxillaImpl();

        // Aplicar métodos de optimización
        double W1 = 500.0;
        double W2 = 900.0;

        ElementMotxilla[] resultadoRecursivo = motxilla.recursiu(elementosUFC, W1, W2);

        // Verificar que el resultado no sea nulo
        assertTrue(resultadoRecursivo != null);

        // Verificar la validez de los resultados
        double totalWeight1 = ElementMotxilla.w1(resultadoRecursivo);
        double totalWeight2 = ElementMotxilla.w2(resultadoRecursivo);
        double totalProfit = ElementMotxilla.profit(resultadoRecursivo);

        // Asegurarse de que la suma de pesos no supere los límites
        assertTrue(totalWeight1 <= W1);
        assertTrue(totalWeight2 <= W2);

        // Asegurarse de que el beneficio total sea correcto
        assertEquals(ElementMotxilla.profit(resultadoRecursivo), totalProfit, 0.01);
    }

    @Test
    public void testIteratiu() {
        Motxilla motxilla = new MotxillaImpl();

        // Aplicar métodos de optimización
        double W1 = 500.0;
        double W2 = 900.0;

        ElementMotxilla[] resultadoIterativo = motxilla.iteratiu(elementosUFC, W1, W2);

        // Verificar que el resultado no sea nulo
        assertTrue(resultadoIterativo != null);

        // Verificar la validez de los resultados
        double totalWeight1 = ElementMotxilla.w1(resultadoIterativo);
        double totalWeight2 = ElementMotxilla.w2(resultadoIterativo);
        double totalProfit = ElementMotxilla.profit(resultadoIterativo);

        // Asegurarse de que la suma de pesos no supere los límites
        assertTrue(totalWeight1 <= W1);
        assertTrue(totalWeight2 <= W2);

        // Asegurarse de que el beneficio total sea correcto
        assertEquals(ElementMotxilla.profit(resultadoIterativo), totalProfit, 0.01);
    }

}
