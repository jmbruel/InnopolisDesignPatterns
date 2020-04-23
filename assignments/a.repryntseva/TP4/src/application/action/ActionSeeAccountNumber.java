package application.action;

import application.BankAgencyApplicationContext;
import bank.Account;
import bank.BankAgency;

public class ActionSeeAccountNumber implements Action<BankAgencyApplicationContext>{
    private final String message;
    private final String code;

    public ActionSeeAccountNumber(String message, String code){
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(BankAgencyApplicationContext bankAgencyApplicationContext) throws Exception {
        bankAgencyApplicationContext.getPrintStream().println(" Account Number -> ");
        String accountNumber = bankAgencyApplicationContext.getScanner().next();

        Account account = bankAgencyApplicationContext.getBankAgency().getAccount(accountNumber);

        if (account == null) {
            bankAgencyApplicationContext.getPrintStream().println("Account not existing ...");
            return;
        }

        account.print();
    }
}
