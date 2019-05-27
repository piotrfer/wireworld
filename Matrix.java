package com.company;

public class Matrix {
    private Cell[][] board;
    private int colNum;
    private int rowNum;

    public Matrix(Cell[][] board, int colNum, int rowNum) {
        this.board = board;
        this.colNum = colNum;
        this.rowNum = rowNum;
    }

    public Cell getBoardElement(int i, int j) {
        return board[i][j];
    }

    public int simulateGeneration() {
        int headNeigh = 0;
        Matrix next = new Matrix(board, colNum, rowNum);
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if( board[i][j].getStatus() == Cell.EMPTY)
                        next.getBoardElement(i,j).setStatus(Cell.EMPTY);
                else if( board[i][j].getStatus() == Cell.HEAD)
                        next.getBoardElement(i, j).setStatus(Cell.TAIL);
                else if( board[i][j].getStatus() == Cell.TAIL)
                        next.getBoardElement(i, j).setStatus(Cell.COND);
                 else if( board[i][j].getStatus() == Cell.COND){
                        headNeigh=0;
                        if (i - 1 >= 0)
                             if (board[i - 1][j].getStatus() == Cell.HEAD) //top neighbour cell
                            headNeigh++;
                        if ((j + 1 < colNum) && (i - 1 >= 0))
                            if (board[i - 1][j + 1].getStatus() == Cell.HEAD) //right top neighbour cell
                            headNeigh++;
                        if (j + 1 < colNum)
                            if (board[i][j + 1].getStatus() == Cell.HEAD) //right neighbour cell
                                headNeigh++;
                        if ((j + 1< colNum) && (i + 1 < rowNum))
                            if (board[i + 1][j + 1].getStatus() == Cell.HEAD) //right bottom neighbour cell
                                headNeigh++;
                        if (i + 1 < rowNum)
                            if (board[i + 1][j].getStatus() == Cell.HEAD) //bottom neighbour cell
                            headNeigh++;
                        if ((j - 1 >= 0) && (i + 1 < rowNum))
                            if (board[i + 1][j - 1].getStatus() == Cell.HEAD) //left bottom neighbour cell
                            headNeigh++;
                        if (j - 1 >= 0)
                            if (board[i][j - 1].getStatus() == Cell.HEAD) //left neighbour cell
                                headNeigh++;
                        if ((j - 1 >= 0) && (i - 1 >= 0))
                            if (board[i - 1][j - 1].getStatus() == Cell.HEAD) //left top neighbour cell
                                headNeigh++;

                        if (headNeigh == 1 || headNeigh == 2 )
                            next.getBoardElement(i, j).setStatus(Cell.HEAD);
                        System.out.println(headNeigh);
                }

            }

        }
        this.board = next.board;
        return 0;
    }
}




