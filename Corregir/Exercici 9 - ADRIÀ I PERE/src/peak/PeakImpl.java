package peak;

import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Representa una implementació de Peak. Implementa la interfície homònima per
 * donar una solució recursiva el problema de trobar el cim d'una estructura que
 * consisteix en un array on els nombres estan ordenats de manera ascendent fins
 * al valor màxim i de manera descendent a partir d'ell.
 *
 *
 * @author antoni
 * @author Adrià Serra Martín
 * @author Pere Garcias Miralles
 */
public class PeakImpl implements Peak {

    /**
     * Troba el màxim (cim) d'un array ordenat en forma de muntanya. Cerca
     * l'element amb el valor numèric més elevat i retorna un {@code Point} on
     * la coordenada x equival al valor del nombre i la coordenada y al seu
     * índex dins l'array.
     *
     * @param a array d'ints
     * @return Point del qual la x és el màxim i la y el seu índex
     * @pre (a != null) ^ (∃!a[pk]:∀a[i], a[pk] > a[i], per i =
     * 0,...,pk-1,pk+1,...,a.length) ^ (pk != 0) ^ (pk != a.length) ^
     * (∀(a[i],a[j]) ∈ {a[0]...a[pk-1]}, a[i] != a[j], per i != j) ^
     * (∀(a[i],a[j]) ∈ {a[pk+1]...a[a.length]}, a[i] != a[j], per i != j)
     *
     * @post Point.x = a[pk] ^ Point.y = pk
     *
     * @ord O(n), n = nombre d'elements dins el conjunt. Es va llegint de forma
     * lineal sobre el conjunt de dades. En el millor dels casos el cim serà el
     * segon element, per tant O(2) En el pitjor dels casos el cim serà el
     * penúltim element, per tant O(n-1) Per tant, l'ordre de complexitat, per
     * un valor n tendint a infinit, serà O(n)
     */
    @Override
    public Point peak(int[] a) {
        // La posició inicial, des d'on un element ja pot ser cim, serà la 1,
        // la posició 0 servirà com a veí per a la comparació
        return peak(a, 1);
    }

    /**
     * Mètode privat utilitzat pel mètode anterior per cercar de manera
     * recursiva el cim del conjunt de dades. Comença pel primer possible cim,
     * és a dir, l'element situat a l'índex 1 i recorr l'array linealment cap a
     * la dreta comprovant si l'element següent al candidat a cim és menor que
     * aquest. En cas afirmatiu, s'ha trobat el cim.
     *
     * @param a conjunt de dades que es va reduint
     * @param i índex de l'element comprovat
     * @return Point del qual la x és el màxim i la y el seu índex
     */
    private Point peak(int a[], int i) {

        if (a[i] > a[i + 1]) {
            return new Point(a[i], i);
        }
        return peak(a, i + 1);
    }
}
