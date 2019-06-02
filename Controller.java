
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

    public void onActionTest(ActionEvent actionEvent) {
        //MyButton test = new MyButton(4,4,grid);
    }

    @FXML
    protected void initialize() {
        //myGrid.init(); //wywolanie metody init nie dziala gdy nowy obiekt MyGridPane zostanie stworzony w tej funkcji ( czemu?),
        // gdy MyGridPane jest jako obiekt tej klasy kompilator czyta , że metoda init jesy wywolywana, ale wywala błąd
        //MyButton m= new MyButton(4,4,grid); //w ten sposob dodaje przycisk bez wyrzucenia bledu
        MyButton [][] button = new MyButton[MyGridPane.DEFAULT_ROW_NUM][MyGridPane.DEFAULT_COL_NUM];
        for(int i=0; i< MyGridPane.DEFAULT_ROW_NUM; i++){
            for(int j=0;j<MyGridPane.DEFAULT_COL_NUM;j++){
                button[i][j]=new MyButton(i, j, grid);
            }
    }}
}

