package src.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	private static final Scanner sc = new Scanner(System.in);
	private static int[] components = new int[3];

	public static void main(String[] args){
		System.out.print("Write how many ml of water the coffee machine has: ");
		int water = sc.nextInt();
		components[0] = Math.floor(water / 200);

		System.out.print("Write how many ml of milk the coffee machine has: ");
		int milk = sc.nextInt();
		components[1] = milk % 50;

		System.out.print("Write how many grams of coffee beans the coffee machine has: ");
		int beans = sc.nextInt();
		components[2] = beans % 15;

		System.out.print("Write how many cups of coffee you will need: ");
		int cups = sc.nextInt();

		if (cups < min(components)){
			System.out.printf("Yes, I can make that amount of coffee and even %s more than that", min(components));
		} else if (cups == min(components)){
			System.out.print("Yes, I can make that amount of coffee");
		} else {
			System.out.printf("No, I can make only %s cups of coffee", min(components));
		}
	}

	private static int min(int[] arr){
		int min = arr[0];
		for (int i = 1; i < arr.length; i++){
			if (min < arr[i]){
				min = arr[i];
				System.out.println(min);
			}
		}
		return min;
	}
}
