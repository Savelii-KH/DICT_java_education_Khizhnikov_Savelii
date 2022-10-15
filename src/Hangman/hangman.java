package src.Hangman;

import java.util.Scanner;

public class hangman {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("HANGMAN");
        System.out.print("Guess the word: ");

        String answer = sc.nextLine();

        if (answer.equals("java")){
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
