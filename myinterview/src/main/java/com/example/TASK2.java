package com.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */


public class TASK2 {
    public static class ListaDeElementos {

        public static void main(String[] args) {
            
            //criação de uma lista
            List<String> minhaListaDeElementos = new ArrayList<String>();
            minhaListaDeElementos.add("Elemento 1");
            minhaListaDeElementos.add("Elemento 2");
            minhaListaDeElementos.add("Elemento 3");
            minhaListaDeElementos.add("Elemento 4");
            minhaListaDeElementos.add("Elemento 5");

            //impressão da lista original criada
            System.out.println("A lista original criada é: " + minhaListaDeElementos);

            //encontrando o índice do elemento do meio da lista criada.
            int tamanho = minhaListaDeElementos.size();
            int indiceDoElementoDoMeio = tamanho / 2;

            //removendo o elemento do meio da lista criada através do lopp 'for'
            for(int i = 0; i < minhaListaDeElementos.size(); i++) {
                if(i == indiceDoElementoDoMeio) {
                    minhaListaDeElementos.remove(i);
                    break; //interrupção do loop for
                }
            }
            //impressão da lista depois da remoção.
            System.out.println("Lista após remoção do elemento do meio: " + minhaListaDeElementos);
        }
    }
}