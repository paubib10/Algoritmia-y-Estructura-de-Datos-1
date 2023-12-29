package tree;

/**
 * Implementación de un Árbol Binario utilizando referencias.
 *
 * @param <E> Tipo de elementos que se almacenarán en el árbol, deben ser comparables.
 * @author @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class BinaryTreeReference<E extends Comparable<E>> implements BinaryTree<E> {

    private Node<E> root;

    /**
     * Verifica si el árbol está vacío.
     *
     * Complejidad: O(1) - Constante, no depende del tamaño del árbol.
     * @return {@code true} si el árbol está vacío, {@code false} si contiene al
     * menos un elemento.
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Inserta un nuevo elemento en el árbol.
     * 
     * Complejidad: O(log N) - Logarítmica, donde N es el número de elementos en el árbol.
     * @param e Elemento a insertar.
     */
    @Override
    public void insert(E e) {
        root = insertAux(root, e);
    }

    /**
     * Método auxiliar para realizar la inserción de manera recursiva.
     *
     * Complejidad: O(log N) - Logarítmica, donde N es el número de elementos en el árbol.
     * @param root Nodo actual.
     * @param e Elemento a insertar.
     * @return Nodo actualizado después de la inserción.
     */
    private Node<E> insertAux(Node<E> root, E e) {
        if (root == null) {
            root = new Node<>(e);
            return root;
        }

        if (e.compareTo(root.data) < 0) {
            root.left = insertAux(root.left, e);
        } else if (e.compareTo(root.data) > 0) {
            root.right = insertAux(root.right, e);
        }

        return root;
    }

    /**
     * Verifica si el árbol contiene un elemento específico.
     *
     * Complejidad: O(log N) - Logarítmica, donde N es el número de elementos en el árbol.
     * @param e Elemento a buscar.
     * @return {@code true} si el elemento está en el árbol, {@code false} si no.
     */
    @Override
    public boolean contains(E e) {
        return containsAux(root, e);
    }

    /**
     * Método auxiliar para realizar la búsqueda de manera recursiva.
     *
     * Complejidad: O(log N) - Logarítmica, donde N es el número de elementos en el árbol.
     * @param root Nodo actual.
     * @param e Elemento a buscar.
     * @return {@code true} si el elemento está en el árbol, {@code false} si no.
     */
    private boolean containsAux(Node<E> root, E e) {
        if (root == null) {
            return false;
        }

        if (e.compareTo(root.data) == 0) {
            return true;
        } else if (e.compareTo(root.data) < 0) {
            return containsAux(root.left, e);
        } else {
            return containsAux(root.right, e);
        }
    }

    /**
     * Calcula la longitud de la rama más larga en el árbol.
     *
     * Complejidad: O(N) - Lineal, donde N es el número de nodos en el árbol.
     * @return Longitud de la rama más larga.
     */
    @Override
    public int longestBranch() {
        return Math.max(0, longestBranchAux(root) - 1); // Restamos 1 al resultado final
    }

    /**
     * Método auxiliar para calcular la longitud de la rama más larga de manera
     * recursiva.
     *
     * Complejidad: O(N) - Lineal, donde N es el número de nodos en el árbol.
     * @param root Nodo actual.
     * @return Longitud de la rama más larga desde el nodo actual.
     */
    private int longestBranchAux(Node<E> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = longestBranchAux(root.left);
        int rightHeight = longestBranchAux(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Obtiene el valor del nodo padre de un nodo con un valor específico.
     *
     * Complejidad: O(log N) - Logarítmica, donde N es el número de elementos en el árbol.
     * @param e Elemento cuyo nodo padre se busca.
     * @return Valor del nodo padre, o {@code null} si el elemento no está en el árbol o es la raíz.
     */
    @Override
    public E getMother(E e) {
        return getMotherAux(root, e);
    }

    /**
     * Método auxiliar para buscar el nodo padre de un nodo con un valor
     * específico.
     *
     * Complejidad: O(log N) - Logarítmica, donde N es el número de elementos en el árbol.
     * @param current Nodo actual.
     * @param e Elemento cuyo nodo padre se busca.
     * @return Valor del nodo padre, o {@code null} si el elemento no está en el árbol o es la raíz.
     */
    private E getMotherAux(Node<E> current, E e) {
        if (current == null) {
            return null; // El elemento no está en el árbol
        }

        if ((current.left != null && current.left.data.equals(e)) || (current.right != null && current.right.data.equals(e))) {
            return current.data; // Se encontró el nodo hijo, devolver el valor del padre
        }

        if (e.compareTo(current.data) < 0) {
            return getMotherAux(current.left, e);
        } else {
            return getMotherAux(current.right, e);
        }
    }

    /**
     * Obtiene el valor del nodo raíz del árbol.
     *
     * Complejidad: O(1) - Constante, no depende del tamaño del árbol.
     * @return Valor del nodo raíz, o {@code null} si el árbol está vacío.
     */
    @Override
    public E getRoot() {
        if (root == null) {
            return null;
        }
        return root.data;
    }
}
