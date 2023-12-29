/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package heap;

/**
 * Interfície base per implementar algorisme d'ordenació basat amb un monticle
 * @author antoni
 */
public interface HeapSort <E extends Comparable<E>> {
    
    /**
     * Donat un conjunt de dade h, l'ordena
     * @param h conjunt de dades que s'ordenarà
     */
    public void heapSort(E[] h);
}
