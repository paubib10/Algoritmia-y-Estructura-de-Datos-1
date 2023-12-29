package exercici11_arv;

/**
 * Interfície que respresenta una matriu que pot emmagatzemar elements
 * comparables
 *
 * @author antoni
 * @param <E> element que emmagatzema la matriu
 */
public interface Matriu<E extends Comparable<E>> {

    /**
     * Set d'un element a la matriu
     *
     * @param e element a insertar
     * @param row fila
     * @param col columna
     */
    public void set(E e, int row, int col);

    /**
     * Retorna element d'una posició
     *
     * @param row fila
     * @param col columna
     * @return element de la fila i columna
     */
    public E get(int row, int col);

    /**
     * Indica si la matriu és simètrica. Algorisme recursiu
     *
     * @return vertader si és simètrica, false en cas contrari
     */
    public boolean isSymmetricalRecursiu();

    /**
     * Indica si la matriu és simètrica. Algorisme iteratiu
     *
     * @return vertader si és simètrica, false en cas contrari
     */
    public boolean isSymmetricalIteratiu();
}
