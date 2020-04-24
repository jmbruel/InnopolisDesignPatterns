package application.action;

import application.context.ApplicationContextBankAgency;
import bank.Account;

public class SeeAccountNumberAction implements Action<ApplicationContextBankAgency> {
    private static final String message = "See an account (by its number)";
    private final String code;

    public SeeAccountNumberAction(String code) {
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
    public void execute(ApplicationContextBankAgency context) {
        context.print("Account Number -> ");
        String number = context.readNext();
        Account c = context.getAgency().getAccount(number);
        if (c == null) {
            context.println("Account non existing ...");
        } else {
            c.print();
        }
    }
}
