import application.BankActionContext;
import application.actions.AddAccount;
import application.actions.DeleteAccount;
import application.actions.Deposit;
import application.actions.Withdraw;
import bank.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class TestAction {


    @Test
    public void testAddDeleteAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("123\nIlgizar\n".getBytes());
        BankActionContext context = BankActionContext.getInstance();
        context.setInputStream(in);

        new AddAccount("1", "Add an account").execute(context);

        String owner = context.getBankAgency().
                getAccount("123").getOwner();

        Assertions.assertEquals("Ilgizar", owner);

        in = new ByteArrayInputStream("123".getBytes());
        context = BankActionContext.getInstance();
        context.setInputStream(in);

        new DeleteAccount("1", "Delete an account").execute(context);

        Account account = context.getBankAgency().getAccount("123");

        Assertions.assertNull(account);
    }


    @Test
    public void testDepositWithdrawAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("050501\n100.0\n".getBytes());
        BankActionContext context = BankActionContext.getInstance();
        context.setInputStream(in);

        new Deposit("1", "Deposit").execute(context);

        double balance = context.getBankAgency().getAccount("050501").balance();

        Assertions.assertEquals(100, balance);

        in = new ByteArrayInputStream("050501\n100.0\n".getBytes());
        context = BankActionContext.getInstance();
        context.setInputStream(in);

        new Withdraw("1", "Withdraw").execute(context);

        balance = context.getBankAgency().getAccount("050501").balance();

        Assertions.assertEquals(0, balance);
    }

}