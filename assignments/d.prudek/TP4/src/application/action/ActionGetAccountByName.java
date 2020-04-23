package application.action;

import application.context.IContext;
import bank.Account;
import bank.BankAgency;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class ActionGetAccountByName implements Action {

    private String message;
    private String code;

    public ActionGetAccountByName(String message, String code) {
        this.message = message;
        this.code = code;
    }
    

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(IContext ic) throws Exception {
        Scanner lect = ic.getScanner();
        System.out.print("Owner -> ");
        String name = lect.next();
        ActionGetAccountByName.ownerAccounts(ic.getBankAgency(), name);
    }
    
    public static void ownerAccounts(BankAgency ag, String ownerName) {
        Account []  t;

        t = ag.getAccountsOf(ownerName);
        if (t.length == 0) {
                System.out.println("no account on this name ...");
        } else {
                System.out.println("  " + t.length + " accounts for " + ownerName);
                for (int i=0; i<t.length; i++)
                        t[i].print();
        }
    }
    
}
