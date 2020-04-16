package application.action;

import application.actioncontext.BankActionContext;

public class ActionAccountsList implements Action<BankActionContext> {
    private String message;
    private String code;

    public ActionAccountsList(String code, String message) {
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
