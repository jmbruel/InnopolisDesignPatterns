package application.action;

import application.actioncontext.BankActionContext;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionSeeAccountNumber implements Action<BankActionContext> {
    String message;
    String code;

    public ActionSeeAccountNumber(String code, String message) {
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
