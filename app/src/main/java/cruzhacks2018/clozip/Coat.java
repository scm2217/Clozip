package cruzhacks2018.clozip;

/**
 * Created by smend on 1/20/2018.
 */

public class Coat extends Clothing {
    public String size;

    public Coat(String type, String color, String size){
        super(type, color);
        this.size = size;
        this.id = "c" + Integer.toString(this.idCount++);
    }
}
