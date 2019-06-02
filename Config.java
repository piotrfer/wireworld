public class Config{
    private int timeInterval;
    private int n;
    private String fileIn;
    private String fileOut;

    {
        timeInterval = 100;
        n = 10;
        fileIn = null;
        fileOut = "prefix";
    }

    public void setTimeInterval( int timeInterval ) throws Exception{
        if( timeInterval < 0 )
            throw new Exception("time interval must be greater than 0!");
        this.timeInterval = timeInterval;
    }

    public void setN( int n ) throws Exception{
        if( n < 0 )
            throw new Exception("generation number must be greater than 0!");
        this.n = n;
    }

    public void setFileIn( String fileIn ){
        this.fileIn = fileIn;
    }

    public void setFileOut( String fileOut ){
        this.fileOut = fileOut;
    }

    public int getTimeInterval(){
        return timeInterval;
    }

    public int getN(){
        return n;
    }

    public String getFileIn(){
        return fileIn;
    }

    public String getFileOut(){
        return fileOut;
    }
}