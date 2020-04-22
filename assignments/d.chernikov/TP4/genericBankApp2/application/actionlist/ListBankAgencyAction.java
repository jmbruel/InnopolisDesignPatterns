package application.actionlist;

import application.action.Action;
import bank.BankAgency;

import java.util.ArrayList;
import java.util.Scanner;

public class ListBankAgencyAction implements ActionList<BankAgency> {
    private static final String message = "List of the Agency actions";
    private final String code, title;
    private final ArrayList<Action<BankAgency>> actionList = new ArrayList<>();

    public ListBankAgencyAction(String code, String title) {
        this.code = code;
        this.title = title;
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
    public boolean addAction(Action<BankAgency> ac) {
        return actionList.add(ac);
    }

    private static final String quitCode = "0";

    @Override
    public void execute(BankAgency ag) throws Exception {
        boolean continue_ = true;
        do {
            System.out.println("Menu of " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
            for (Action<BankAgency> a : actionList) {
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
                for (Action<BankAgency> a : actionList) {
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
