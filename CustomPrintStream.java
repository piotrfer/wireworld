import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CustomPrintStream extends PrintStream {
    public CustomPrintStream() {
        super(new ByteArrayOutputStream());
    }

    public void println(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    public void print(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

}  