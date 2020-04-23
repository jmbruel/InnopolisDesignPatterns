package application.action;

import application.ApplicationContextBankAgency;

public class ActionAccountsLists extends GenericAction<ApplicationContextBankAgency> {
    public ActionAccountsLists(String message, String code) {
        super(message, code);
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public void execute(ApplicationContextBankAgency applicationContextBankAgency) throws Exception {
        applicationContextBankAgency.getBankAgency().print();
    }
}
