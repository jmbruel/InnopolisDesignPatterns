package application;

import application.action.impl.*;
import application.actionlist.ActionList;
import application.actionlist.impl.ActionListBankAgency;
import bank.BankAgency;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationContextBankAgency {

    private static ApplicationContextBankAgency instance;
    private static ActionList<ApplicationContextBankAgency> menu;

    private BankAgency bankAgency;
    private Scanner scanner;
    private PrintWriter printWriter;


    private ApplicationContextBankAgency() {
        bankAgency = AccesBankAgency.getBankAgency();
        scanner = new Scanner(System.in);
        printWriter = new PrintWriter(System.out);
        setMenu();
    }


    private static void setMenu(){
        ActionListBankAgency accountInfoMenu =
                new ActionListBankAgency(2, "Account menu", "See an account (by its number)");
        accountInfoMenu.addAction(new ActionSeeAccountNumber( 1));
        accountInfoMenu.addAction(new ActionSeeAccountOwner(2));

        ActionListBankAgency operationsMenu =
                new ActionListBankAgency(3, "Operations' Menu", "Operation on an account");
        operationsMenu.addAction(new ActionDeposit( 1));
        operationsMenu.addAction(new ActionWithdraw( 2));

        ActionListBankAgency accountMenu =
                new ActionListBankAgency(4, "Menu Accounts management", "Accounts Management");
        accountMenu.addAction(new ActionAddAccount(1));
        accountMenu.addAction(new ActionRemoveAccount(2));

        menu = new ActionListBankAgency(1, "General Menu", "General Menu");
        menu.addAction(new ActionAccountsLists( 1));
        menu.addAction(accountInfoMenu);
        menu.addAction(operationsMenu);
        menu.addAction(accountMenu);
    }

    public static ApplicationContextBankAgency getInstance() {
        if (instance == null) {
            instance = new ApplicationContextBankAgency();
        }
        return instance;
    }

    public ActionList<ApplicationContextBankAgency> getMenu() {
        return menu;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void changeScannerStream(InputStream stream) {
        scanner.close();
        scanner = new Scanner(stream);
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void changePrintWriterStream(OutputStream stream) {
        printWriter.close();
        printWriter = new PrintWriter(stream);
    }

    public BankAgency getBankAgency() {
        return bankAgency;
    }

    public void close(){
        scanner.close();
        printWriter.close();
    }
}
