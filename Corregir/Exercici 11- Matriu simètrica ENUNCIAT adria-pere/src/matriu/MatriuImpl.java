package matriu;

/**
 *
 * Classe per representar una matriu matemàtica d'elements comparables,
 * implementada en forma de vector unidimensional seguint un ordre
 * <i>row-major</i>. <br>
 *
 * La classe implementa també dos mètodes, recursiu i iteratiu, per comprovar si
 * una matriu és simètrica.
 *
 * @author antoni
 * @author Pere Garcias Miralles
 * @author Adrià Serra Martín
 * @param <E> Element que emmagatzema la matriu
 */
public class MatriuImpl<E extends Comparable<E>> implements Matriu<E> {

    /**
     * Nombre de files i columnes que té la matriu, respectivament <br>
     * (la primera fila/columna té l'índex 0)
     */
    private int rows, cols;

    /**
     * Array d'elements que componen la matriu
     */
    private Comparable[] elements;

    /**
     * Es crea una matriu buida representada en un array per files
     *
     * @param cols nombre de columnes de la matriu
     * @param rows nombre de files de la matriu
     */
    public MatriuImpl(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        elements = new Comparable[rows * cols];
    }

    /**
     * Es crea una matriu representada en un array per files, segons un conjunt
     * de dades donades. <br> <br>
     *
     * Es controlen els casos on no es pugui crear la matriu degut a problemes
     * amb els paràmetres <br> (p.e. Dimensions negatives, incoherència entre
     * files/columnes i la quantitat de dades especificades...)
     *
     * @param matriu dades que contendrà la matriu
     * @param cols nombre de columnes de la matriu
     * @param rows nombre de files de la matriu
     */
    public MatriuImpl(E[] matriu, int rows, int cols) {

        if (rows <= 0 || cols <= 0 || rows * cols != matriu.length || matriu.length % rows != 0 || matriu.length % cols != 0) {
            throw new IllegalArgumentException("No es pot crear una matriu amb les dimensions donades");
        }
        this.rows = rows;
        this.cols = cols;
        this.elements = matriu;
    }

    @Override
    public void set(E e, int row, int col) {
        elements[row * cols + col] = e;
    }

    @Override
    public E get(int row, int col) {
        return (E) elements[row * cols + col];
    }

    @Override
    public boolean isSymmetricalRecursiu() {

        return this.isSymmetricalRecursiu(this.rows, this.cols, this.elements);
    }

    /**
     * Mètode privat per inicialitzar i fer la comprovació de simetria d'una
     * matriu recursivament com a tal. Cobert pel mètode públic del mateix nom,
     * per tapar la definició dels paràmetres d'inici.
     */
    private boolean isSymmetricalRecursiu(int rows, int cols, Comparable[] elements) {

        // Cas de dimensió 1x1
        if (rows == 1 && cols == 1) {
            return true;

            // Cas de dimensió NxN (amb simetria fila-columna)
        } else if (filaColSimetrica(rows, cols, this)) {
            return isSymmetricalRecursiu(rows - 1, cols - 1, elements);

            // Cas de dimensió NxN (sense simetria fila-columna)
        } else {
            return false;
        }
    }

    /**
     * Mètode privat per, donada una matriu/submatriu, extreure i comparar un a
     * un els elements de la seva darrera fila i columna.
     *
     * @param rows Nombre de files de la matriu/submatriu
     * @param cols Nombre de columnes de la matriu/submatriu
     * @param m Matriu per extreure els elements de la fila i columna a comparar
     * @return True si la fila i columna són simètriques, false si no ho són
     */
    private boolean filaColSimetrica(int rows, int cols, Matriu m) {

        // Arrays per guardar elements de la fila i columna
        Comparable[] elementsFiles = new Comparable[rows];
        Comparable[] elementsColumnes = new Comparable[cols];

        // Cas on el nombre de files i columnes no coincideix, per tant no simètrica
        if (rows != cols) {
            return false;
        }
        // Obtenció dels elements de la fila a comparar
        for (int i = 0; i < elementsFiles.length; i++) {
            elementsFiles[i] = m.get(rows - 1, i);
        }

        // Obtenció dels elements de la columna a comparar
        for (int i = 0; i < elementsColumnes.length; i++) {
            elementsColumnes[i] = m.get(i, cols - 1);
        }

        // Comparació element a element
        for (int i = 0; i < elementsFiles.length; i++) {
            if (elementsFiles[i] != elementsColumnes[i]) {
                return false;
            }
        }
        return true;
    }

    
    @Override
    public boolean isSymmetricalIteratiu() {
        return isSymmetricalIteratiu(rows, cols);
    }

    /**
     * Mètode privat per inicialitzar i fer la comprovació de simetria d'una
     * matriu iterativament. Utilitzat pel mètode públic homònim sense
     * paràmetres per garantir l'encapsulament dels paràmetres.
     * 
     * @param rows número de files de la matriu
     * @param cols número de columnes de la matriu
     * @return true si la matriu és simètrica, false en cas contrari
     */
    private boolean isSymmetricalIteratiu(int rows, int cols) {
        while (rows != 1 || cols != 1) {
            if (filaColSimetrica(rows, cols, this)) {
                rows--;
                cols--;
            } else {
                return false;
            }
        }
        return true;
    }

}
