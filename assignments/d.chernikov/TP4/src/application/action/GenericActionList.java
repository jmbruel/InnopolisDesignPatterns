package application.action;

import application.context.AppContext;

import java.util.ArrayList;

public class GenericActionList<Context extends AppContext> implements ActionList<Context> {
    private static final String message = "List of the Agency actions";
    private final String code, title;
    private final ArrayList<Action<Context>> actionList;

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
    public boolean addAction(Action<Context> context, int index) {
        actionList.set(index, context);
        return true;
    }

    @Override
    public boolean removeAction(int index) {
        actionList.remove(index);
        return true;
    }

    @Override
    public boolean removeAction(Action<Context> context) {
        return actionList.remove(context);
    }

    @Override
    public String[] listOfActions() {
        return (String[]) actionList.stream().map(Action::actionMessage).toArray();
    }

    private static final String quitCode = "0";

    @Override
    public void execute(Context context) throws Exception {
        boolean continue_ = true;
        do {
            context.println(listTitle());
            for (Action<Context> a : actionList) {
                context.println(a.actionCode() + " - " + a.actionMessage());
            }
            context.println(quitCode + " - Quit");

            context.print("Choice -> ");
            String choice = context.readNext();

            if (choice.equals(quitCode)) {
                continue_ = false;
            } else {
                boolean found = false;
                for (Action<Context> a : actionList) {
                    if (a.actionCode().equals(choice)) {
                        a.execute(context);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    context.println("Please, enter the valid action code");
                }
            }
        } while (continue_);

        context.println("End of menu " + listTitle());
    }
}
