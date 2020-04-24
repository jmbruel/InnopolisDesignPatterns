package test;

import application.ApplicationContextBankAgency;
import application.action.*;
import bank.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TestAction {


    @Test
    public void testAction1() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("00100\nLena\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionAddAccount("1", "Hello").execute(ApplicationContextBankAgency.getInstance());

        String owner = ApplicationContextBankAgency.getInstance().getBankAgency().
                getAccount("00100").getOwner();

        Assertions.assertEquals("Lena", owner);

    }

    @Test
    public void testAction2() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("050503".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionRemoveAccount("1", "Hello").execute(ApplicationContextBankAgency.getInstance());

        Account account = ApplicationContextBankAgency.getInstance().getBankAgency().getAccount("050503");

        Assertions.assertNull(account);


    }

    @Test
    public void testAction3() throws Exception {

        ByteArrayInputStream in = new ByteArrayInputStream("050501\n100.0\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionWithdraw("1", "Hello").execute(ApplicationContextBankAgency.getInstance());


        Assertions.assertEquals(-100.0, ApplicationContextBankAgency.getInstance().getBankAgency().
                getAccount("050501").balance());

    }

    @Test
    public void testAction4() throws Exception {

        ByteArrayInputStream in = new ByteArrayInputStream("050502\n200.0\n".getBytes());
        ApplicationContextBankAgency.getInstance().setInputStream(in);

        new ActionDeposit("1", "Hello").execute(ApplicationContextBankAgency.getInstance());


        Assertions.assertEquals(200.0, ApplicationContextBankAgency.getInstance().getBankAgency().
                getAccount("050502").balance());

    }

}
