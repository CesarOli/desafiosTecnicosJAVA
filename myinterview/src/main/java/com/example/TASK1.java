package com.example;
import java.util.Scanner;
/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
     public static class VerificaFrasePalindromo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Diga uma frase qualquer para detectar se é ou não um PALÍNDROMO: ");
            String input = scanner.nextLine().trim().toUpperCase();

            String[] palavras = input.split("\\s+");
            String juntar = String.join("", palavras);

            StringBuilder inverter = new StringBuilder();
            for(int i = juntar.length() -1; i>=0; i--) {
                inverter.append(juntar).charAt(i);
            }

            if(inverter.toString().equals(juntar)) {
                System.out.println(("A frase " + scanner + " é Palíndromo."));
            }
            else {
                System.out.println("Esta frase " + scanner + " não é um Palíndromo.");
            }

        }
     
        
     }
 
} 