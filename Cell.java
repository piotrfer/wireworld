
public class Cell {
    public static final int EMPTY=0; //black
    public static final int TAIL=2; //red
    public static final int  HEAD=3; //blue
    public static final int COND=1; //yellow
    private  int status;
    public Cell(int status){
        this.status=status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
