package application.action;

import application.BankAgencyApplicationContext;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionAddAccount implements Action<BankAgencyApplicationContext> {
    private final String message;
    private final String code;

    public ActionAddAccount(String message, String code){
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(BankAgencyApplicationContext bankAgencyApplicationContext) throws Exception {
        PrintStream printStream = bankAgencyApplicationContext.getPrintStream();
        BankAgency agency = bankAgencyApplicationContext.getBankAgency();

        printStream.print("Enter account Number: ");
        String number = bankAgencyApplicationContext.getScanner().next();

        printStream.print("Enter account owner name: ");
        String name = bankAgencyApplicationContext.getScanner().next();

        Account c = new Account(number, name);

        try {
            agency.addAccount(c);
        } catch (Exception e) {
            printStream.println(e.toString());
        }
    }
}
