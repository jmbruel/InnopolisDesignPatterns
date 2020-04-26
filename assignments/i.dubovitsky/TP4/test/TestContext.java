import application.ApplicationContextBankAgency;
import bank.BankAgency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.PrintWriter;
import java.util.Scanner;

public class TestContext {

    @Test
    public void testBankAgencySingleton() {
        BankAgency bankAgency = ApplicationContextBankAgency.getInstance().getBankAgency();
        BankAgency bankAgency2 = ApplicationContextBankAgency.getInstance().getBankAgency();

        Assertions.assertNotNull(bankAgency);
        Assertions.assertNotNull(bankAgency2);
        Assertions.assertEquals(bankAgency, bankAgency2);
    }


    @Test
    public void testScannerSingleton() {
        Scanner scanner = ApplicationContextBankAgency.getInstance().getScanner();
        Scanner scanner1 = ApplicationContextBankAgency.getInstance().getScanner();

        Assertions.assertNotNull(scanner);
        Assertions.assertNotNull(scanner1);
        Assertions.assertEquals(scanner, scanner1);
    }

    @Test
    public void testPrintWriterSingleton() {
        PrintWriter printWriter = ApplicationContextBankAgency.getInstance().getPrintWriter();
        PrintWriter printWriter1 = ApplicationContextBankAgency.getInstance().getPrintWriter();

        Assertions.assertNotNull(printWriter);
        Assertions.assertNotNull(printWriter1);
        Assertions.assertEquals(printWriter, printWriter1);
    }
}
