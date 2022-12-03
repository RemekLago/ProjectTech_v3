package v3.projecttech_v3;

import static android.graphics.Color.rgb;
import static v3.projecttech_v3.Activity_Login.intentEditdata;
import static v3.projecttech_v3.Activity_Login.userLoginCheck;
import static v3.projecttech_v3.DataBaseChanges4.ListWithColumnsNames4;
import static v3.projecttech_v3.MainActivity_Table2.database4;
import static v3.projecttech_v3.MainActivity_Table2.intent10;
import static v3.projecttech_v3.MainActivity_Table2.intent11;
import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.rPozycja;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_1;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_2;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_3;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_4;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_5;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_6;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_7;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_8;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_9;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_10;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_11;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_12;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_13;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_14;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import v3.projecttech_v3.db.DataBaseHelper4;
import v3.projecttech_v3.db.entity.Data4;

public class MainActivity_Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycja extends AppCompatActivity implements RecyclerViewInterface4{

    public static ArrayList<String> FinalListWithCellColor4;
    public static ArrayList<Integer> FinalListWithColumnsAdjust4;
    public static ArrayList<Integer> FinalListWithColumnsWidth4;
    public static String columnName4;
    public static RecyclerView recyclerView4;
    public static AdapterRecyclerView4 adapterRecyclerView4;
    public static DataBaseHelper4 dataBaseSQL4;


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
        setContentView(R.layout.activity_main_procedura_magazyn_lsv_magazyn_lokalizacja_pozycja);

        dataBaseSQL4 = new DataBaseHelper4(MainActivity_Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycja.this);

        Log.i("checking", "database4: " + dataBaseSQL4.toString());

        // For procedure Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycja
        DataBaseChanges4 dataFinal4 = new DataBaseChanges4();
        ArrayList<ArrayList<String>> database04 = dataFinal4.doInBackground();
        database4 = dataFinal4.cleaningDatabase(database04);

        dataFinal4.columnsNames();
        FinalListWithCellColor4 = dataFinal4.cellsColor(database4);
        FinalListWithColumnsAdjust4 = dataFinal4.columnsAdjust();
        FinalListWithColumnsWidth4 = dataFinal4.columnsWidth();

        Log.i("checking", "database4 size: " + database4.size());

        recyclerView4 = findViewById(R.id.recyclerView4);

        adapterRecyclerView4 = new AdapterRecyclerView4(this, database4, this);
        recyclerView4.setAdapter(adapterRecyclerView4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));

        Button buttonBack = findViewById(R.id.buttonBack);

        Intent intent12 = new Intent(this, MainActivity_Table2.class);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent12);
            }
        });

        TextView textView_NazwaPozycja = findViewById(R.id.textView_NazwaPozycja);
        TextView textView_Pozycja = findViewById(R.id.textView_Pozycja);
        textView_NazwaPozycja.setText("PozycjaNazwa");
        textView_Pozycja.setText("Pozycja");
