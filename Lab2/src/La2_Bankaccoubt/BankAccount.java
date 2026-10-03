package La2_Bankaccoubt;

import Lab2_insufficientfundsexception.InsufficientFundsException;

public class BankAccount {

	private String ac_number;
	private String ac_name;
	private double ac_balance;
	
	public BankAccount(String ac_number, String ac_name, double ac_balance) {
		
		
		if(ac_number.isEmpty() || !ac_number.matches("\\d{9}")) {
			throw new IllegalArgumentException("Account must be at least 9 digit.");
		}
		
		if(ac_name == null || ac_name.isEmpty()) {
			throw new IllegalArgumentException("Account name connot be blank."); 
		}
		
		if(ac_balance < 0) {
			throw new IllegalArgumentException("The balance cannot be negative.");
		}
		
		this.ac_number = ac_number;
		this.ac_name = ac_name;
		this.ac_balance = ac_balance;
	}
	
	public void deposit(double amount) throws IllegalArgumentException {
		
		
		if (amount <= 0) {
			throw new IllegalArgumentException("The amount cannnot be zero or negative");
		}
		
		ac_balance += amount;
	}
	
	public void withdraw(double amount) throws IllegalArgumentException, InsufficientFundsException{
	
		
		if(amount > ac_balance) {
			throw new InsufficientFundsException("The amount cannot exceed balance");
		}
		if(amount <= 0) {
			throw new IllegalArgumentException("The amount cannot be zero or negative");
		}
		
		ac_balance -= amount;
	}
	
	public String getAccountNumber() {
		return ac_number;
	}
	
	public String getAccountName() {
		return ac_name;
	}
	
	public double getAccountBalance() {
		return ac_balance;
	}

	@Override 
	public String toString() {
		return String.format("Account Name: %s | Account Number: %s | Account Balance: $%.2f", ac_name, ac_number, ac_balance);
	}


}
