
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class Controller {
    @FXML
    private GridPane grid;
    @FXML
    private Button startButton = new Button();
    @FXML
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
    private TextArea messagebox = new TextArea();
    @FXML
    private ToggleButton nonstopbtn = new ToggleButton();
    @FXML
    private ToggleButton stepsbtn = new ToggleButton();
    @FXML
    private Button stopButton = new Button();
    @FXML
    private RadioButton firstintervalbtn = new RadioButton();
    @FXML
    private RadioButton secondintervalbtn = new RadioButton();
    @FXML
    private RadioButton thirdintervalbtn = new RadioButton();
    @FXML
    private RadioButton fourthintervalbtn = new RadioButton();
    @FXML
    private RadioButton firstnumberbtn = new RadioButton();
    @FXML
    private RadioButton secondnumberbtn = new RadioButton();
    @FXML
    private RadioButton thirdnumberbtn = new RadioButton();
    @FXML
    private RadioButton fourthnumberbtn = new RadioButton();

    private Config config = new Config();
    private ToggleGroup modeToggle = new ToggleGroup();
    private ToggleGroup intervalToggle = new ToggleGroup();
    private ToggleGroup numberToggle = new ToggleGroup();


    @FXML
    protected void initialize() {

        CustomConsole cs = new CustomConsole( messagebox );
        PrintStream printStream = new PrintStream( cs, true);
        System.setOut(printStream);
        System.setErr(printStream);

        mySetToggleGroups();

        for(int i=0; i< MyGridPane.DEFAULT_ROW_NUM; i++){
            for(int j=0;j<MyGridPane.DEFAULT_COL_NUM;j++){
                myGrid.addMyButton(new MyButton(i, j, grid));
            }
        }
        MySpinner.initializeSpinners(myGrid,heartColumnSpinner, heartRowSpinner,flowerColumnSpinner, flowerRowSpinner, kiteColumnSpinner, kiteRowSpinner);
        ModulesCreator.initializeModules();

        System.out.println("Welcome to WireWorldSimulator2000!");
        System.out.println("Press help button if you need help!");
    }


    private void mySetToggleGroups(){
        nonstopbtn.setToggleGroup(modeToggle);
        nonstopbtn.setSelected(true);
        stepsbtn.setToggleGroup(modeToggle);
        firstintervalbtn.setToggleGroup(intervalToggle);
        secondintervalbtn.setToggleGroup(intervalToggle);
        thirdintervalbtn.setToggleGroup(intervalToggle);
        fourthintervalbtn.setToggleGroup(intervalToggle);
        thirdintervalbtn.setSelected(true);
        firstnumberbtn.setToggleGroup(numberToggle);
        secondnumberbtn.setToggleGroup(numberToggle);
        thirdnumberbtn.setToggleGroup(numberToggle);
        fourthnumberbtn.setToggleGroup(numberToggle);
        firstnumberbtn.setSelected(true);
        nonStopAction();
    }

    private void checkConfig(){
        if(nonstopbtn.isSelected()){
            config.setNonStop(true);
        }
        else{
            config.setNonStop(false);
        }
        if(firstintervalbtn.isSelected()){
            try {
                config.setTimeInterval(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if( secondintervalbtn.isSelected()){
            try {
                config.setTimeInterval(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if( thirdintervalbtn.isSelected()){
            try {
                config.setTimeInterval(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                config.setTimeInterval(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if( firstnumberbtn.isSelected()){
            try {
                config.setN(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if( secondnumberbtn.isSelected()){
            try {
                config.setN(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if( thirdnumberbtn.isSelected()){
            try {
                config.setN(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                config.setN(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onActionStop(ActionEvent actionEvent){

        config.setNonStop(false);

        startButton.setDisable(false);
        startButton.setVisible(true);
        stopButton.setDisable(true);
        stopButton.setVisible(false);

        System.out.println("Simulation stopped.");
    }

    public void printHelp(){
        System.out.println("Help:");
        System.out.println("WireWorldSimulator2000 can simulate WireWorld cellular automaton proposed by Brian Silverman in 1987.");
        System.out.println("Choose your settings in 'settings' page on the right side of the screen.");
        System.out.println("You can choose mode of simulation - non stop simulation or step by step.");
        System.out.println("You can also choose time interval and number of generations to simulate.");
        System.out.println("If you want to open file or save current generation use button on the right bottom side of the screen.");
        System.out.println("On the second tab - modules - you can add preinstalled modules to your grid.");
        System.out.println("Thank you for choosing WireWorldSimulator2000!");
    }

    public void nonStopAction(){
        firstnumberbtn.setDisable(true);
        secondnumberbtn.setDisable(true);
        thirdnumberbtn.setDisable(true);
        fourthnumberbtn.setDisable(true);
    }

    public void stepsAction(ActionEvent actionEvent){
        firstnumberbtn.setDisable(false);
        secondnumberbtn.setDisable(false);
        thirdnumberbtn.setDisable(false);
        fourthnumberbtn.setDisable(false);
    }

    public void onActionStart(ActionEvent actionEvent) {

        System.out.println("Simulation started.");
        checkConfig();
        if( config.getNonStop() ){

            MyTreadNonStopExtension mtnse = new MyTreadNonStopExtension(myGrid, config);
            Thread nonStopSimulationThread = new Thread( mtnse );

            nonStopSimulationThread.start();

            startButton.setDisable(true);
            startButton.setVisible(false);
            stopButton.setDisable(false);
            stopButton.setVisible(true);


        }
        else{
            MyTreadExtension simulateThread = new MyTreadExtension(myGrid, config, startButton);
            Thread simulationThread = new Thread(simulateThread);

            simulationThread.start();
        }
    }

    public void openbtnAction(ActionEvent actionEvent) {
        FileChooser ofc = new FileChooser();
        File selectedFile = ofc.showOpenDialog(null);


        if(selectedFile != null){
            try {
                myGrid.convertFromMatrix(MyFileReader.readFile(selectedFile.getAbsolutePath()));
                System.out.println("File " + selectedFile.getName() + " loaded successfully.");
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

class MyTreadExtension extends Thread {

    private Config config;
    public MyGridPane myGrid;
    private Button startButton;

    public MyTreadExtension(MyGridPane myGrid, Config config, Button startButton) {
        this.myGrid = myGrid;
        this.startButton = startButton;
        this.config = config;
    }

    @Override
    public void run(){

        startButton.setDisable(true);

        for(int i = 0; i < config.getN(); i++){
            try {
                TimeUnit.MILLISECONDS.sleep(config.getTimeInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Matrix m = myGrid.convertToMatrix();
            m.simulateGeneration();
            myGrid.convertFromMatrix(m);
        }
        startButton.setDisable(false);
    }
}

class MyTreadNonStopExtension extends Thread {

    private Config config;
    public MyGridPane myGrid;
    private Button startButton;

    public MyTreadNonStopExtension(MyGridPane myGrid, Config config) {
        this.myGrid = myGrid;
        this.config = config;
    }

    @Override
    public void run(){

        while(config.getNonStop()){
            try {
                TimeUnit.MILLISECONDS.sleep(config.getTimeInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Matrix m = myGrid.convertToMatrix();
            m.simulateGeneration();
            myGrid.convertFromMatrix(m);
        }
    }
}