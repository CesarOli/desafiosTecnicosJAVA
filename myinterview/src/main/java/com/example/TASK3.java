package com.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.List;


/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */
public class TASK3 {
    public static void main(String[] args) {

        //criação da lista
        List<String> minhaLista = gerarListaAleatoria();

        //impressao da lista
        System.out.println("Lista criada: " + minhaLista); 

        //contando quantidade de itens distintos
        int itensDistintos = contarItensDistintos(minhaLista);
        
        // impressão quantidade de itens distintos
        System.out.println("A quantidade de itens distintos é: " + itensDistintos);
    }
    private static List<String> gerarListaAleatoria() {
        Random random = new Random();
        int quantidadeDeItens = random.nextInt(12) + 1; // adição de 1 a 12 itens aleatórios

        List<String> lista = new ArrayList<String>();
        for (int i = 0; i < quantidadeDeItens; i++) {
            lista.add("Item" + i);
        }
        return lista;
    }
    private static int contarItensDistintos(List<String> lista) {
        Set<String> conjuntoDistintos = new HashSet<String>(lista);
        return conjuntoDistintos.size();
    }
}
