package peak;

import java.awt.Point;

/**
 * Interfície que s'aplica a un conjunt de dades ordenat seguint una estructura
 * de muntanya. Els valors estan ordenats en ordre ascendent fins que s'arriba
 * a un valor màxim únic (cim) i, a partir d'ell, els valors estan ordenats en
 * ordre descendent. El cim no pot estar a cap dels extrems i no hi pot haver
 * elements repetits dins una mateixa vessant (ascendent o descendent).
 * 
 * @author Adrià Serra Martín
 * @author Pere Garcias Miralles
 */
public interface Peak {

    /**
     * Implementa la cerca del cim del conjunt de dades.
     * 
     * @param a array d'ints
     * @return objecte Point amb l'element cim i el seu índex a l'array
     */
    public Point peak(int a[]);
}
