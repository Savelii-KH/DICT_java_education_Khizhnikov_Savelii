package src.Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {

	private static final String[] words = {"c++", "php", "lua", "java", "basic", "delphi", "pascal", "kotlin", "python", "javascript"};
	private static final String[] letters = {"\0"};
	private static final Scanner sc = new Scanner(System.in);
	private static String word = words[new Random().nextInt(words.length)];
	private static String tire_word = new String(new char[word.length()]).replace("\0", "-");
	private static Integer attempts = 0;

	public static void menu(){
		System.out.print("HANGMAN\n\nType \"play\" to play the game, \"exit\" to quit: ");
		String answer = sc.nextLine();

		if (answer.equalsIgnoreCase("exit")){
			System.out.println("Goodbye, see your next time");
			System.exit(0);
		} else if (answer.equalsIgnoreCase("play")){
			while (attempts <= 7 && tire_word.contains("-")){
				System.out.println("\n" + tire_word);
				System.out.print("Input a letter: ");

				String input = sc.nextLine();
				input_length(input);
			}
		} else {
			menu();
		}
	}

	private static void input_length(String input){
		if (input.length() == 1){
			int code = input.charAt(0);
			registry_check(code);
		} else System.out.println("You should input a single letter.\n");
	}

	private static void registry_check(Integer code){
		if (code >= 97 && code <= 122 || code == 43){
			String input = Character.toString(code);
			duplicate_checking(input);
		} else System.out.println("Please enter a lowercase English letter.\n");
	}

	private static void duplicate_checking(String input){
		if (input.contains(letters[0])){
			System.out.println("You've already guessed this letter.\n");
		} else {
			letters[0] = input;
			game(input);
		}
	}

	private static void game(String letter) {
		StringBuilder new_tire_word = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter.charAt(0)) {
				new_tire_word.append(letter.charAt(0));
			} else if (tire_word.charAt(i) != 45) {
				new_tire_word.append(word.charAt(i));
			} else {
				new_tire_word.append("-");
			}
		}
		win_check(new_tire_word, letter);
	}

	private static void win_check(StringBuilder new_tire_word, String letter){
		if (tire_word.contains(letter)) {
			attempts++;
			System.out.println("No improvements");
		} else if (tire_word.equals(new_tire_word.toString())){
			attempts++;
			System.out.println("That letter doesn't appear in the word\n");
		} else {
			tire_word = new_tire_word.toString();
		}
		if (word.equals(tire_word)){
			System.out.println("\nYou guessed the word! The word was '" + word + "'.\nYou survived!\n");
			word = words[new Random().nextInt(words.length)];
			tire_word = new String(new char[word.length()]).replace("\0", "-");
			attempts = 0;
			menu();
		}
		if (attempts == 7){
			System.out.println("You lost\n");
			word = words[new Random().nextInt(words.length)];
			tire_word = new String(new char[word.length()]).replace("\0", "-");
			attempts = 0;
			menu();
		}
	}
}