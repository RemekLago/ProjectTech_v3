package v3.projecttech_v3;

import static android.graphics.Color.rgb;
import static v3.projecttech_v3.DataBaseChanges2.ListWithColumnsNames;
import static v3.projecttech_v3.DataBaseChanges2.tmpdata2;
import static v3.projecttech_v3.DataBaseChanges3.ListWithColumnsNames3;
import static v3.projecttech_v3.MainActivity_Table2.database3;
import static v3.projecttech_v3.MainActivity_Table2.recyclerView;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_1;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_10;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_11;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_12;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_13;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_14;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_15;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_2;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_3;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_4;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_5;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_6;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_7;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_8;
import static v3.projecttech_v3.db.DataBaseHelper.SORTEDBY_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import v3.projecttech_v3.db.DataBaseHelper;
import v3.projecttech_v3.db.DataBaseHelper3;
import v3.projecttech_v3.db.entity.Data;
import v3.projecttech_v3.db.entity.Data3;

public class MainActivity_Procedura_PozycjaPartia_HistoriaZycia extends AppCompatActivity implements RecyclerViewInterface3{

    public static ArrayList<String> FinalListWithCellColor3;
    public static ArrayList<Integer> FinalListWithColumnsAdjust3;
    public static ArrayList<Integer> FinalListWithColumnsWidth3;
    public static String columnName3;
    public static RecyclerView recyclerView3;
    public static AdapterRecyclerView3 adapterRecyclerView3;
    public static DataBaseHelper3 dataBaseSQL3;


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
        setContentView(R.layout.activity_main_procedura_pozycja_partia_historia_zycia);

        dataBaseSQL3 = new DataBaseHelper3(MainActivity_Procedura_PozycjaPartia_HistoriaZycia.this);

        Log.i("checking", "database3: " + dataBaseSQL3.toString());

        // For procedure Procedura_Public_PozycjaPartia_HistoriaZycia
        DataBaseChanges3 dataFinal3 = new DataBaseChanges3();
        ArrayList<ArrayList<String>> database03 = dataFinal3.doInBackground();
        database3 = dataFinal3.cleaningDatabase(database03);

        dataFinal3.columnsNames();
        FinalListWithCellColor3 = dataFinal3.cellsColor(database3);
        FinalListWithColumnsAdjust3 = dataFinal3.columnsAdjust();
        FinalListWithColumnsWidth3 = dataFinal3.columnsWidth();

        Log.i("checking", "database3 size: " + database3.size());

        recyclerView3 = findViewById(R.id.recyclerView3);

        adapterRecyclerView3 = new AdapterRecyclerView3(this, database3, this);
        recyclerView3.setAdapter(adapterRecyclerView3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        Button buttonBack = findViewById(R.id.buttonBack);

        Intent intent13 = new Intent(this, MainActivity_Table2.class);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent13.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent13);
            }
        });

        TextView textView_NazwaPozycja = findViewById(R.id.textView_NazwaPozycja);
        TextView textView_Pozycja = findViewById(R.id.textView_Pozycja);
        textView_NazwaPozycja.setText("PozycjaNazwa");
        textView_Pozycja.setText("Pozycja");
