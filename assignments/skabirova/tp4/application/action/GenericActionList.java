package application.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericActionList<E> implements ActionList<E> {

    /**
     * Generic Version of ActionList
     */

    String message;
    String code;
    String title;
    List<Action<E>> actionList;


    public GenericActionList(String message, String code, String title){
        this.message = message;
        this.title = title;
        this.code = code;
        this.actionList = new ArrayList<>();
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
    public boolean addAction(Action<E> ac) {
        return actionList.add(ac);
    }

    @Override
    public boolean addAction(Action<E> ac, int index) {
        actionList.add(index, ac);
        return actionList.get(index).equals(ac);
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
        ArrayList<String> s = new ArrayList<>();
        actionList.forEach((a) -> s.add(a.actionMessage()));
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
    public void execute(E e) throws Exception {
        String code;
        while (true) {
            System.out.println(this.title);
            for(Action<E> a: actionList){
                System.out.println(a.actionCode() + " - " + a.actionMessage());
            }
            System.out.println("0 - To quit this menu");
            System.out.println("Choice ?");

            code = new Scanner(System.in).next();
            if(code.equals("0")) return;

            for(Action<E> a:actionList){
                if(a.actionCode().equals(code)){
                    a.execute(e);
                    break;
                }
            }
        }
    }
}
