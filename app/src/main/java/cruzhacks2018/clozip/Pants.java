package cruzhacks2018.clozip;

/**
 * Created by smend on 1/20/2018.
 */

public class Pants extends Clothing {
    public int size;

    public Pants(String type, String color, int size){
        super(type, color);
        this.size = size;
        this.id = "p" + Integer.toString(this.idCount++);
    }
}
