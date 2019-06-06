public class Module extends Matrix{
    
    String name;   
    
    public Module(Cell[][] board, int colNum, int rowNum) {
        super(board, colNum, rowNum);
        name = "noname";
    }

    public Module(Cell[][] board, int colNum, int rowNum, String name) {
        super(board, colNum, rowNum);
        this.name = "noname";
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getName( String name ){
        return name;
    }

}