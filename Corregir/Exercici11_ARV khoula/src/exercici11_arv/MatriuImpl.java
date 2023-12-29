package exercici11_arv;

/**
 * Implementació de la classe matriu per a comprovar si una matriu és simètrica
 * o no, és a dir, que els extrems de la matriu amb el seu mirall són idèntics.
 *
 * @param <E> genèric
 * @author ARV & KIB
 */
public class MatriuImpl<E extends Comparable<E>> implements Matriu<E> {

    private E matriu[];
    private int rows;
    private int cols;

    /**
     * Es crea una matriu representada en un array per files. Constructor.
     *
     * @param cols
     * @param rows
     */
    public MatriuImpl(int rows, int cols) {
        this.matriu = (E[]) new Comparable[rows * cols];
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Es crea una matriu representada en un array per files. Constructor.
     *
     * @param matriu
     * @param cols
     * @param rows
     */
    public MatriuImpl(E[] matriu, int rows, int cols) {
        this.matriu = matriu;
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Estableix un valor a l'element de la matriu situada a la posició indicada
     * per row i col.
     *
     * @param e
     * @param row
     * @param col
     */
    @Override
    public void set(E e, int row, int col) {
        matriu[row * cols + col] = e;
    }

    /**
     * Obté l'element de la matriu situat a la posició indicada per row i col.
     *
     * @param row
     * @param col
     * @return l'element de la matriu
     */
    @Override
    public E get(int row, int col) {
        return (E) matriu[row * cols + col];
    }

    /**
     * Crida a la funció per a afegir 2 paràmetres.
     *
     * @return la funció amb els dos paràmetres afegits, per a què es vagin
     * reduint cada vegada més.
     */
    @Override
    public boolean isSymmetricalRecursiu() {
        return isSymmetricalRecursiu(this.rows, this.cols);
    }

    /**
     * Temps de complexitat: O(n^2), essent n, el nombre de files (o columnes ja
     * que ha de ser el mateix), ja que va cridant a una altra funció més petita
     * reduint n-1 cada vegada. L'arbre binari va fent l'arbre a la meitat,
     * aquest algoritme en canvi només redueix n-1 cada vegada, per això el
     * temps de complexitat surt clarament més gran. Anàlisi de casos: Cas base:
     * Miram que la matriu sigui quadrada (retorna false) i que si ha arribat
     * fins al cas base amb les cridades recursives on nombre de files és 1,
     * retorna true. Cas recursiu: Anam mirant per a cada fila n-1 i columna n-1
     * si cadascun dels elements són miralls, és a dir, si l'element (j,i) és el
     * mateix que (i,j), en aquest cas redueix la cridada a n-1 i es va fent la
     * recursivitat. En cas contrari, és perque qualcun dels elements no és
     * mirall i per tant ja retorna false.
     *
     * @pre Una matriu qualsevol que no pot ser nul·la. S'ha de donar el nombre
     * de files i de columnes de la matriu.
     * @post Vertader si l'element de la matriu (i,j) per a tot "i" i "j" és el
     * mateix que l'element de la matriu (j,i), i = fila, j = columna. Fals si
     * no ho compleix o si no és una matriu n*n, és a dir, no té el mateix
     * nombre de files que de columnes.
     * @param rows
     * @param cols
     * @return True si és simètrica, false en cas contrari.
     */
    //Check sintàctic: el nombre de paràmetres correspon a l'especificació.
    public boolean isSymmetricalRecursiu(int rows, int cols) {
        //CASO BASE
        //Check semàntic: están coberts tots els estats de la @pre
        //Check semàntic: l'algoritme funciona quan no hi ha cridades recursives
        //(si ens dona una matriu 1x1 sempre serà simètrica).
        if (rows != cols) {
            return false;
        }
        if (rows == 1) {
            return true;
            //CASO RECURSIVO
        } else {
            int i = rows - 1;
            for (int j = 0; j < i; j++) {
                if (get(i, j).compareTo(get(j, i)) != 0) {
                    return false;
                }
            }
            //Check sintàctic: es crida amb la mateixa forma del mètode.
            //Check semàntic: els valors dels paràmetres de les cridades 
            //recursives satisfàn la @pre.
            //Check semàntic: La cridada satisfà la @post, retorna false en cas
            //que ja hagi trobat uns elements no miralls o va reduint la matriu
            //retornant true de moment.
            //Check semàntic: el tamany dels paràmetres es van fent cada vegada
            //més petits: es redueix n-1 files/columnes.
            return isSymmetricalRecursiu(rows - 1, cols - 1);
        }
    }

    /**
     * És un mètode que realitza 2 fors per anar comparant els elements de
     * l'extrem dret amb els de l'extrem esquerre. Aquí es veu millor el temps
     * de complexitat de l'algorisme, O(n^2), on "n" és el nombre de
     * files/columnes de la matriu.
     *
     * @return true si la matriu és simètrica, false en cas contrari.
     */
    @Override
    public boolean isSymmetricalIteratiu() {
        if (rows != cols) {
            return false;
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    if (get(i, j).compareTo(get(j, i)) != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
