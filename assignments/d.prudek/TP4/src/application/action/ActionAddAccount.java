package application.action;

import application.context.IContext;
import bank.Account;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class ActionAddAccount implements Action {

    private String message;
    private String code;

    public ActionAddAccount(String message, String code) {
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
    public void execute(IContext context) throws Exception {
        Scanner lect = context.getScanner();
        System.out.println("Create new account");
        System.out.print("Account Number -> ");
        String number = lect.next();
        System.out.print("Account Owner -> ");
	String name = lect.next();
        
        Account account = new Account(number, name);
        
        context.getBankAgency().addAccount(account);
    }
    
}
