package application;

import application.action.*;
import application.actionList.ActionListBankAgency;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class ApplicationContextBankAgency {

    static ApplicationContextBankAgency instance = new ApplicationContextBankAgency();

    public static Action<ApplicationContextBankAgency> generateMenu(){
        ActionListBankAgency generalMenu = new ActionListBankAgency(
                "General",
                "1",
                "General Menu"
        );

        ActionListBankAgency accountInfoMenu = new ActionListBankAgency(
                "See an account (by its number)",
                "2",
                "Account menu");
        accountInfoMenu.addAction(new ActionSeeAccountNumber( "Get Account by Number", "1"));
        accountInfoMenu.addAction(new ActionSeeAccountOwner( "Get Accounts by Owner", "2"));

        ActionListBankAgency operationsMenu = new ActionListBankAgency(
                "Operation on an account",
                "3",
                "Operations' Menu");
        operationsMenu.addAction(new ActionDeposit( "Deposit", "1"));
        operationsMenu.addAction(new ActionWithdraw( "Withdraw", "2"));

        ActionListBankAgency accountMenu = new ActionListBankAgency(
                "Accounts Management",
                "4",
                "Menu Accounts management");
        accountMenu.addAction(new ActionAddAccount("Add Account", "1"));
        accountMenu.addAction(new ActionDeleteAccount("Remove Account", "2"));

        generalMenu.addAction(new ActionAccountsLists( "Accounts' List", "1"));
        generalMenu.addAction(accountInfoMenu);
        generalMenu.addAction(operationsMenu);
        generalMenu.addAction(accountMenu);

        return generalMenu;
    }

    public static ApplicationContextBankAgency getInstance() {
        return instance;
    }

    BankAgency bankAgency;

    Scanner scanner;

    PrintStream printStream;


    public ApplicationContextBankAgency() {
        this.printStream = new PrintStream(System.out);
        this.scanner = new Scanner(System.in);
        this.bankAgency = AccesBankAgency.getBankAgency();
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
}
