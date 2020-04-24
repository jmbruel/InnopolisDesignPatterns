
import application.BankActionContext;
import bank.BankAgency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.PrintStream;
import java.util.Scanner;

public class TestContext {

    @Test
    public void testContextBankAgency(){
        BankAgency bankAgency = BankActionContext.getInstance().getBankAgency();
        BankAgency bankAgency2 = BankActionContext.getInstance().getBankAgency();

        Assertions.assertNotNull(bankAgency);
        Assertions.assertNotNull(bankAgency2);
        Assertions.assertEquals(bankAgency, bankAgency2);
    }


    @Test
    public void testContextScanner(){
        Scanner scanner = BankActionContext.getInstance().getScanner();
        Scanner scanner1 = BankActionContext.getInstance().getScanner();

        Assertions.assertNotNull(scanner);
        Assertions.assertNotNull(scanner1);
        Assertions.assertEquals(scanner, scanner1);
    }

    @Test
    public void testContextPrintStream(){
        PrintStream printStream = BankActionContext.getInstance().getPrintStream();
        PrintStream printStream1 = BankActionContext.getInstance().getPrintStream();

        Assertions.assertNotNull(printStream);
        Assertions.assertNotNull(printStream1);
        Assertions.assertEquals(printStream, printStream1);
    }
}