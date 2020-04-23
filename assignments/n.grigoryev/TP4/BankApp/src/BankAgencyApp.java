

import java.util.Locale;
import java.util.Scanner;

import application.AccesBankAgency;
import bank.BankAgency;
import bank.Account;
import bank.exception.ABInexistingAccountException;
import bank.exception.AccountException;

public class BankAgencyApp {

	private static String tab(int amount) {
		return "  ".repeat(amount);
	}

	/**
	 * UI of the App
	 * @param ag	BankAgency to get name and location
	 */
	public static void printGenralMenu(BankAgency ag) {
		System.out.println("--");
		System.out.println(BankAgencyApp.tab(1) + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
		System.out.println(BankAgencyApp.tab(1) + "General Menu");
		System.out.println("--");
		System.out.println(BankAgencyApp.tab(1) + "Choose:");
		System.out.println(BankAgencyApp.tab(2) + "l - List of the Agency accounts");
		System.out.println(BankAgencyApp.tab(2) + "2 - See an account (by its number)");
		System.out.println(BankAgencyApp.tab(2) + "3 - Operation on an account");
		System.out.println(BankAgencyApp.tab(2) + "4 - Accounts management");
		System.out.println("\n" + BankAgencyApp.tab(2) + "0 - To quit this menu");
		System.out.println("Choice ?");
	}

	public static void printAccountOperationsMenu(BankAgency ag) {
		System.out.println("--");
		System.out.println(BankAgencyApp.tab(1) + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
		System.out.println(BankAgencyApp.tab(1) + "Menu Operation on an account");
		System.out.println("--");
		System.out.println(BankAgencyApp.tab(1) + "Choose:");
		System.out.println(BankAgencyApp.tab(2) + "l - Deposit money on an account");
		System.out.println(BankAgencyApp.tab(2) + "2 - Withdraw money from an account");
		System.out.println("\n" + BankAgencyApp.tab(2) + "0 - To quit this menu");
		System.out.println("Choice ?");
	}

	public static void printAccountsManagementMenu(BankAgency ag) {
		System.out.println("--");
		System.out.println(BankAgencyApp.tab(1) + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
		System.out.println(BankAgencyApp.tab(1) + "Menu Operation on an account");
		System.out.println("--");
		System.out.println(BankAgencyApp.tab(1) + "Choose:");
		System.out.println(BankAgencyApp.tab(2) + "l - Add an account");
		System.out.println(BankAgencyApp.tab(2) + "2 - Delete an account");
		System.out.println("\n" + BankAgencyApp.tab(2) + "0 - To quit this menu");
		System.out.println("Choice ?");
	}

	public static void proceedAccountOperationsMenu(Scanner lect, BankAgency ag) {
		boolean proceed = true;
		String number;
		double amount;
		String choice;
		while (proceed) {
			BankAgencyApp.printAccountOperationsMenu(ag);
			choice = lect.next();
			choice = choice.toLowerCase();
			switch (choice) {
				case "1":
					System.out.print("Account Number -> ");
					number = lect.next();
					System.out.print("Deposit amount -> ");
					amount = lect.nextDouble();
					BankAgencyApp.depositOnAccount(ag, number, amount);
					BankAgencyApp.tempo();
					break;
				case "2":
					System.out.print("Account Number -> ");
					number = lect.next();
					System.out.print("Withdraw amount -> ");
					amount = lect.nextDouble();
					BankAgencyApp.withdrawFromAccount(ag, number, amount);
					BankAgencyApp.tempo();
					break;
				case "0":
					System.out.println();
					proceed = false;
					break;
				default :
					System.out.println("Problem ...");
					BankAgencyApp.tempo();
					break;
			}
		}
	}
	public static void preceedAccountsManagementMenu(Scanner lect, BankAgency ag) {
		boolean proceed = true;
		String number, name;
		double amount;
		Account c;
		String choice;
		while (proceed) {
			BankAgencyApp.printAccountsManagementMenu(ag);
			choice = lect.next();
			choice = choice.toLowerCase();
			switch (choice) {
				case "1":
					System.out.print("Account Number -> ");
					number = lect.next();
					System.out.print("Account owner name -> ");
					name = lect.next();
					c = new Account(number, name);
					try {
						ag.addAccount(c);
					} catch (Exception e) {
						System.out.println(e.toString());
					}
					BankAgencyApp.tempo();
					break;
				case "2":
					System.out.print("Account Number -> ");
					number = lect.next();
					try {
						ag.removeAccount(number);
					} catch (ABInexistingAccountException e) {
						System.out.println(e.toString());
					}
					BankAgencyApp.tempo();
					break;
				case "0":
					System.out.println();
					proceed = false;
					break;
				default :
					System.out.println("Problem ...");
					BankAgencyApp.tempo();
					break;
			}
		}
	}

	public static void proceedGeneralMenu(Scanner lect, BankAgency ag) {
		String name, number;
		Account c;
		boolean proceed = true;
		String choice;
		while (proceed) {
			BankAgencyApp.printGenralMenu(ag);
			choice = lect.next();
			choice = choice.toLowerCase();
			switch (choice) {
				case "1":
					ag.print();
					BankAgencyApp.tempo();
					break;
				case "2":
					System.out.print("Account Number -> ");
					number = lect.next();
					c = ag.getAccount(number);
					if (c==null) {
						System.out.println("Account non existing ...");
					} else {
						c.print();
					}
					BankAgencyApp.tempo();
					break;
				case "3":
					BankAgencyApp.proceedAccountOperationsMenu(lect, ag);
					break;
				case "4":
					BankAgencyApp.preceedAccountsManagementMenu(lect, ag);
					break;
				case "0" :
					System.out.println("ByeBye");
					BankAgencyApp.tempo();
					proceed = false;
					break;
				default :
					System.out.println("Problem ...");
					BankAgencyApp.tempo();
					break;
			}
		}
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo() {
		Scanner lect ;

		lect = new Scanner (System.in );

		System.out.print("Type any car + return to continue ... ");
		lect.next(); 
	}

	public static void main(String argv[]) {

		Scanner lect;
		BankAgency myAgency ;


		lect = new Scanner( System.in );
		lect.useLocale(Locale.US);

		myAgency = AccesBankAgency.getBankAgency();

		BankAgencyApp.proceedGeneralMenu(lect, myAgency);

	}

	public static void ownerAccounts(BankAgency ag, String ownerName) {
		Account []  t;

		t = ag.getAccountsOf(ownerName);
		if (t.length == 0) {
			System.out.println("no account on this name ...");
		} else {
			System.out.println("  " + t.length + " accounts for " + ownerName);
			for (int i=0; i<t.length; i++)
				t[i].print();
		}
	}

	public static void depositOnAccount(BankAgency ag, String accountNumber, double amount) {
		Account c;

		c = ag.getAccount(accountNumber);
		if (c==null) {
			System.out.println("Account not existing ...");
		} else {
			System.out.println("Balance before deposit: "+c.balance());
			try {
				c.deposit(amount);
				System.out.println("Balance after deposit: "+c.balance());
			} catch (AccountException e) {
				System.out.println("Deposit error, Balance unchanged: " + c.balance());
				System.out.println(e.getMessage());
			}
		}
	}

	public static void withdrawFromAccount(BankAgency ag, String accountNumber, double amount) {
		Account c;

		c = ag.getAccount(accountNumber);
		if (c==null) {
			System.out.println("Account not existing ...");
		} else {
			System.out.println("Balance before withdrawal: " + c.balance());
			try {
				c.withdraw(amount);
				System.out.println("Balance after withdrawal: "+c.balance());
			} catch (AccountException e) {
				System.out.println("Withdraw error, Balance unchanged: " + c.balance());
				System.out.println(e.getMessage());
			}
		}

	}
}
