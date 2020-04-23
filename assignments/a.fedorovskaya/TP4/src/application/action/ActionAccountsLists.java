package application.action;

import application.ApplicationContextBankAgency;

public class ActionAccountsLists implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionAccountsLists(String message, String code){
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
        context.getBankAgency().print();
    }
}
