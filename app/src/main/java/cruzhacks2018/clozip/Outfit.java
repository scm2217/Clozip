package cruzhacks2018.clozip;

/**
 * Created by smend on 1/20/2018.
 */

public class Outfit {
    public Pants pants;
    public Shirt shirt;
    public Coat coat;

    public int pickCount = 0;
    public int rainPickCount = 0;
    public double avgTemp = 0;

    public Outfit(Pants pants, Shirt shirt){
        this.pants = pants;
        this.shirt = shirt;
    }
    public Outfit(Pants pants, Shirt shirt, Coat coat){
        this.pants = pants;
        this.shirt = shirt;
        this.coat = coat;
    }

    public void UpdateUsageStatistics(boolean isRain, double temp){
        avgTemp += (temp - avgTemp)/pickCount;
        pickCount++;
        if (isRain) {
            rainPickCount++;
        }
    }
}
