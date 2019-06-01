import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class MyButton extends Button {
    static int WIDTH=35;
    static int HEIGHT= 31;

    public MyButton(int x, int y , GridPane grid) {
        setId("Button(" +x+","+ y + ")");
        setText("");
        setPrefWidth(WIDTH);
        setPrefHeight(HEIGHT);
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                setStyle("-fx-background-color: #ff0000; ");
            }
        });
        grid.add(this, x, y);  //x is column index and 0 is row index

    }
}
