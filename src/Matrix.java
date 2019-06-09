public class Matrix {
    private Cell[][] board;
    private int colNum;
    private int rowNum;

    public Matrix(Cell[][] board, int colNum, int rowNum) {
        this.board = board;
        this.colNum = colNum;
        this.rowNum = rowNum;
    }
    //metoda ktora dodaje modul
    public void changeMatrix(Matrix module, int colInsertNum, int rowInsertNum){
        if((colInsertNum + module.getColNum() - 1) < this.colNum && (rowInsertNum + module.getRowNum() - 1) < this.rowNum){
            for(int i = rowInsertNum; i<rowInsertNum+ module.getRowNum();i++)
                for(int j=colInsertNum; j< colInsertNum + module.getColNum(); j++)
                    this.board[i][j] = module.getBoardElement(i-rowInsertNum,j-colInsertNum);
        }
        else
        {
            System.out.println("Error changing matrix");
        }
    }

    public int getColNum() {
        return colNum;
    }
    public void printToConsole(){
        for(int i=0;i<rowNum;i++) {
            for (int j = 0; j < colNum; j++)
                System.out.print(" " + board[i][j].getStatus());
            System.out.println("");
        }
    }
    public int getRowNum() {
        return rowNum; }

        public Cell getBoardElement ( int i, int j){
            return board[i][j];
        }

        public int simulateGeneration () {
            int headNeigh = 0;
            Cell[][] next = new Cell[rowNum][colNum];
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    try {
                        next[i][j] = new Cell(board[i][j].getStatus());
                    } catch (Exception e) {
                        ;
                    }
                }
            }

            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (board[i][j].getStatus() == Cell.EMPTY)
                        next[i][j].setStatus(Cell.EMPTY);
                    else if (board[i][j].getStatus() == Cell.HEAD)
                        next[i][j].setStatus(Cell.TAIL);

                    else if (board[i][j].getStatus() == Cell.TAIL)
                        next[i][j].setStatus(Cell.COND);

                    else if (board[i][j].getStatus() == Cell.COND) {
                        headNeigh = 0;
                        if (i - 1 >= 0)
                            if (board[i - 1][j].getStatus() == Cell.HEAD) //top neighbour cell
                                headNeigh++;

                        if ((j + 1 < colNum) && (i - 1 >= 0))
                            if (board[i - 1][j + 1].getStatus() == Cell.HEAD) //right top neighbour cell
                                headNeigh++;

                        if (j + 1 < colNum)
                            if (board[i][j + 1].getStatus() == Cell.HEAD) //right neighbour cell
                                headNeigh++;

                        if ((j + 1 < colNum) && (i + 1 < rowNum))
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

                        if (headNeigh == 1 || headNeigh == 2)
                            next[i][j].setStatus(Cell.HEAD);
                    }

                }

            }
            this.board = next;
            return 0;
        }
    }



