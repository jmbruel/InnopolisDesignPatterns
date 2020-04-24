package elukyanchikovaTP4.src.application.action;

import application.BankAgencyApplicationContext;
import bank.Account;

public class ActionSeeAccountOwner implements Action<BankAgencyApplicationContext> {
    private final String message;
    private final String code;

    public ActionSeeAccountOwner(String message, String code) {
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
        bankAgencyApplicationContext.getPrintStream().println("Account owner:");
        String owner = bankAgencyApplicationContext.getScanner().next();

        Account[] accounts = bankAgencyApplicationContext.getBankAgency().getAccountsOf(owner);

        if (accounts.length != 0) {
            for (Account account : accounts) {
                account.print();
            }
        } else {
            bankAgencyApplicationContext.getPrintStream().println("Accounts do not exist...");

        }


    }
}