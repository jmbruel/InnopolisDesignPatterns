package application.action;

import application.context.IContext;
import bank.Account;
import bank.BankAgency;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class ActionGetAccountByNumber implements Action {

    private String message;
    private String code;

    public ActionGetAccountByNumber(String message, String code) {
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
        BankAgency ba = ic.getBankAgency();
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
