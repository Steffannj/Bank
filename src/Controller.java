import java.io.IOException;
import java.util.Scanner;

public class Controller {
	Bank b = new Bank();

	public void init() throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome.");
		try {
			while (true) {
				System.out.println("Make your choice: " + "\n1. Create user" + "\n2. Transfer from source to target"
						+ "\n3. Details");
				int choice = input.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter user number: ");
					int num = input.nextInt();
					input.nextLine();
					System.out.println("Enter user name: ");
					String name = input.nextLine();
					System.out.println("Enter user balance: ");
					double balance = input.nextDouble();
					b.createUser(num, name, balance);
					break;
				case 2:
					System.out.println("Enter source account number: ");
					int sourceNum = input.nextInt();
					System.out.println("Enter target account number: ");
					int targetNum = input.nextInt();
					System.out.println("Enter amount to transfer: ");
					double amount = input.nextDouble();
					b.transfer(sourceNum, targetNum, amount);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Wrong input.");
		}

	}
}
