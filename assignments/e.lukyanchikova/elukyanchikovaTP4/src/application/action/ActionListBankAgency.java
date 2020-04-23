package elukyanchikovaTP4.src.application.action;

import application.BankAgencyApplicationContext;
import application.action.ActionList;

import java.io.PrintStream;
import java.util.ArrayList;

public class ActionListBankAgency implements ActionList<BankAgencyApplicationContext> {
    private final String message;
    private final String code;
    private final String title;
    private final ArrayList<Action<BankAgencyApplicationContext>> actionList;

    public ActionListBankAgency(String message, String code, String title) {
        this.message = message;
        this.code = code;
        this.title = title;
        actionList = new ArrayList<>();
    }

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return actionList.size();
    }

    @Override
    public boolean addAction(Action<BankAgencyApplicationContext> ac) {
        return actionList.add(ac);
    }

    @Override
    public boolean addAction(Action<BankAgencyApplicationContext> ac, int index) {
        if (actionList.contains(ac)) {
            return false;
        }

        actionList.add(index, ac);
        return true;
    }

    @Override
    public boolean removeAction(int index) {
        return actionList.remove(index) != null;
    }

    @Override
    public boolean removeAction(Action<BankAgencyApplicationContext> ac) {
        return actionList.remove(ac);
    }

    @Override
    public String[] listOfActions() {
        ArrayList<String> result = new ArrayList<>();
        actionList.forEach(action -> result.add(action.actionCode()));

        return result.toArray(new String[this.actionList.size()]);
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
    public void execute(BankAgencyApplicationContext bankAgencyApplicationContext) throws Exception {
        while (true) {
            PrintStream printStream = bankAgencyApplicationContext.getPrintStream();

            printStream.println(this.title);

            actionList.forEach((action) -> System.out.println(action.actionCode() + " - " + action.actionMessage()));

            printStream.println("0 - Quit");
            printStream.print("Choice -> ");

            String choice = bankAgencyApplicationContext.getScanner().next();

            if (choice.equals("0")) { return; }

            for (Action<BankAgencyApplicationContext> action : actionList) {
                if (action.actionCode().equals(choice)){
                    action.execute(bankAgencyApplicationContext);
                    break;
                }
            }
        }
    }
}
