
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    private GridPane grid;
    private MyGridPane myGrid = new MyGridPane();
    @FXML
    private Spinner kiteRowSpinner;
    @FXML
    private Spinner kiteColumnSpinner;
    @FXML
    private Spinner flowerRowSpinner;
    @FXML
    private Spinner flowerColumnSpinner;
    @FXML
    private Spinner heartRowSpinner;
    @FXML
    private Spinner heartColumnSpinner;





    @FXML
    protected void initialize() {
        //zrobic oddzielna funkcje w gridpane dodajaca te buttony
        for(int i=0; i< MyGridPane.DEFAULT_ROW_NUM; i++){
            for(int j=0;j<MyGridPane.DEFAULT_COL_NUM;j++){
                myGrid.addMyButton(new MyButton(i, j, grid));
            }
        }
        MySpinner.initializeSpinners(myGrid,heartColumnSpinner, heartRowSpinner,flowerColumnSpinner, flowerRowSpinner, kiteColumnSpinner, kiteRowSpinner);
        ModulesCreator.initializeModules();
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

    public void addKite(ActionEvent actionEvent) {
        int rowValue = (Integer) kiteRowSpinner.getValue();
        int colValue = (Integer) kiteColumnSpinner.getValue();
        Matrix m = myGrid.convertToMatrix();
        m.changeMatrix(ModulesCreator.getKite(),colValue,rowValue);
        myGrid.convertFromMatrix(m);

    }

    public void addFlower(ActionEvent actionEvent) {
        int rowValue = (Integer) flowerRowSpinner.getValue();
        int colValue = (Integer) flowerColumnSpinner.getValue();
        //System.out.println(" " + rowValue+ "   " + colValue);
        Matrix m = myGrid.convertToMatrix();
        m.changeMatrix(ModulesCreator.getFlower(),colValue,rowValue);
        myGrid.convertFromMatrix(m);

    }

    public void addHeart(ActionEvent actionEvent) {
        int rowValue = (Integer) heartRowSpinner.getValue();
        int colValue = (Integer) heartColumnSpinner.getValue();
        //System.out.println(" " + rowValue+ "   " + colValue);
        Matrix m = myGrid.convertToMatrix();
        m.changeMatrix(ModulesCreator.getHeart(),colValue,rowValue);
        myGrid.convertFromMatrix(m);

    }
}

