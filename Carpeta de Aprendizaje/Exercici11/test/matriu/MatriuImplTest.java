package matriu;

import matriu.MatriuImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class MatriuImplTest {

    private MatriuImpl<Integer> m1, m2, m3;
    private MatriuImpl<String> mS1, mS2, mS3;

    @Before
    public void setUp() throws Exception {
        Integer matriu1[] = {0, 1, 2, 1, 1, 2, 2, 2, 3};
        Integer matriu2[] = {0, 1, 2, 3, 1, 2, 2, 2, 3};
        Integer matriu3[] = {0, 1, 2, 1, 1, 2};

        m1 = new MatriuImpl<>(matriu1, 3, 3);
        m2 = new MatriuImpl<>(matriu2, 3, 3);
        m3 = new MatriuImpl<>(matriu3, 2, 3);
    }

    /**
     * Test of isSymmetricalRecursiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalRecursiu() {
        System.out.println("isSymmetricalRecursiu");
        assertEquals(true, m1.isSymmetricalRecursiu());
        assertEquals(false, m2.isSymmetricalRecursiu());
        assertEquals(false, m3.isSymmetricalRecursiu());
    }

    /**
     * Test of isSymmetricalIteratiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalIteratiu() {
        System.out.println("isSymmetricalIteratiu");
        assertEquals(true, m1.isSymmetricalIteratiu());
        assertEquals(false, m2.isSymmetricalIteratiu());
        assertEquals(false, m3.isSymmetricalIteratiu());
    }

    @Before
    public void setUpString() throws Exception {
        String matriuString1[] = {"a", "b", "c", "b", "b", "c", "c", "c", "d"};
        String matriuString2[] = {"a", "b", "c", "d", "e", "f"};
        String matriuString3[] = {"hola"};

        mS1 = new MatriuImpl<>(matriuString1, 3, 3);
        mS2 = new MatriuImpl<>(matriuString2, 2, 3);
        mS3 = new MatriuImpl<>(matriuString3, 1, 1);
    }

    /**
     * Test of isSymmetricalIteratiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalIteratiuString() {
        System.out.println("isSymmetricalIteratiuString");
        assertEquals(true, mS1.isSymmetricalIteratiu());
        assertEquals(false, mS2.isSymmetricalIteratiu());
        assertEquals(true, mS3.isSymmetricalIteratiu());
    }

    /**
     * Test of isSymmetricalRecursiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalRecursiuString() {
        System.out.println("isSymmetricalRecursiuString");
        assertEquals(true, mS1.isSymmetricalRecursiu());
        assertEquals(false, mS2.isSymmetricalRecursiu());
        assertEquals(true, mS3.isSymmetricalRecursiu());
    }
}
