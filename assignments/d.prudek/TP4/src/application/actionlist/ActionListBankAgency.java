package application.actionlist;

import application.action.Action;
import application.action.ActionList;
import application.context.IContext;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class ActionListBankAgency implements ActionList {
    
    private String message;
    private String code;
    private String title;
    private ArrayList<Action> actionlist = new ArrayList<Action>();

    public ActionListBankAgency(String message, String code, String title) {
        this.message = message;
        this.code = code;
        this.title = title;
    }
    
    

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return actionlist.size();
    }

    @Override
    public boolean addAction(Action ac) {
        actionlist.add(ac);
        return true;
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
    public void execute(IContext context) throws Exception {
        String code;
        Scanner lect = context.getScanner();
        while (true) {
            System.out.println(this.title);
            for(Action a: actionlist){
                System.out.println(a.actionCode() + " - " + a.actionMessage());
            }
            System.out.println("0 - To quit this menu");
            System.out.println("Choice ?");

            code = lect.next();

            if(code.equals("0")) return;

            for(Action a : actionlist){
                if(a.actionCode().equals(code)){
                    a.execute(context);
                    break;
                }
            }
        }
    }
    
}
