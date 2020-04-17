package application.action;

import application.ApplicationContextBankAgency;
import java.io.PrintStream;
import bank.Account;

public class ActionAddAccount extends GenericAction<ApplicationContextBankAgency> {
    public ActionAddAccount(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        PrintStream stream = ctx.getPrintStream();
        stream.print("Account Number -> ");

        ctx.getPrintStream().flush();

        String number = ctx.getScanner().next();
        stream.print("Owner Name -> ");
        stream.flush();

        String owner = ctx.getScanner().next();
        Account newAccount = new Account(number, owner);
        ctx.getBankAgency().addAccount(newAccount);
    }
}
