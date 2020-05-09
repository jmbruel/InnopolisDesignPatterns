package application.action;

import application.ApplicationContextBankAgency;

public class ActionRemoveAccount implements Action<ApplicationContextBankAgency> {
    private final String message;
    private final String code;

    public ActionRemoveAccount(String code, String message) {
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
        context.outputDevice.print("Account Number to Remove -> ");
        final String number = context.inputDevice.next();

        context.getAgency().removeAccount(number);
    }
}
