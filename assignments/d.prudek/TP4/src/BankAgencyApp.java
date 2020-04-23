
import application.action.Action;
import application.action.ActionAccountsLists;
import application.action.ActionAddAccount;
import application.action.ActionDeposit;
import application.action.ActionGetAccountByName;
import application.action.ActionGetAccountByNumber;
import application.action.ActionRemoveAccount;
import application.action.ActionWithdraw;
import application.actionlist.ActionListBankAgency;
import application.context.BankAgencyContext;
import application.context.IContext;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankAgencyApp {
    
    public static void main(String argv[]) {
        IContext context = BankAgencyContext.getInstance();
        try {
            initActions().execute(context);
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            context.close();
        } catch (IOException ex) {
            Logger.getLogger(BankAgencyApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Action initActions(){
        ActionListBankAgency actionListBankAgency = new ActionListBankAgency("General", "1", "General Menu");

        ActionListBankAgency actionListAccountInfo = new ActionListBankAgency("Account Info", "2", "Account Information by");
        actionListAccountInfo.addAction(new ActionGetAccountByNumber("Get Account by Number", "1"));
        actionListAccountInfo.addAction(new ActionGetAccountByName("Get Accounts by Owner", "2"));

        ActionListBankAgency actionListOperations = new ActionListBankAgency("Operation on an Account", "3",
            "Operations' Menu");
        actionListOperations.addAction(new ActionDeposit("Deposit", "1"));
        actionListOperations.addAction(new ActionWithdraw("Withdraw", "2"));

        ActionListBankAgency actionListAccountManagement = new ActionListBankAgency("Accounts Management", "4",
            "Accounts Management Menu");
        actionListAccountManagement.addAction(new ActionAddAccount("Add Account", "1"));
        actionListAccountManagement.addAction(new ActionRemoveAccount("Remove Account", "2"));

        actionListBankAgency.addAction(new ActionAccountsLists("Accounts' List", "1"));
        actionListBankAgency.addAction(actionListAccountInfo);
        actionListBankAgency.addAction(actionListOperations);
        actionListBankAgency.addAction(actionListAccountManagement);

        return actionListBankAgency;
    }

}
