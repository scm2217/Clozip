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
        ImageButton coatButton = findViewById(R.id.jacket);
        pantButton.setOnClickListener(onClickListener);
        shirtButton.setOnClickListener(onClickListener);
        coatButton.setOnClickListener(onClickListener);


        if (g.currentPant != null) {

        }
        if (g.currentShirt != null) {

        }
        if (g.currentCoat != null) {

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
                case R.id.jacket:
                    startActivity(new Intent(ChooseOutfit.this, CoatList.class));
                    break;
            }

        }
    };
}
