package application.action;

import bank.Account;
import bank.BankAgency;

import java.util.Scanner;

public class SeeAccountNumberAction implements Action<BankAgency> {
    private static final String message = "See an account (by its number)";
    private final String code;

    public SeeAccountNumberAction(String code) {
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
    public void execute(BankAgency ag) throws Exception {
        System.out.print("Account Number -> ");
        Scanner lect = new Scanner(System.in);
        String number = lect.next();
        Account c = ag.getAccount(number);
        if (c == null) {
            System.out.println("Account non existing ...");
        } else {
            c.print();
        }
    }
}
