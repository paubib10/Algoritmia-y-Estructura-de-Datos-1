package exercici11_arv;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Classe de proves per a comprovar que tots els tests de la classe principal es
 * poden validar.
 *
 * @author ARV & KIB
 */
public class MatriuImplTest {

    private MatriuImpl<Integer> m1;
    private MatriuImpl<Integer> m2;
    private MatriuImpl<Integer> m3;
    private MatriuImpl<String> m4;
    private MatriuImpl<String> m5;
    private MatriuImpl<String> m6;

    /**
     * Introdueix les dades de les matrius amb les que treballarem en els tests.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Integer matriu1[] = {0, 1, 2, 1, 1, 2, 2, 2, 3};
        Integer matriu2[] = {0, 1, 2, 3, 1, 2, 2, 2, 3};
        Integer matriu3[] = {0, 1, 2, 1, 1, 2};
        m1 = new MatriuImpl<>(matriu1, 3, 3);
        m2 = new MatriuImpl<>(matriu2, 3, 3);
        m3 = new MatriuImpl<>(matriu3, 2, 3);
        String matriu4[] = {"hola", "yo", "soy", "hola"};
        String matriu5[] = {"casa", "hola", "hola", "palo"};
        String matriu6[] = {"ci", "ce", "ca", "ce", "co", "ce", "ca", "ce", "cu"};
        m4 = new MatriuImpl<>(matriu4, 2, 2);
        m5 = new MatriuImpl<>(matriu5, 2, 2);
        m6 = new MatriuImpl<>(matriu6, 3, 3);
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
     * Test 2 of isSymmetricalRecursiu method, of class MatriuImpl. Treballa amb
     * matrius de tipus String.
     */
    @Test
    public void testIsSymmetricalRecursiuString() {
        System.out.println("isSymmetricalRecursiuString");
        assertEquals(false, m4.isSymmetricalRecursiu());
        assertEquals(true, m5.isSymmetricalRecursiu());
        assertEquals(true, m6.isSymmetricalRecursiu());
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

    /**
     * Test 2 of isSymmetricalRecursiu method, of class MatriuImpl. Treballa amb
     * matrius de tipus String.
     */
    @Test
    public void testIsSymmetricalIteratiuString() {
        System.out.println("isSymmetricalIteratiuString");
        assertEquals(false, m4.isSymmetricalIteratiu());
        assertEquals(true, m5.isSymmetricalIteratiu());
        assertEquals(true, m6.isSymmetricalIteratiu());
    }
}
