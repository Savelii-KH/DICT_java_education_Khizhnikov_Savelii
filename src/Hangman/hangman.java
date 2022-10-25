package src.Hangman;

import java.util.Random;
import java.util.Scanner;

public class hangman {

	public static String[] words = {"c++", "php", "lua", "java", "basic", "delphi", "pascal", "kotlin", "python", "javascript"};
	public static String word = words[new Random().nextInt(words.length)];
	public static Integer attempts = 0;
	public static String tire_word = new String(new char[word.length()]).replace("\0", "-");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("HANGMAN\n\n");
		while (attempts <= 7 && tire_word.contains("-")){
			System.out.println(tire_word);
			System.out.print("\nInput a letter: ");
			String input = sc.nextLine();
			game(input);
		}
		if (attempts == 7){
			System.out.println("You loose\n");
		}
		System.out.println("Thanks for playing!\nWe'll see how well you did in the next stage");
		sc.close();
	}

	public static void game(String letter){
		StringBuilder new_tire_word = new StringBuilder();
		for (int i = 0; i < word.length(); i++){
			if (word.charAt(i) == letter.charAt(0)){
				new_tire_word.append(letter.charAt(0));
			} else if (tire_word.charAt(i) != 45){
				new_tire_word.append(word.charAt(i));
			} else {
				new_tire_word.append("-");
			}
		}
		if (tire_word.equals(new_tire_word.toString())){
			attempts++;
			System.out.println("That letter doesn't appear in the word");
		} else {
			tire_word = new_tire_word.toString();
		}
		if (word.equals(tire_word)){
			System.out.println("Correct! You win! The word was '" + word + "'\n");
		}
	}
}