package exercici3;

import figuras.Circulo;
import figuras.Rectangulo;
import figuras.Triangulo;
import figuras.Cuadrado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Clase para generar figuras geométricas aleatorias. Esta clase genera una
 * colección de figuras geométricas aleatorias, con valores aleatorios para sus dimensiones.
 *
 * @author Pau Toni Bibiloni &amp; Blanca Atienzar
 */
public class GenerarFiguras {

    /**
     * Genera una colección de figuras geométricas aleatorias.
     *
     * @return Una colección de figuras geométricas aleatorias.
     */
    public static Collection<Figura> generarFigurasAleatorias() {
        List<Figura> figuras = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int figuraAleatoria = random.nextInt(4);
            double lado1 = random.nextDouble() * 10 + 1;
            double lado2 = random.nextDouble() * 10 + 1;

            switch (figuraAleatoria) {
                case 0:
                    figuras.add(new Circulo(lado1));
                    break;
                case 1:
                    figuras.add(new Triangulo(lado1));
                    break;
                case 2:
                    figuras.add(new Rectangulo(lado1, lado2));
                    break;
                case 3:
                    figuras.add(new Cuadrado(lado1));
                    break;
            }
        }

        return figuras;
    }

}
