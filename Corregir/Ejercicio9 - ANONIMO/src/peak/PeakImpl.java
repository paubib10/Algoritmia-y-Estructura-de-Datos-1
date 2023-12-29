/**
 * Especificación formal del algoritmo utilizando lógica de predicados:
 * 
 * Supongamos que el array tiene longitud n
 * Llamaremos al índice donde esta la cima i.
 * Definimos el predicado P(x,i) como verdadero si x es la cima y i es el índice 
 * de la cima, y falso en otro caso.
 * 
 * P(x,i)≡(a[i]=x)∧(a[i]>a[i−1])∧(a[i]>a[i+1])
 * 
 * 
 * El algoritmo implementado utiliza una búsqueda binaria para encontrar la cima. 
 * En cada iteración, se divide el espacio de búsqueda por la mitad, lo que 
 * lleva a un tiempo de ejecución de O(log n). Por lo tanto, la complejidad 
 * temporal del algoritmo es O(log n). La complejidad espacial es O(1), ya que
 * no se utiliza espacio adicional en relación con el tamaño del array de entrada.
*/


package peak;

import java.awt.Point;
/*
 * @author antoni
*/
public class PeakImpl implements Peak {

    @Override
    public Point peak(int[] a) {
        return findPeak(a, 0, a.length - 1);
    }

    private Point findPeak(int[] a, int left, int right) {
        if (left == right) {
            // Caso base: solo hay un elemento, que es la cima
            return new Point(a[left], left);
        }

        int mid = left + (right - left) / 2;

        if (a[mid] > a[mid + 1]) {
            // La cima está en la mitad izquierda
            return findPeak(a, left, mid);
        } else {
            // La cima está en la mitad derecha
            return findPeak(a, mid + 1, right);
        }
    }
}
