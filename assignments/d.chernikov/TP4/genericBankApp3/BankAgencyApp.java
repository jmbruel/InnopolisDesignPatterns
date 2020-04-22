import application.AccesBankAgency;
import application.action.AccountsListsAction;
import application.action.SeeAccountNumberAction;
import application.action.ActionList;
import application.action.GenericActionList;
import bank.BankAgency;

public class BankAgencyApp {
    public static void main(String[] argv) throws Exception {
        BankAgency ag = AccesBankAgency.getBankAgency();
        ActionList<BankAgency> mainAction = new GenericActionList<>("1", "Menu of " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")", 2);
        mainAction.addAction(new AccountsListsAction("1"), 0);
        mainAction.addAction(new SeeAccountNumberAction("2"), 1);
        mainAction.execute(ag);
        System.out.println("ByeBye");
    }
}
