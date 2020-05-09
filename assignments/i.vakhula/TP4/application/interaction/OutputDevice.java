package application.interaction;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Responsible for writing data to output device.
 */
public class OutputDevice {
    private PrintWriter writer;

    public OutputDevice() {
        this(System.out);
    }

    public OutputDevice(OutputStream outputStream) {
        this.writer = new PrintWriter(outputStream);
    }

    public void setWriter(OutputStream outputStream) {
        this.writer.close();
        this.writer = new PrintWriter(outputStream, true);
    }

    public void println() {
        this.writer.println();
        this.writer.flush();
    }

    public void println(Object output) {
        this.writer.println(output);
        this.writer.flush();
    }

    public void print(Object output) {
        this.writer.print(output);
        this.writer.flush();
    }

    public PrintWriter getWriter() {
        return this.writer;
    }
}
