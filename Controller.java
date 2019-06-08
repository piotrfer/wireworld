
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller {
    @FXML
    private GridPane grid;
    @FXML
    private Button startButton = new Button();
    @FXML
    private MyGridPane myGrid = new MyGridPane();
    @FXML
    private Button openbtn = new Button();
    @FXML
    private Button savebtn = new Button();
    @FXML
    private TextFlow messagebox = new TextFlow();
    @FXML
    private ToggleButton nonstopbtn = new ToggleButton();
    @FXML
    private ToggleButton stepsbtn = new ToggleButton();
    @FXML
    private ToggleGroup modeToggle = new ToggleGroup();
    @FXML
    private Button stopButton = new Button();

    private Config config = new Config();
    //private MyTreadExtension simulateThread = new MyTreadExtension(myGrid, config);
    //private Thread simulationThread = new Thread(simulateThread);

    @FXML
    protected void initialize() {
        //zrobic oddzielna funkcje w gridpane dodajaca te buttony
        nonstopbtn.setToggleGroup(modeToggle);
        nonstopbtn.setSelected(true);
        stepsbtn.setToggleGroup(modeToggle);
        for(int i=0; i< MyGridPane.DEFAULT_ROW_NUM; i++){
            for(int j=0;j<MyGridPane.DEFAULT_COL_NUM;j++){
                myGrid.addMyButton(new MyButton(i, j, grid));
            }
        }
    }

    /*Thread simulationThread = new Thread(() -> {
            final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(() -> {
                Matrix m = myGrid.convertToMatrix();
                m.simulateGeneration();
                myGrid.convertFromMatrix(m);
            }, 0, config.getTimeInterval(), TimeUnit.MILLISECONDS);
    }); */

    private void checkConfig(){
        if(nonstopbtn.isSelected()){
            config.setNonStop(true);
        }
        else{
            config.setNonStop(false);
        }

    }

    public void onActionStop(ActionEvent actionEvent){

        config.setNonStop(false);

        config.setNonStop(false);
        startButton.setDisable(false);
        startButton.setVisible(true);
        stopButton.setDisable(true);
        stopButton.setVisible(false);

    }

    public void onActionStart(ActionEvent actionEvent) {

        checkConfig();
        if( config.getNonStop() ){

            //simulationThread.start();

            startButton.setDisable(true);
            startButton.setVisible(false);
            stopButton.setDisable(false);
            stopButton.setVisible(true);

            //simulationThread.start();


        }
        else{
            Matrix m = myGrid.convertToMatrix();
            m.simulateGeneration();
            myGrid.convertFromMatrix(m);
        }
    }

    public void openbtnAction(ActionEvent actionEvent) {
        FileChooser ofc = new FileChooser();
        File selectedFile = ofc.showOpenDialog(null);


        if(selectedFile != null){
            try {
                myGrid.convertFromMatrix(MyFileReader.readFile(selectedFile.getAbsolutePath()));

            }
            catch(Exception e){
                System.err.println("File error " + e.getLocalizedMessage() + ".");
            }
        }
        else{
            System.err.println("File does not exist!");
        }
    }

    public void savebtnAction(ActionEvent actionEvent) {
        FileChooser sfc = new FileChooser();
        sfc.setInitialFileName("SaveGeneration");
        sfc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt"));
        File savedFile = sfc.showSaveDialog(null);

        if(savedFile != null) {
            try {
                MyFileWriter.writeFile(savedFile.getAbsolutePath(), myGrid.convertToMatrix());
                System.out.println("File was saved successfully.");
            }
            catch(IOException e){
                System.err.println("File error.");
            }
        }
        else{
            System.out.println("File error.");
        }
    }

}

/*class MyTreadExtension extends Thread {

    private Config config;
    public MyGridPane myGrid;

    public MyTreadExtension(MyGridPane myGrid, Config config) {
        this.myGrid = myGrid;
        this.config = config;
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            Matrix m = myGrid.convertToMatrix();
            m.simulateGeneration();
            myGrid.convertFromMatrix(m);
        }
    }
}*/
