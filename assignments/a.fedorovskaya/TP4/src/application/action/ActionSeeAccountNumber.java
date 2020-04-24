package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

public class ActionSeeAccountNumber implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionSeeAccountNumber(String code, String message){
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
        context.getPrintWriter().print("Account Number -> ");
        context.getPrintWriter().flush();
        String number = context.getScanner().next();

        Account account = context.getBankAgency().getAccount(number);
        if (account==null) {
            context.getPrintWriter().println("Account non existing ...");
        } else {
            account.print();
        }
    }
}
