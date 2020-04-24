import application.action.AccountsListsAction;
import application.action.ActionList;
import application.action.GenericActionList;
import application.action.SeeAccountNumberAction;
import application.context.ApplicationContextBankAgency;

public class BankAgencyApp {
    public static void main(String[] argv) throws Exception {
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        ActionList<ApplicationContextBankAgency> mainAction = new GenericActionList<>("1", "Menu of " + context.getAgencyTitle(), 2);
        mainAction.addAction(new AccountsListsAction("1"), 0);
        mainAction.addAction(new SeeAccountNumberAction("2"), 1);
        mainAction.execute(context);
        System.out.println("ByeBye");
    }
}
