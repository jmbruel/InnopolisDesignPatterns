package application.interaction;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Responsible for reading data.
 */
public class InputDevice {
    private Scanner reader;

    public InputDevice() {
        this(System.in);
    }

    public InputDevice(InputStream inputStream) {
        this.reader = new Scanner(inputStream);
    }

    public void setReader(InputStream inputStream) {
        this.reader.close();
        this.reader = new Scanner(inputStream);
    }

    public String next() {
        return this.reader.next();
    }

    public String nextLine() {
        return this.reader.nextLine();
    }

    public double nextDouble() {
        return this.reader.nextDouble();
    }

    public Scanner getReader() {
        return this.reader;
    }
}
