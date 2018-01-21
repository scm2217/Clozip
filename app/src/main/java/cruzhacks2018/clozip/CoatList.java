package cruzhacks2018.clozip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CoatList extends AppCompatActivity {
    OutfitManager g;
    Coat[] coatList = new Coat[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coat_list);

        g = (OutfitManager)getApplication();

        ImageView[] coatImages = {findViewById(R.id.c1), findViewById(R.id.c2), findViewById(R.id.c3), findViewById(R.id.c4)};
        Button[] coatButtons = {findViewById(R.id.cb1), findViewById(R.id.cb2), findViewById(R.id.cb3), findViewById(R.id.cb4)};

        int i = 0;
        for(Coat value : g.coats.values()){
            if(i++ >= 3) break;
            coatImages[i].setImageResource(value.image);
            coatList[i] = value;
        }
        for(Button butt : coatButtons){
            butt.setOnClickListener(onClickListener);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.sb1:
                    g.currentCoat = coatList[0];
                    break;
                case R.id.sb2:
                    g.currentCoat= coatList[1];
                    break;
                case R.id.sb3:
                    g.currentCoat = coatList[2];
                    break;
                case R.id.sb4:
                    g.currentCoat = coatList[3];
                    break;
            }
            startActivity(new Intent(CoatList.this, ChooseOutfit.class));
        }
    };
}
