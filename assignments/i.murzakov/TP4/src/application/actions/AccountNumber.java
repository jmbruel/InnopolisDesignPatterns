package application.actions;

import action.Action;
import application.BankActionContext;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class AccountNumber implements Action<BankActionContext> {
    String message;
    String code;

    public AccountNumber(String code, String message) {
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
        PrintStream printStream = context.getPrintStream();
        Scanner scanner = context.getScanner();
        BankAgency ag = context.getBankAgency();
        String number;
        printStream.print("Account Number -> ");
        number = scanner.next();
        Account c = ag.getAccount(number);
        if (c==null) {
            printStream.println("Account non existing ...");
        } else {
            c.print();
        }
    }
}