package test;

import application.ApplicationContextBankAgency;
import bank.BankAgency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.PrintStream;
import java.util.Scanner;

public class TestContext {
    @Test
    public void testContextBankAgency(){
        BankAgency bankAgency = ApplicationContextBankAgency.getInstance().getBankAgency();
        BankAgency bankAgency2 = ApplicationContextBankAgency.getInstance().getBankAgency();

        Assertions.assertNotNull(bankAgency);
        Assertions.assertNotNull(bankAgency2);
        Assertions.assertEquals(bankAgency, bankAgency2);
    }


    @Test
    public void testContextScanner(){
        Scanner scanner = ApplicationContextBankAgency.getInstance().getScanner();
        Scanner scanner1 = ApplicationContextBankAgency.getInstance().getScanner();

        Assertions.assertNotNull(scanner);
        Assertions.assertNotNull(scanner1);
        Assertions.assertEquals(scanner, scanner1);
    }

    @Test
    public void testContextPrintStream(){
        PrintStream printStream = ApplicationContextBankAgency.getInstance().getPrintStream();
        PrintStream printStream1 = ApplicationContextBankAgency.getInstance().getPrintStream();

        Assertions.assertNotNull(printStream);
        Assertions.assertNotNull(printStream1);
        Assertions.assertEquals(printStream, printStream1);
    }
}