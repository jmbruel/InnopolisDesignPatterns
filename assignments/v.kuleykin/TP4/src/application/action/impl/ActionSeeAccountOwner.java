package application.action.impl;

import application.ApplicationContextBankAgency;
import application.action.GenericAction;
import bank.Account;

public class ActionSeeAccountOwner extends GenericAction<ApplicationContextBankAgency> {

    public ActionSeeAccountOwner(Integer code) {
        super(code.toString(), "Get Accounts by Owner");
    }


    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        context.getPrintWriter().println("Account owner --> ");
        String owner = context.getScanner().next();

        Account[] accounts = context.getBankAgency().getAccountsOf(owner);

        if (accounts.length == 0) {
            context.getPrintWriter().println("This account doesn't exist!");
            return;
        }

        for (Account account : accounts) {
            account.print();
        }
    }
}
