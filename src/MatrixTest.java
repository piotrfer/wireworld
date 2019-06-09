import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void simulateGeneration() {
        Cell[][] board= new Cell[3][3];
        int [][] board2 ={{0, 1, 0},
        {3,0,1},
        {0,1,0}};
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j]=new Cell(board2[i][j]);
        Matrix actual= new Matrix(board,3,3);
        actual.simulateGeneration();

        Cell[][] boardExp= new Cell[3][3];
        int [][] board2Exp ={{0, 3, 0},
                {2,0,1},
                {0,3,0}};
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                boardExp[i][j]=new Cell(board2Exp[i][j]);
        Matrix expected = new Matrix(boardExp,3,3);
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                assertEquals(expected.getBoardElement(i,j).getStatus(), actual.getBoardElement(i,j).getStatus());


    }
}