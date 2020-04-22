package application.action;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericActionList<E> implements ActionList<E> {
    private static final String message = "List of the Agency actions";
    private final String code, title;
    private final ArrayList<Action<E>> actionList;

    public GenericActionList(String code, String title, int size) {
        this.code = code;
        this.title = title;
        actionList = new ArrayList<>(size);
        while (actionList.size() < size) {
            actionList.add(null);
        }
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
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return actionList.size();
    }

    @Override
    public boolean addAction(Action<E> ac, int index) {
        actionList.set(index, ac);
        return true;
    }

    @Override
    public boolean removeAction(int index) {
        actionList.remove(index);
        return true;
    }

    @Override
    public boolean removeAction(Action<E> ac) {
        return actionList.remove(ac);
    }

    @Override
    public String[] listOfActions() {
        return (String[]) actionList.stream().map(Action::actionMessage).toArray();
    }

    private static final String quitCode = "0";

    @Override
    public void execute(E ag) throws Exception {
        boolean continue_ = true;
        do {
            System.out.println(listTitle());
            for (Action<E> a : actionList) {
                System.out.println(a.actionCode() + " - " + a.actionMessage());
            }
            System.out.println(quitCode + " - Quit");

            System.out.print("Choice -> ");
            Scanner lect = new Scanner(System.in);
            String choice = lect.next();

            if (choice.equals(quitCode)) {
                continue_ = false;
            } else {
                boolean found = false;
                for (Action<E> a : actionList) {
                    if (a.actionCode().equals(choice)) {
                        a.execute(ag);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Please, enter the valid action code");
                }
            }
        } while (continue_);

        System.out.println("End of menu " + listTitle());
    }
}
