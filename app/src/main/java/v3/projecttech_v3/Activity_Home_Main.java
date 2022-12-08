package v3.projecttech_v3;

import static v3.projecttech_v3.AdapterRecyclerView_Home.tmpUserSettings2;
import static v3.projecttech_v3.InputExampleToActivity_Home.gettingRandomUser1;
import static v3.projecttech_v3.InputExampleToActivity_Home.inputtingExampleData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Activity_Home_Main extends AppCompatActivity {
    RecyclerView recyclerView_dataList;
    ArrayList<String> titles;
    ArrayList<Integer> images;
    AdapterRecyclerView_Home adapterRecyclerView_home;
    ArrayList<ArrayList<String>> userSettings;
    public static ArrayList<ArrayList<String>> userSettings2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        // for test - take random user with some settings
        inputtingExampleData();
        userSettings = gettingRandomUser1();

        try {
            userSettings2 = tmpUserSettings2;
        } catch(Exception e) {
            Log.i("checking", "exception method: gettingRandomUser2 in InputExampleToActivity_Home2" + e.toString());
        }

        recyclerView_dataList = findViewById(R.id.recyclerview_home1);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        if (userSettings2 == null) {
            for (int i = 0; i < userSettings.size(); i++) {
                titles.add(userSettings.get(i).get(1).toString());
                images.add(Integer.valueOf(userSettings.get(i).get(3).toString()));
            }
            userSettings.clear();
        } else if ( userSettings2 != null) {
            for (int i = 0; i < userSettings2.size(); i++) {
                Log.i("checking", "userSetting2.size " + userSettings2.size());
                Log.i("checking", "userSetting2.size " + userSettings2.get(i).get(1).toString());

                titles.add(userSettings2.get(i).get(1).toString());
                images.add(Integer.valueOf(userSettings2.get(i).get(3).toString()));
            }
            userSettings2.clear();
        }


//        titles.add( "First item from database");
//        titles.add( "Second item from database");
//        titles.add( "Third item from database");
//        titles.add( "Fourth item from database");
//
//        images.add(R.drawable.paletowanie);
//        images.add(R.drawable.recycling);
//        images.add(R.drawable.ustawienia);
//        images.add(R.drawable.paletazpaczkami);

        adapterRecyclerView_home = new AdapterRecyclerView_Home(this, titles, images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView_dataList.setLayoutManager(gridLayoutManager);
        recyclerView_dataList.setAdapter(adapterRecyclerView_home);
    }
}