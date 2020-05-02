package application;

import bank.BankAgency;
import java.io.PrintStream;
import java.util.Scanner;

public final class ApplicationContextBankAgency implements ExecutionContext {
    private BankAgency bankAgency;
    private Scanner scanner;
    private PrintStream printStream;

    private static ApplicationContextBankAgency instance = new ApplicationContextBankAgency();

    public static ApplicationContextBankAgency getInstance() {
        return instance;
    }

    private ApplicationContextBankAgency() {
        this.printStream = new PrintStream(System.out);
        this.scanner = new Scanner(System.in);
        this.bankAgency = AccesBankAgency.getBankAgency();
    }

    public BankAgency getBankAgency() {
        return bankAgency;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }
}
