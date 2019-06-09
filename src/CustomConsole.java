import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.io.OutputStream;

public class CustomConsole extends OutputStream {

    private TextArea output;

    public CustomConsole(TextArea ta) {
        this.output = ta;
    }

    @Override
    public void write(int i) throws IOException {
        output.appendText(String.valueOf((char)i));
    }
}
