public class Main {

    public static void main(String[] args) {
        int row=5;
        int col=6;
        Cell[][] board = new Cell[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j <col; j++){
                board[i][j]= new Cell((int)(Math.random()*4));}}

       for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(board[i][j].getStatus() + " ");
            System.out.println(" ");}

        Matrix test = new Matrix(board, col, row);
        test.simulateGeneration();
        System.out.println(" ");
        
        MyFileWriter.writeFile("prefix", test);
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(test.getBoardElement(i,j).getStatus() + " ");
            System.out.println(" ");
        }
    }
}

