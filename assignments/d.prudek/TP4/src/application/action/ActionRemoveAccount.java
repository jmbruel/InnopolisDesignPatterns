package application.action;

import application.context.IContext;
import bank.Account;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class ActionRemoveAccount implements Action {
    
    private String message;
    private String code;

    public ActionRemoveAccount(String message, String code) {
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
        System.out.println("Remove account");
        System.out.print("Account Number -> ");
        String number = lect.next();
        
        ic.getBankAgency().removeAccount(number);
    }
    
}
