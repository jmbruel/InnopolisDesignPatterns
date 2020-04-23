package application.action;

import application.BankAgencyApplicationContext;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintStream;

public class ActionDeposit implements Action<BankAgencyApplicationContext>{
    private final String message;
    private final String code;

    public ActionDeposit(String message, String code){
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

        printStream.print("Enter account Number -> ");
        String accountNumber = bankAgencyApplicationContext.getScanner().next();

        printStream.print("Enter deposit amount -> ");
        double amount = bankAgencyApplicationContext.getScanner().nextDouble();

        Account account = bankAgencyApplicationContext.getBankAgency().getAccount(accountNumber);

        if (account == null) {
            printStream.println("Account does not exist ...");
        } else {
            printStream.println("Balance before deposit: " + account.balance());
            
            try {
                account.deposit(amount);
                printStream.println("Balance after deposit: " + account.balance());
            } catch (AccountException e) {
                printStream.println("Deposit error, Balance unchanged: " + account.balance());
                printStream.println(e.getMessage());
            }
        }
    }
}
