package src.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	private static final Scanner sc = new Scanner(System.in);
	private static int[] components = {400, 540, 120, 9, 550};

	public static void main(String[] args) {
		while (true) {
			System.out.println("Write action (buy, fill, take, remaining, exit): ");
			String answer = sc.nextLine();
			menu(answer);
		}
	}

	public static void menu (String answer) {
		switch (answer){
			case "buy" -> buy();
			case "fill" -> fill();
			case "take" -> take();
			case "remaining" -> remaining();
			case "exit" -> System.exit(0);
			default -> System.out.println("Incorrect operation");
		}
	}

	private static void fill(){
		System.out.println("Write how many ml of water you want to add: ");
		int water = sc.nextInt() + components[0];
		System.out.println("Write how many ml of milk you want to add: ");
		int milk = sc.nextInt() + components[1];
		System.out.println("Write how many grams of coffee beans you want to add: ");
		int coffee = sc.nextInt() + components[2];
		System.out.println("Write how many disposable coffee cups you want to add: ");
		int cups = sc.nextInt() + components[3];
		components = new int[]{water, milk, coffee, cups, components[4]};
	}

	private static void remaining(){
		System.out.println("The coffee machine has:");
		System.out.printf("%d of water\n", components[0]);
		System.out.printf("%d of milk\n", components[1]);
		System.out.printf("%d of coffee beans\n", components[2]);
		System.out.printf("%d of disposable cups\n", components[3]);
		System.out.printf("%d of money\n", components[4]);
	}

	private static void take(){
		System.out.printf("I gave you %d\n", components[4]);
		components[4] = 0;
	}

	private static void buy(){
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
		String input = sc.nextLine();
		switch (input){
			case "1" -> espresso();
			case "2" -> latte();
			case "3" -> cappuccino();
			default -> {
				System.out.println("You have to choose something between 1 and 3");
				buy();
			}
		}
	}

	private static String component_count_check(int water_c, int milk_c, int beans_c){
		if (components[0] < water_c){
			return "Sorry, not enough water!";
		} else if (components[1] < milk_c){
			return "Sorry, not enough milk!";
		} else if (components[2] < beans_c){
			return "Sorry, not enough coffee beans!";
		} else if (components[3] < 1){
			return "Sorry, not enough cups!";
		}
		System.out.println("I have enough resources, making you a coffee!");
		return "enough";
	}

	private static void cappuccino(){
		if (component_count_check(200, 100, 12).equals("enough")) {
			components[0] -= 200;   	//pick water
			components[1] -= 100;	    //pick milk
			components[2] -= 12;	    //pick coffee beans
			components[3] -= 1;        	//pick cup
			components[4] += 6;        	//add money
		} else {
			System.out.println(component_count_check(200, 100, 12));
		}
	}

	private static void espresso(){
		if (component_count_check(250, 0, 16).equals("enough")) {
			components[0] -= 250;       //pick water
			components[2] -= 16;       	//pick coffee beans
			components[3] -= 1;         //pick cup
			components[4] += 4;         //add money
		} else {
			System.out.println(component_count_check(250, 0, 16));
		}
	}

	private static void latte(){
		if (component_count_check(350, 75, 20).equals("enough")) {
			components[0] -= 350;       //pick water
			components[1] -= 75;        //pick milk
			components[2] -= 20;        //pick coffee beans
			components[3] -= 1;         //pick cup
			components[4] += 7;         //add money
		} else {
			System.out.println(component_count_check(350, 75, 20));
		}
	}
}

