package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

public class ActionWithdrawFromAccount extends GenericAction<ApplicationContextBankAgency>  {
    public ActionWithdrawFromAccount(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        ctx.getPrintStream().print("Account Number -> ");
        ctx.getPrintStream().flush();

        String number = ctx.getScanner().next();
        ctx.getPrintStream().print("Withdraw amount -> ");
        ctx.getPrintStream().flush();

        double amount = ctx.getScanner().nextDouble();
        Account account = ctx.getBankAgency().getAccount(number);

        if (account == null) {
            ctx.getPrintStream().println("Account not existing ...");
        } else {
            ctx.getPrintStream().println("Balance before withdrawal: " + account.balance());
            try {
                account.withdraw(amount);
                ctx.getPrintStream().println("Balance after withdrawal: " + account.balance());
            } catch (AccountException e) {
                ctx.getPrintStream().println("Withdraw error, Balance unchanged: " + account.balance());
                ctx.getPrintStream().println(e.getMessage());
            }
        }

        ctx.getPrintStream().flush();
    }
}