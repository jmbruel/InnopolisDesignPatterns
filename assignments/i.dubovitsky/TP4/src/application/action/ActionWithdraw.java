package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintWriter;

public class ActionWithdraw implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionWithdraw(String code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        PrintWriter printWriter = context.getPrintWriter();
        printWriter.print("Account Number -> ");
        printWriter.flush();
        String number = context.getScanner().next();

        printWriter.print("Withdraw amount -> ");
        printWriter.flush();

        double amount = context.getScanner().nextDouble();
        Account c = context.getBankAgency().getAccount(number);
        if (c == null) {
            printWriter.println("Account not existing ...");
        } else {
            printWriter.println("Balance before withdrawal: " + c.balance());

            try {
                c.withdraw(amount);
                printWriter.println("Balance after withdrawal: " + c.balance());
            } catch (AccountException e) {
                printWriter.println("Withdraw error, Balance unchanged: " + c.balance());
                printWriter.println(e.getMessage());
            }
        }

        printWriter.flush();
    }
}