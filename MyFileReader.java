import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader<NumberFormatExcepion> {

    public static Matrix readFile(String path) throws IOException, NumberFormatException {

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line = null;

        int rowNum = 0;
        int colNum = 0;
        
        int[][] matrix = null;

        for(int i = 0; (line = br.readLine()) != null; i++){
            matrix = addMatrix(matrix, line.length());
            System.out.println(line);
            for(int j = 0; j < line.length(); j++){
                matrix[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        rowNum = matrix.length;
        colNum = matrix[0].length;

        Cell [][] board = new Cell [rowNum][colNum];
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                try{
                    board[i][j] = new Cell( matrix[i][j] );
                }
                catch(Exception e){
                    System.err.println("Number must be in range <0,3>");
                }
            }
        }

        return( new Matrix(board, colNum, rowNum) );
}

private static int[][] addMatrix(int[][] matrix, int length ) throws NumberFormatException{
    if( matrix == null){
        matrix = new int[1][length];
        return matrix;
    }
    else{
        if(length != matrix[0].length)
            throw new NumberFormatException("lines must be equal length");
        int[][] newmatrix = new int[matrix.length + 1][length];
        for(int i = 0; i < matrix.length; i++){
            newmatrix[i] = matrix[i];
        }
        return newmatrix;
    }
}
}