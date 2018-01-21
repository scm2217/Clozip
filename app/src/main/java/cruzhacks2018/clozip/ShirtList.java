package cruzhacks2018.clozip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShirtList extends AppCompatActivity {
    OutfitManager g;
    Shirt[] shirtList = new Shirt[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_list);

        g = (OutfitManager)getApplication();

        ImageView[] shirtImages = {findViewById(R.id.s1), findViewById(R.id.s2), findViewById(R.id.s3), findViewById(R.id.s4)};
        Button[] shirtButtons = {findViewById(R.id.sb1), findViewById(R.id.sb2), findViewById(R.id.sb3), findViewById(R.id.sb4)};

        int i = 0;
        for(Shirt value : g.shirts.values()){
            if(i++ >= 3) break;
            shirtImages[i].setImageResource(value.image);
            shirtList[i] = value;
        }
        for(Button butt : shirtButtons){
            butt.setOnClickListener(onClickListener);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.sb1:
                    g.currentShirt = shirtList[0];
                    break;
                case R.id.sb2:
                    g.currentShirt = shirtList[1];
                    break;
                case R.id.sb3:
                    g.currentShirt = shirtList[2];
                    break;
                case R.id.sb4:
                    g.currentShirt = shirtList[3];
                    break;
            }
            startActivity(new Intent(ShirtList.this, ChooseOutfit.class));
        }
    };
}
