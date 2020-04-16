package application.actionList;

import application.ApplicationContextBankAgency;
import application.action.Action;
import application.action.ActionList;

import java.util.ArrayList;
import java.util.List;

public class ActionListBankAgency implements ActionList<ApplicationContextBankAgency> {
    private String code;
    private String message;
    private String title;
    private List<Action<ApplicationContextBankAgency>> actionList;


    public ActionListBankAgency(String code, String message, String title){
        this.code = code;
        this.message = message;
        this.title = title;
        this.actionList = new ArrayList<>();
    }

    @Override
    public String listTitle() {
        return this.title;
    }

    @Override
    public int size() {
        return this.actionList.size();
    }

    @Override
    public boolean addAction(Action<ApplicationContextBankAgency> ac) {
        return this.actionList.add(ac);
    }

    @Override
    public boolean addAction(Action<ApplicationContextBankAgency> ac, int index) {
        this.actionList.add(index, ac);
        return this.actionList.contains(ac);
    }

    @Override
    public boolean removeAction(int index) {
        return this.actionList.remove(index) != null;
    }

    @Override
    public boolean removeAction(Action<ApplicationContextBankAgency> ac) {
        return this.actionList.remove(ac);
    }

    @Override
    public String[] listOfActions() {
        ArrayList<String> s = new ArrayList<>();
        actionList.forEach((a) -> s.add(a.actionMessage()));
        return s.toArray(new String[0]);
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        String code;
        while (true) {
            context.getPrintWriter().println(this.title);
            for(Action<ApplicationContextBankAgency> a: actionList){
                context.getPrintWriter().println(a.actionCode() + " - " + a.actionMessage());
            }
            context.getPrintWriter().println("0 - To quit this menu");
            context.getPrintWriter().println("Choice ?");
            context.getPrintWriter().flush();

            code = context.getScanner().next();

            if(code.equals("0")) return;

            for(Action<ApplicationContextBankAgency> a:actionList){
                if(a.actionCode().equals(code)){
                    a.execute(context);
                    break;
                }
            }
        }
    }
}
