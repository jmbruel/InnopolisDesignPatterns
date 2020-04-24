package application.action;

import application.ApplicationContextBankAgency;
import bank.BankAgency;

public class ActionAccountsLists extends GenericAction<ApplicationContextBankAgency> {

    public ActionAccountsLists(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency applicationContextBankAgency) throws Exception {
        applicationContextBankAgency.getBankAgency().print();
    }
}
