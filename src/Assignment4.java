import java.util.*;
import java.io.*;

class BankAtmException extends Exception {
	String str1;

	BankAtmException(String str2) {
		str1 = str2;
	}

	public String toString() {
		return ("BankAtmException Occurred: " + str1);
	}
}

class BankAtm {
	int atmId = 123456;
	String bankName = "ACADGILD BANK";
	String loaction = "Bangalore";
	double balance = 20000;

	public void withdrawl(double amount) {
		try {
			if (balance < 10000 || amount >= balance) {
				throw new BankAtmException("You don't have sufficient balance to withdrawl");
			} else {
				balance = balance - amount;

				System.out.println("Withdrawl successfull ");

			}
		} catch (BankAtmException exp) {
			System.out.println(exp);
		}

	}

	public void deposit(double amt) {
		balance = balance + amt;
		System.out.println("Deposit successful ");
	}

	public void displayBalance() {

		System.out.println("Your account balance is :" + this.balance);
		System.out.println("Thank you for banking");
	}

	public boolean validation(int n) {
		try {
			if (n != atmId) {
				throw new BankAtmException("Authentication failed !!! ");
			} else {
				System.out.println("Authentication successful ");
				return true;
			}
		} catch (BankAtmException exp) {
			System.out.println(exp);
			return false;
		}

	}

}

public class Assignment4 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the AtmID");
		int id = sc.nextInt();
		BankAtm b = new BankAtm();
		boolean authentication = b.validation(id);
		if (authentication) {
			System.out.println("Enter W for Withdrawl, D for Deposit ,B for Balance Enquery");
			String c = sc.next();
			switch (c) {
			case "W":
				System.out.println("Enter the amount to be withdrwn");
				b.withdrawl(sc.nextDouble());
				System.out.println(" Do you want to check your balance? Enter 'Yes' for balance enquery else enter 'No'");
				String s = sc.next();
				if (s.equals("Yes")) {
					b.displayBalance();
					System.out.println("Thank you for Banking");
				} 
				if(s.equals("No")) {
					System.out.println("Thank you for Banking");
				}
				break;
			case "D":
				System.out.println("Enter the amount want to deposit");
				b.deposit(sc.nextDouble());
				System.out.println(" Do you want to check your balance? Enter 'Yes' for balance enquery else enter 'No'");
				String r = sc.next();
				if (r.equals("Yes")) {
					b.displayBalance();
					System.out.println("Thank you for Banking");
				} 
				if(r.equals("No"))
				{
					System.out.println("Thank you for Banking");
				}
				break;
			case "B":
				b.displayBalance();
				break;
			default:
				System.out.println(" No option choosen");
			}
		} else {
			System.out.println("Please enter valid AtmID !!!");
		}
	}
}
