/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backtracking;

/**
 * Interfície per al mètodes de Backtracking que implementarem durant les
 * sessions pràctiques
 * @author antoni
 */
public interface Backtracking {
    
    /**
     * Mètode per resoldre el problema de la motxilla. w.length == p.lenght AND
     * w.length > 0
     * @param W pes màxim de la motxilla, >0
     * @param w conjunt de pesos de cada element, cada w[i] > 0
     * @param p conjunt del profit de cada element, cada p[i] > 0
     * @return selecció més òptima
     */
    public int[] knapSack(int W, int w[], int p[]);
}
