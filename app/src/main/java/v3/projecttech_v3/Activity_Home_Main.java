package v3.projecttech_v3;

import static v3.projecttech_v3.AdapterRecyclerView_Home.tmpUserSettings2;
import static v3.projecttech_v3.InputExampleToActivity_Home.gettingRandomUser1;
import static v3.projecttech_v3.InputExampleToActivity_Home.inputtingExampleData;
import static v3.projecttech_v3.Procedura_Drzewko_Kafelki_prcAccountFormTree.takingUserSettings;
import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.takingPositionInformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Activity_Home_Main extends AppCompatActivity implements RecyclerViewInterface{
    RecyclerView recyclerView_dataList;
    ArrayList<String> titles;
    ArrayList<Bitmap> images;
    AdapterRecyclerView_Home adapterRecyclerView_home;
    ArrayList<ArrayList<String>> userSettings;
    public static ArrayList<ArrayList<String>> userSettings2;
    public static ArrayList<ArrayList<String>> listWithUserSettings;
    public static int userAccessLevel;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        // ustawienie zmiennej userAccessLevel na początkową wartość: 0,
        // potem w zależności jaki box będzie kliknięty w procedurze wartość ta ulegnie zmianie
        SharedPreferences preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = preferences.edit();
        editor2.putInt("UserSettings", 0);
        editor2.apply();
        userAccessLevel = preferences.getInt("UserSettings",0);

        listWithUserSettings = new ArrayList<>();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
                    DataBaseChanges5_home databaseUserSettings = new DataBaseChanges5_home();
                    listWithUserSettings = databaseUserSettings.doInBackground();
//                } catch (Exception e) {
//                    Log.i("checking", "exception Procedura_Drzewko_Kafelki_prcAccountFormTree2" + e.toString());
//                }
//            }
//        });
//        thread.start();



//        // for test - take random user with some settings
//        inputtingExampleData();
//        userSettings = gettingRandomUser1();
//
//        try {
//            userSettings2 = tmpUserSettings2;
//        } catch(Exception e) {
//            Log.i("checking", "exception method: gettingRandomUser2 in InputExampleToActivity_Home2" + e.toString());
//        }

        recyclerView_dataList = findViewById(R.id.recyclerview_home1);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        Log.i("checking", "listWithUserSettings1 size: " + listWithUserSettings.size());
        Log.i("checking", "listWithUserSettings1: " + listWithUserSettings.get(0));
//
        for (int i=0; i < listWithUserSettings.size(); i++) {
            Log.i("checking", "listWithUserSettings: " + listWithUserSettings.get(i));
            titles.add(listWithUserSettings.get(i).get(1));
            String base64String = listWithUserSettings.get(i).get(3);
            byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            images.add(decodedByte);
        }


//        if (userSettings2 == null) {
//            for (int i = 0; i < userSettings.size(); i++) {
//                titles.add(userSettings.get(i).get(1).toString());
//                images.add(Integer.valueOf(userSettings.get(i).get(3).toString()));
//            }
//            userSettings.clear();
//        } else if ( userSettings2 != null) {
//            for (int i = 0; i < userSettings2.size(); i++) {
//                Log.i("checking", "userSetting2.size " + userSettings2.size());
//                Log.i("checking", "userSetting2.size " + userSettings2.get(i).get(1).toString());
//
//                titles.add(userSettings2.get(i).get(1).toString());
//                images.add(Integer.valueOf(userSettings2.get(i).get(3).toString()));
//            }
//            userSettings2.clear();
//        }


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

    @Override
    public void onItemClick(int position) {

    }
}