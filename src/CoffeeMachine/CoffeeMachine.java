package src.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("Write how many cups of coffee you will need:");
		System.out.print("~ ");

		long cups = sc.nextLong();

		System.out.printf("\nFor %s cups of coffee you will need:", cups);
		System.out.printf("\n%s ml of water", cups * 200);
		System.out.printf("\n%s ml of milk", cups * 50);
		System.out.printf("\n%s g of coffee beans", cups * 15);
	}
}
