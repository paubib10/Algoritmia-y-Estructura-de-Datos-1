package matriu;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author antoni
 */
public class MatriuImplTest {

    private MatriuImpl<Integer> m1;
    private MatriuImpl<Integer> m2;
    private MatriuImpl<Integer> m3;
    //--------------------------------------------------------------------------

    // MATRIUS TRIVIALS
    private MatriuImpl<Integer> t1;
    private MatriuImpl<Character> t2;
    private MatriuImpl<String> t3;

    // MATRIU D'ENTERS SIMÈTRICA
    private MatriuImpl<Integer> r1s;
    Integer matriuR1S2[]
            = {1, 2,
                2, 1};

    Integer matriuR1S3[]
            = {1, 2, 3,
                2, 1, 5,
                3, 5, 1};

    Integer matriuR1S4[]
            = {1, 2, 3, 4,
                2, 1, 5, 6,
                3, 5, 1, 7,
                4, 6, 7, 1};

    // MATRIU D'ENTERS ASIMÈTRICA (SIMÈTRICA FINS 3X3)
    private MatriuImpl<Integer> r1a;
    Integer matriuR1A2[]
            = {1, 2,
                2, 1};

    Integer matriuR1A3[]
            = {1, 2, 9,
                2, 1, 10,
                9, 10, 1};

    Integer matriuR1A4[]
            = {1, 2, 9, 4,
                2, 1, 10, 8,
                9, 10, 1, 12,
                4, 8, 13, 1};

    // MATRIU DE CARÀCTERS SIMÈTRICA
    private MatriuImpl<Character> r2s;
    Character matriuR2S2[]
            = {'a', 'a',
                'a', 'b'};

    Character matriuR2S3[]
            = {'a', 'a', 'a',
                'a', 'b', 'b',
                'a', 'b', 'c'};

    Character matriuR2S4[]
            = {'a', 'a', 'a', 'a',
                'a', 'b', 'b', 'b',
                'a', 'b', 'c', 'c',
                'a', 'b', 'c', 'd'};

    // MATRIU DE CARÀCTERS ASIMÈTRICA (SIMÈTRICA FINS 2X2)
    private MatriuImpl<Character> r2a;
    Character matriuR2A2[]
            = {'a', 'a',
                'a', 'a'};

    Character matriuR2A3[]
            = {'a', 'a', 'e',
                'a', 'a', 'f',
                'e', 'c', 'g'};

    Character matriuR2A4[]
            = {'a', 'a', 'e', 'a',
                'a', 'a', 'f', 'b',
                'e', 'c', 'g', 'e',
                'a', 'b', 'c', 'd'};

