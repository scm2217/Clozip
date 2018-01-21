package cruzhacks2018.clozip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OutfitList extends AppCompatActivity {
    OutfitManager g;
    Outfit[] outfitList = new Outfit[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_list);

        g = (OutfitManager)getApplication();

        ImageView[][] outfitImages = {{findViewById(R.id.obp1), findViewById(R.id.obs1), findViewById(R.id.obc1)},
                {findViewById(R.id.obp2), findViewById(R.id.obs2), findViewById(R.id.obc2)},
                {findViewById(R.id.obp3), findViewById(R.id.obs3), findViewById(R.id.obc3)}};
        Button[] outfitButtons = {findViewById(R.id.ob1), findViewById(R.id.ob2), findViewById(R.id.ob3)};
        int i = 0;
        for(Outfit value : g.outfits.values()){
            if(i++ >= 2) break;
            outfitImages[i][0].setImageResource(value.pants.image);
            outfitImages[i][1].setImageResource(value.shirt.image);
            outfitImages[i][2].setImageResource((value.coat == null ? 0 : value.coat.image));
            outfitList[i] = value;
        }
        for(Button butt : outfitButtons){
            butt.setOnClickListener(onClickListener);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.ob1:
                    g.currentOutfit = outfitList[0];
                    break;
                case R.id.ob2:
                    g.currentOutfit = outfitList[1];
                    break;
                case R.id.ob3:
                    g.currentOutfit = outfitList[2];
                    break;
            }
            startActivity(new Intent(OutfitList.this, ExistingOutfits.class));
        }
    };
}
