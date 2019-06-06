import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MyGridPane {

    // grid jest tworzony w scene builderze,
    // trzeba pamietac, zeby te wartosci sie zgadzaly, docelowo mozna zrobic
    // tak zeby gridpane tworzyc tu w oparciu o domyslne wartoosci

    public static final int DEFAULT_COL_NUM = 20;
    public static final int DEFAULT_ROW_NUM = 14;
    private int colNum = DEFAULT_COL_NUM;
    private int rowNum = DEFAULT_ROW_NUM ;
    private ArrayList<MyButton> buttonsList = new ArrayList<>(); //lista przyciskow jednowymiarowa, trzeba pamietac o zamianie wspolrzednych

    public ArrayList<MyButton> getButtonsList() {
        return buttonsList;
    }

    public void addMyButton(MyButton button){
        buttonsList.add(button);
    }

    public void clearButtonList(){
        buttonsList.clear();
    }

    public void init(){
    //tu bedzie metoda tworzaca plansze na poczatku
}
    public void convertFromMatrix(Matrix m){ // zmieniamy kolorki istniejacym
        for(int i=0; i< rowNum; i++){
            for(int j=0;j<colNum;j++){
                switch(m.getBoardElement(i,j).getStatus()){
                    case(Cell.EMPTY):
                       buttonsList.get(i*colNum +j).setStyle("-fx-base: black;");
                       break;
                    case(Cell.HEAD):
                        buttonsList.get(i*colNum +j).setStyle("-fx-base: blue;");
                        break;
                    case(Cell.COND):
                        buttonsList.get(i*colNum +j).setStyle("-fx-base: yellow;");
                        break;
                    case(Cell.TAIL):
                        buttonsList.get(i*colNum +j).setStyle("-fx-base: red;");
                        break;
                }
            }
        }
    }

    public Matrix convertToMatrix(){
        Cell [][] board = new Cell[rowNum][colNum];
        for(MyButton button : buttonsList){
            if(button.getStyle().equals("-fx-base: black;")) //mozna potem zrobic switcha
                board[button.getX()][button.getY()]= new Cell(Cell.EMPTY);
            else if(button.getStyle().equals("-fx-base: yellow;"))
                board[button.getX()][button.getY()]= new Cell(Cell.COND);
            else if(button.getStyle().equals("-fx-base: blue;"))
                board[button.getX()][button.getY()]= new Cell(Cell.HEAD);
            else if(button.getStyle().equals("-fx-base: red;"))
                board[button.getX()][button.getY()]= new Cell(Cell.TAIL);
        }
        return new Matrix(board,colNum,rowNum);

    }

    /*private void addMyButton(MyButton button, int x, int y){
        button.setId("Button(" +x+","+ y + ")");
        grid.add(button, x, y);
    } */

}
