package test;

import application.ApplicationContextBankAgency;
import application.action.ActionAddAccount;
import application.action.ActionGetAccount;
import application.action.ActionRemoveAccount;
import application.actionlist.ActionListBankAgency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ActionListTest {

    @Test
    void testSizeOfActionList() {
        ActionListBankAgency actionListBankAgency = new ActionListBankAgency("", "", "");
        Assertions.assertEquals(0, actionListBankAgency.size());

        actionListBankAgency.addAction(new ActionGetAccount("1", "1"));
        Assertions.assertEquals(1, actionListBankAgency.size());
    }

    /**
     * flow consists of add an account, deposit, withdraw and remove
     */
    @Test
    void flow() throws Exception {
        final int initialNumberOfAccounts = ApplicationContextBankAgency.getInstance().getAgency().getNbAccounts();
        Assertions.assertEquals(initialNumberOfAccounts, ApplicationContextBankAgency.getInstance().getAgency().getNbAccounts());

        // prepare context (scan should read something and by this we gives food for it)
        InputStream prepareAdd = new ByteArrayInputStream("coolest_number\ncoolest_owner\n".getBytes());
        ApplicationContextBankAgency.getInstance().inputDevice.setReader(prepareAdd);

        // add an account
        ActionAddAccount actionAddAccount = new ActionAddAccount("1", "...");
        actionAddAccount.execute(ApplicationContextBankAgency.getInstance());

        String owner = ApplicationContextBankAgency.getInstance().getAgency().getAccount("coolest_number")
                .getOwner();

        Assertions.assertEquals("coolest_owner", owner);
        Assertions.assertEquals(initialNumberOfAccounts + 1, ApplicationContextBankAgency.getInstance().getAgency().getNbAccounts());

        // prepare context (scan should read something and by this we gives food for it)
        InputStream prepareRemove = new ByteArrayInputStream("coolest_number\n".getBytes());
        ApplicationContextBankAgency.getInstance().inputDevice.setReader(prepareRemove);
        // remove an account
        ActionRemoveAccount actionRemoveAccount = new ActionRemoveAccount("2", "...");
        actionRemoveAccount.execute(ApplicationContextBankAgency.getInstance());

        Assertions.assertEquals(initialNumberOfAccounts, ApplicationContextBankAgency.getInstance().getAgency().getNbAccounts());
    }


}
