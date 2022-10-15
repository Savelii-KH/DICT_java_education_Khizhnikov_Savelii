package src.Hangman;

import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args){
        String[] arr = {"java", "kotlin", "python", "javascript"};

        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int arr_number = rn.nextInt(4);

        System.out.println("HANGMAN");
        System.out.print("Guess the word " + word_breaking(arr[arr_number]) + ": ");

        String answer = sc.nextLine();

        if (answer.equals(arr[arr_number])){
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }

    public static String word_breaking(String br_word){
        String[] breaking_word = br_word.split("");
        String[] word = new String[breaking_word.length];

        for (int i = 0; i < breaking_word.length; i++){
            if (i <= 1) {
                word[i] = breaking_word[i];
            } else {
                word[i] = "-";
            }
        }
        return String.join("", word);
    }
}