//        textView_NazwaPozycja.setText( tmpdata3.get("PozycjaNazwa"));
//        textView_Pozycja.setText((tmpdata3.get("Pozycja")));

        TextView textView1name = findViewById(R.id.textView1name3);
        TextView textView2name = findViewById(R.id.textView2name3);
        TextView textView3name = findViewById(R.id.textView3name3);
        TextView textView4name = findViewById(R.id.textView4name3);
        TextView textView5name = findViewById(R.id.textView5name3);
        TextView textView6name = findViewById(R.id.textView6name3);
        TextView textView7name = findViewById(R.id.textView7name3);
        TextView textView8name = findViewById(R.id.textView8name3);

        textView1name.setText(ListWithColumnsNames3.get(0));
        textView2name.setText(ListWithColumnsNames3.get(1));
        textView3name.setText(ListWithColumnsNames3.get(2));
        textView4name.setText(ListWithColumnsNames3.get(3));
        textView5name.setText(ListWithColumnsNames3.get(4));
        textView6name.setText(ListWithColumnsNames3.get(5));
        textView7name.setText(ListWithColumnsNames3.get(6));
        textView8name.setText(ListWithColumnsNames3.get(7));

        textView1name.setTextColor(Color.WHITE);
        textView2name.setTextColor(Color.WHITE);
        textView3name.setTextColor(Color.WHITE);
        textView4name.setTextColor(Color.WHITE);
        textView5name.setTextColor(Color.WHITE);
        textView6name.setTextColor(Color.WHITE);
        textView7name.setTextColor(Color.WHITE);
        textView8name.setTextColor(Color.WHITE);

        textView1name.setBackgroundColor(rgb(3, 37, 76));
        textView2name.setBackgroundColor(rgb(3, 37, 76));
        textView3name.setBackgroundColor(rgb(3, 37, 76));
        textView4name.setBackgroundColor(rgb(3, 37, 76));
        textView5name.setBackgroundColor(rgb(3, 37, 76));
        textView6name.setBackgroundColor(rgb(3, 37, 76));
        textView7name.setBackgroundColor(rgb(3, 37, 76));
        textView8name.setBackgroundColor(rgb(3, 37, 76));


        textView1name.setGravity(FinalListWithColumnsAdjust3.get(0));
        textView2name.setGravity(FinalListWithColumnsAdjust3.get(1));
        textView3name.setGravity(FinalListWithColumnsAdjust3.get(2));
        textView4name.setGravity(FinalListWithColumnsAdjust3.get(3));
        textView5name.setGravity(FinalListWithColumnsAdjust3.get(4));
        textView6name.setGravity(FinalListWithColumnsAdjust3.get(5));
        textView7name.setGravity(FinalListWithColumnsAdjust3.get(6));
        textView8name.setGravity(FinalListWithColumnsAdjust3.get(7));


        ViewGroup.LayoutParams params1 = textView1name.getLayoutParams();
        ViewGroup.LayoutParams params2 = textView2name.getLayoutParams();
        ViewGroup.LayoutParams params3 = textView3name.getLayoutParams();
        ViewGroup.LayoutParams params4 = textView4name.getLayoutParams();
        ViewGroup.LayoutParams params5 = textView5name.getLayoutParams();
        ViewGroup.LayoutParams params6 = textView6name.getLayoutParams();
        ViewGroup.LayoutParams params7 = textView7name.getLayoutParams();
        ViewGroup.LayoutParams params8 = textView8name.getLayoutParams();
//
//        params1.width = FinalListWithColumnsWidth3.get(0);
//        params2.width = FinalListWithColumnsWidth3.get(1);
//        params3.width = FinalListWithColumnsWidth3.get(2);
//        params4.width = FinalListWithColumnsWidth3.get(3);
//        params5.width = FinalListWithColumnsWidth3.get(4);
//        params6.width = FinalListWithColumnsWidth3.get(5);
//        params7.width = FinalListWithColumnsWidth3.get(6);
//        params8.width = FinalListWithColumnsWidth3.get(7);
        params1.width = 0;
        params2.width = 0;
        params3.width = 100;
        params4.width = 350;
        params5.width = 350;
        params6.width = 200;
        params7.width = 500;
        params8.width = 300;
        textView1name.setLayoutParams(params1);
        textView2name.setLayoutParams(params2);
        textView3name.setLayoutParams(params3);
        textView4name.setLayoutParams(params4);
        textView5name.setLayoutParams(params5);
        textView6name.setLayoutParams(params6);
        textView7name.setLayoutParams(params7);
        textView8name.setLayoutParams(params8);

        textView1name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView1name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_1, Toast.LENGTH_SHORT).show();
            }
        });

        textView2name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView2name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_2, Toast.LENGTH_SHORT).show();
            }
        });

        textView3name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView3name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_3, Toast.LENGTH_SHORT).show();
            }
        });

        textView4name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView4name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_4, Toast.LENGTH_SHORT).show();
            }
        });

        textView5name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView5name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_5, Toast.LENGTH_SHORT).show();
            }
        });

        textView6name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView6name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_6, Toast.LENGTH_SHORT).show();
            }
        });

        textView7name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView7name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_7, Toast.LENGTH_SHORT).show();
            }
        });

        textView8name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName3 = textView8name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_8, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateView() {
        ArrayList<Data3> sortedData = dataBaseSQL3.getAllDataOrdered(columnName3);
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(1).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(2).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(3).getLp());
        dataBaseSQL3.deleteAllData();
        Log.i("checking", "databaseSQL ordering columnname: " + columnName3);
        for (int i=0; i<sortedData.size(); i++) {
            dataBaseSQL3.insertData(sortedData.get(i));
//            Log.i("checking", "databaseSQL ordering: " + i);
//            Log.i("checking", "databaseSQL ordering LP: " + sortedData.get(i).getLp());
//            Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getDataId(i+1).getLp());
        }
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(1).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(2).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(3).getLp());

        adapterRecyclerView3.notifyDataSetChanged();
        recyclerView3.setAdapter(adapterRecyclerView3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
    }

    public static int positionForDataBaseSQL3;
    @Override
    public void onItemClick3(int position) {
        Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
        positionForDataBaseSQL3 = position;

    }
}