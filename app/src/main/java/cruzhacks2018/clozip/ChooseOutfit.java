package cruzhacks2018.clozip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseOutfit extends AppCompatActivity {
    OutfitManager g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_outfit);

        g = (OutfitManager)getApplication();

        ImageButton pantButton = findViewById(R.id.pants);
        ImageButton shirtButton = findViewById(R.id.shirt);
        ImageButton coatButton = findViewById(R.id.coatButt);
        ImageButton confirmButton = findViewById(R.id.confirmSelection);
        pantButton.setOnClickListener(onClickListener);
        shirtButton.setOnClickListener(onClickListener);
        coatButton.setOnClickListener(onClickListener);
        confirmButton.setOnClickListener(onClickListener);


        if (g.currentPant != null) {
            pantButton.setImageResource(g.currentPant.image);
        }
        if (g.currentShirt != null) {
            shirtButton.setImageResource(g.currentShirt.image);
        }
        if (g.currentCoat != null) {
            coatButton.setImageResource(g.currentCoat.image);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.pants:
                    startActivity(new Intent(ChooseOutfit.this, PantsList.class));
                    break;
                case R.id.shirt:
                    startActivity(new Intent(ChooseOutfit.this, ShirtList.class));
                    break;
                case R.id.coatButt:
                    startActivity(new Intent(ChooseOutfit.this, CoatList.class));
                    break;
                case R.id.confirmSelection:
                    if(g.PickOutfit()){
                        startActivity(new Intent(ChooseOutfit.this, ExistingOutfits.class));
                    }
            }

        }
    };
}
