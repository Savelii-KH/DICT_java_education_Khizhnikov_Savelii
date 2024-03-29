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

        System.out.println("Now I will prove to you that I can count to any number you want.");

        int numb = scanner.nextInt();

        for(int i = 0; i <= numb; i++){
            System.out.println(i + "!");
        }

        System.out.println("Let's test your knowledge of traffic rules.");
        System.out.println("The signs of which group introduce or cancel movement restrictions on the carriageway?");
        System.out.println("1. Informational and indicative signs\n2. Prohibition signs\n3. Priority signs\n4. Warning signs");

        while(true){
            int answer = scanner.nextInt();
            if(answer == 2){
                System.out.println("Great, you right!");
                break;
            } else {
                System.out.println("Please, try again.");
            }
        }
        System.out.println("Goodbye, have a nice day!");
    }
}
