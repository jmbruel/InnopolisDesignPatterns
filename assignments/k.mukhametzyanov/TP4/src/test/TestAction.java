package test;

import application.ApplicationContextBankAgency;
import application.action.ActionAddAccount;
import application.action.ActionDeleteAccount;
import application.action.ActionDepositToAccount;
import application.action.ActionWithdrawFromAccount;
import bank.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class TestAction {
    @Test
    public void testAddAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("00200\nTestUser\n".getBytes());
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        context.setInputStream(in);

        new ActionAddAccount("Some message", "1").execute(context);

        String owner = context.getBankAgency().
                getAccount("00200").getOwner();

        Assertions.assertEquals("TestUser", owner);

    }

    @Test
    public void testDeleteAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("090905".getBytes());
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        context.setInputStream(in);

        new ActionDeleteAccount("Some message", "1").execute(context);

        Account account = context.getBankAgency().getAccount("090905");

        Assertions.assertNull(account);
    }

    @Test
    public void testWithdrawMoneyAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("090905\n100,0\n".getBytes());
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        context.setInputStream(in);

        new ActionWithdrawFromAccount("Some message", "1").execute(context);


        Assertions.assertEquals(-100.0, context.getBankAgency().
                getAccount("090905").balance());
    }

    @Test
    public void testDepositMonetAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("090904\n200,0\n".getBytes());
        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
        context.setInputStream(in);

        new ActionDepositToAccount("Some message", "1").execute(context);


        Assertions.assertEquals(200.0, context.getBankAgency().
                getAccount("090904").balance());

    }
}