package application.action;

import bank.BankAgency;

public class AccountsListsAction implements Action {
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
    public void execute(BankAgency ag) throws Exception {
        ag.print();
    }
}
