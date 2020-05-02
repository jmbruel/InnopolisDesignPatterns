package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;
import java.io.PrintStream;
import java.util.Scanner;

public class DepositToAccountAction extends GenericAction<ApplicationContextBankAgency> {
    public DepositToAccountAction(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency executionContext) throws Exception {
        PrintStream out = executionContext.getPrintStream();
        Scanner in = executionContext.getScanner();

        out.print("Account Number: ");
        out.flush();
        String number = in.next();

        out.print("Deposit amount: ");
        out.flush();
        double amount = in.nextDouble();

        Account account = executionContext.getBankAgency().getAccount(number);

        if (account == null) {
            out.println("Account does not exist!");
        } else {
            out.println("Old balance: " + account.balance());

            try {
                account.deposit(amount);
            } catch (AccountException e) {
                out.println("An error occurred while performing the operation: " + e.getMessage());
            }

            out.println("Current balance: " + account.balance());
        }

        out.flush();
    }
}
