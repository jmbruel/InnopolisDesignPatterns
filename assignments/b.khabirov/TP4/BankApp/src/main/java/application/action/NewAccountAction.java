package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class NewAccountAction extends GenericAction<ApplicationContextBankAgency>  {

    public NewAccountAction(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency executionContext) throws Exception {
        PrintStream out = executionContext.getPrintStream();
        Scanner in = executionContext.getScanner();
        BankAgency agency = executionContext.getBankAgency();

        out.print("Account number: ");
        out.flush();
        String number = in.next();

        out.print("Owner name: ");
        out.flush();
        String owner = in.next();

        agency.addAccount(new Account(number, owner));
        out.println("New account has been added!");
        out.flush();
    }
}
