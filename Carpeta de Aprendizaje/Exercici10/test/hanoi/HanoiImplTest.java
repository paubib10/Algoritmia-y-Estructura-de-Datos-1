package hanoi;

import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la implementación de Hanoi (HanoiImpl). Se utilizan
 * casos de prueba para validar el correcto funcionamiento del algoritmo de las
 * Torres de Hanoi.
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class HanoiImplTest {

    private Stack<Integer> a;
    private Stack<Integer> b;
    private Stack<Integer> c;
    private Stack<Integer> copyAInit;
    private int h = 0;

    /**
     * Configura el entorno de prueba inicializando las torres y discos.
     */
    @Before
    public void setUp() {
        a = new Stack();
        b = new Stack();
        c = new Stack();

        for (int i = h; i > 0; i--) {
            a.push(i);
        }
        copyAInit = (Stack<Integer>) a.clone();
    }

    /**
     * Test del método recursiuHanoi con varios discos.
     */
    @Test
    public void testRecursiuHanoi() {
        System.out.println("recursiuHanoi");
        h = 5;
        setUp();
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());

        Hanoi pHanoi = new HanoiImpl();
        pHanoi.recursiuHanoi(h, a, b, c);

        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

    /**
     * Test del método recursiuHanoi con discos dispersos entre a y c.
     */
    @Test
    public void testRecursiuHanoiDiscosDispersos() {
        System.out.println("testRecursiuHanoiDiscosDispersos");
        h = 4;
        // Coloca algunos discos en la torre destino c
        c.push(4);
        c.push(3);
        setUp();

        Hanoi pHanoi = new HanoiImpl();
        pHanoi.recursiuHanoi(h, a, b, c);

        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

    /**
     * Test del método recursiuHanoi con un solo disco.
     */
    @Test
    public void testRecursiuHanoiOneDisco() {
        System.out.println("recursiuHanoiOneDisco");
        h = 1;
        setUp();
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());

        Hanoi pHanoi = new HanoiImpl();
        pHanoi.recursiuHanoi(h, a, b, c);

        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

}
