import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MyFileWriterTest {

    @Test
    public void writeFile() {
        Cell[][] board= new Cell[4][4];
        int [][] board2 ={{0, 2, 3, 1},
                {2, 0, 2, 3},
                {2, 3, 1, 0},
                {0, 1, 1, 0}};
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                board[i][j]=new Cell(board2[i][j]);
        Matrix actual= new Matrix(board,4,4);
        try {
            MyFileWriter.writeFile("testWriteFile", actual);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //tu trzeba sprawdzic czy plik faktycznie sie zapisal
    }
}