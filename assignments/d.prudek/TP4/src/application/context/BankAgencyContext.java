package application.context;

import application.AccesBankAgency;
import bank.BankAgency;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public class BankAgencyContext implements IContext {
    
    private static BankAgencyContext instance;
    private BankAgency bankAgency;
    private Scanner scanner;
    private PrintWriter printWriter;

    private BankAgencyContext(){
        printWriter = new PrintWriter(System.out);
        scanner = new Scanner(System.in);
        bankAgency = AccesBankAgency.getBankAgency();
    }

    public static BankAgencyContext getInstance() {
        if(instance == null)
            instance = new BankAgencyContext();
        return instance;
    }

    @Override
    public Scanner getScanner(){
        return scanner;
    }

    @Override
    public PrintWriter getPrintWriter(){
        return printWriter;
    }

    @Override
    public BankAgency getBankAgency(){
        return bankAgency;
    }

    @Override
    public void setInputStream(InputStream stream){
        scanner.close();
        scanner = new Scanner(stream);
    }

    @Override
    public void close(){
        scanner.close();
        printWriter.close();
    }
    
}
