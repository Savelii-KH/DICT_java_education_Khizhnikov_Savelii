package src.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	private static final Scanner sc = new Scanner(System.in);
	private static int[] components = {400, 540, 120, 9, 550};

	public static void main(String[] args) {
		display();
		System.out.println("Write action (buy, fill, take): ");
		String answer = sc.nextLine();
		menu(answer);
	}

	private static void display(){
		System.out.println("The coffee machine has:");
		System.out.printf("%d of water\n", components[0]);
		System.out.printf("%d of milk\n", components[1]);
		System.out.printf("%d of coffee beans\n", components[2]);
		System.out.printf("%d of disposable cups\n", components[3]);
		System.out.printf("%d of money\n", components[4]);
	}

	public static void menu (String answer) {
		System.out.println("Write action (buy, fill, take): ");
		if (answer.equalsIgnoreCase("fill")){
			fill();
		} else if (answer.equalsIgnoreCase("take")){
			take();
		} else if (answer.equalsIgnoreCase("buy")){
			buy();
		} else {
			System.out.println("Incorrect operation");
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

		display();
	}

	private static void take(){
		System.out.printf("I gave you %d", components[4]);

		components[4] = 0;

		display();
	}

	private static void buy(){
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
		int input = sc.nextInt();

		if (input == 1){
			espresso();
		} else if (input == 2){
			latte();
		} else if (input == 3){
			cappuccino();
		} else {
			System.out.println("You have to choose something between 1 and 3");
			buy();
		}
	}

	private static void espresso(){
		components[0] -= 250;
		components[2] -= 16;
		components[3] -= 1;
		components[4] += 4;

		display();
	}

	private static void latte(){
		components[0] -= 350;
		components[1] -= 75;
		components[2] -= 20;
		components[3] -= 1;
		components[4] += 7;

		display();
	}

	private static void cappuccino(){
		components[0] -= 200;
		components[1] -= 100;
		components[2] -= 12;
		components[3] -= 1;
		components[4] += 6;

		display();
	}
}

