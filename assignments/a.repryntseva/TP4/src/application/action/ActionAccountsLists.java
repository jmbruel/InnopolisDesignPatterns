package application.action;

import application.BankAgencyApplicationContext;
import bank.BankAgency;

public class ActionAccountsLists implements Action<BankAgencyApplicationContext>{
    private final String message;
    private final String code;

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
    public void execute(BankAgencyApplicationContext context) throws Exception {
        context.getBankAgency().print();
    }
}
