package elukyanchikovaTP4.src.application.action;

import application.BankAgencyApplicationContext;

import java.io.PrintStream;

public class ActionDeleteAccount implements Action<BankAgencyApplicationContext>{
    private final String message;
    private final String code;

    public ActionDeleteAccount(String message, String code){
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

        bankAgencyApplicationContext.getPrintStream().print("Account number to delete: ");
        String accountNumber = bankAgencyApplicationContext.getScanner().next();

        bankAgencyApplicationContext.getBankAgency().removeAccount(accountNumber);
    }
}