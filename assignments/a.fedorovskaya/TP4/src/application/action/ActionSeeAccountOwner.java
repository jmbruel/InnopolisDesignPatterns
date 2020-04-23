package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

public class ActionSeeAccountOwner implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionSeeAccountOwner(String code, String message) {
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
        context.getPrintWriter().print("Account Owner -> ");
        context.getPrintWriter().flush();
        String owner = context.getScanner().next();
        Account[] accounts = context.getBankAgency().getAccountsOf(owner);
        if (accounts.length == 0) {
            context.getPrintWriter().println("no account on this name ...");
        } else {
            context.getPrintWriter().println("  " + accounts.length + " accounts for " + owner);
            for (Account account : accounts) {
                account.print();
            }
        }
    }
}