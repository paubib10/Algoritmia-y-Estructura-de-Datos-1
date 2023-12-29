package exercici2;

public class Exercici2 {

    public static void main(String[] args) {
        try {
            
            // Ejemplo 1: Pila Genérica con Cursores
            System.out.println("\nPila Genérica con Cursores:");
            PilaCursores<Integer> pila1 = new PilaCursores<>(10);
            pila1.push(1);
            pila1.push(3);
            pila1.push(6);
            pila1.push(8);
            System.out.println("Elemento en la cima: " + pila1.cima());
            pila1.pop();
            System.out.println("Elemento en la cima después del pop: " + pila1.cima());

            // Ejemplo 2: Pila Genérica con Punteros
            System.out.println("\nPila Genérica con Punteros:");
            PilaPunteros<Integer> pila2 = new PilaPunteros<>();
            pila2.push(2);
            pila2.push(5);
            pila2.push(7);
            pila2.push(9);
            System.out.println("Elemento en la cima: " + pila2.cima());
            pila2.pop();
            System.out.println("Elemento en la cima después del pop: " + pila2.cima());

        } catch (IllegalStateException ex) { // Excepciones
            ex.printStackTrace();
        }
    }
}

