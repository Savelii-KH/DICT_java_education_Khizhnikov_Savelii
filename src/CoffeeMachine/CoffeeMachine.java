package src.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
	private static final Scanner sc = new Scanner(System.in);
	private static final float[] components = new float[3];

	public static void main(String[] args){
		System.out.print("Write how many ml of water the coffee machine has: ");
		int water = sc.nextInt();
		components[0] = (int) Math.floor(water / 200.0);

		System.out.print("Write how many ml of milk the coffee machine has: ");
		int milk = sc.nextInt();
		components[1] = milk % 50;

		System.out.print("Write how many grams of coffee beans the coffee machine has: ");
		int beans = sc.nextInt();
		components[2] = beans % 15;

		System.out.print("Write how many cups of coffee you will need: ");
		int cups = sc.nextInt();

		if (cups < min()){
			System.out.printf("Yes, I can make that amount of coffee and even %s more than that", min() - cups);
		} else if (cups == min()){
			System.out.print("Yes, I can make that amount of coffee");
		} else {
			System.out.printf("No, I can make only %s cups of coffee", min());
		}
	}

	private static int min(){
		float min = components[0];
		for (int i = 1; i < components.length; i++){
			if (min < components[i]){
				min = components[i];
				System.out.println(min);
			}
		}
		return (int) min;
	}
}
