package exercici3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Exercici3 {

    public static void main(String[] args) {
        Collection<Figura> figuras = GenerarFiguras.generarFigurasAleatorias();
        List<Double> sumaAreas = new CalcularResultados().calcularSumaAreas(figuras);
        List<Double> sumaPerimetros = new CalcularResultados().calcularSumaPerimetros(figuras);
        CalcularResultados cr = new CalcularResultados();

        System.out.println("SUMA DE ÁREAS Y PERÍMETROS DE TODAS LAS FIGURAS");
        System.out.printf("%-18s: %.2f\n", "Suma de áreas", (sumaAreas.get(0) + sumaAreas.get(1) + sumaAreas.get(2) + sumaAreas.get(3)));
        System.out.printf("%-18s: %.2f\n", "Suma de perímetros", (sumaPerimetros.get(0) + sumaPerimetros.get(1) + sumaPerimetros.get(2) + sumaPerimetros.get(3)));

        System.out.println("\n\nSUMA DE ÁREAS Y PERÍMETROS DE CADA TIPO DE FIGURA");
        System.out.printf("%-20s: %.2f\n", "Área Círculo", sumaAreas.get(0));
        System.out.printf("%-20s: %.2f\n", "Perímetro Círculo", sumaPerimetros.get(0));
        System.out.printf("%-20s: %.2f\n", "Área Cuadrado", sumaAreas.get(1));
        System.out.printf("%-20s: %.2f\n", "Perímetro Cuadrado", sumaPerimetros.get(1));
        System.out.printf("%-20s: %.2f\n", "Área Triángulo", sumaAreas.get(2));
        System.out.printf("%-20s: %.2f\n", "Perímetro Triángulo", sumaPerimetros.get(2));
        System.out.printf("%-20s: %.2f\n", "Área Rectángulo", sumaAreas.get(3));
        System.out.printf("%-20s: %.2f\n", "Perímetro Rectángulo", sumaPerimetros.get(3));

        System.out.println("\n\nÁREA MÁXIMA Y MÍNIMA DE TODAS LAS FIGURAS");
        System.out.printf("%-10s: %.2f\n", "Área máxima", cr.calcularAreaMaxima(figuras, null));
        System.out.printf("%-10s: %.2f\n", "Área mínima", cr.calcularAreaMinima(figuras, null));

        System.out.println("\n\nÁREA MÁXIMA Y MÍNIMA DE CADA TIPO DE FIGURA");
        System.out.printf("%-22s: %.2f\n", "Área Máxima Círculo", cr.calcularAreaMaxima(figuras, "Círculo"));
        System.out.printf("%-22s: %.2f\n", "Área Mínima Círculo", cr.calcularAreaMinima(figuras, "Círculo"));
        System.out.printf("%-22s: %.2f\n", "Área Máxima Cuadrado", cr.calcularAreaMaxima(figuras, "Cuadrado"));
        System.out.printf("%-22s: %.2f\n", "Área Mínima Cuadrado", cr.calcularAreaMinima(figuras, "Cuadrado"));
        System.out.printf("%-22s: %.2f\n", "Área Máxima Triángulo", cr.calcularAreaMaxima(figuras, "Triángulo"));
        System.out.printf("%-22s: %.2f\n", "Área Mínima Triángulo", cr.calcularAreaMinima(figuras, "Triángulo"));
        System.out.printf("%-22s: %.2f\n", "Área Máxima Rectángulo", cr.calcularAreaMaxima(figuras, "Rectángulo"));
        System.out.printf("%-22s: %.2f\n", "Área Mínima Rectángulo", cr.calcularAreaMinima(figuras, "Rectángulo"));

        List<Double> areasOrdenadas = cr.OrdenarArea(figuras, null);
        List<Double> perimetrosOrdenados = cr.OrdenarPerimetros(figuras, null);
        List<Figura> listaDeFiguras = new ArrayList<>(figuras);

        System.out.println("\n\nLAS 10 PRIMERAS FIGURAS ORDENADAS POR ÁREA EN ORDEN DESCENDENTE");
        for (int i = 0; i < 10; i++) {
            Figura figura = listaDeFiguras.get(i);
            System.out.printf("Figura: %-12s Área: %.4f   Perímetro: %.4f\n", figura.obtenerTipo(), areasOrdenadas.get(i), figura.calcularArea());
        }

        System.out.println("\n\nLAS 10 PRIMERAS FIGURAS ORDENADAS POR PERÍMETRO EN ORDEN DESCENDENTE");
        for (int i = 0; i < 10; i++) {
            Figura figura = listaDeFiguras.get(i);
            System.out.printf("Figura: %-12s Área: %.2f   Perímetro: %.2f\n", figura.obtenerTipo(), figura.calcularArea(), perimetrosOrdenados.get(i));
        }
    }
}
