package action;

import java.io.Closeable;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
    Minimal context with `Scanner` and `PrintStream`
 */
public interface ActionContext extends Closeable {
    Scanner getScanner();

    PrintStream getPrintStream();

    void setInputStream(InputStream stream);

    void close();
}