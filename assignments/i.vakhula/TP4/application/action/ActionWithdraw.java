package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

import java.util.Objects;

public class ActionWithdraw implements Action<ApplicationContextBankAgency> {
    private final String message;
    private final String code;

    public ActionWithdraw(String code, String message) {
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
    public void execute(ApplicationContextBankAgency context) throws Exception {
        context.outputDevice.print("Account Number -> ");
        final String number = context.inputDevice.next();

        context.outputDevice.print("Withdraw amount -> ");
        final double amount = context.inputDevice.nextDouble();

        Account account = context.getAgency().getAccount(number);
        if (Objects.isNull(account)) {
            context.outputDevice.println("Account not existing ...");
        } else {
            context.outputDevice.println("Balance before withdrawal: " + account.balance());
            try {
                account.withdraw(amount);
                context.outputDevice.println("Balance after withdrawal: " + account.balance());
            } catch (AccountException e) {
                context.outputDevice.println("Withdraw error, Balance unchanged: " + account.balance());
                context.outputDevice.println(e.getMessage());
            }
        }
    }
}
