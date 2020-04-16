package tests;

import application.ApplicationContextBankAgency;
import application.action.*;
import bank.Account;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestActions {

    @Test
    public void testAddAction() throws Exception {
        InputStream is = new ByteArrayInputStream("1\nArina1\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(is);

        ActionAddAccount action = new ActionAddAccount("1", "Add Account");
        action.execute(ApplicationContextBankAgency.getInstance());

        String owner = ApplicationContextBankAgency.getInstance().getBankAgency().getAccount("1")
                .getOwner();

        Assertions.assertEquals("Arina1", owner);
    }

    @Test
    public void testRemoveAction() throws Exception {
        InputStream is1 = new ByteArrayInputStream("3\nArina3\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(is1);

        ActionAddAccount action1 = new ActionAddAccount("1", "Add Account");
        action1.execute(ApplicationContextBankAgency.getInstance());

        InputStream is2 = new ByteArrayInputStream("3".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(is2);

        ActionRemoveAccount action2 = new ActionRemoveAccount("1", "Remove Account");
        action2.execute(ApplicationContextBankAgency.getInstance());

        Account account = ApplicationContextBankAgency.getInstance().getBankAgency().getAccount("3");

        Assertions.assertNull(account);
    }

    @Test
    public void testDeposit() throws Exception {
        InputStream is1 = new ByteArrayInputStream("4\nArina4\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(is1);

        ActionAddAccount action1 = new ActionAddAccount("1", "Add Account");
        action1.execute(ApplicationContextBankAgency.getInstance());

        InputStream is2 = new ByteArrayInputStream("4\n2000\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(is2);

        ActionDeposit action2 = new ActionDeposit("1", "Deposit");
        action2.execute(ApplicationContextBankAgency.getInstance());

        double balance = ApplicationContextBankAgency.getInstance().getBankAgency().getAccount("4").balance();

        Assertions.assertEquals(2000, balance);
    }

    @Test
    public void testWithdraw() throws Exception {
        InputStream is1 = new ByteArrayInputStream("5\nArina5\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(is1);

        ActionAddAccount action1 = new ActionAddAccount("1", "Add Account");
        action1.execute(ApplicationContextBankAgency.getInstance());

        InputStream is2 = new ByteArrayInputStream("5\n200\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(is2);

        ActionWithdraw action2 = new ActionWithdraw("1", "Withdraw");
        action2.execute(ApplicationContextBankAgency.getInstance());

        double balance = ApplicationContextBankAgency.getInstance().getBankAgency().getAccount("5").balance();

        Assertions.assertEquals(-200, balance);
    }

}
