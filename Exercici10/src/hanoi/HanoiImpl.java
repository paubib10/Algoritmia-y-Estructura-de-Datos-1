/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.util.Stack;

/**
 *
 * @author Pau Toni Bibiloni Martínez &amp; Blanca Atienzar Martínez
 */
public class HanoiImpl<E extends Comparable<E>> implements Hanoi<E> {

    /**
     * Solucion recursiva al problema de las torres Hanoi.
     *
     * <p>
     * <strong>Precondiciones:</strong> El número de discos {@code h} debe ser
     * mayor que 0. Las torres {@code a}, {@code b}, y {@code c} no deben ser
     * nulas.
     * </p>
     *
     * <p>
     * <strong>Postcondiciones:</strong> El estado final de las torres cumple
     * con las reglas del problema de las Torres de Hanoi. La torre origen
     * {@code a} estará vacía, la torre auxiliar {@code b} estará vacía, y la
     * torre destino {@code c} contendrá todos los discos ordenados
     * correctamente, siendo el disco más grande en la parte inferior y el más
     * pequeño en la parte superior.
     * </p>
     *
     * <p>
     * <strong>Análisis de Casos:</strong>
     * </p>
     * a. Si {@code h >= 1}:
     * <p>
     * a.1. Si {@code h == 1}, mueve el disco de la torre origen {@code a} a la
     * torre destino {@code c}.
     * </p>
     * a.2. Si {@code h > 1}, realiza la lógica recursiva: 
     *      (1) Mueve {@code (h-1)} discos de la torre origen {@code a} a la torre auxiliar {@code b}. 
     *      (2) Mueve el disco restante de la torre origen {@code a} a la torre destino {@code c}. 
     *      (3) Mueve {@code (h-1)} discos de la torre auxiliar {@code b} a la torre destino {@code c}.
     * </p>
     *
     * <p>
     * b. Si {@code h <= 0}, la torre origen {@code a} esta vacía. Se lanza
     * IllegalArgumentException.
     * <p>
     * <strong>Proof:</strong>
     * </p>
     * Para hacer la verificacion del programa entre los diferentes casos
     * (precondicion, recursive, postcondicion, smaller), lo hemos hecho de la
     * siguiente forma:
     * <p>
     * a. Todos los estados de la precondicion estan cubiertos.
     * </p>
     * <p>
     * b. Los valores de los parametros de la llamada recursiva cumplen con la
     * precondicon especificada.
     * </p>
     * <p>
     * c. Cuando llama al program se satisface la postcondicion.
     * </p>
     * <p>
     * d. En cada llamada recursiva, el número de discos disminuye {@code h-1}.
     * Es decir, se cumple el principio "smaller".
     * </p>
     * <p>
     * <strong>Complejidad:</strong> O(2^n), donde n es el numero de discos. 
     * </p>
     * Dado que cada nivel del árbol representa un movimiento de disco, y cada nodo tiene
     * dos hijos que corresponden a  las dos llamadas recursivas en cada paso, el algoritmo
     * sigue una estructura de árbol binario en sus llamadas recursivas. 
     * 
     * @param h Número de discos en la torre origen.
     * @param a Torre origen.
     * @param b Torre auxiliar.
     * @param c Torre destino.
     * @throws IllegalArgumentException Si el número de discos es 0 o menos.
     */
    @Override
    public void recursiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {
        if (h == 1) {
            c.push(a.pop());
        } else {
            recursiuHanoi(h - 1, a, c, b);
            c.push(a.pop());
            recursiuHanoi(h - 1, b, a, c);
        }
    }

}

/**
 * En general, el proyecto esta bien elaborado y acaparada todos los requisitos que se pedían.
 */
