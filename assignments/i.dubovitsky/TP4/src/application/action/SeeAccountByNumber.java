package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintWriter;

public class SeeAccountByNumber implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public SeeAccountByNumber(String code, String message) {
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
        Account account = context.getBankAgency().getAccount(number);
        if (account == null) {
            printWriter.println("Account non existing ...");
        } else {
            account.print();
        }
    }
}
