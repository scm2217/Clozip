package cruzhacks2018.clozip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ExistingOutfits extends AppCompatActivity {
    OutfitManager g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_outfits);

        g = (OutfitManager)getApplication();

        ImageButton confirmButton = findViewById(R.id.checkoutOutfit);
        ImageButton cancelButton = findViewById(R.id.cancelOutfit);
        confirmButton.setOnClickListener(onClickListener);
        cancelButton.setOnClickListener(onClickListener);

        ImageView coat = findViewById(R.id.coatOutfit);
        ImageView shirt = findViewById(R.id.shirtOutfit);
        ImageView pant = findViewById(R.id.pantOutfit);

        TextView timesUsedText = (TextView)findViewById(R.id.timesUsed);
        TextView popText = (TextView)findViewById(R.id.totalPop);
        TextView weatherUseText = (TextView)findViewById(R.id.weatherUsage);

        Outfit outfit = g.currentOutfit;
        timesUsedText.setText(Double.toString(outfit.pickCount));
        popText.setText(g.OutfitTotalPercentage(outfit));
        weatherUseText.setText(outfit.weatherInfo);
        if(outfit.coat != null) {
            coat.setImageResource(outfit.coat.image);
        }
        shirt.setImageResource(outfit.shirt.image);
        pant.setImageResource(outfit.pants.image);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.checkoutOutfit:
                    g.CheckoutOutfit();
                    startActivity(new Intent(ExistingOutfits.this, ClozipMenu.class));
                    break;
                case R.id.cancelOutfit:
                    g.currentOutfit = null;
                    startActivity(new Intent(ExistingOutfits.this, ClozipMenu.class));
                    break;
            }
        }
    };
}
