import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
	Bank b = new Bank();

	public void init() throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome.");

		boolean exit = false;
		while (!exit) {
			System.out.println("Make your choice: " + "\n1. Create user"
					+ "\n2. Transfer from source to target"
					+ "\n3. Details\n4. Exit");
			int choice = 0;
			boolean validInput;
			do {
				validInput = true;
				try {
					choice = input.nextInt();
				} catch (InputMismatchException e) {
					validInput = false;
					System.out.println("Wrong input.");
					input.nextLine();
				}
			} while (!validInput);

			switch (choice) {
			case 1:
				try {
					System.out.println("Enter user number: ");
					int num = input.nextInt();
					input.nextLine();
					System.out.println("Enter user name: ");
					String name = input.nextLine();
					System.out.println("Enter user balance: ");
					double balance = input.nextDouble();
					b.createUser(num, name, balance);

				} catch (InputMismatchException e) {
					System.out.println("Wrong input.");
					input.nextLine();
				}
				break;

			case 2:
				try {
					System.out.println("Enter source account number: ");
					int sourceNum = input.nextInt();
					System.out.println("Enter target account number: ");
					int targetNum = input.nextInt();
					System.out.println("Enter amount to transfer: ");
					double amount = input.nextDouble();
					b.transfer(sourceNum, targetNum, amount);
					
				} catch (InputMismatchException e) {
					System.out.println("Wrong input.");
					input.nextLine();
				}
				break;

			case 3:
				System.out.println("Details of all existing accounts: ");
				b.details();
				break;
			case 4:
				System.out.println("Thank you for using this app. Good bye.");
				input.close();
				exit = true;
				break;
			default: 
				System.out.println("Please enter a number between 1-4.");
			}
		
		}

	}
}
