package application.action;

import application.ApplicationContextBankAgency;

import java.io.PrintWriter;

public class ActionDeleteAccount implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionDeleteAccount(String code, String message) {
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
    public void execute(ApplicationContextBankAgency context) throws Exception {
        PrintWriter printWriter = context.getPrintWriter();
        printWriter.print("Account Number to Delete -> ");
        printWriter.flush();
        String number = context.getScanner().next();
        context.getBankAgency().removeAccount(number);
    }
}
