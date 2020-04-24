package application;

import action.Action;
import action.ActionContext;
import action.ActionList;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountActionList<Context extends ActionContext> implements ActionList<Context> {
    String message;
    String code;
    String title;
    ArrayList<Action<Context>> actionlist;

    public BankAccountActionList(String code, String message, String title) {
        this.code = code;
        this.message = message;
        this.title = title;
        this.actionlist = new ArrayList<Action<Context>>();
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
    public boolean addAction(Action<Context> ac) {
        this.actionlist.add(ac);
        return true;
    }

    @Override
    public boolean removeAction(int index) {
        return false;
    }

    @Override
    public boolean removeAction(Action<Context> ac) {
        this.actionlist.remove(ac);
        return true;
    }

    @Override
    public String[] listOfActions() {
        String[] list = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            list[i] = this.actionlist.get(i).actionMessage();
        }
        return list;
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
    public void execute(Context context) throws Exception {
        PrintStream printStream = context.getPrintStream();
        Scanner scanner = context.getScanner();
        String code;
        while (true) {
            printStream.println(this.title);
            printStream.println("  Choose:");
            for(int i=0; i<this.size(); i++){
                Action<Context> action = this.actionlist.get(i);
                printStream.println("    " + action.actionCode() + " - " + action.actionMessage());
            }
            printStream.println("\n    0 - To quit this menu");
            printStream.println("  Choice ?");

            code = scanner.next();
            if(code.equals("0")) return;

            for(Action<Context> action: this.actionlist){
                if(action.actionCode().equals(code)){
                    action.execute(context);
                    break;
                }
            }
        }
    }
}