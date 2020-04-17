package application.actions;

import action.Action;
import application.BankActionContext;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class AddAccount implements Action<BankActionContext> {
    private String message;
    private String code;

    public AddAccount(String code, String message) {
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
    public void execute(BankActionContext context) throws Exception {
        Scanner scanner = context.getScanner();
        PrintStream printStream = context.getPrintStream();
        BankAgency ag = context.getBankAgency();
        printStream.print("Account Number -> ");
        String number = scanner.next();
        printStream.print("Account owner name -> ");
        String name = scanner.next();
        Account c = new Account(number, name);
        try {
            ag.addAccount(c);
        } catch (Exception e) {
            printStream.println(e.toString());
        }
    }
}