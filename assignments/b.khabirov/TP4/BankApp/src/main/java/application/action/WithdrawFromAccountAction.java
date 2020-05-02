package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintStream;
import java.util.Scanner;

public class WithdrawFromAccountAction extends GenericAction<ApplicationContextBankAgency>  {

    public WithdrawFromAccountAction(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency executionContext) throws Exception {
        PrintStream out = executionContext.getPrintStream();
        Scanner in = executionContext.getScanner();

        out.print("Account number: ");
        out.flush();
        String number = in.next();
        Account account = executionContext.getBankAgency().getAccount(number);

        if (account == null) {
            out.println("Account does not exist!");
            out.flush();
            return;
        }

        out.print("Amount to withdraw: ");
        out.flush();
        double amount = in.nextDouble();

        out.println("Old balance: " + account.balance());
        try {
            account.withdraw(amount);
        } catch (AccountException e) {
            out.println("An error occurred while performing the operation: " + e.getMessage());
        }
        out.println("New balance: " + account.balance());
        out.flush();
    }
}
