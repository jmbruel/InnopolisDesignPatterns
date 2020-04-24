package application.action;

public abstract class GenericAction<Context> implements Action<Context> {
    protected String message;
    protected String code;

    public GenericAction(String message, String code) {
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
}