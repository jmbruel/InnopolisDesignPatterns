package application.action;

import application.ApplicationContextBankAgency;
import bank.Account;

import java.util.Objects;

public class ActionGetAccount implements Action<ApplicationContextBankAgency> {
    private final String message;
    private final String code;

    public ActionGetAccount(String code, String message) {
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

        final Account account = context.getAgency().getAccount(number);

        if (Objects.isNull(account)) {
            context.outputDevice.println("Account non existing ...");
        } else {
            account.print();
        }
    }
}
