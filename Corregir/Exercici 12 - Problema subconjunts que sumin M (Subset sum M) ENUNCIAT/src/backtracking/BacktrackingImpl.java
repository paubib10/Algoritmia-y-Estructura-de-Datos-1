/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.ArrayList;

/**
 * Classe implementació Backtracking
 *
 * @author Joan Matemalas Rossello i Constantino Pérez Palacios
 */
public class BacktrackingImpl implements Backtracking {
/**
 * P={ int[]a!=null}
 */
    @Override
    public ArrayList<ArrayList<Integer>> sumM(int[] a, int M) {
        ArrayList<ArrayList<Integer>> subconjuntos = new ArrayList<>();
        backtrack(a, 0, new ArrayList<>(), 0, M, subconjuntos);
        return subconjuntos;
    }

    private void backtrack(int[] conjunto, int indiceActual, ArrayList<Integer> subconjuntoActual,
                           int sumaActual, int M, ArrayList<ArrayList<Integer>> subconjuntos) {
       
        /**
         * Caso base
         */
        
        if (sumaActual == M) {
            subconjuntos.add(new ArrayList<>(subconjuntoActual));
        }

        /**
         * resta de casos
         */
        for (int i = indiceActual; i < conjunto.length; i++) {
            subconjuntoActual.add(conjunto[i]);
            // Llamada recursiva para explorar más elementos
            backtrack(conjunto, i + 1, subconjuntoActual, sumaActual + conjunto[i], M, subconjuntos);
            // Eliminar el último elemento para probar otros subconjuntos
            subconjuntoActual.remove(subconjuntoActual.size() - 1);
        }
        /**
         * Q={Suma elementos subconjuntos = M}
         */
    }
    /**
     * L'ordre de complexitat es O(n) degut a que hi ha nomes una cridada recursiva i el cost de la part no recursiva es alpha=0;
     */
 }

