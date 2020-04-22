package application.context;

import application.AccesBankAgency;
import bank.BankAgency;

import java.util.Scanner;

public class ApplicationContextBankAgency implements AppContext {
    private static ApplicationContextBankAgency instance = new ApplicationContextBankAgency();

    public static ApplicationContextBankAgency getInstance() {
        return instance;
    }

    private ApplicationContextBankAgency() {
    }

    private final Scanner lect = new Scanner(System.in);
    private final BankAgency ag = AccesBankAgency.getBankAgency();

    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @Override
    public String readNext() {
        return lect.next();
    }

    public BankAgency getAgency() {
        return ag;
    }

    public String getAgencyTitle() {
        return ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")";
    }
}
