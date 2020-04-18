package application.action;

import application.ApplicationContextBankAgency;
import bank.BankAgency;

public class ActionAccountsList extends BankAction {



    public ActionAccountsList(String message, String code) {
        super(message, code);
    }


    @Override
    public void execute(ApplicationContextBankAgency ac) throws Exception {
        ac.getBankAgency().print();
    }

}
