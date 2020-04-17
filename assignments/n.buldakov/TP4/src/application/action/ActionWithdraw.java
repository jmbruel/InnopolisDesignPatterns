package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintStream;

public class ActionWithdraw extends GenericAction<ApplicationContextBankAgency>  {

    public ActionWithdraw(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        PrintStream stream = ctx.getPrintStream();

        stream.print("Account Number -> ");
        stream.flush();
        String number = ctx.getScanner().next();
        stream.print("Withdraw amount -> ");
        stream.flush();
        double amount = ctx.getScanner().nextDouble();
        Account c = ctx.getBankAgency().getAccount(number);
        if (c==null) {
            stream.println("Account not existing ...");
        } else {
            stream.println("Balance before withdrawal: " + c.balance());
            try {
                c.withdraw(amount);
                stream.println("Balance after withdrawal: "+c.balance());
            } catch (AccountException e) {
                stream.println("Withdraw error, Balance unchanged: " + c.balance());
                stream.println(e.getMessage());
            }
        }
        stream.flush();
    }
}
