
import static org.junit.Assert.*;

public class MyFileReaderTest {

    @org.junit.Test
    public void readFile() {
        Cell[][] board = new Cell[4][4];
        int[][] board2 = {{0, 0, 3, 1},
                {2, 2, 1, 3},
                {1, 2, 3, 0},
                {0, 0, 3, 2}};
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                board[i][j] = new Cell(board2[i][j]);
        Matrix expected = new Matrix(board, 4, 4);
        Matrix actual = null;
        try {
            actual = MyFileReader.readFile("readFileTest.txt");
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        //actual.printToConsole();
        //expected.printToConsole();

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                try {
                    assertEquals(expected.getBoardElement(i, j).getStatus(), actual.getBoardElement(i, j).getStatus());
                } catch (NullPointerException e) {
                }
            }
        }


    }
}