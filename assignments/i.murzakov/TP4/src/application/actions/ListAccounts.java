package application.actions;

import action.Action;
import application.BankActionContext;

public class ListAccounts implements Action<BankActionContext> {
    private String message;
    private String code;

    public ListAccounts(String code, String message) {
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
    public void execute(BankActionContext context) throws Exception {
        context.getBankAgency().print();
    }
}