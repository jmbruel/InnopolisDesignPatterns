package application.action;

import application.context.IContext;
import bank.Account;
import bank.BankAgency;
import bank.exception.AccountException;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class ActionWithdraw implements Action {

    private String message;
    private String code;

    public ActionWithdraw(String message, String code) {
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
        System.out.print("Account Number -> ");
        String number = lect.next();
        System.out.print("Withdraw amount -> ");
        double amount = lect.nextDouble();
        ActionWithdraw.withdrawFromAccount(ic.getBankAgency(), number, amount);
    }
    
    public static void withdrawFromAccount(BankAgency ag, String accountNumber, double amount) {
        Account c;

        c = ag.getAccount(accountNumber);
        if (c==null) {
                System.out.println("Account not existing ...");
        } else {
                System.out.println("Balance before withdrawal: " + c.balance());
                try {
                        c.withdraw(amount);
                        System.out.println("Balance after withdrawal: "+c.balance());
                } catch (AccountException e) {
                        System.out.println("Withdraw error, Balance unchanged: " + c.balance());
                        System.out.println(e.getMessage());
                }
        }

    }
    
}
