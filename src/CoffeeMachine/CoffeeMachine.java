package src.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	private static final Scanner sc = new Scanner(System.in);
	private int water, milk, beans, cup, money;

	public CoffeeMachine (int water_in, int milk_in, int beans_in, int cups_in, int money_in){
		this.water = water_in;
		this.milk = milk_in;
		this.beans = beans_in;
		this.cup = cups_in;
		this.money = money_in;
	}

	public  void menu (String answer) {
		switch (answer){
			case "buy" -> buy();
			case "fill" -> fill();
			case "take" -> take();
			case "remaining" -> remaining();
			case "exit" -> System.exit(0);
			default -> System.out.println("Incorrect operation");
		}
	}

	private void fill(){
		System.out.println("Write how many ml of water you want to add: ");
		water += sc.nextInt();
		System.out.println("Write how many ml of milk you want to add: ");
		milk += sc.nextInt();
		System.out.println("Write how many grams of coffee beans you want to add: ");
		beans += sc.nextInt();
		System.out.println("Write how many disposable coffee cups you want to add: ");
		cup += sc.nextInt();
	}

	private void remaining(){
		System.out.println("The coffee machine has:");
		System.out.printf("%d of water\n", water);
		System.out.printf("%d of milk\n", milk);
		System.out.printf("%d of coffee beans\n", beans);
		System.out.printf("%d of disposable cups\n", cup);
		System.out.printf("%d of money\n", money);
	}

	private void take(){
		System.out.printf("I gave you %d\n", money);
		money = 0;
	}

	private void buy(){
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to menu: ");
		String input = sc.nextLine();
		switch (input){
			case "1" -> espresso();
			case "2" -> latte();
			case "3" -> cappuccino();
			case "back" -> System.out.println("Back to menu");
			default -> {
				System.out.println("You have to choose something between 1 and 3");
				buy();
			}
		}
	}

	private String component_count_check(int water_c, int milk_c, int beans_c){
		if (water < water_c){
			return "Sorry, not enough water!";
		} else if (milk < milk_c){
			return "Sorry, not enough milk!";
		} else if (beans < beans_c){
			return "Sorry, not enough coffee beans!";
		} else if (cup < 1){
			return "Sorry, not enough cups!";
		}
		System.out.println("I have enough resources, making you a coffee!");
		return "enough";
	}

	private void cappuccino(){
		if (component_count_check(200, 100, 12).equals("enough")) {
			water -= 200;   		//pick water
			milk -= 100;	    	//pick milk
			beans -= 12;	    	//pick coffee beans
			cup -= 1;        		//pick cup
			money += 6;        		//add money
		} else {
			System.out.println(component_count_check(200, 100, 12));
		}
	}

	private void espresso(){
		if (component_count_check(250, 0, 16).equals("enough")) {
			water -= 250;       	//pick water
			beans -= 16;       		//pick coffee beans
			cup -= 1;         		//pick cup
			money += 4;         	//add money
		} else {
			System.out.println(component_count_check(250, 0, 16));
		}
	}

	private void latte(){
		if (component_count_check(350, 75, 20).equals("enough")) {
			water -= 350;       	//pick water
			milk -= 75;       		//pick milk
			beans -= 20;        	//pick coffee beans
			cup -= 1;         		//pick cup
			money += 7;         	//add money
		} else {
			System.out.println(component_count_check(350, 75, 20));
		}
	}
}