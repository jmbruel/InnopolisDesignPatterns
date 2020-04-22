import application.AccesBankAgency;
import application.action.AccountsListsAction;
import application.action.SeeAccountNumberAction;
import application.actionlist.ActionList;
import application.actionlist.ListBankAgencyAction;

public class BankAgencyApp {
    public static void main(String[] argv) throws Exception {
        ActionList mainAction = new ListBankAgencyAction("1", "Main Action");
        mainAction.addAction(new AccountsListsAction("1"));
        mainAction.addAction(new SeeAccountNumberAction("2"));
        mainAction.execute(AccesBankAgency.getBankAgency());
        System.out.println("ByeBye");
    }
}
