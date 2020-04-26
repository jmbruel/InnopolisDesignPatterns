package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintWriter;

public class ActionDeposit implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionDeposit(String code, String message) {
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
        printWriter.print("Deposit amount -> ");
        printWriter.flush();
        double amount = context.getScanner().nextDouble();
        Account c = context.getBankAgency().getAccount(number);

        if (c == null) {
            printWriter.println("Account not existing ...");
        } else {
            printWriter.println("Balance before deposit: " + c.balance());
            printWriter.flush();
            try {
                c.deposit(amount);
                printWriter.println("Balance after deposit: " + c.balance());
            } catch (AccountException e) {
                printWriter.println("Deposit error, Balance unchanged: " + c.balance());
                printWriter.println(e.getMessage());
            }
        }
        printWriter.flush();
    }
}
