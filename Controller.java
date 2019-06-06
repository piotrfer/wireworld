
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    private GridPane grid;
    private MyGridPane myGrid = new MyGridPane();

    @FXML
    protected void initialize() {
        //zrobic oddzielna funkcje w gridpane dodajaca te buttony
        for(int i=0; i< MyGridPane.DEFAULT_ROW_NUM; i++){
            for(int j=0;j<MyGridPane.DEFAULT_COL_NUM;j++){
                myGrid.addMyButton(new MyButton(i, j, grid));
            }
        }
    }

    public void onActionStart(ActionEvent actionEvent) {
        Matrix m = myGrid.convertToMatrix();
        m.simulateGeneration();
        myGrid.convertFromMatrix(m);
    }

    public void openFile() {
        System.out.println("Ok, tu się plik otworzy jak coś");
    }

    public void saveFile() {
        System.out.println("Ok, tu będę zapisywał plik jak już ogarnę");
    }
}

