package cruzhacks2018.clozip;

/**
 * Created by smend on 1/20/2018.
 */

public class Shirt extends Clothing {
    public String size;

    public Shirt(String type, String color, String size){
        super(type, color);
        this.size = size;
        this.id = "s" + Integer.toString(this.idCount++);
    }
}
