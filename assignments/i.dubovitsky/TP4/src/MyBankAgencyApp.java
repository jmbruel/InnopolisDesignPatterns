import application.ApplicationContextBankAgency;
import application.action.*;
import application.actionlist.ActionListBankAgency;

public class MyBankAgencyApp {
    public static void main(String[] argv) {
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        try {
            createActions().execute(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.close();
    }

    public static Action<ApplicationContextBankAgency> createActions() {
        ActionListBankAgency generalMenu = new ActionListBankAgency("General", "1",
                "General Menu");
        ActionListBankAgency accInfo = new ActionListBankAgency("Account Info", "2",
                "Account Information by");

        accInfo.addAction(new SeeAccountByNumber("1", "See Account by Number"));
        accInfo.addAction(new SeeAccountByOwnerName("2", "See Accounts by Owner"));

        ActionListBankAgency operationsMenu = new ActionListBankAgency("Operation on an Account", "3",
                "Operations' Menu");

        operationsMenu.addAction(new ActionDeposit("1", "Deposit"));
        operationsMenu.addAction(new ActionWithdraw("2", "Withdraw"));

        ActionListBankAgency accsCtrl = new ActionListBankAgency("Accounts Control", "4",
                "Accounts Control Menu");

        accsCtrl.addAction(new ActionAddAccount("1", "Add Account"));
        accsCtrl.addAction(new ActionDeleteAccount("2", "Delete Account"));

        generalMenu.addAction(new ActionAccountsLists("List all accounts", "1"));

        generalMenu.addAction(accInfo);
        generalMenu.addAction(operationsMenu);
        generalMenu.addAction(accsCtrl);

        return generalMenu;
    }

}
