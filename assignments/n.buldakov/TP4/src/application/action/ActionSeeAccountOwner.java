package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

public class ActionSeeAccountOwner extends GenericAction<ApplicationContextBankAgency>  {

    public ActionSeeAccountOwner(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        ctx.getPrintStream().println(" Account owner -> ");
        String owner = ctx.getScanner().next();

        Account[] accounts = ctx.getBankAgency().getAccountsOf(owner);

        if (accounts.length == 0) {
            ctx.getPrintStream().println("Accounts not existing ...");
            return;
        }

        for (Account account : accounts) {
            account.print();
        }
    }
}
