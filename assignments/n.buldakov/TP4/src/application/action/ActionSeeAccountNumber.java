package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;

public class ActionSeeAccountNumber extends GenericAction<ApplicationContextBankAgency>  {

    public ActionSeeAccountNumber(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        ctx.getPrintStream().println(" Account Number -> ");
        String number = ctx.getScanner().next();

        Account account = ctx.getBankAgency().getAccount(number);

        if (account == null) {
            ctx.getPrintStream().println("Account not existing ...");
            return;
        }

        account.print();
    }
}
