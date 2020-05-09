package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

public class ActionAddAccount implements Action<ApplicationContextBankAgency> {
    private final String message;
    private final String code;

    public ActionAddAccount(String code, String message) {
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
        context.outputDevice.print("Account Number to Add -> ");
        final String number = context.inputDevice.next();

        context.outputDevice.print("Owner Name -> ");
        final String owner = context.inputDevice.next();

        context.getAgency().addAccount(new Account(number, owner));
    }
}
