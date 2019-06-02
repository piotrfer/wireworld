import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int row=5;
        int col=6;
        Cell[][] board = new Cell[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j <col; j++){
                try{
                board[i][j]= new Cell((int)(Math.random()*4));
                }
                catch(Exception e){
                    System.err.println("Number must be in range <0,3>");
                }
            }
        }
            

       for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(board[i][j].getStatus() + " ");
            System.out.println(" ");}

        Matrix test = new Matrix(board, col, row);
        test.simulateGeneration();
        System.out.println(" ");
        
        MyFileWriter.writeFile("prefix", test);
        Matrix test2 = null;
        try{
            test2 = MyFileReader.readFile("dataprefix0.txt");
        }
        catch(IOException e){
            System.err.println("Lol " + e.getLocalizedMessage());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(test2.getBoardElement(i,j).getStatus() + " ");
            System.out.println(" ");
        }
    }
}

