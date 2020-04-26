package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintWriter;

public class ActionAddAccount implements Action<ApplicationContextBankAgency> {
    private final String message;
    private final String code;

    public ActionAddAccount(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        PrintWriter printWriter = context.getPrintWriter();
        printWriter.print("Account Number -> ");
        printWriter.flush();
        String number = context.getScanner().next();
        printWriter.print("Owner Name -> ");
        printWriter.flush();
        String owner = context.getScanner().next();
        Account newAccount = new Account(number, owner);
        context.getBankAgency().addAccount(newAccount);
    }
}
