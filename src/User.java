
public class User {
	int userNum;
	String userName;
	double accBalance;
	public User(int userNum, String userName, double accBalance) {
		this.userNum = userNum;
		this.userName = userName;
		this.accBalance = accBalance;
	}
	
	@Override
	public String toString() {
		return  userNum + userName + accBalance;
	}

	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	
	
}
