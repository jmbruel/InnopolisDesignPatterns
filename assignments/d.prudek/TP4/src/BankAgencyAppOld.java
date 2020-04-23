

import java.util.Locale;
import java.util.Scanner;

import application.AccesBankAgency;
import application.action.Action;
import application.action.ActionAccountsLists;
import application.action.ActionAddAccount;
import application.action.ActionDeposit;
import application.action.ActionGetAccountByName;
import application.action.ActionGetAccountByNumber;
import application.action.ActionRemoveAccount;
import application.action.ActionWithdraw;
import application.actionlist.ActionListBankAgency;
import application.context.BankAgencyContext;
import application.context.IContext;
import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankAgencyAppOld {
    
    public static void main(String argv[]) {
        IContext context = BankAgencyContext.getInstance();
        try {
            initActions().execute(context);
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            context.close();
        } catch (IOException ex) {
            Logger.getLogger(BankAgencyAppOld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Action initActions(){
        ActionListBankAgency actionListBankAgency = new ActionListBankAgency("1", "General",
                        "General Menu");

        ActionListBankAgency actionListAccountInfo = new ActionListBankAgency("2", "Account Info",
        "Account Information by");
        actionListAccountInfo.addAction(new ActionGetAccountByNumber("1", "Get Account by Number"));
        actionListAccountInfo.addAction(new ActionGetAccountByName("2", "Get Accounts by Owner"));

        ActionListBankAgency actionListOperations = new ActionListBankAgency("3",
                        "Operation on an Account",
                        "Operations' Menu");
        actionListOperations.addAction(new ActionDeposit("1", "Deposit"));
        actionListOperations.addAction(new ActionWithdraw("2", "Withdraw"));

        ActionListBankAgency actionListAccountManagement = new ActionListBankAgency("4",
                        "Accounts Management",
                        "Accounts Management Menu");
        actionListAccountManagement.addAction(new ActionAddAccount("1", "Add Account"));
        actionListAccountManagement.addAction(new ActionRemoveAccount("2", "Remove Account"));

        actionListBankAgency.addAction(new ActionAccountsLists("1", "Accounts' List"));
        actionListBankAgency.addAction(actionListAccountInfo);
        actionListBankAgency.addAction(actionListOperations);
        actionListBankAgency.addAction(actionListAccountManagement);

        return actionListBankAgency;
    }
    
    
//
//	/**
//	 * UI of the App
//	 * @param ag	BankAgency to get name and location
//	 */
//	public static void printMenu(BankAgency ag) {
//		System.out.println("Menu of " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
//		System.out.println("l - List of the Agency accounts");
//		System.out.println("v - See an account (by its number)");
//		System.out.println("p - See the accounts of an owner (by its name)");
//		System.out.println("d - Deposit money on an account");
//		System.out.println("r - Withdraw money from an account");
//		System.out.println("q - Quit");
//		System.out.print("Choice -> ");
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
//		System.out.print("Type any car + return to continue ... ");
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
//				case "q" :
//					System.out.println("ByeBye");
//					BankAgencyApp.tempo();
//					proceed = false;
//					break;
//				case "l" :
//					myAgency.print();
//					BankAgencyApp.tempo();
//					break;
//				case "v" :
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
//				case "p" :
//					System.out.print("Owner -> ");
//					name = lect.next();
//					BankAgencyApp.ownerAccounts(myAgency, name);
//					BankAgencyApp.tempo();
//					break;
//				case "d" :
//					System.out.print("Account Number -> ");
//					number = lect.next();
//					System.out.print("Deposit amount -> ");
//					amount = lect.nextDouble();
//					BankAgencyApp.depositOnAccount(myAgency, number, amount);
//					BankAgencyApp.tempo();
//					break;
//				case "r" :
//					System.out.print("Account Number -> ");
//					number = lect.next();
//					System.out.print("Withdraw amount -> ");
//					amount = lect.nextDouble();
//					BankAgencyApp.withdrawFromAccount(myAgency, number, amount);
//					BankAgencyApp.tempo();
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
