package application.context;

import bank.BankAgency;
import java.io.Closeable;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author David Prudek
 */
public interface IContext extends Closeable {
    
    public Scanner getScanner();
    public PrintWriter getPrintWriter();
    public BankAgency getBankAgency();
    public void setInputStream(InputStream stream);

}
