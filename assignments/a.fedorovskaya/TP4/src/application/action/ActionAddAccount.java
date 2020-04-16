package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

public class ActionAddAccount implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionAddAccount(String code, String message){
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
    public void execute(ApplicationContextBankAgency context) throws Exception {
        context.getPrintWriter().print("Account Number to Add -> ");
        context.getPrintWriter().flush();
        String number = context.getScanner().next();

        context.getPrintWriter().print("Owner Name -> ");
        context.getPrintWriter().flush();
        String owner = context.getScanner().next();

        Account account = new Account(number, owner);
        context.getBankAgency().addAccount(account);
    }
}