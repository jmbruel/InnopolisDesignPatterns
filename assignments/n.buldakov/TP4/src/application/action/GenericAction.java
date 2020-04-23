package application.action;

import application.ApplicationContextBankAgency;

public abstract class GenericAction<E> implements Action<E> {
    protected String message;

    protected String code;

    public GenericAction(String message, String code) {
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
