package elukyanchikovaTP4.src.application.action;

import application.BankAgencyApplicationContext;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionAddAccount implements Action<BankAgencyApplicationContext> {
    private final String message;
    private final String code;

    public ActionAddAccount(String message, String code) {
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

        printStream.print("Account Number: ");
        String accountNumber = bankAgencyApplicationContext.getScanner().next();

        printStream.print("Account owner name: ");
        String ownerName = bankAgencyApplicationContext.getScanner().next();

        Account account = new Account(accountNumber, ownerName);
        bankAgencyApplicationContext.getBankAgency().addAccount(account);

    }
}