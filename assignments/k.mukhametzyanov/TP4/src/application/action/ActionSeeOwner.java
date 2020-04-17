package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

public class ActionSeeOwner extends GenericAction<ApplicationContextBankAgency>  {
    public ActionSeeOwner(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        ctx.getPrintStream().println(" Account owner -> ");
        String owner = ctx.getScanner().next();

        Account[] accounts = ctx.getBankAgency().getAccountsOf(owner);
        if (accounts.length != 0) {
            for (Account account : accounts) {
                account.print();
            }

            return;
        }

        ctx.getPrintStream().println("Accounts not existing ...");
    }
}