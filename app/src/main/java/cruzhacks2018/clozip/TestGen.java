package cruzhacks2018.clozip;
/**
 * Created by smend on 1/21/2018.
 */

//Used to generate test data for hackathon
public class TestGen {
    OutfitManager g;

    Pants[] ptest = new Pants[4];
    Shirt[] stest = new Shirt[4];
    Coat[] ctest = new Coat[4];
    Outfit[] otest = new Outfit[4];

    TestGen(OutfitManager parent){
        g = parent;
    }
    void Run(){
        ptest[0] = new Pants("Jeans", "Blue", 32);
        ptest[0].image = R.drawable.pants;
        ptest[1] = new Pants("Jeans", "Green",36);
        ptest[1].image = R.drawable.pants4;
        ptest[2] = new Pants("Skinny Jeans", "Dark Grey", 26);
        ptest[2].image = R.drawable.pants3;
        ptest[3] = new Pants("Khakis", "Beige", 34);
        ptest[3].image = R.drawable.pants2;

        stest[0] = new Shirt("T-shirt", "Blue", "M");
        stest[0].image = R.drawable.shirt;
        stest[1] = new Shirt("Shirt", "Black", "S");
        stest[1].image = R.drawable.shirt1;
        stest[2] = new Shirt("Long Sleeve Shirt", "White", "M");
        stest[2].image = R.drawable.shirt3;
        stest[3] = new Shirt("Collar Shirt", "Light Blue", "M");
        stest[3].image = R.drawable.shirt4;

        ctest[0] = new Coat("Long Coat", "Black", "L");
        ctest[0].image = R.drawable.coat1;
        ctest[1] = new Coat("Heavy coat", "Green", "M");
        ctest[1].image = R.drawable.coat2;
        ctest[2] = new Coat("Jacket", "Black", "S");
        ctest[2].image = R.drawable.coat3;
        ctest[3] = new Coat("Winter Coat", "Tan", "L");
        ctest[3].image = R.drawable.coat4;

        for(int i = 0; i < 4; i++){
            g.pants.put(ptest[i].GetId(), ptest[i]);
        }
        for(int i = 0; i < 4; i++){
            g.shirts.put(stest[i].GetId(), stest[i]);
        }
        for(int i = 0; i < 4; i++){
            g.coats.put(ctest[i].GetId(), ctest[i]);
        }

        for(int i = 0; i < 4; i++){
            g.currentPant = ptest[i];
            g.currentShirt = stest[i];
            g.currentCoat = ctest[i];
            g.PickOutfit();
            g.currentPant = null;
            g.currentShirt = null;
            g.currentCoat = null;
            g.currentOutfit = null;
        }
    }
}
