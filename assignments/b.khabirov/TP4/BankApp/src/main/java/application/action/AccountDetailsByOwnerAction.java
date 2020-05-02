package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintStream;

public class AccountDetailsByOwnerAction extends GenericAction<ApplicationContextBankAgency>  {
    public AccountDetailsByOwnerAction(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency executionContext) throws Exception {
        PrintStream out = executionContext.getPrintStream();
        out.println("Account owner name: ");
        String owner = executionContext.getScanner().next();
        Account[] accounts = executionContext.getBankAgency().getAccountsOf(owner);

        if (accounts.length == 0) {
            out.println("No accounts were found for given owner.");
        } else {
            for (Account account : accounts) {
                out.println(account.toString());
            }
        }
    }
}
