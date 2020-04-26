package application.actionlist;

import application.ApplicationContextBankAgency;
import application.action.Action;
import application.action.GenericActionList;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ActionListBankAgency extends GenericActionList<ApplicationContextBankAgency> {
    public ActionListBankAgency(String message, String code, String title) {
        super(message, code, title);
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        while (true) {
            PrintWriter printWriter = context.getPrintWriter();
            printWriter.println(this.title);
            for(Action<ApplicationContextBankAgency> a: actionList){
                context.getPrintWriter().println(a.actionCode() + " - " + a.actionMessage());
            }            printWriter.println("0 - Quit");
            printWriter.print("Choice -> ");

            printWriter.flush();

            String choice = context.getScanner().next();

            if (choice.equals("0"))
                return;

            for (Action<ApplicationContextBankAgency> action : actionList) {
                if (action.actionCode().equals(choice)){
                    action.execute(context);
                    break;
                }
            }
        }
    }
}
