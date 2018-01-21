package cruzhacks2018.clozip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OutfitList extends AppCompatActivity {
    OutfitManager g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_list);

        g = (OutfitManager)getApplication();
    }
}
