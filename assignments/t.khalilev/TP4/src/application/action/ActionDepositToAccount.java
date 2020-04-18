package application.action;

import application.ApplicationContextBankAgency;

import java.io.PrintStream;

public class ActionDepositToAccount extends BankAction {

    public ActionDepositToAccount(String message, String code) {
        super(message, code);
    }


    @Override
    public void execute(ApplicationContextBankAgency ac) throws Exception {
        PrintStream stream = ac.getPrintStream();

        stream.print("Account Number -> ");
        String number = ac.getScanner().next();
        System.out.print("Deposit amount -> ");
        Double amount = ac.getScanner().nextDouble();
        ac.depositOnAccount(number, amount);

    }
}
