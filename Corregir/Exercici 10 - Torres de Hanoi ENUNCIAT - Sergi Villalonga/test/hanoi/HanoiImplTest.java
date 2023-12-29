package hanoi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Stack;

public class HanoiImplTest {

    private Stack<Integer> a;
    private Stack<Integer> b;
    private Stack<Integer> c;
    private Stack<Integer> copyAInit;
    private int h;

    @Before
    public void setUp() {
        a = new Stack();
        b = new Stack();
        c = new Stack();
        h = 5;
        for (int i = h; i > 0; i--) {
            a.push(i);
        }
        copyAInit = (Stack<Integer>) a.clone();
    }

    @Test
    public void testRecursiuHanoiWithOddHeight() {
        System.out.println("recursiuHanoi - Altura impar");
        // Modifica el valor de h a un número impar
        h = 3;
        setUp();  // Restablecer las torres
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());
        Hanoi<Integer> pHanoi = new HanoiImpl<>();
        pHanoi.recursiuHanoi(h, a, b, c);
        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }


    @Test
    public void testRecursiuHanoiWithEvenHeight() {
        System.out.println("recursiuHanoi - Altura par");
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());
        Hanoi<Integer> pHanoi = new HanoiImpl<>();
        pHanoi.recursiuHanoi(h, a, b, c);
        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

    @Test
    public void testRecursiuHanoiWithSingleDisk() {
        System.out.println("recursiuHanoi - Un disco");
        // Modifica el valor de h a 1 para representar un solo disco
        h = 1;
        setUp();  // Restablecer las torres
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());
        Hanoi<Integer> pHanoi = new HanoiImpl<>();
        pHanoi.recursiuHanoi(h, a, b, c);
        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }


    @Test
    public void testRecursiuHanoiWithNoDisks() {
        System.out.println("recursiuHanoi - Sin discos");
        // Modifica el valor de h a 0 para representar ninguna torre
        h = 0;
        setUp();  // Restablecer las torres
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());
        Hanoi<Integer> pHanoi = new HanoiImpl<>();
        pHanoi.recursiuHanoi(h, a, b, c);
        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

}
