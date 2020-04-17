package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

public class ActionDepositToAccount  extends GenericAction<ApplicationContextBankAgency>  {
    public ActionDepositToAccount(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        ctx.getPrintStream().print("Account Number -> ");
        ctx.getPrintStream().flush();

        String number = ctx.getScanner().next();
        ctx.getPrintStream().print("Deposit amount -> ");
        ctx.getPrintStream().flush();

        double amount = ctx.getScanner().nextDouble();
        Account account = ctx.getBankAgency().getAccount(number);

        if (account == null) {
            ctx.getPrintStream().println("Account not existing ...");
            ctx.getPrintStream().flush();
            return;
        }

        ctx.getPrintStream().println("Balance before deposit: " + account.balance());
        ctx.getPrintStream().flush();

        try {
            account.deposit(amount);
            ctx.getPrintStream().println("Balance after deposit: " + account.balance());
        } catch (AccountException e) {
            ctx.getPrintStream().println("Deposit error, Balance unchanged: " + account.balance());
            ctx.getPrintStream().println(e.getMessage());
        }

        ctx.getPrintStream().flush();
    }
}