package application.action;

import application.context.ApplicationContextBankAgency;

public class AccountsListsAction implements Action<ApplicationContextBankAgency> {
    private static final String message = "List of the Agency accounts";
    private final String code;

    public AccountsListsAction(String code) {
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

    @Override
    public void execute(ApplicationContextBankAgency context) {
        context.getAgency().print();
    }
}
