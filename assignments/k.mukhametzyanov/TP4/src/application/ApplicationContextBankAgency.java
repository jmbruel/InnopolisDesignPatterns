package application;

import application.action.*;
import application.action.ActionListBankAgency;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class ApplicationContextBankAgency {
    BankAgency bankAgency;
    Scanner scanner;
    PrintStream printStream;

    static ApplicationContextBankAgency instance = new ApplicationContextBankAgency();

    public ApplicationContextBankAgency() {
        this.scanner = new Scanner(System.in);
        this.printStream = new PrintStream(System.out);
        this.bankAgency = AccesBankAgency.getBankAgency();
    }

    public static ApplicationContextBankAgency getInstance() {
        return instance;
    }

    public static Action<ApplicationContextBankAgency> generateMenu(){
        ActionListBankAgency generalMenu = new ActionListBankAgency(
                "Menu of " + getInstance().bankAgency.getAgencyName() + " (" + getInstance().bankAgency.getAgencyLoc() + ")",
                "1",
                "General Menu"
        );

        generalMenu.addAction(new ActionSeeAccountNumber( "Get Account by Number", "1"));
        generalMenu.addAction(new ActionSeeOwner( "Get Accounts by Owner", "2"));
        generalMenu.addAction(new ActionAccountsLists( "Accounts' List", "3"));

        ActionListBankAgency managementMenu = new ActionListBankAgency("Accounts Management", "4", "Menu management");
        managementMenu.addAction(new ActionAddAccount("Add Account", "1"));
        managementMenu.addAction(new ActionDeleteAccount("Remove Account", "2"));

        ActionListBankAgency operationsMenu = new ActionListBankAgency("Operation on an account", "5", "Menu operations");
        operationsMenu.addAction(new ActionDepositToAccount( "Deposit", "1"));
        operationsMenu.addAction(new ActionWithdrawFromAccount( "Withdraw", "2"));

        generalMenu.addAction(managementMenu);
        generalMenu.addAction(operationsMenu);

        return generalMenu;
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