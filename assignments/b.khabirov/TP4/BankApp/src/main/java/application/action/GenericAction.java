package application.action;

import application.ExecutionContext;

public abstract class GenericAction<E extends ExecutionContext> implements Action<E> {
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
