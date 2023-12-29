package tree;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class BinaryTreeReferenceTest {

    private BinaryTree<Integer> tree;
    private BinaryTree<Integer> emptyTree;
    private BinaryTree<Integer> singleNodeTree;

    @Before
    public void setUp() throws Exception {
        tree = new BinaryTreeReference();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(80);
        
        emptyTree = new BinaryTreeReference<>();

        singleNodeTree = new BinaryTreeReference<>();
        singleNodeTree.insert(42);
    }

    /**
     * Test of isEmpty method, of class BinaryTreeReference.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BinaryTree<Integer> instance = new BinaryTreeReference();
        assertEquals(true, instance.isEmpty());
        assertEquals(false, tree.isEmpty());
    }

    /**
     * Test of insert method, of class BinaryTreeReference.
     */
    @Test
    public void testInsertContains() {
        System.out.println("insertContains");
        assertEquals(false, tree.contains(25));
        tree.insert(25);
        assertEquals(true, tree.contains(25));
    }

    /**
     * Test of longestBranch and Insert method, of class BinaryTreeReference.
     */
    @Test
    public void testLongestBranchInsert() {
        System.out.println("longestBranchInsert");
        assertEquals(3, tree.longestBranch( ));
        tree.insert(25);
        assertEquals(3, tree.longestBranch());
        tree.insert(5);
        assertEquals(4, tree.longestBranch());
        tree.insert(81);
        tree.insert(82);
        tree.insert(83);
        assertEquals(5, tree.longestBranch());
    }
    
    @Test
    public void testLongestBranchInsertSingleEmpty() {
        System.out.println("longestBranchInsertSingleEmpty");
        assertEquals(0, emptyTree.longestBranch());
        assertEquals(0, singleNodeTree.longestBranch());
    }

    /**
     * Test of getMother method, of class BinaryTreeReference.
     */
    @Test
    public void testGetMother() {
        System.out.println("getMother");
        assertEquals(null, tree.getMother(50));
        int i = tree.getMother(30);
        assertEquals(50, i);
        i = tree.getMother(70);
        assertEquals(50, i);
        i = tree.getMother(10);
        assertEquals(20, i);
        assertEquals(null, tree.getMother(15));
        assertEquals(null, tree.getMother(tree.getRoot()));
    }

    /**
     * Test of getRoot method, of class BinaryTreeReference.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        int i = tree.getRoot();
        assertEquals(50, i);
    }  
    
    private BinaryTree<String> new_tree = new BinaryTreeReference();

    /**
     * Test del metodo contains y metodo Insert, de la clase 
     * BinaryTreeReference, utiizando la variable String.
     */
    @Test
    public void testInsertContainsString() {
        System.out.println("insertContainsString");
        assertEquals(false,new_tree.contains(null));
        new_tree.insert("abcde");
        assertEquals(false,new_tree.contains("abc"));
        assertEquals(true,new_tree.contains("abcde"));
    }

    /**
     * Test del metodo longestBranch y metodo Insert, de la clase 
     * BinaryTreeReference, utiizando la variable String.
     */
    @Test
    public void testLongestBranchInsertString() {
        System.out.println("longestBranchInsertString");
        new_tree.insert("abcde");
        assertEquals(0, new_tree.longestBranch());
        new_tree.insert("tree");
        assertEquals(1, new_tree.longestBranch());
        new_tree.insert("binary");
        new_tree.insert("trees");
    }

    /**
     * Test del metodo getMother y metodo Insert, de la clase 
     * BinaryTreeReference, utiizando la variable String.
     */
    @Test
    public void testGetMotherString() {
        new_tree.insert("abcde");
        new_tree.insert("tree");
        new_tree.insert("binary");
        new_tree.insert("trees");
        
        System.out.println("getMotherString");
        assertEquals(null, new_tree.getMother("aaa"));
        new_tree.insert("abcde");
        assertEquals(null, new_tree.getMother("abcde"));
        assertEquals("tree", new_tree.getMother("trees"));
    }

    /**
     * Test del metodo getRoot y metodo Insert, de la clase 
     * BinaryTreeReference, utiizando la variable String.
     */
    @Test
    public void testGetRootString() {
        System.out.println("getRootString");
        new_tree.insert("abcde");
        new_tree.insert("algoritmia");
        String i = new_tree.getRoot();
        assertEquals("abcde", i);
    }
    
}
