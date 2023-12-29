package exercici3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CalcularResultados {

    public List<Double> calcularSumaAreas(Collection<Figura> figuras) {
        double sumaCercle = 0.0;
        double sumaQuadrat = 0.0;
        double sumaTriangle = 0.0;
        double sumaRectangle = 0.0;

        for (Figura figura : figuras) {
            if (figura.obtenerTipo() == "Círculo") {
                sumaCercle += figura.calcularArea();
            } else if (figura.obtenerTipo() == "Cuadrado") {
                sumaQuadrat += figura.calcularArea();
            } else if (figura.obtenerTipo() == "Triángulo") {
                sumaTriangle += figura.calcularArea();
            } else if (figura.obtenerTipo() == "Rectángulo") {
                sumaRectangle += figura.calcularArea();
            }
        }

        List<Double> suma = new ArrayList<Double>();
        suma.add(0, sumaCercle);
        suma.add(1, sumaQuadrat);
        suma.add(2, sumaTriangle);
        suma.add(3, sumaRectangle);

        return suma;
    }

    public List<Double> calcularSumaPerimetros(Collection<Figura> figuras) {
        double sumaCercle = 0;
        double sumaQuadrat = 0;
        double sumaTriangle = 0;
        double sumaRectangle = 0;

        for (Figura figura : figuras) {
            if (figura.obtenerTipo() == "Círculo") {
                sumaCercle += figura.calcularPerimetro();
            } else if (figura.obtenerTipo() == "Cuadrado") {
                sumaQuadrat += figura.calcularPerimetro();
            } else if (figura.obtenerTipo() == "Triángulo") {
                sumaTriangle += figura.calcularPerimetro();
            } else if (figura.obtenerTipo() == "Rectángulo") {
                sumaRectangle += figura.calcularPerimetro();
            }
        }

        List<Double> suma = new ArrayList<Double>();
        suma.add(0, sumaCercle);
        suma.add(1, sumaQuadrat);
        suma.add(2, sumaTriangle);
        suma.add(3, sumaRectangle);

        return suma;
    }

    public double calcularAreaMaxima(Collection<Figura> figuras, String tipoFigura) {
        double maxima = Double.MIN_VALUE;
        for (Figura figura : figuras) {
            if (tipoFigura == null || tipoFigura.equals(figura.obtenerTipo())) {
                double area = figura.calcularArea();
                if (area > maxima) {
                    maxima = area;
                }
            }
        }
        return maxima;
    }

    public double calcularAreaMinima(Collection<Figura> figuras, String tipoFigura) {
        double minima = Double.MAX_VALUE;
        for (Figura figura : figuras) {
            if (tipoFigura == null || tipoFigura.equals(figura.obtenerTipo())) {
                double area = figura.calcularArea();
                if (area < minima) {
                    minima = area;
                }
            }
        }
        return minima;
    }

    public List<Double> OrdenarArea(Collection<Figura> figuras, String tipoFigura) { //DESCENDENTE
        ArrayList<Double> suma = new ArrayList<>();
        for (Figura figura : figuras) {
            if (tipoFigura == null || figura.obtenerTipo() == tipoFigura) {
                suma.add(figura.calcularArea());
            }

        }
        Collections.sort(suma, Collections.reverseOrder());
        return suma;
    }

    public List<Double> OrdenarPerimetros(Collection<Figura> figuras, String tipoFigura) { //DESCENDENTE
        ArrayList<Double> suma = new ArrayList<>();
        for (Figura figura : figuras) {
            if (tipoFigura == null || figura.obtenerTipo() == tipoFigura) {
                suma.add(figura.calcularPerimetro());
            }
        }
        Collections.sort(suma, Collections.reverseOrder());
        return suma;
    }

}