//        textView_NazwaPozycja.setText( tmpdata3.get("PozycjaNazwa"));
//        textView_Pozycja.setText((tmpdata3.get("Pozycja")));

        TextView textView1name = findViewById(R.id.textView1name4);
        TextView textView2name = findViewById(R.id.textView2name4);
        TextView textView3name = findViewById(R.id.textView3name4);
        TextView textView4name = findViewById(R.id.textView4name4);
        TextView textView5name = findViewById(R.id.textView5name4);
        TextView textView6name = findViewById(R.id.textView6name4);
        TextView textView7name = findViewById(R.id.textView7name4);
        TextView textView8name = findViewById(R.id.textView8name4);
        TextView textView9name = findViewById(R.id.textView9name4);
        TextView textView10name = findViewById(R.id.textView10name4);
        TextView textView11name = findViewById(R.id.textView11name4);
        TextView textView12name = findViewById(R.id.textView12name4);
        TextView textView13name = findViewById(R.id.textView13name4);
        TextView textView14name = findViewById(R.id.textView14name4);
        TextView textView15name = findViewById(R.id.textView15name4);

        textView1name.setText(ListWithColumnsNames4.get(0));
        textView2name.setText(ListWithColumnsNames4.get(1));
        textView3name.setText(ListWithColumnsNames4.get(2));
        textView4name.setText(ListWithColumnsNames4.get(3));
        textView5name.setText(ListWithColumnsNames4.get(4));
        textView6name.setText(ListWithColumnsNames4.get(5));
        textView7name.setText(ListWithColumnsNames4.get(6));
        textView8name.setText(ListWithColumnsNames4.get(7));
        textView8name.setText(ListWithColumnsNames4.get(8));
        textView8name.setText(ListWithColumnsNames4.get(9));
        textView8name.setText(ListWithColumnsNames4.get(10));
        textView8name.setText(ListWithColumnsNames4.get(11));
        textView8name.setText(ListWithColumnsNames4.get(12));
        textView8name.setText(ListWithColumnsNames4.get(13));
        textView8name.setText(ListWithColumnsNames4.get(14));

        textView1name.setTextColor(Color.WHITE);
        textView2name.setTextColor(Color.WHITE);
        textView3name.setTextColor(Color.WHITE);
        textView4name.setTextColor(Color.WHITE);
        textView5name.setTextColor(Color.WHITE);
        textView6name.setTextColor(Color.WHITE);
        textView7name.setTextColor(Color.WHITE);
        textView8name.setTextColor(Color.WHITE);
        textView9name.setTextColor(Color.WHITE);
        textView10name.setTextColor(Color.WHITE);
        textView11name.setTextColor(Color.WHITE);
        textView12name.setTextColor(Color.WHITE);
        textView13name.setTextColor(Color.WHITE);
        textView14name.setTextColor(Color.WHITE);
        textView15name.setTextColor(Color.WHITE);

        textView1name.setBackgroundColor(rgb(3, 37, 76));
        textView2name.setBackgroundColor(rgb(3, 37, 76));
        textView3name.setBackgroundColor(rgb(3, 37, 76));
        textView4name.setBackgroundColor(rgb(3, 37, 76));
        textView5name.setBackgroundColor(rgb(3, 37, 76));
        textView6name.setBackgroundColor(rgb(3, 37, 76));
        textView7name.setBackgroundColor(rgb(3, 37, 76));
        textView8name.setBackgroundColor(rgb(3, 37, 76));
        textView9name.setBackgroundColor(rgb(3, 37, 76));
        textView10name.setBackgroundColor(rgb(3, 37, 76));
        textView11name.setBackgroundColor(rgb(3, 37, 76));
        textView12name.setBackgroundColor(rgb(3, 37, 76));
        textView13name.setBackgroundColor(rgb(3, 37, 76));
        textView14name.setBackgroundColor(rgb(3, 37, 76));
        textView15name.setBackgroundColor(rgb(3, 37, 76));


        textView1name.setGravity(FinalListWithColumnsAdjust4.get(0));
        textView2name.setGravity(FinalListWithColumnsAdjust4.get(1));
        textView3name.setGravity(FinalListWithColumnsAdjust4.get(2));
        textView4name.setGravity(FinalListWithColumnsAdjust4.get(3));
        textView5name.setGravity(FinalListWithColumnsAdjust4.get(4));
        textView6name.setGravity(FinalListWithColumnsAdjust4.get(5));
        textView7name.setGravity(FinalListWithColumnsAdjust4.get(6));
        textView8name.setGravity(FinalListWithColumnsAdjust4.get(7));
        textView9name.setGravity(FinalListWithColumnsAdjust4.get(8));
        textView10name.setGravity(FinalListWithColumnsAdjust4.get(9));
        textView11name.setGravity(FinalListWithColumnsAdjust4.get(10));
        textView12name.setGravity(FinalListWithColumnsAdjust4.get(11));
        textView13name.setGravity(FinalListWithColumnsAdjust4.get(12));
        textView14name.setGravity(FinalListWithColumnsAdjust4.get(13));
        textView15name.setGravity(FinalListWithColumnsAdjust4.get(14));


        ViewGroup.LayoutParams params1 = textView1name.getLayoutParams();
        ViewGroup.LayoutParams params2 = textView2name.getLayoutParams();
        ViewGroup.LayoutParams params3 = textView3name.getLayoutParams();
        ViewGroup.LayoutParams params4 = textView4name.getLayoutParams();
        ViewGroup.LayoutParams params5 = textView5name.getLayoutParams();
        ViewGroup.LayoutParams params6 = textView6name.getLayoutParams();
        ViewGroup.LayoutParams params7 = textView7name.getLayoutParams();
        ViewGroup.LayoutParams params8 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params9 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params10 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params11 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params12 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params13 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params14 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params15 = textView8name.getLayoutParams();

