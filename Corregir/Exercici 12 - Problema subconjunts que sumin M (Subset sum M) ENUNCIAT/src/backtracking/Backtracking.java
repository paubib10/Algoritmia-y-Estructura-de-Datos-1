/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backtracking;

import java.util.ArrayList;

/**
 * Interfície per al mètodes de Backtracking que implementarem durant les
 * sessions pràctiques
 * @author antoni
 */
public interface Backtracking {
    /**
     * Donat un conjunt numèric, trobar tots els subconjunts que sumen M
     * @param a conjunt númeric. Tots els elements a són >=0
     * @param M Resultat suma dels subconjunts. M>=0
     * @return conjunt dels subconjunts que sumen M
     */
    public ArrayList<ArrayList<Integer>> sumM(int a[], int M);
}
