package application.actionlist;

import application.ApplicationContextBankAgency;
import application.action.Action;
import application.action.ActionList;

import java.util.ArrayList;
import java.util.List;

public class ActionListBankAgency implements ActionList<ApplicationContextBankAgency> {

    private String message;
    private String code;
    private String title;
    private List<Action<ApplicationContextBankAgency>> actionlist;

    public ActionListBankAgency(String code, String message, String title) {
        this.message = message;
        this.title = title;
        this.code = code;
        this.actionlist = new ArrayList<>();
    }

    @Override
    public String listTitle() {
        return this.title;
    }

    @Override
    public int size() {
        return this.actionlist.size();
    }

    @Override
    public boolean addAction(Action<ApplicationContextBankAgency> ac) {
        return this.actionlist.add(ac);
    }

    @Override
    public boolean addAction(Action<ApplicationContextBankAgency> ac, int index) {
        this.actionlist.add(index, ac);
        return this.actionlist.get(index).equals(ac);
    }

    @Override
    public boolean removeAction(int index) {
        return this.actionlist.remove(index) != null;
    }

    @Override
    public boolean removeAction(Action<ApplicationContextBankAgency> ac) {
        return this.actionlist.remove(ac);
    }

    @Override
    public String[] listOfActions() {
        ArrayList<String> s = new ArrayList<>();
        this.actionlist.forEach((a) -> s.add(a.actionMessage()));
        return s.toArray(new String[0]);
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
        String code;
        while (true) {
            context.outputDevice.println(this.title);

            for (Action<ApplicationContextBankAgency> a : this.actionlist) {
                context.outputDevice.println(a.actionCode() + " - " + a.actionMessage());
            }

            context.outputDevice.println("0 - To quit this menu");
            context.outputDevice.print("Choice -> ");

            code = context.inputDevice.next();

            if (code.equals("0")) {
                return;
            }

            for (Action<ApplicationContextBankAgency> a : this.actionlist) {
                if (a.actionCode().equals(code)) {
                    a.execute(context);
                    break;
                }
            }
        }
    }
}