//        params1.width = FinalListWithColumnsWidth4.get(0);
//        params2.width = FinalListWithColumnsWidth4.get(1);
//        params3.width = FinalListWithColumnsWidth4.get(2);
//        params4.width = FinalListWithColumnsWidth4.get(3);
//        params5.width = FinalListWithColumnsWidth4.get(4);
//        params6.width = FinalListWithColumnsWidth4.get(5);
//        params7.width = FinalListWithColumnsWidth4.get(6);
//        params8.width = FinalListWithColumnsWidth4.get(7);
//        params9.width = FinalListWithColumnsWidth4.get(8);
//        params10.width = FinalListWithColumnsWidth4.get(9);
//        params11.width = FinalListWithColumnsWidth4.get(10);
//        params12.width = FinalListWithColumnsWidth4.get(11);
//        params13.width = FinalListWithColumnsWidth4.get(12);
//        params14.width = FinalListWithColumnsWidth4.get(13);
//        params15.width = FinalListWithColumnsWidth4.get(14);
        params1.width = 0;
        params2.width = 0;
        params3.width = 100;
        params4.width = 300;
        params5.width = 400;
        params6.width = 400;
        params7.width = 250;
        params8.width = 0;
        params9.width = 0;
        params10.width = 0;
        params11.width = 0;
        params12.width = 0;
        params13.width = 0;
        params14.width = 0;
        params15.width = 0;
        textView1name.setLayoutParams(params1);
        textView2name.setLayoutParams(params2);
        textView3name.setLayoutParams(params3);
        textView4name.setLayoutParams(params4);
        textView5name.setLayoutParams(params5);
        textView6name.setLayoutParams(params6);
        textView7name.setLayoutParams(params7);
        textView8name.setLayoutParams(params8);
        textView9name.setLayoutParams(params9);
        textView10name.setLayoutParams(params10);
        textView11name.setLayoutParams(params11);
        textView12name.setLayoutParams(params12);
        textView13name.setLayoutParams(params13);
        textView14name.setLayoutParams(params14);
        textView15name.setLayoutParams(params15);

        textView1name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView1name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_1, Toast.LENGTH_SHORT).show();
            }
        });

        textView2name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView2name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_2, Toast.LENGTH_SHORT).show();
            }
        });

        textView3name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView3name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_3, Toast.LENGTH_SHORT).show();
            }
        });

        textView4name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView4name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_4, Toast.LENGTH_SHORT).show();
            }
        });

        textView5name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView5name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_5, Toast.LENGTH_SHORT).show();
            }
        });

        textView6name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView6name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_6, Toast.LENGTH_SHORT).show();
            }
        });

        textView7name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView7name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_7, Toast.LENGTH_SHORT).show();
            }
        });

        textView8name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView8name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_8, Toast.LENGTH_SHORT).show();
            }
        });

        textView9name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView9name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_9, Toast.LENGTH_SHORT).show();
            }
        });

        textView10name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView10name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_10, Toast.LENGTH_SHORT).show();
            }
        });

        textView11name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView11name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_11, Toast.LENGTH_SHORT).show();
            }
        });

        textView12name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView12name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_12, Toast.LENGTH_SHORT).show();
            }
        });

        textView13name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView13name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_13, Toast.LENGTH_SHORT).show();
            }
        });

        textView14name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView14name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_14, Toast.LENGTH_SHORT).show();
            }
        });

        textView15name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName4 = textView15name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_15, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateView() {
        ArrayList<Data4> sortedData = dataBaseSQL4.getAllDataOrdered(columnName4);
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(1).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(2).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(3).getLp());
        dataBaseSQL4.deleteAllData();
        Log.i("checking", "databaseSQL4 ordering columnname: " + columnName4);
        for (int i=0; i<sortedData.size(); i++) {
            dataBaseSQL4.insertData(sortedData.get(i));
//            Log.i("checking", "databaseSQL ordering: " + i);
//            Log.i("checking", "databaseSQL ordering LP: " + sortedData.get(i).getLp());
//            Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getDataId(i+1).getLp());
        }
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(1).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(2).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(3).getLp());

        adapterRecyclerView4.notifyDataSetChanged();
        recyclerView4.setAdapter(adapterRecyclerView4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));
    }

    public static int positionFordataBaseSQL4;
    @Override
    public void onItemClick4(int position) {
        Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
        positionFordataBaseSQL4 = position;

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
                Intent intentLogin = new Intent(getApplicationContext(), Activity_Login.class);
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

                Intent  intentLogOut = new Intent(getApplicationContext(), Activity_Login.class);
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