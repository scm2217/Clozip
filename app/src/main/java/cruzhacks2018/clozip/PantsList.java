package cruzhacks2018.clozip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PantsList extends AppCompatActivity {
    OutfitManager g;
    Pants[] pantList = new Pants[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pants_list);

        g = (OutfitManager)getApplication();

        ImageView[] pantImages = {findViewById(R.id.p1), findViewById(R.id.p2), findViewById(R.id.p3), findViewById(R.id.p4)};
        Button[] pantButtons = {findViewById(R.id.pb1), findViewById(R.id.pb2), findViewById(R.id.pb3), findViewById(R.id.pb4)};

        int i = 0;
        for(Pants value : g.pants.values()){
            if(i++ >= 3) break;
            pantImages[i].setImageResource(value.image);
            pantList[i] = value;
        }
        for(Button butt : pantButtons){
            butt.setOnClickListener(onClickListener);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.pb1:
                    g.currentPant = pantList[0];
                    break;
                case R.id.pb2:
                    g.currentPant = pantList[1];
                    break;
                case R.id.pb3:
                    g.currentPant = pantList[2];
                    break;
                case R.id.pb4:
                    g.currentPant = pantList[3];
                    break;
            }
            startActivity(new Intent(PantsList.this, ChooseOutfit.class));
        }
    };
}
