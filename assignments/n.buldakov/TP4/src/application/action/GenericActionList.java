package application.action;

import bank.BankAgency;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class GenericActionList<E> implements ActionList<E> {

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
    public void execute(E e) throws Exception {
        while (true) {
            System.out.println(this.title);
            actionList.forEach((action) -> System.out.println(action.actionCode() + " - " + action.actionMessage()));
            System.out.println("0 - Quit");
            System.out.print("Choice -> ");

            String choice = new Scanner(System.in).next();

            if (choice.equals("0"))
                return;

            for (Action<E> action : actionList) {
                if (action.actionCode().equals(choice)){
                    action.execute(e);
                    break;
                }
            }
        }
    }
}
