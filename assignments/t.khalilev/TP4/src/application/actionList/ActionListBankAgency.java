package application.actionList;

import application.ApplicationContextBankAgency;
import application.action.Action;

import java.io.PrintStream;

public class ActionListBankAgency extends GenericActionList<ApplicationContextBankAgency> {
    public ActionListBankAgency(String message, String code, String title){
        super(message, code, title);
    }
    @Override
    public void execute(ApplicationContextBankAgency ctx) throws Exception {
        while (true) {
            PrintStream stream = ctx.getPrintStream();
            stream.println(this.title);
            actionList.forEach((action) -> System.out.println(action.actionCode() + " - " + action.actionMessage()));
            stream.println("0 - Quit");
            stream.print("Choice -> ");

            stream.flush();

            String choice = ctx.getScanner().next();

            if (choice.equals("0"))
                return;

            for (Action<ApplicationContextBankAgency> action : actionList) {
                if (action.actionCode().equals(choice)){
                    action.execute(ctx);
                    break;
                }
            }
        }
    }

}
