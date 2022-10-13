package src.ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args){
        System.out.println("Hello! My name is Svinus.");
        System.out.println("I was created in 2022.");
        System.out.println("Please remind me your name.");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("What a great name you have, "+ name + "!");
        System.out.println("Lets me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        int remainder_3 = scanner.nextInt();
        int remainder_5 = scanner.nextInt();
        int remainder_7 = scanner.nextInt();
        int guessed_age = (remainder_3 * 70 + remainder_5 * 21 + remainder_7 * 15) % 105;

        System.out.println("Your age is " + guessed_age + "; that's a good time to start programming!");
    }
}
