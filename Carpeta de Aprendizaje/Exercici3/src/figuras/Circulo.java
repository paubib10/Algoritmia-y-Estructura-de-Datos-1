package figuras;

import exercici3.Figura;

/**
 * Clase que representa un círculo.
 * 
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String obtenerTipo() {
        return "Círculo";
    }
}
