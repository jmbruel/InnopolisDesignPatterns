import application.action.ActionAddAccount;
import application.action.ActionDeleteAccount;
import application.action.ActionDepositMoneyOnAccount;
import application.action.ActionWithdrawMoneyFromAccount;
import application.actioncontext.BankActionContext;
import bank.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class TestAction {


    @Test
    public void testAddAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("00100\nNikita\n".getBytes());
        BankActionContext context = BankActionContext.getInstance();
        context.setInputStream(in);

        new ActionAddAccount("1", "Hello").execute(context);

        String owner = context.getBankAgency().
                getAccount("00100").getOwner();

        Assertions.assertEquals("Nikita", owner);

    }

    @Test
    public void testDeleteAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("750610".getBytes());
        BankActionContext context = BankActionContext.getInstance();
        context.setInputStream(in);

        new ActionDeleteAccount("1", "Hello").execute(context);

        Account account = context.getBankAgency().getAccount("750610");

        Assertions.assertNull(account);
    }

    @Test
    public void testWithdrawMoneyAction() throws Exception {

        ByteArrayInputStream in = new ByteArrayInputStream("050501\n100,0\n".getBytes());
        BankActionContext context = BankActionContext.getInstance();
        context.setInputStream(in);

        new ActionWithdrawMoneyFromAccount("1", "Hello").execute(context);


        Assertions.assertEquals(-100.0, context.getBankAgency().
                getAccount("050501").balance());
    }

    @Test
    public void testDepositMonetAction() throws Exception {

        ByteArrayInputStream in = new ByteArrayInputStream("050502\n200,0\n".getBytes());
        BankActionContext context = BankActionContext.getInstance();
        context.setInputStream(in);

        new ActionDepositMoneyOnAccount("1", "Hello").execute(context);


        Assertions.assertEquals(200.0, context.getBankAgency().
                getAccount("050502").balance());

    }

}