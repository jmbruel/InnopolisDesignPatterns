package application.action;

import application.ApplicationContextBankAgency;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class DeleteAccountAction extends GenericAction<ApplicationContextBankAgency>  {
    public DeleteAccountAction(String message, String code) {
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

        agency.removeAccount(number);
    }
}
