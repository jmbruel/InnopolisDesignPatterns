package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;

public class ActionSeeAccountNumber extends BankAction {


    public ActionSeeAccountNumber(String message, String code) {
        super(message, code);
    }



    @Override
    public void execute(ApplicationContextBankAgency ac) throws Exception {
        PrintStream stream = ac.getPrintStream();

        String accNum = ac.getScanner().next();

        Account c = ac.getBankAgency().getAccount(accNum);
        if (c==null) {
            stream.println("Account non existing ...");
        } else {
            c.print();
        }
    }
}
