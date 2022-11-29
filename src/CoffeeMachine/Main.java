package src.CoffeeMachine;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		CoffeeMachine coffee_machine = new CoffeeMachine(1000, 1000, 1000, 100, 300);
		Scanner sc = new Scanner(System.in);
		System.out.println("Write action (buy, fill, take, remaining, exit):");
		while (true){
			String answer = sc.nextLine();
			coffee_machine.menu(answer);
			System.out.println("Write action (buy, fill, take, remaining, exit):");
		}
	}
}
