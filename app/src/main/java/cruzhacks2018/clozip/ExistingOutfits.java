package cruzhacks2018.clozip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExistingOutfits extends AppCompatActivity {
    OutfitManager g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_outfits);

        g = (OutfitManager)getApplication();
    }
}
