package application.action;

import application.ExecutionContext;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class GenericActionList<E extends ExecutionContext> implements ActionList<E> {
    protected String message;
    protected String code;
    protected String title;
    protected ArrayList<Action<E>> actionList;

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return actionList.size();
    }

    @Override
    public boolean addAction(Action<E> ac) {
        return this.addAction(ac, actionList.size());
    }

    @Override
    public boolean addAction(Action<E> ac, int index) {
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
    public boolean removeAction(Action<E> ac) {
        return actionList.remove(ac);
    }

    @Override
    public String[] listOfActions() {
        ArrayList<String> stringActions = new ArrayList<>();

        for (Action<E> action: actionList) {
            stringActions.add(action.actionMessage());
        }
        return stringActions.toArray(new String[0]);
    }

    public GenericActionList(String message, String code, String title) {
        this.message = message;
        this.code = code;
        this.title = title;
        actionList = new ArrayList<>();
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
    public void execute(E executionContext) throws Exception {
        while (true) {
            PrintStream outStream = executionContext.getPrintStream();

            outStream.println(this.title);
            actionList.forEach((action) -> outStream.println(action.actionCode() + " - " + action.actionMessage()));
            outStream.println("\n0 - To quit this menu");
            outStream.print("Choice ?\n");

            outStream.flush();

            String input = executionContext.getScanner().next();

            if (input.equals("0"))
                return;

            for (Action<E> action : actionList) {
                if (action.actionCode().equals(input)) {
                    action.execute(executionContext);
                    break;
                }
            }
        }
    }
}
