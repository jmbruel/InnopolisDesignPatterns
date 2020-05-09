package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

import java.util.Objects;

public class ActionDeposit implements Action<ApplicationContextBankAgency> {
    private final String message;
    private final String code;

    public ActionDeposit(String code, String message) {
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

        context.outputDevice.print("Deposit amount -> ");
        final double amount = context.inputDevice.nextDouble();

        final Account account = context.getAgency().getAccount(number);

        if (Objects.isNull(account)) {
            context.outputDevice.println("Account not existing ...");
        } else {
            context.outputDevice.println("Balance before deposit: " + account.balance());
            try {
                account.deposit(amount);
                context.outputDevice.println("Balance after deposit: " + account.balance());
            } catch (AccountException e) {
                context.outputDevice.println("Deposit error, Balance unchanged: " + account.balance());
                context.outputDevice.println(e.getMessage());
            }
        }
    }
}
