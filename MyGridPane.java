import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MyGridPane {

    @FXML
    GridPane grid;
    // domyslne wartosci, ale i tak grid jest tworzony w scene builderze,
    // trzeba pamietac, zeby te wartosci sie zgadzaly, mozna potem zrobic
    // tak zeby gridpane tworzyc tu w oparciu o domyslne wartoosci
    public static final int DEFAULT_COL_NUM = 20;
    public static final int DEFAULT_ROW_NUM = 14;

    public void init(){
    /*for(int i=0; i<DEFAULT_ROW_NUM; i++){
        for(int j=0;j<DEFAULT_COL_NUM;j++){
            addMyButton(new MyButton(),i,j);
        }
    } */

        MyButton m= new MyButton(4,4,grid);
}

    /*private void addMyButton(MyButton button, int x, int y){
        button.setId("Button(" +x+","+ y + ")");
        grid.add(button, x, y);
    } */

}
