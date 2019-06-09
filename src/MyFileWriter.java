import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter{

    public static void writeFile( String path, Matrix matrix) throws IOException{

        try{
            FileWriter fw = new FileWriter( path );
            for(int i = 0; i < matrix.getRowNum(); i++){
                for(int j = 0; j < matrix.getColNum(); j++){
                    fw.write(Integer.toString(matrix.getBoardElement(i, j).getStatus()));
                }
                fw.write('\n');
            }
            fw.close();
        } catch( IOException e ){
            throw new IOException("File error");
        }
    }
}