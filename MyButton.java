
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class MyButton extends Button {
    static int WIDTH=32;
    static int HEIGHT=29;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MyButton() {
        setText("");
        setPrefWidth(WIDTH);
        setPrefHeight(HEIGHT);
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(getStyle().equals("-fx-base: black;"))
                    setStyle("-fx-base: yellow;");
                else if(getStyle().equals("-fx-base: yellow;"))
                    setStyle("-fx-base: blue;");
                else if(getStyle().equals("-fx-base: blue;"))
                    setStyle("-fx-base: red;");
                else if(getStyle().equals("-fx-base: red;"))
                    setStyle("-fx-base: black;");
            }
        });
    }

    public MyButton(int x, int y , GridPane grid) {
        this.x=x;
        this.y=y;
        setId("Button(" +x+","+ y + ")");
        setText("");
        setPrefWidth(WIDTH);
        setPrefHeight(HEIGHT);
        setStyle("-fx-base: black;");
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(getStyle().equals("-fx-base: black;"))
                    setStyle("-fx-base: yellow;");
                else if(getStyle().equals("-fx-base: yellow;"))
                    setStyle("-fx-base: blue;");
                else if(getStyle().equals("-fx-base: blue;"))
                    setStyle("-fx-base: red;");
                else if(getStyle().equals("-fx-base: red;"))
                    setStyle("-fx-base: black;");
            }
        });
        grid.add(this, y, x);

    }

   /* public void addToGridPane(int x,int y , GridPane grid ){
        //sprawdzic czy juz przypadkiem wcesniej nie dodano
        setId("Button(" +x+","+ y + ")");
        grid.add(this, y, x);
    } */ //na razie nie potrzeba, moze kidys sie przyda
}
