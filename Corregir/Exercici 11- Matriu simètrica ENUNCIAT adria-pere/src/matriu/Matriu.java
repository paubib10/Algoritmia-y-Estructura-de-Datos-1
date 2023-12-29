package matriu;

/**
 * Interfície que respresenta una matriu que pot emmagatzemar elements
 * comparables
 *
 * @author antoni
 * @author Pere Garcias Miralles
 * @author Adrià Serra Martín
 * @param <E> element que emmagatzema la matriu
 */
public interface Matriu<E extends Comparable<E>> {

    /**
     * Set d'un element a la matriu.
     *
     * @param e element a insertar
     * @param row fila
     * @param col columna
     */
    public void set(E e, int row, int col);

    /**
     * Retorna element d'una posició.
     *
     * @param row fila
     * @param col columna
     * @return element de la fila i columna
     */
    public E get(int row, int col);

    /**
     * Indica si la matriu és simètrica. Algorisme recursiu.
     *
     * @esp <strong>Sintàctica:</strong> <br>
     * La funció cal retornar vertader o fals, per la qual cosa és convenient
     * utilitzar un mètode booleà privat, <br> del mateix nom que el públic
     * isSymmetricalRecursiu() des del qual es cridarà. <br> <br>
     *
     * Com paràmetres, el mètode s'aplicarà sobre la matriu requerida. Es
     * necessitaran addicionalment altres <br> dos paràmetres enters per
     * conèixer quantes files i columnes tendran les submatrius recursives,<br>
     * a més del propi paràmetre de tipus Comparable[] que representi dita
     * matriu/submatriu. <br>
     * <br>
     *
     * <strong> Semàntica: </strong> <br> <br>
     * Precondició: <br>
     * • El nombre de files i columnes de la matriu/submatriu cal ser major que
     * zero. <br>
     * • La matriu/submatriu ha d'estar organitzada en ordre <i>row-major</i>.
     * <br>
     * • La matriu/submatriu ha de ser no nul·la.
     * <br> <br>
     *
     * Postcondició: <br>
     * • El mètode retornarà cert si cada posició de la matriu té el mateix
     * element quan aquesta es transposi (A=A<sup>T</sup>). <br>
     *
     * @anc <strong> Cas 1x1: </strong> (cas trivial) <br>
     * Quan la matriu sigui només d'un element (una fila i una columna), aquesta
     * serà automàticament simètrica. <br> Si el programa arriba fins aquest
     * punt abans de retornar {@code false} la matriu es donarà finalment per
     * simètrica. <br> <br>
     *
     * <strong> Cas NxN: </strong> <br>
     * Cal comprovar-se la simetria (coincidència de cada element) entre la
     * primera fila i columna de la matriu/submatriu. <br> Si es compleix la
     * simetria, comprovada a través del mètode filaColSimetrica() aplicat sobre
     * la matriu/submatriu, <br> el mètode segueix endavant fent una cridada
     * recursiva que decrementa en 1 la dimensió de la matriu/submatriu <br>
     * (resta la darrera fila i columna). Si no es compleix la simetria, el
     * mètode acaba i retorna {@code false}.
     *
     * @ord O(n): Seguint el teorema de reducció per resta, com que el total de
     * cridades recursives és a = 1, la quantitat en què es redueix el nombre
     * d'elements a cada cridada és el resultat de reduir una dimensió una
     * matriu quadrada, és a dir, c = 2 i, finalment, com que la complexitat de
     * l'algorisme del cas trivial és 1, es té que alfa = 0. Per tant, ens
     * trobam davant un cas on T(n)∈Θ(n^(0+1), o sigui, Θ(n). Si s'hagués
     * d'establir la simetria d'un arbre binari, el procediment seria paregut ja
     * que, per una part, el cas trivial seguiria sent un únic element (l'arrel,
     * en el cas de l'arbre); per una altra part, si es comparés tota la part a
     * l'esquerra de l'arrel amb la part de la dreta començant per les fulles,
     * es reduiria a cada iteració el nombre d'elements, però amb la diferència
     * que en el cas de l'arbre seria a la meitat, i no dos com en el cas de la
     * matriu. Per això, l'ordre de complexitat de la matriu és O(n) i el de
     * l'arbre binari O(log(n)).
     *
     * @return true si és simètrica, false en cas contrari
     */
    public boolean isSymmetricalRecursiu();

    /**
     * Indica si la matriu és simètrica. Algorisme iteratiu
     * <br> Funciona anàlogament a l'algorisme recursiu anterior, per la qual
     * cosa s'adhereix a la mateixa especificació i lògica, ja que es tracta
     * de la transformació d'aquest algorisme recursiu en un d'iteratiu.
     *
     * @return true si és simètrica, false en cas contrari
     */
    public boolean isSymmetricalIteratiu();
}
