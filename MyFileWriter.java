import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter{

    public static int writeFile( String prefix, Matrix matrix){

        int num = 0;

        if( prefix == null ){
            prefix = "data";
        }
        
        StringBuilder b = new StringBuilder("data");
        b.append(prefix).append(num).append(".txt");
        String filename = b.toString();

        try{
            FileWriter fw = new FileWriter( filename );
            for(int i = 0; i < matrix.getRowNum(); i++){
                for(int j = 0; j < matrix.getColNum(); j++){
                    fw.write(Integer.toString(matrix.getBoardElement(i, j).getStatus()));
                }
                fw.write('\n');
            }
            fw.close();
        } catch( IOException e ){
            System.err.println("in/out err");
            return 1;
        }

        return 0;



    }
}