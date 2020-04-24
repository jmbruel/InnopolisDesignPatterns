package application.action;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericActionList<Context> implements ActionList<Context> {
    protected String message;
    protected String code;
    protected String title;
    protected ArrayList<Action<Context>> actionList;

    public GenericActionList(String message, String code, String title) {
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
    public boolean addAction(Action<Context> ac) {
        return this.addAction(ac, actionList.size());
    }

    @Override
    public boolean addAction(Action<Context> ac, int index) {
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
    public boolean removeAction(Action<Context> ac) {
        return actionList.remove(ac);
    }

    @Override
    public String[] listOfActions() {
        int size = this.size();
        String[] list = new String[size];

        for (int i = 0; i < size; i++) {
            list[i] = this.actionList.get(i).actionMessage();
        }

        return list;
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
    public void execute(Context e) throws Exception {
        while (true) {
            System.out.println(this.title);

            for(int i = 0; i < this.size(); i++){
                Action<Context> action = this.actionList.get(i);
                System.out.println(action.actionCode() + " - " + action.actionMessage());
            }

            System.out.println("0 - Quit");
            System.out.print("Choice -> ");

            String choice = new Scanner(System.in).next();
            if (choice.equals("0"))
                return;

            for (Action<Context> action : actionList) {
                if (action.actionCode().equals(choice)){
                    action.execute(e);
                    break;
                }
            }
        }
    }
}
