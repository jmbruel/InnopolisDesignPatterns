package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintWriter;

public class SeeAccountByOwnerName implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public SeeAccountByOwnerName(String code, String message) {
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
        printWriter.print("Account Owner -> ");
        printWriter.flush();
        String owner = context.getScanner().next();
        Account[] accounts = context.getBankAgency().getAccountsOf(owner);
        if (accounts.length == 0) {
            printWriter.println("no account on this name ...");
        } else {
            printWriter.println("  " + accounts.length + " accounts for " + owner);
            for (Account account : accounts) {
                account.print();
            }
        }
    }
}