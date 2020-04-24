package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

public class ActionRemoveAccount implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionRemoveAccount(String code, String message){
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
        context.getPrintWriter().print("Account Number to Remove -> ");
        context.getPrintWriter().flush();
        String number = context.getScanner().next();
        context.getBankAgency().removeAccount(number);
    }
}
