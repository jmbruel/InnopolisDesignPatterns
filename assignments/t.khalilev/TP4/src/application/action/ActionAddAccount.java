package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.io.PrintStream;

public class ActionAddAccount extends BankAction {


        public ActionAddAccount(String message, String code) {
            super(message,code);
        }

        @Override
        public void execute(ApplicationContextBankAgency ac) throws Exception {
                PrintStream stream = ac.getPrintStream();
                stream.print("Account Number -> ");
                ac.getPrintStream().flush();
                String number = ac.getScanner().next();
                stream.print("Owner Name -> ");
                stream.flush();
                String owner = ac.getScanner().next();
                ac.getBankAgency().addAccount(new Account(number, owner));
        }

}
