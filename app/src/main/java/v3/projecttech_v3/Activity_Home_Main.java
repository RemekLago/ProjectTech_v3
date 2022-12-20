package v3.projecttech_v3;

import static v3.projecttech_v3.Activity_User_Login.intentEditdata;
import static v3.projecttech_v3.Activity_User_Login.userLoginCheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.util.ArrayList;

import v3.projecttech_v3.db.DataBaseHelper_Home;

public class Activity_Home_Main extends AppCompatActivity implements RecyclerViewInterface{
    RecyclerView recyclerView_dataList;
    ArrayList<String> titles;
    ArrayList<Bitmap> images;
//    ArrayList<Drawable> images;

    AdapterRecyclerView_Home adapterRecyclerView_home;
    public static ArrayList<ArrayList<String>> userSettings2;
    public static ArrayList<ArrayList<String>> listWithUserSettings;
    public static int userAccessLevel;
    public static SharedPreferences preferences;
    public static DataBaseHelper_Home dataBaseSQLHome;
    public static ProgressBar progressBar;


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

        preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
        userAccessLevel = preferences.getInt("UserSettings",-1);
        Log.i("checking", "userAccessLevel_1: " + userAccessLevel );

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(ProgressBar.VISIBLE);
//        progressBar.setVisibility(ProgressBar.INVISIBLE);

//        // only for testing progressbar
//        SharedPreferences.Editor editor2 = preferences.edit();
//        editor2.putInt("UserSettings", -1);
//        editor2.apply();
//        userAccessLevel = preferences.getInt("UserSettings",-1);


        if (userAccessLevel >= 0){
            Log.i("checking", "opcja1");
            startRecyclerView ();
            }


        if (userAccessLevel < 0) {
            Log.i("checking", "opcja2");

            dataBaseSQLHome = new DataBaseHelper_Home(Activity_Home_Main.this);
            Log.i("checking", "dataBaseSQLHome size: " + dataBaseSQLHome.getAllData().size());
            preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("UserSettings", 0);
            editor.apply();

            userAccessLevel = preferences.getInt("UserSettings",-1);
            Log.i("checking", "userAccessLevel_2: " + userAccessLevel );

            DataBaseChanges5_home databaseUserSettings = new DataBaseChanges5_home();
            databaseUserSettings.doInBackground();
            startRecyclerView ();
        }


//        // for test - take random user with some settings
//        inputtingExampleData();
//        userSettings = gettingRandomUser1();
//
//        try {
//            userSettings2 = tmpUserSettings2;
//        } catch(Exception e) {
//            Log.i("checking", "exception method: gettingRandomUser2 in InputExampleToActivity_Home2" + e.toString());
//        }

//        recyclerView_dataList = findViewById(R.id.recyclerview_home1);
//
//        titles = new ArrayList<>();
//        images = new ArrayList<>();
//
////        Log.i("checking", "listWithUserSettings1 size: " + listWithUserSettings.size());
////        Log.i("checking", "listWithUserSettings1: " + listWithUserSettings.get(0));
////
//        for (int i=0; i < listWithUserSettings.size(); i++) {
//            if (listWithUserSettings.get(i).get(0).equals(""+userAccessLevel)) {
//            Log.i("checking", "listWithUserSettings: " + listWithUserSettings.get(i));
//            titles.add(listWithUserSettings.get(i).get(2));
//            String base64String = listWithUserSettings.get(i).get(4);
//            byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
//            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//            images.add(decodedByte);
////            images.add(getDrawable(R.drawable.informacja));
//            }
//        }
//
//        adapterRecyclerView_home = new AdapterRecyclerView_Home(this, titles, images);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
//        recyclerView_dataList.setLayoutManager(gridLayoutManager);
//        recyclerView_dataList.setAdapter(adapterRecyclerView_home);


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

    }

    public void startRecyclerView () {
        recyclerView_dataList = findViewById(R.id.recyclerview_home1);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        int sizeOfDataInDatabase = dataBaseSQLHome.getAllData().size();
//        Log.i("checking", "sizeOfDataInDatabase: " + sizeOfDataInDatabase);

        for (int i=0; i < sizeOfDataInDatabase; i++) {
            if (dataBaseSQLHome.getAllData().get(i).getParentId().equals(""+userAccessLevel)) {
                Log.i("checking", "listWithUserSettings: " + dataBaseSQLHome.getAllData().get(i));
                titles.add(dataBaseSQLHome.getAllData().get(i).getName());
                String base64String = dataBaseSQLHome.getAllData().get(i).getBase64();
                byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                images.add(decodedByte);
//            images.add(getDrawable(R.drawable.informacja));

            }
        }

        adapterRecyclerView_home = new AdapterRecyclerView_Home(this, titles, images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView_dataList.setLayoutManager(gridLayoutManager);
        recyclerView_dataList.setAdapter(adapterRecyclerView_home);

        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        userAccessLevel = preferences.getInt("UserSettings",-1);
        Log.i("checking", "userAccessLevel_callback2: " + userAccessLevel);

        int sizeOfDataInDatabase = dataBaseSQLHome.getAllData().size();

        for (int i=0; i < sizeOfDataInDatabase; i++) {
            if (dataBaseSQLHome.getAllData().get(i).getChildId().equals(""+userAccessLevel)) {
                int ParentId = Integer.parseInt(dataBaseSQLHome.getAllData().get(i).getParentId());
                Log.i("checking", "ParentId: " + ParentId);

                preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("UserSettings", ParentId);
                editor.apply();
                userAccessLevel = preferences.getInt("UserSettings",-1);
                Log.i("checking", "userAccessLevel_callback3: " + userAccessLevel);

            }

        }

        Log.i("checking", "userAccessLevel_callback4: " + userAccessLevel);

        Intent goBack =new Intent(getApplicationContext(), Activity_Home_Main.class);
        startActivity(goBack);

//        super.onBackPressed();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        if(userLoginCheck == 1)
        {
            menuInflater.inflate(R.menu.bar_menu_login, menu);
        } else
        {
            menuInflater.inflate(R.menu.bar_menu_logout, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_login:
                Intent intentLogin = new Intent(getApplicationContext(), Activity_User_Login.class);
                startActivity(intentLogin);
                return true;

            case R.id.menu_logout:
//                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putString("remember", "false");
//                editor.apply();

                SharedPreferences preferencesLogin = getSharedPreferences("ShearedUserLogin", MODE_PRIVATE);
                SharedPreferences.Editor editor2 = preferencesLogin.edit();
                editor2.putInt("userLoginCheck", 0);
                editor2.apply();

                finish();

                Intent  intentLogOut = new Intent(getApplicationContext(), Activity_User_Login.class);
                startActivity(intentLogOut);
                return true;

            case R.id.menu_editdata:

                startActivity(intentEditdata);
                return true;

            case R.id.menu_search:
                Intent intentEnterdata = new Intent(getApplicationContext(), MainActivity_enterdata.class);
                startActivity(intentEnterdata);
                return true;

            default:
                return false;

        }
    }
}