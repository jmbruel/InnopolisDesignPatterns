import application.AccesBankAgency;
import application.action.*;
import application.actioncontext.BankActionContext;
import application.actionlist.ActionList;
import application.actionlist.GenericActionList;
import bank.Account;
import bank.BankAgency;
import bank.exception.ABInexistingAccountException;
import bank.exception.AccountException;

import java.util.Locale;
import java.util.Scanner;

public class BankAgencyApplication {

    public static void main(String argv[]) {
        BankActionContext context = BankActionContext.getInstance();
		try {
			initActions().execute(context);
		} catch (Exception e){
			e.printStackTrace();
		}
		context.close();
    }

    /**
     * Method which initialize all actions
     *
     * @return root action
     */
    public static ActionList<BankActionContext> initActions() {
        BankActionContext context = BankActionContext.getInstance();
        BankAgency ag = context.getBankAgency();
        GenericActionList<BankActionContext> actionListBankAgency = new GenericActionList<BankActionContext>("1", "General",
                "--\n  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")\n  General Menu\n--");
        actionListBankAgency.addAction(new ActionAccountsList("1", "List of the Agency accounts"));
        actionListBankAgency.addAction(new ActionSeeAccountNumber("2", "See an account (by its number)"));

        GenericActionList<BankActionContext> actionListAccountOperation = new GenericActionList<BankActionContext>("3", "Operation on an account",
                "--\n  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")\n  Menu Operation on an account\n--");
        actionListAccountOperation.addAction(new ActionDepositMoneyOnAccount("1", "Deposit money on an account"));
        actionListAccountOperation.addAction(new ActionWithdrawMoneyFromAccount("2", "Withdraw money from an account"));
        actionListBankAgency.addAction(actionListAccountOperation);

        GenericActionList<BankActionContext> actionListManagement = new GenericActionList<BankActionContext>("4",
                "Accounts management",
                "--\n  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")\n  Menu Accounts management\n--");
		actionListManagement.addAction(new ActionAddAccount("1", "Add an account"));
		actionListManagement.addAction(new ActionDeleteAccount("2", "Delete an account"));
		actionListBankAgency.addAction(actionListManagement);

        return actionListBankAgency;
    }
}
