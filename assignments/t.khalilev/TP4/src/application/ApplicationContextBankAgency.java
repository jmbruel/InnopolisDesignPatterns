package application;

import application.action.*;
import application.actionList.ActionListBankAgency;
import bank.Account;
import bank.BankAgency;
import bank.exception.AccountException;

import java.io.PrintStream;
import java.util.Scanner;

public class ApplicationContextBankAgency {

    static ApplicationContextBankAgency instance = new ApplicationContextBankAgency();

    public static ApplicationContextBankAgency getInstance() {
        return instance;
    }
    private BankAgency bankAgency;

    private Scanner scanner;

    private PrintStream printStream;


    public ApplicationContextBankAgency() {
        this.printStream = new PrintStream(System.out);
        this.scanner = new Scanner(System.in);
        this.bankAgency = AccessBankAgency.getBankAgency();
    }


    public static Action<ApplicationContextBankAgency> getMenu() {
        ActionListBankAgency mainMenu = new ActionListBankAgency("Main", "1", "Main Menu");

        ActionListBankAgency accountSearchMenu = new ActionListBankAgency("See an account", "2", "See account");
        accountSearchMenu.addAction(new ActionSeeAccountNumber("Get account by number", "1"));
        accountSearchMenu.addAction(new ActionSeeAccountName("Get account by name", "2"));

        ActionListBankAgency operationsMenu = new ActionListBankAgency("Account Operations menu", "3", "Operations menu");
        operationsMenu.addAction(new ActionDepositToAccount("Deposit from account", "1"));
        operationsMenu.addAction(new ActionWithdrawFromAccount("Withdraw from account", "2"));

        ActionListBankAgency accManagementMenu = new ActionListBankAgency("Account Management menu", "4", "Account management menu");
        accManagementMenu.addAction(new ActionAddAccount("Add account","1"));
        accManagementMenu.addAction(new ActionDeleteAccount("Delete account","2"));

        mainMenu.addAction(new ActionAccountsList("All accounts", "1"));
        mainMenu.addAction(accountSearchMenu);
        mainMenu.addAction(operationsMenu);
        mainMenu.addAction(accManagementMenu);

        return mainMenu;
    }

    public BankAgency getBankAgency() {
        return bankAgency;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public void depositOnAccount(String accountNumber, double amount) {
        Account c;

        c = this.bankAgency.getAccount(accountNumber);
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

    public void withdrawFromAccount(String accountNumber, double amount) {
        Account c;

        c = this.bankAgency.getAccount(accountNumber);
        if (c==null) {
            System.out.println("Account not existing ...");
        } else {
            System.out.println("Balance before withdraw: "+c.balance());
            try {
                c.withdraw(amount);
                System.out.println("Balance after withdraw: "+c.balance());
            } catch (AccountException e) {
                System.out.println("Withdraw error, Balance unchanged: " + c.balance());
                System.out.println(e.getMessage());
            }
        }
    }

}
