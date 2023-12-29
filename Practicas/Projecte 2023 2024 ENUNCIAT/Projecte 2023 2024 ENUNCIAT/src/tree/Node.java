package tree;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 * @param <E>
 */
public class Node<E> {

    E data;
    Node<E> left, right;

    Node(E item) {
        data = item;
        left = right = null;
    }
}
