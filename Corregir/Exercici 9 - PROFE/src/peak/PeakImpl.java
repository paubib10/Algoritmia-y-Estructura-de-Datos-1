package peak;

import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antoni
 */
public class PeakImpl implements Peak {

    /**
     * Algorisme d'inicialització. Donat un array d'enters. Els valors van amb
     * ordre creixent sense repetició fins a un índex, i a partir d'aquest índex
     * van amb ordre decreixent sense repetició. Trobar l'element cim i el seu
     * índex. Un element és el cim, si és més gran que els seus veïnats. El cim
     * mai estarà en els extrems i només hi ha un cim. (Heu de trobar el valor
     * màxim, i només hi ha un màxim).
     *
     * @param a conjunt d'enters
     * @return Point x és el peak, y és l'índex
     */
    @Override
    public Point peak(int[] a) {
        return peak(a, 1, a.length - 2);
    }

    /**
     * Algorismes recursiu. Donat un array d'enters. Els valors van amb ordre
     * creixent sense repetició fins a un índex, i a partir d'aquest índex van
     * amb ordre decreixent sense repetició. Trobar l'element cim i el seu
     * índex. Un element és el cim, si és més gran que els seus veïnats. El cim
     * mai estarà en els extrems i només hi ha un cim. (Heu de trobar el valor
     * màxim, i només hi ha un màxim). Ordre de complexitat: Teorema reducció
     * per quocient. a == 1 c == 2 alfa = 0
     *
     * @param a conjunt d'enters
     * @param i índex inici conjunt
     * @param j índex final conjunt
     * @return Point x és el peak, y és l'índex
     */
    private static Point peak(int a[], int i, int j) {
        int m = (i + j) / 2;
        if (a[m] > a[m - 1] && a[m] > a[m + 1]) {
            return new Point(a[m], m);
        }
        if (a[m - 1] < a[m] && a[m] < a[m + 1]) {
            return peak(a, m + 1, j);
        } else {
            return peak(a, i, m - 1);
        }
    }

}
