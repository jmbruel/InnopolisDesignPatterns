package elukyanchikovaTP4.src.application.action;

import application.BankAgencyApplicationContext;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintStream;

public class ActionWithdraw implements Action<BankAgencyApplicationContext>{
    private final String message;
    private final String code;

    public ActionWithdraw(String message, String code){
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

        printStream.print("Account Number -> ");
        String accountNumber = bankAgencyApplicationContext.getScanner().next();

        printStream.print("Withdraw amount -> ");
        double amount = bankAgencyApplicationContext.getScanner().nextDouble();

        Account c = bankAgencyApplicationContext.getBankAgency().getAccount(accountNumber);
        if (c==null) {
            printStream.println("Account not existing ...");
        } else {
            printStream.println("Balance before withdrawal: " + c.balance());

            try {
                c.withdraw(amount);
                printStream.println("Balance after withdrawal: "+c.balance());
            } catch (AccountException e) {
                printStream.println("Withdraw error, Balance unchanged: " + c.balance());
                printStream.println(e.getMessage());
            }
        }
        printStream.flush();
    }
}