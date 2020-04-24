import application.ApplicationContextBankAgency;
import application.action.*;
import application.actionList.ActionListBankAgency;

public class Main {
    public static void main(String[] argv){
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        try {
            createActions().execute(context);
        }catch (Exception e){
            e.printStackTrace();
        }
        context.close();
    }

    public static Action<ApplicationContextBankAgency> createActions(){
        ActionListBankAgency actionListBankAgency = new ActionListBankAgency("1", "General",
                "General Menu");
        ActionListBankAgency actionListAccountInfo = new ActionListBankAgency("2", "Account Info",
                "Account Information by");

        actionListAccountInfo.addAction(new ActionSeeAccountNumber("1", "Get Account by Number"));
        actionListAccountInfo.addAction(new ActionSeeAccountOwner("2", "Get Accounts by Owner"));

        ActionListBankAgency actionListOperations = new ActionListBankAgency("3", "Operation on an Account",
                "Operations' Menu");

        actionListOperations.addAction(new ActionDeposit("1", "Deposit"));
        actionListOperations.addAction(new ActionWithdraw("2", "Withdraw"));

        ActionListBankAgency actionListAccountManagement = new ActionListBankAgency("4", "Accounts Management",
                "Accounts Management Menu");

        actionListAccountManagement.addAction(new ActionAddAccount("1", "Add Account"));
        actionListAccountManagement.addAction(new ActionRemoveAccount("2", "Remove Account"));

        actionListBankAgency.addAction(new ActionAccountsLists("1", "Accounts' List"));

        actionListBankAgency.addAction(actionListAccountInfo);
        actionListBankAgency.addAction(actionListOperations);
        actionListBankAgency.addAction(actionListAccountManagement);

        return actionListBankAgency;
    }

}
