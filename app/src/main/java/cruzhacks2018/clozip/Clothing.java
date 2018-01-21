package cruzhacks2018.clozip;

/**
 * Created by smend on 1/20/2018.
 */

public abstract class Clothing {
    protected static int idCount = 0;
    protected String id;

    public String type;
    public String color;

    public Clothing(String type, String color){
        this.type = type;
        this.color = color;
    }

    public String GetId(){
        return id;
    }
}
