package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintStream;

public class ActionDeleteAccount extends BankAction {


    public ActionDeleteAccount(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ac) throws Exception {
        PrintStream stream = ac.getPrintStream();
        stream.print("Account Number -> ");
        ac.getPrintStream().flush();
        String number = ac.getScanner().next();
        ac.getBankAgency().removeAccount(number);
    }

}
