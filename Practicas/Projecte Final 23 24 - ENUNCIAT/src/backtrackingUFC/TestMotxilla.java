package backtrackingUFC;

import backtracking.ElementMotxilla;
import backtracking.Motxilla;
import backtracking.MotxillaImpl;

/**
 * Pruebas unitarias para la clase UFCDataLoader.
 * 
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class TestMotxilla {

    public static void main(String[] args) {
        // Cargar datos de UFC utilizando UFCDataLoader
        UFCDataLoader ufcDataLoader = new UFCDataLoader("ufc-fighters-statistics.txt");
        
        ElementMotxilla[] elementosUFC = ufcDataLoader.loadUFCData();

        // Instanciar la clase MotxillaImplUFC
        Motxilla motxilla = new MotxillaImpl();

        // Aplicar métodos de optimización
        double W1 = 500.0;
        double W2 = 900.0;

        ElementMotxilla[] resultadoRecursivo = motxilla.recursiu(elementosUFC, W1, W2);
        ElementMotxilla[] resultadoIterativo = motxilla.iteratiu(elementosUFC, W1, W2);

        // Imprimir resultados
        imprimirResultado("Recursivo", resultadoRecursivo);
        imprimirResultado("Iterativo", resultadoIterativo);

    }
    
    private static void imprimirResultado(String metodo, ElementMotxilla[] resultado) {
        System.out.println("Resultado " + metodo + ":");
        for (ElementMotxilla elemento : resultado) {
            System.out.println("Name: " + elemento.getElement() + ", Weight: " + elemento.getWeigth1()
                    + ", Height: " + elemento.getWeigth2() + ", Wins: " + elemento.getProfit());
        }
        System.out.println("\nTotal Profit: " + ElementMotxilla.profit(resultado));
        System.out.println("Total Weight 1: " + ElementMotxilla.w1(resultado));
        System.out.println("Total Weight 2: " + ElementMotxilla.w2(resultado));
        System.out.println();
    }

}
