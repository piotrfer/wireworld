import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.util.ArrayList;
//znowu bardzo brzydka metoda, ale działa xd
public class MySpinner {
    public static void initializeSpinners(MyGridPane myGrid,Spinner s1, Spinner s2, Spinner s3, Spinner s4, Spinner s5, Spinner s6){
        //bardzo brzydko zrobione bo jest sztywna wartosc 5 czyli liczba kolumn i wierszy dla wszystkich modulow
        SpinnerValueFactory<Integer> columnValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, myGrid.getColNum()-5 );
        SpinnerValueFactory<Integer> rowValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, myGrid.getRowNum()-5 );
        SpinnerValueFactory<Integer> columnValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, myGrid.getColNum()-5 );
        SpinnerValueFactory<Integer> rowValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, myGrid.getRowNum()-5 );
        SpinnerValueFactory<Integer> columnValueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, myGrid.getColNum()-5 );
        SpinnerValueFactory<Integer> rowValueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, myGrid.getRowNum()-5 );
        s1.setValueFactory(columnValueFactory);
        s3.setValueFactory(columnValueFactory2);
        s5.setValueFactory(columnValueFactory3);
        s2.setValueFactory(rowValueFactory);
        s4.setValueFactory(rowValueFactory2);
        s6.setValueFactory(rowValueFactory3);

    }
}
