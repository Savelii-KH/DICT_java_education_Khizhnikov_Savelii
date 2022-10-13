package src.ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args){
        System.out.println("Hello! My name is Svinus.");
        System.out.println("I was created in 2022.");
        System.out.println("Please remind me your name.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("What a great name you have, "+ name + "!");
    }
}
