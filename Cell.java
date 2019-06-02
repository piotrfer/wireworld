public class Cell {
    public static final int EMPTY=0;
    public static final int TAIL=2;
    public static final int  HEAD=3;
    public static final int COND=1;
    private  int status;
    public Cell() {this.status=EMPTY; }
    public Cell(int status) throws Exception{
        if( status < 0 || status > 3 ){
            throw new Exception("number must be in range <0,3>");
        }
        else{
            this.status=status;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
