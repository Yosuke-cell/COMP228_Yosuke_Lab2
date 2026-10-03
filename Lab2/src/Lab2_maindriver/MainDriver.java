package Lab2_maindriver;

import java.util.InputMismatchException;
import java.util.Scanner;


import La2_Bankaccoubt.BankAccount;
import Lab2_insufficientfundsexception.InsufficientFundsException;

public class MainDriver {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BankAccount[] accounts = new BankAccount[3];
		
		System.out.println("====Banking System====");
		// create account
		for(int i = 0; i < accounts.length; i++) {
			System.out.println("--- Enter detail for account " + (i + 1) + " ---");
			accounts[i] = createAccount();
			System.out.println("Account created: " + accounts[i]); 
		}
		
		
		// make deposit and withdraw
		for (BankAccount account : accounts) {
			System.out.println("--- Transaction for " + account.getAccountName() + " ---");
			
			makeDeposit(account);
			makeWithdraw(account);
		}
		
		//done
		System.out.println("=== final Account summary ===");
		for (BankAccount account : accounts) {
			System.out.println(account);
		}
		
		sc.close();
	}
	
	// static method for making bank account
	private static BankAccount createAccount() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				System.out.print("Enter your name: ");
				String name = sc.nextLine();
				
				System.out.print("Enter account number (9 digits): ");
				String number = sc.nextLine();
				
				System.out.print("Enter your initial balance: ");
				double balance = sc.nextDouble();
				sc.nextLine();
				
				return new BankAccount(number, name,  balance);
			} catch(IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage() + " Please try agein.");
				
			} catch(InputMismatchException e) {
				System.out.println("Error: Please enter a number for the balnce.");
				sc.nextLine();
			}
		}
	}

	//static method for making withdraw
	private static void makeWithdraw(BankAccount account) {
		// TODO Auto-generated method stub
		boolean done = false;
		while(!done) {
			try {
				
				System.out.print("Enter a amount of money to withdraw: ");
				double amount = sc.nextDouble();
				account.withdraw(amount);
				System.out.printf("Withdraw successful. New balance: $%.2f%n", account.getAccountBalance());
				done = true;
				
			} catch(IllegalArgumentException e) {
				
				System.out.println("Withraw failed: " + e.getMessage());
				
			} catch(InputMismatchException e){
				
				System.out.println("Withdraw failed: Please enter a number.");
				sc.nextLine();
				
			} catch(InsufficientFundsException e) {
				
				System.out.println("Error: " + e.getMessage());
				
			}
			
			finally {
				
				System.out.println("Withdraw processed");
				
			}
		}
	}

	private static void makeDeposit(BankAccount account) {
		// TODO Auto-generated method stub
		boolean done = false;
		while(!done) {
			try {
				
				System.out.print("Enter a amount of money to deposit: ");
				double amount = sc.nextDouble();
				account.deposit(amount);
				System.out.printf("Deposit successful. New balance: $%.2f%n", account.getAccountBalance());
				done = true;
				
			} catch(IllegalArgumentException e) {
				
				System.out.println("Deposit failed: " + e.getMessage());
				
			} catch(InputMismatchException e){
				
				System.out.println("Deposit failed: Please enter a number.");
				sc.nextLine();
			}finally {
				
				System.out.println("Deposit processed");
				
			}
	}
}
}