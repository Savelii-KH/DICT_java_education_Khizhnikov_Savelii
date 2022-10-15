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
        System.out.print("Guess the word: ");

        String answer = sc.nextLine();

        if (answer.equals(arr[arr_number])){
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
