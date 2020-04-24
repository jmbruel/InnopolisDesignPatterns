package application.action;

import application.ApplicationContextBankAgency;

import java.io.PrintStream;

public class ActionWithdrawFromAccount extends BankAction {


    public ActionWithdrawFromAccount(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency ac) throws Exception {
        PrintStream stream = ac.getPrintStream();

        stream.print("Account Number -> ");
        String number = ac.getScanner().next();
        System.out.print("Withdraw amount -> ");
        Double amount = ac.getScanner().nextDouble();
        ac.withdrawFromAccount(number, amount);

    }
}
