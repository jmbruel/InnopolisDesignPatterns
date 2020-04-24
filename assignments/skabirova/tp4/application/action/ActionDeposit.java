package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;
import bank.exception.AccountException;

public class ActionDeposit implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionDeposit(String code, String message){
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
        context.getPrintWriter().print("Account Number -> ");
        context.getPrintWriter().flush();
        String number = context.getScanner().next();
        context.getPrintWriter().print("Deposit amount -> ");
        context.getPrintWriter().flush();
        double amount = context.getScanner().nextDouble();
        Account c = context.getBankAgency().getAccount(number);

        if (c==null) {
            context.getPrintWriter().println("Account not existing ...");
        } else {
            context.getPrintWriter().println("Balance before deposit: "+c.balance());
            context.getPrintWriter().flush();
            try {
                c.deposit(amount);
                context.getPrintWriter().println("Balance after deposit: "+c.balance());
            } catch (AccountException e) {
                context.getPrintWriter().println("Deposit error, Balance unchanged: " + c.balance());
                context.getPrintWriter().println(e.getMessage());
            }
        }
        context.getPrintWriter().flush();
    }
}
