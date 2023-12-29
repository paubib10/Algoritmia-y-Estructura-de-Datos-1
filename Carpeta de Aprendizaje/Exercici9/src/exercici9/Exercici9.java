package exercici9;

import java.awt.Point;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class Exercici9 {

    /**
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        int[] array = {5, 10, 20, 15, 3};
        PeakImpl p = new PeakImpl();
        Point result = p.peak(array);
        System.out.println("La cima es " + result.x + " y su índice es " + result.y);
    }
}
