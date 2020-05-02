package application;

import application.action.*;

/**
 * An action factory that assembles an action list for bank app.
 */
public class BankActionFactory implements ActionFactory<ApplicationContextBankAgency> {
    @Override
    public Action<ApplicationContextBankAgency> createAction() {
        GenericActionList<ApplicationContextBankAgency> mainMenu = new GenericActionList<>(
                "General",
                "1",
                "General Menu"
        );

        GenericActionList<ApplicationContextBankAgency> accountInfoMenu = new GenericActionList<>(
                "See an account (by its number)",
                "2",
                "Accounts list"
        );

        accountInfoMenu.addAction(new AccountDetailsByNumberAction("Get Account by Number", "1"));
        accountInfoMenu.addAction(new AccountDetailsByOwnerAction("Get Accounts by Owner", "2"));

        GenericActionList<ApplicationContextBankAgency> operationsMenu = new GenericActionList<>(
                "Operation on an account",
                "3",
                "Operations on an account"
        );

        operationsMenu.addAction(new DepositToAccountAction( "Deposit money to an account", "1"));
        operationsMenu.addAction(new WithdrawFromAccountAction( "Withdraw money from an account", "2"));

        GenericActionList<ApplicationContextBankAgency> accountMenu = new GenericActionList<>(
                "Accounts Management",
                "4",
                "Accounts management"
        );

        accountMenu.addAction(new NewAccountAction("Add an account", "1"));
        accountMenu.addAction(new DeleteAccountAction("Delete an account", "2"));

        mainMenu.addAction(new ListAccountsAction("List of the Agency accounts", "1"));
        mainMenu.addAction(accountInfoMenu);
        mainMenu.addAction(operationsMenu);
        mainMenu.addAction(accountMenu);

        return mainMenu;
    }
}
