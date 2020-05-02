package application.action;

import application.ApplicationContextBankAgency;

import java.io.PrintStream;

public class ListAccountsAction extends GenericAction<ApplicationContextBankAgency> {
    public ListAccountsAction(String message, String code) {
        super(message, code);
    }

    @Override
    public void execute(ApplicationContextBankAgency executionContext) throws Exception {
        String agencyDescription = executionContext.getBankAgency().toString();
        PrintStream out = executionContext.getPrintStream();

        out.println(agencyDescription);
        out.flush();
    }
}
