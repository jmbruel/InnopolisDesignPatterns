import application.ApplicationContextBankAgency;
import application.action.*;
import bank.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TestAction {


    @Test
    public void testAddAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("00100\nIlya\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionAddAccount("Test", "1").execute(ApplicationContextBankAgency.getInstance());

        String owner = ApplicationContextBankAgency.getInstance().getBankAgency().
                getAccount("00100").getOwner();

        Assertions.assertEquals("Ilya", owner);

    }

    @Test
    public void testDeleteAccountAction() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("050503".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionDeleteAccount("1", "Test").execute(ApplicationContextBankAgency.getInstance());

        Account account = ApplicationContextBankAgency.getInstance().getBankAgency().getAccount("050503");

        Assertions.assertNull(account);


    }

    @Test
    public void testWithdrawAction() throws Exception {

        ByteArrayInputStream in = new ByteArrayInputStream("050501\n100.0\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionWithdraw("1", "Test").execute(ApplicationContextBankAgency.getInstance());


        Assertions.assertEquals(-100.0, ApplicationContextBankAgency.getInstance().getBankAgency().
                getAccount("050501").balance());

    }

    @Test
    public void testDepositAction() throws Exception {

        ByteArrayInputStream in = new ByteArrayInputStream("050502\n200.0\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionDeposit("1", "Test").execute(ApplicationContextBankAgency.getInstance());


        Assertions.assertEquals(200.0, ApplicationContextBankAgency.getInstance().getBankAgency().
                getAccount("050502").balance());

    }

}
