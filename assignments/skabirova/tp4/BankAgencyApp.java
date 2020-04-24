

import java.util.Locale;
import java.util.Scanner;

import application.AccesBankAgency;
import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;

public class BankAgencyApp {

//	/**
//	 * UI of the App
//	 * @param ag	BankAgency to get name and location
//	 */
//	public static void printMenu(BankAgency ag) {
//		System.out.println(ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
//		System.out.println("General Menu");
//		System.out.println("l - List of the Agency accounts");
//		System.out.println("2 - See an account (by its number)");
//		System.out.println("3 - Operation on an account");
//		System.out.println("4 - Accounts management");
////		System.out.println("p - See the accounts of an owner (by its name)");
////		System.out.println("d - Deposit money on an account");
////		System.out.println("r - Withdraw money from an account");
//		System.out.println();
//		System.out.println("0 - To quit this menu");
//		System.out.println("Choice ?");
//	}
//
//	public static void printMenu2(BankAgency ag) {
//		System.out.println(ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
//		System.out.println("Menu Operation on an account");
//		System.out.println("1 - Deposit money on an account");
//		System.out.println("2 - Withdraw money from an account");
//		System.out.println();
//		System.out.println("0 - To quit this menu");
//		System.out.println("Choice ?");
//	}
//
//	public static void printMenu3(BankAgency ag) {
//		System.out.println(ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
//		System.out.println("Menu Accounts management");
//		System.out.println("1 - See the accounts of an owner (by its name)");
//		System.out.println();
//		System.out.println("0 - To quit this menu");
//		System.out.println("Choice ?");
//	}
//
//	/**
//	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
//	 */
//	public static void tempo() {
//		Scanner lect ;
//
//		lect = new Scanner (System.in );
//
//		System.out.print("Type any char + return to continue ... ");
//		lect.next();
//	}
//
//	public static void main(String argv[]) {
//
//		String choice;
//
//		boolean proceed ;
//		Scanner lect;
//		BankAgency myAgency ;
//
//		String name, number;
//		Account c;
//		double amount;
//
//		lect = new Scanner( System.in );
//		lect.useLocale(Locale.US);
//
//		myAgency = AccesBankAgency.getBankAgency();
//
//		proceed = true;
//		while (proceed) {
//			BankAgencyApp.printMenu(myAgency);
//			choice = lect.next();
//			choice = choice.toLowerCase();
//			switch (choice) {
//				case "0" :
//					System.out.println("ByeBye");
//					BankAgencyApp.tempo();
//					proceed = false;
//					break;
//				case "1" :
//					myAgency.print();
//					BankAgencyApp.tempo();
//					break;
//				case "2" :
//					System.out.print("Account Number -> ");
//					number = lect.next();
//					c = myAgency.getAccount(number);
//					if (c==null) {
//						System.out.println("Account non existing ...");
//					} else {
//						c.print();
//					}
//					BankAgencyApp.tempo();
//					break;
//				case "3":
//					boolean proceed2 = true;
//					String choice2;
//					while (proceed2) {
//						printMenu2(myAgency);
//						choice2 = lect.next();
//						choice2 = choice2.toLowerCase();
//						switch (choice2){
//							case "1":
//								System.out.print("Account Number -> ");
//								number = lect.next();
//								System.out.print("Deposit amount -> ");
//								amount = lect.nextDouble();
//								BankAgencyApp.depositOnAccount(myAgency, number, amount);
//								BankAgencyApp.tempo();
//								break;
//							case "2":
//								System.out.print("Account Number -> ");
//								number = lect.next();
//								System.out.print("Withdraw amount -> ");
//								amount = lect.nextDouble();
//								BankAgencyApp.withdrawFromAccount(myAgency, number, amount);
//								BankAgencyApp.tempo();
//								break;
//							case "0":
//								System.out.println("End of Menu Operation on an account");
//								BankAgencyApp.tempo();
//								proceed2 = false;
//								break;
//						}
//					}
//					break;
//				case "4":
//					boolean proceed3 = true;
//					String choice3;
//					while (proceed3) {
//						printMenu3(myAgency);
//						choice3 = lect.next();
//						choice3 = choice3.toLowerCase();
//						switch (choice3){
//							case "1":
//								System.out.print("Owner -> ");
//								name = lect.next();
//								BankAgencyApp.ownerAccounts(myAgency, name);
//								BankAgencyApp.tempo();
//								break;
//							case "0":
//								BankAgencyApp.tempo();
//								proceed3 = false;
//								break;
//						}
//					}
//					break;
//				default :
//					System.out.println("Problem ...");
//					BankAgencyApp.tempo();
//					break;
//			}
//		}
//
//	}
//
//	public static void ownerAccounts(BankAgency ag, String ownerName) {
//		Account []  t;
//
//		t = ag.getAccountsOf(ownerName);
//		if (t.length == 0) {
//			System.out.println("no account on this name ...");
//		} else {
//			System.out.println("  " + t.length + " accounts for " + ownerName);
//			for (int i=0; i<t.length; i++)
//				t[i].print();
//		}
//	}
//
//	public static void depositOnAccount(BankAgency ag, String accountNumber, double amount) {
//		Account c;
//
//		c = ag.getAccount(accountNumber);
//		if (c==null) {
//			System.out.println("Account not existing ...");
//		} else {
//			System.out.println("Balance before deposit: "+c.balance());
//			try {
//				c.deposit(amount);
//				System.out.println("Balance after deposit: "+c.balance());
//			} catch (AccountException e) {
//				System.out.println("Deposit error, Balance unchanged: " + c.balance());
//				System.out.println(e.getMessage());
//			}
//		}
//	}
//
//	public static void withdrawFromAccount(BankAgency ag, String accountNumber, double amount) {
//		Account c;
//
//		c = ag.getAccount(accountNumber);
//		if (c==null) {
//			System.out.println("Account not existing ...");
//		} else {
//			System.out.println("Balance before withdrawal: " + c.balance());
//			try {
//				c.withdraw(amount);
//				System.out.println("Balance after withdrawal: "+c.balance());
//			} catch (AccountException e) {
//				System.out.println("Withdraw error, Balance unchanged: " + c.balance());
//				System.out.println(e.getMessage());
//			}
//		}
//
//	}
}
