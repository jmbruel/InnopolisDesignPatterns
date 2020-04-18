package application.actionList;

import application.action.Action;
import application.action.ActionList;
import bank.BankAgency;

import java.util.ArrayList;

public class GenericActionList<E> implements ActionList<E> {
    protected String message;
    protected String code;
    protected String title;
    protected ArrayList<Action<E>> actionList;

    public GenericActionList(String message, String code, String title) {
        this.message = message;
        this.code = code;
        this.title = title;
        this.actionList = new ArrayList<>();
    }


    @Override
    public String listTitle() {
        return this.title;
    }

    @Override
    public int size() {
        return actionList.size();
    }

    @Override
    public boolean addAction(Action<E> ac, int index) {
        if (actionList.contains(ac)) {
            return false;
        }
        actionList.add(index, ac);
        return true;
    }

    public boolean addAction(Action<E> ac){
       return this.addAction(ac, actionList.size());
    }

    @Override
    public boolean removeAction(int index) {
        return actionList.remove(index)!=null;
    }

    @Override
    public boolean removeAction(Action<E> ac) {
        return actionList.remove(ac);
    }

    @Override
    public String listOfActions() {
        return null;
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
    public void execute(E ac) throws Exception {

    }

}
