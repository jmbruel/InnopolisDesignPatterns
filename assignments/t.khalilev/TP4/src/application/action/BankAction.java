package application.action;

import application.ApplicationContextBankAgency;

abstract public class BankAction implements Action<ApplicationContextBankAgency> {
    protected String message;
    protected String code;


    public BankAction(String message, String code) {
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

}
