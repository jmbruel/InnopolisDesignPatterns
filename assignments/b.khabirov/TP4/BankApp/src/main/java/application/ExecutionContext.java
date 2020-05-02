package application;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * An interface describing an application execution context,
 * that is, an environment the application is executed in.
 */
public interface ExecutionContext {
    /**
     * @return a scanner, where to expect user inputs
     */
    Scanner getScanner();

    /**
     * @return a stream, where the clients are expected to output.
     */
    PrintStream getPrintStream();
}
