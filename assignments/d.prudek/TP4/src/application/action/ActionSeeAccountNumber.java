package application.action;

import application.context.IContext;
import bank.Account;
import bank.BankAgency;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class ActionSeeAccountNumber implements Action {

    private String message;
    private String code;

    public ActionSeeAccountNumber(String message, String code) {
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
        BankAgency ba = context.getBankAgency();
        System.out.print("Account Number -> ");
	String number = lect.next();
        Account c = ba.getAccount(number);
        if (c==null) {
            System.out.println("Account non existing ...");
        } 
        else {
            c.print();
        }
    }
    
}
