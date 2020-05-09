package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.util.Arrays;

public class ActionGetAccountByOwner implements Action<ApplicationContextBankAgency> {
    private final String message;
    private final String code;

    public ActionGetAccountByOwner(String code, String message) {
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
        context.outputDevice.print("Account Owner -> ");
        final String owner = context.inputDevice.next();

        final Account[] accounts = context.getAgency().getAccountsOf(owner);
        if (accounts.length == 0) {
            context.outputDevice.println("no account on this name ...");
        } else {
            context.outputDevice.println("  " + accounts.length + " accounts for " + owner);
            Arrays.stream(accounts).forEach(Account::print);
        }
    }
}
