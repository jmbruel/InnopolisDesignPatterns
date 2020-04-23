import application.actions.*;
import application.BankActionContext;
import action.ActionList;
import application.BankAccountActionList;
import bank.BankAgency;

public class BankAgencyApp {

	public static void main(String[] argv) {
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
		BankAccountActionList<BankActionContext> actionListBankAgency = new BankAccountActionList<BankActionContext>("1", "General",
				"--\n  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")\n  General Menu\n--");
		actionListBankAgency.addAction(new ListAccounts("1", "List of the Agency accounts"));
		actionListBankAgency.addAction(new AccountNumber("2", "See an account (by its number)"));

		BankAccountActionList<BankActionContext> actionListAccountOperation = new BankAccountActionList<BankActionContext>("3", "Operation on an account",
				"--\n  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")\n  Menu Operation on an account\n--");
		actionListAccountOperation.addAction(new Deposit("1", "Deposit money on an account"));
		actionListAccountOperation.addAction(new Withdraw("2", "Withdraw money from an account"));
		actionListBankAgency.addAction(actionListAccountOperation);

		BankAccountActionList<BankActionContext> actionListManagement = new BankAccountActionList<BankActionContext>("4",
				"Accounts management",
				"--\n  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")\n  Menu Accounts management\n--");
		actionListManagement.addAction(new AddAccount("1", "Add an account"));
		actionListManagement.addAction(new DeleteAccount("2", "Delete an account"));
		actionListBankAgency.addAction(actionListManagement);

		return actionListBankAgency;
	}
}