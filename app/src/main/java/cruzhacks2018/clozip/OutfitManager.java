package cruzhacks2018.clozip;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smend on 1/20/2018.
 */

public class OutfitManager extends Application {
    Map<String, Outfit> outfits;
    Weather weather;

    public Clothing currentClothing;
    public Outfit currentOutfit;
    public Pants currentPant;
    public Shirt currentShirt;
    public Coat currentCoat;

    private int totalOutfitsUsed;

    public OutfitManager(){
        this.outfits = new HashMap<String, Outfit>();
        this.weather = new Weather();
    }

    //used to keep track of selected clothing between menus
    public void updateSelection(){
        char type = currentClothing.GetId().charAt(0);
        switch(type){
            case 'p':   this.currentPant = (Pants)currentClothing;
                        break;
            case 's':   this.currentShirt = (Shirt)currentClothing;
                        break;
            case 'c':   this.currentCoat = (Coat)currentClothing;
                        break;
        }
    }

    //Either find or create selected outfit combination (coat optional overloaded option)
    public Outfit PickOutfit(Pants pants, Shirt shirt){
        String outfitId = pants.GetId() + shirt.GetId();
        Outfit outfit;
        if(this.outfits.containsKey(outfitId)){
            outfit = outfits.get(outfitId);
        }
        else{
            outfit = new Outfit(pants, shirt);
            this.outfits.put(outfitId, outfit);
        }
        return outfit;
    }

    public Outfit PickOutfit(Pants pants, Shirt shirt, Coat coat){
        String outfitId = pants.GetId() + shirt.GetId() + coat.GetId();
        Outfit outfit;
        if(this.outfits.containsKey(outfitId)){
            outfit = outfits.get(outfitId);
        }
        else{
            outfit = new Outfit(pants, shirt, coat);
            this.outfits.put(outfitId, outfit);
        }
        return outfit;
    }

    //retrieves outfit and updates statistics
    public boolean CheckoutOutfit(Outfit outfit){
        outfit.UpdateUsageStatistics(Weather.isRain, Weather.tempF);
        this.totalOutfitsUsed++;

        //return true if no problems retrieving outfit
        return true;
    }

    //displays the percentage of the time the outfit is picked on any day
    public String OutfitTotalPercentage(Outfit outfit){
        String usage = Double.toString(outfit.pickCount/(double)totalOutfitsUsed *100) + "%";
        return usage;
    }
}
