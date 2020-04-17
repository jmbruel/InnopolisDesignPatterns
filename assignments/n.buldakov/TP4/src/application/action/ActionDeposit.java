package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintStream;

public class ActionDeposit  extends GenericAction<ApplicationContextBankAgency>  {

    public ActionDeposit(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        PrintStream stream = ctx.getPrintStream();

        stream.print("Account Number -> ");
        stream.flush();
        String number = ctx.getScanner().next();
        stream.print("Deposit amount -> ");
        stream.flush();
        double amount = ctx.getScanner().nextDouble();
        Account account = ctx.getBankAgency().getAccount(number);

        if (account==null) {
            stream.println("Account not existing ...");
        } else {
            stream.println("Balance before deposit: " + account.balance());
            stream.flush();
            try {
                account.deposit(amount);
                stream.println("Balance after deposit: " + account.balance());
            } catch (AccountException e) {
                stream.println("Deposit error, Balance unchanged: " + account.balance());
                stream.println(e.getMessage());
            }
        }
        stream.flush();
    }
}
