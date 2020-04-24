package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintStream;

public class ActionDeleteAccount extends GenericAction<ApplicationContextBankAgency>  {

    public ActionDeleteAccount(String message, String code) {
        super(message, code);
    }


    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        PrintStream stream = ctx.getPrintStream();

        stream.print("Account Number -> ");
        ctx.getPrintStream().flush();
        String number = ctx.getScanner().next();
        ctx.getBankAgency().removeAccount(number);
    }
}
