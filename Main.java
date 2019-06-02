
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @FXML private GridPane grid;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        /*Cell[][] board = new Cell[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 44; j++)
                board[i][j].setStatus((int) Math.random() % 4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 44; j++)
                System.out.print(board[i][j] + " ");
            System.out.println(" ");
        }
        Matrix test = new Matrix(board, 4, 4);
        test.simulateGeneration();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 44; j++)
                System.out.print(board[i][j] + " ");
            System.out.println(" ");
        } */
    }
}
