package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;

public class AccountDetailsByNumberAction extends GenericAction<ApplicationContextBankAgency>  {
    public AccountDetailsByNumberAction(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency executionContext) throws Exception {
        PrintStream out = executionContext.getPrintStream();
        out.println("Account number: ");
        String number = executionContext.getScanner().next();
        Account account = executionContext.getBankAgency().getAccount(number);

        if (account == null) {
            out.println("Account does not exist!");
            return;
        }

        out.println(account.toString());
    }
}
