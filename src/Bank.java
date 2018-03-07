import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Bank {
	Bank() {

	}

	ArrayList<User> users = new ArrayList<>();
	Path userPath = Paths.get("users.txt");

	public void writeUser() throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(userPath);
		for (User u1 : users) {
			writer.write(u1.getUserNum() + " " + u1.getUserName() + " " + u1.getAccBalance());
			writer.newLine();
		}
		writer.flush();
	}

	public void readUser() throws IOException {
		BufferedReader reader = Files.newBufferedReader(userPath);
		users.clear();
		String temp;
		while ((temp = reader.readLine()) != null) {
			String[] arr = temp.split(" ");
			User tempUser = new User(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]));
			users.add(tempUser);
		}
		reader.close();
	}

	public void createUser(int userNum, String userName, double accBalance) throws IOException {
		readUser();
		User newUser = new User(userNum, userName, accBalance);
		if (validUser(newUser)) {
			users.add(newUser);
			writeUser();
		} else {
			System.out.println("Can't add user.");
		}
	}

	public void transfer(int sourceAccount, int targetAccount, double amount) throws IOException {
		readUser();
		boolean validSource = false;
		boolean validTarget = false;
		double sourceAmount = 0;
		int sourceIndex = 0;
		int targetIndex = 0;
		for (User user : users) {
			if(user.userNum == sourceAccount){
				validSource = true;
				sourceAmount = user.getAccBalance();
				sourceIndex = users.indexOf(user);
			}
			else if(user.userNum == targetAccount){
				validTarget = true;
				targetIndex = users.indexOf(user);
			}
		}
		if (validSource && validTarget && sourceAmount >= amount) {
			users.get(sourceIndex).setAccBalance(users.get(sourceIndex).accBalance - amount);
			users.get(targetIndex).setAccBalance(users.get(targetIndex).accBalance + amount);
			System.out.println("Succesfull transfer.");
			writeUser();
		}else{
			System.out.println("Transfer is not available.");
		}
	}

	public boolean validUser(User u) {
		for (User user : users) {
			if (user.getUserNum() == u.getUserNum()) {
				return false;
			}
		}
		if (u.getUserNum() < 0) {
			return false;
		}
		if (u.getAccBalance() < 0) {
			return false;
		}
		return true;
	}
	
}
