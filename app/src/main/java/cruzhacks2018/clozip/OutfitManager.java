package cruzhacks2018.clozip;

import android.app.Application;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smend on 1/20/2018.
 */

public class OutfitManager extends Application {
    Map<String, Outfit> outfits;
    Map<String, Pants> pants;
    Map<String, Shirt> shirts;
    Map<String, Coat> coats;
    Weather weather;

    public Clothing currentClothing = null;
    public Outfit currentOutfit = null;
    public Pants currentPant = null;
    public Shirt currentShirt = null;
    public Coat currentCoat = null;

    private int totalOutfitsUsed;

    public OutfitManager(){
        this.outfits = new HashMap<String, Outfit>();
        this.pants = new HashMap<String, Pants>();
        this.shirts = new HashMap<String, Shirt>();
        this.coats = new HashMap<String, Coat>();
        this.weather = new Weather();
        TestGen gen = new TestGen(this);
        gen.Run();
        Log.d("TEST", pants.toString());
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
    public boolean PickOutfit(){
        //fail to pick outfit if no shirt or pants
        if(currentPant == null || currentShirt == null){
            return false;
        }

        String outfitId = currentPant.GetId() + currentShirt.GetId();
        if(currentCoat != null){
            outfitId += currentCoat.GetId();
        }

        Outfit outfit;
        if(this.outfits.containsKey(outfitId)){
            outfit = outfits.get(outfitId);
        }
        else{
            if(currentCoat != null){
                outfit = new Outfit(currentPant, currentShirt, currentCoat);
            }
            else {
                outfit = new Outfit(currentPant, currentShirt);
            }
            this.outfits.put(outfitId, outfit);
        }
        currentOutfit = outfit;
        return true;
    }

    /* outdated code
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
    */

    //retrieves outfit and updates statistics
    public boolean CheckoutOutfit(){
        currentOutfit.UpdateUsageStatistics(Weather.isRain, Weather.tempF);
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
