package cruzhacks2018.clozip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ClothingInformation extends AppCompatActivity {
    OutfitManager g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_information);

        g = (OutfitManager)getApplication();
        TextView typeText = (TextView)findViewById(R.id.clothingType);
        TextView colorText = (TextView)findViewById(R.id.clothingColor);
        TextView sizeText = (TextView)findViewById(R.id.clothingSize);
        TextView weatherText = (TextView)findViewById(R.id.clothingWeather);

        if(g.currentClothing != null){
            Clothing item = g.currentClothing;
            typeText.setText(item.type);
            colorText.setText(item.color);
            sizeText.setText((String)item.size);
            weatherText.setText(item.weather);

            ImageButton acceptButton = findViewById(R.id.clothingAccept);
            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    g.updateSelection();
                    startActivity(new Intent(ClothingInformation.this, ChooseOutfit.class));
                }
            });
        }
    }
}