    @Before
    public void setUp() throws Exception {
        Integer matriu1[] = {0, 1, 2, 1, 1, 2, 2, 2, 3};
        Integer matriu2[] = {0, 1, 2, 3, 1, 2, 2, 2, 3};
        Integer matriu3[] = {0, 1, 2, 1, 1, 2};
        m1 = new MatriuImpl<>(matriu1, 3, 3);
        m2 = new MatriuImpl<>(matriu2, 3, 3);
        m3 = new MatriuImpl<>(matriu3, 2, 3);
        //----------------------------------------------------------------------

        // MATRIUS TRIVIALS
        Integer matriuT1[] = {1};
        Character matriuT2[] = {'a'};
        String matriuT3[] = {"a"};

        t1 = new MatriuImpl<>(matriuT1, 1, 1);
        t2 = new MatriuImpl<>(matriuT2, 1, 1);
        t3 = new MatriuImpl<>(matriuT3, 1, 1);
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
     * PROOF DEL MÈTODE RECURSIU PER COMPROVAR LA SIMETRIA D'UNA MATRIU
     *
     * Els diferents estats de la precondició sempre es compliran:
     *
     * • Els nombres de files/columnes menors o iguals a zero provocaran
     * excepcions en l'execució del programa, forçant així aquesta precondició
     * si es vol executar el programa.
     *
     * • Donat que les matrius sobre les que s'executen els mètodes creats són
     * les de la pròpia classe MatriuImpl, per definició aquestes estaran
     * organitzades en ordre row-major.
     *
     * • De la mateixa forma que amb el nombre de files i columnes, si la matriu
     * proporcionada és nul·la, el codi no es podrà executar correctament degut
     * a l'aparició d'excepcions. Per tant també es força aquesta precondició.
     *
     * A més, clarament el volum de les dades es redueix cada recursió, ja que
     * si bé no es dona el cas d'una matriu 1x1, o que aquesta sigui no
     * simètrica segons el retorn del mètode filaColSimetrica, es farà una
     * cridada recursiva sempre per definició reduint en 1 el valor de files i
     * columnes; prèviament establert a la cridada anterior.
     *
     * També serà correcte i comprovable a través dels tests, que sempre que una
     * matriu sigui simètrica segons la definició matemàtica, el programa
     * retornarà el valor true, i false si no; complint així la postcondició.
     */
    /**
     * Comprovació de que es compleix el cas trivial (cas sense recursió).
     */
    @Test
    public void testCompleixCasTrivial() {
        System.out.println("----------------------");
        System.out.println("TEST CAS TRIVIAL");
        assertTrue(t1.isSymmetricalRecursiu());
        assertTrue(t3.isSymmetricalRecursiu());
        assertTrue(t2.isSymmetricalRecursiu());
        System.out.println("OK");
        System.out.println("----------------------");
    }

    /**
     * Comprovació del compliment de la precondició en diferents punts de
     * l'execució del codi, "imitant" les passes del programa (demostració de
     * que els paràmetres a cridades recursives com les simulades sempre
     * satisfaran la precondició i el seu valor minvarà).
     */
    @Test
    public void testPrecondicioSatisfeta() {

        System.out.println("----------------------");
        System.out.println("TEST CASOS INTERMITJOS");

        //----------------------------------------------------------------------
        // MATRIU D'ENTERS SIMÈTRICA
        // Comprovació simetria 4x4
        r1s = new MatriuImpl<>(matriuR1S4, 4, 4);
        assertTrue(r1s.isSymmetricalRecursiu());

        // Comprovació simetria 3x3
        r1s = new MatriuImpl<>(matriuR1S3, 3, 3);
        assertTrue(r1s.isSymmetricalRecursiu());

        // Comprovació simetria 2x2
        r1s = new MatriuImpl<>(matriuR1S2, 2, 2);
        assertTrue(r1s.isSymmetricalRecursiu());

        //----------------------------------------------------------------------
        // MATRIU D'ENTERS ASIMÈTRICA (SIMÈTRICA FINS 3X3)
        // Comprovació simetria 4x4
        r1a = new MatriuImpl<>(matriuR1A4, 4, 4);
        assertFalse(r1a.isSymmetricalRecursiu());

        // Comprovació simetria 3x3
        r1a = new MatriuImpl<>(matriuR1A3, 3, 3);
        assertTrue(r1a.isSymmetricalRecursiu());

        // Comprovació simetria 2x2
        r1a = new MatriuImpl<>(matriuR1A2, 2, 2);
        assertTrue(r1a.isSymmetricalRecursiu());

        //----------------------------------------------------------------------
        // MATRIU DE CARÀCTERS SIMÈTRICA
        // Comprovació simetria 4x4
        r2s = new MatriuImpl<>(matriuR2S4, 4, 4);
        assertTrue(r2s.isSymmetricalRecursiu());

        // Comprovació simetria 3x3
        r2s = new MatriuImpl<>(matriuR2S3, 3, 3);
        assertTrue(r2s.isSymmetricalRecursiu());

        // Comprovació simetria 2x2
        r2s = new MatriuImpl<>(matriuR2S2, 2, 2);
        assertTrue(r2s.isSymmetricalRecursiu());

        //----------------------------------------------------------------------
        // MATRIU DE CARÀCTERS ASIMÈTRICA (SIMÈTRICA FINS 2X2)
        // Comprovació simetria 4x4
        r2a = new MatriuImpl<>(matriuR2A4, 4, 4);
        assertFalse(r2a.isSymmetricalRecursiu());

        // Comprovació simetria 3x3
        r2a = new MatriuImpl<>(matriuR2A3, 3, 3);
        assertFalse(r2a.isSymmetricalRecursiu());

        // Comprovació simetria 2x2
        r2a = new MatriuImpl<>(matriuR2A2, 2, 2);
        assertTrue(r2a.isSymmetricalRecursiu());

        System.out.println("OK");
        System.out.println("----------------------");

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
     * Test idèntic al de la versió recursiva, però en iteratiu.
     */
    @Test
    public void testCompleixCasTrivialIteratiu() {
        System.out.println("----------------------");
        System.out.println("TEST CAS TRIVIAL ITERATIU");
        assertTrue(t1.isSymmetricalIteratiu());
        assertTrue(t3.isSymmetricalIteratiu());
        assertTrue(t2.isSymmetricalIteratiu());
        System.out.println("OK");
        System.out.println("----------------------");
    }

    /**
     * Test idèntic al de la versió recursiva, però en iteratiu.
     */
    @Test
    public void testPrecondicioSatisfetaIteratiu() {

        System.out.println("----------------------");
        System.out.println("TEST CASOS INTERMITJOS ITERATIU");

        //----------------------------------------------------------------------
        // MATRIU D'ENTERS SIMÈTRICA
        // Comprovació simetria 4x4
        r1s = new MatriuImpl<>(matriuR1S4, 4, 4);
        assertTrue(r1s.isSymmetricalIteratiu());

        // Comprovació simetria 3x3
        r1s = new MatriuImpl<>(matriuR1S3, 3, 3);
        assertTrue(r1s.isSymmetricalIteratiu());

        // Comprovació simetria 2x2
        r1s = new MatriuImpl<>(matriuR1S2, 2, 2);
        assertTrue(r1s.isSymmetricalIteratiu());

        //----------------------------------------------------------------------
        // MATRIU D'ENTERS ASIMÈTRICA (SIMÈTRICA FINS 3X3)
        // Comprovació simetria 4x4
        r1a = new MatriuImpl<>(matriuR1A4, 4, 4);
        assertFalse(r1a.isSymmetricalIteratiu());

        // Comprovació simetria 3x3
        r1a = new MatriuImpl<>(matriuR1A3, 3, 3);
        assertTrue(r1a.isSymmetricalIteratiu());

        // Comprovació simetria 2x2
        r1a = new MatriuImpl<>(matriuR1A2, 2, 2);
        assertTrue(r1a.isSymmetricalIteratiu());

        //----------------------------------------------------------------------
        // MATRIU DE CARÀCTERS SIMÈTRICA
        // Comprovació simetria 4x4
        r2s = new MatriuImpl<>(matriuR2S4, 4, 4);
        assertTrue(r2s.isSymmetricalIteratiu());

        // Comprovació simetria 3x3
        r2s = new MatriuImpl<>(matriuR2S3, 3, 3);
        assertTrue(r2s.isSymmetricalIteratiu());

        // Comprovació simetria 2x2
        r2s = new MatriuImpl<>(matriuR2S2, 2, 2);
        assertTrue(r2s.isSymmetricalIteratiu());

        //----------------------------------------------------------------------
        // MATRIU DE CARÀCTERS ASIMÈTRICA (SIMÈTRICA FINS 2X2)
        // Comprovació simetria 4x4
        r2a = new MatriuImpl<>(matriuR2A4, 4, 4);
        assertFalse(r2a.isSymmetricalIteratiu());

        // Comprovació simetria 3x3
        r2a = new MatriuImpl<>(matriuR2A3, 3, 3);
        assertFalse(r2a.isSymmetricalIteratiu());

        // Comprovació simetria 2x2
        r2a = new MatriuImpl<>(matriuR2A2, 2, 2);
        assertTrue(r2a.isSymmetricalIteratiu());

        System.out.println("OK");
        System.out.println("----------------------");
    }

}
