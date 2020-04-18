package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintStream;


public class ActionSeeAccountName extends BankAction {

    public ActionSeeAccountName(String message, String code) {
        super(message, code);
    }


    @Override
    public void execute(ApplicationContextBankAgency ac) throws Exception {
        Account []  t;
        PrintStream stream = ac.getPrintStream();
        stream.print("Owner name -> ");
        String ownerName = ac.getScanner().next();
        t = ac.getBankAgency().getAccountsOf(ownerName);
        if (t.length == 0) {
            System.out.println("no account on this name ...");
        } else {
            System.out.println("  " + t.length + " accounts for " + ownerName);
            for (int i=0; i<t.length; i++)
                t[i].print();
        }
    }
}
