package elukyanchikovaTP4.src.application.action;

import application.BankAgencyApplicationContext;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintStream;

public class ActionDeposit implements Action<BankAgencyApplicationContext> {
    private final String message;
    private final String code;

    public ActionDeposit(String message, String code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(BankAgencyApplicationContext bankAgencyApplicationContext) throws Exception {
        PrintStream printStream = bankAgencyApplicationContext.getPrintStream();

        printStream.print("Account Number");
        String accountNumber = bankAgencyApplicationContext.getScanner().next();

        printStream.print("Enter deposit amount ");
        double amount = bankAgencyApplicationContext.getScanner().nextDouble();

        Account account = bankAgencyApplicationContext.getBankAgency().getAccount(accountNumber);

        if (account != null) {
            printStream.println("Balance before deposit: " + account.balance());

            try {
                account.deposit(amount);
                printStream.println("Balance: " + account.balance());
            } catch (AccountException e) {
                printStream.println("Deposit error: no changes performed: " + account.balance());
                printStream.println(e.getMessage());
            }

        } else {
            printStream.println("Error: Account does not exist");
        }
    }
}