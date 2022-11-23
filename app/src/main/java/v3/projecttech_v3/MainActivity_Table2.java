package v3.projecttech_v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import static android.graphics.Color.rgb;
import static v3.projecttech_v3.AdapterRecyclerView.position2;
import static v3.projecttech_v3.DataBaseChanges2.ListWithColumnsNames;
import static v3.projecttech_v3.DataBaseChanges2.tmpdata2;
import static v3.projecttech_v3.MainActivity_enterdata.editTextNumber;
import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.rKomunikat;
import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.rStatus;
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


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import v3.projecttech_v3.db.DataBaseHelper;
import v3.projecttech_v3.db.entity.Data;

public class MainActivity_Table2 extends AppCompatActivity implements RecyclerViewInterface{

    public static ArrayList<ArrayList<String>> database2;
    public static ArrayList<String> FinalListWithCellColor;
    public static ArrayList<Integer> FinalListWithColumnsAdjust;
    public static ArrayList<Integer> FinalListWithColumnsWidth;
    public static DataBaseChanges dataFinal;
    static Intent intent4;
    public static DataBaseHelper dataBaseSQL;
    public static String columnName;
    public static RecyclerView recyclerView;
    public static AdapterRecyclerView2 adapterRecyclerView2;
//    private DataAdapter;.
    static String searchCode;
    static TextView textViewSearch;

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
        setContentView(R.layout.activity_main_table2);

        dataBaseSQL = new DataBaseHelper(MainActivity_Table2.this);

        Log.i("checking", dataBaseSQL.toString());

        DataBaseChanges2 dataFinal = new DataBaseChanges2();
        ArrayList<ArrayList<String>> database0 = dataFinal.doInBackground();
        database2 = dataFinal.cleaningDatabase(database0);

        dataFinal.columnsNames();
        FinalListWithCellColor = dataFinal.cellsColor(database2);
        FinalListWithColumnsAdjust = dataFinal.columnsAdjust();
        FinalListWithColumnsWidth = dataFinal.columnsWidth();

        Log.i("checking", "database size: " + database2.size());

        recyclerView = findViewById(R.id.recyclerView);

        adapterRecyclerView2 = new AdapterRecyclerView2(this, database2, this);
        recyclerView.setAdapter(adapterRecyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String checkStatus = rStatus;
        if (checkStatus.equals("0")) {
            Toast.makeText(getApplicationContext(), rKomunikat, Toast.LENGTH_LONG).show();
        }


        Button buttonScanCode = findViewById(R.id.buttonScanCode);

        buttonScanCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_Table2.this, MainActivity_Scanner.class));
            }
        });

        Button buttonSearch = findViewById(R.id.buttonSearch);
        textViewSearch = findViewById(R.id.editTextNumber);

        intent4 = new Intent(MainActivity_Table2.this, MainActivity_Table2.class);

         buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchCode = textViewSearch.getText().toString();
                textViewSearch.setText(null);
                editTextNumber.setText(null);
                intent4.putExtra("searchPozycja",searchCode);
                Log.i("checking", "ButtonSearch: " + searchCode);
                startActivity(intent4);

            }
        });

//        Log.i("checking", "rStatus: " + tmpdata2.get("rStatus"));
//        Log.i("checking", "rKomunikat: " + tmpdata2.get("rKomunikat"));
//        Log.i("checking", "rPozycja: " + tmpdata2.get("rPozycja"));
//        Log.i("checking", "rPozycjaNazwa: " + tmpdata2.get("rPozycjaNazwa"));


        TextView textView_NazwaPozycja = findViewById(R.id.textView_NazwaPozycja);
        TextView textView_Pozycja = findViewById(R.id.textView_Pozycja);
        textView_NazwaPozycja.setText( tmpdata2.get("PozycjaNazwa"));
        textView_Pozycja.setText((tmpdata2.get("Pozycja")));

        TextView textView1name = findViewById(R.id.textView1name);
        TextView textView2name = findViewById(R.id.textView2name);
        TextView textView3name = findViewById(R.id.textView3name);
        TextView textView4name = findViewById(R.id.textView4name);
        TextView textView5name = findViewById(R.id.textView5name);
        TextView textView6name = findViewById(R.id.textView6name);
        TextView textView7name = findViewById(R.id.textView7name);
        TextView textView8name = findViewById(R.id.textView8name);
        TextView textView9name = findViewById(R.id.textView9name);
        TextView textView10name = findViewById(R.id.textView10name);
        TextView textView11name = findViewById(R.id.textView11name);
        TextView textView12name = findViewById(R.id.textView12name);
        TextView textView13name = findViewById(R.id.textView13name);
        TextView textView14name = findViewById(R.id.textView14name);
        TextView textView15name = findViewById(R.id.textView15name);

        textView1name.setText(ListWithColumnsNames.get(0));
        textView2name.setText(ListWithColumnsNames.get(1));
        textView3name.setText(ListWithColumnsNames.get(2));
        textView4name.setText(ListWithColumnsNames.get(3));
        textView5name.setText(ListWithColumnsNames.get(4));
        textView6name.setText(ListWithColumnsNames.get(5));
        textView7name.setText(ListWithColumnsNames.get(6));
        textView8name.setText(ListWithColumnsNames.get(7));
        textView9name.setText(ListWithColumnsNames.get(8));
        textView10name.setText(ListWithColumnsNames.get(9));
        textView11name.setText(ListWithColumnsNames.get(10));
        textView12name.setText(ListWithColumnsNames.get(11));
        textView13name.setText(ListWithColumnsNames.get(12));
        textView14name.setText(ListWithColumnsNames.get(13));
        textView15name.setText(ListWithColumnsNames.get(14));

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

        textView1name.setGravity(FinalListWithColumnsAdjust.get(0));
        textView2name.setGravity(FinalListWithColumnsAdjust.get(1));
        textView3name.setGravity(FinalListWithColumnsAdjust.get(2));
        textView4name.setGravity(FinalListWithColumnsAdjust.get(3));
        textView5name.setGravity(FinalListWithColumnsAdjust.get(4));
        textView6name.setGravity(FinalListWithColumnsAdjust.get(5));
        textView7name.setGravity(FinalListWithColumnsAdjust.get(6));
        textView8name.setGravity(FinalListWithColumnsAdjust.get(7));
        textView9name.setGravity(FinalListWithColumnsAdjust.get(8));
        textView10name.setGravity(FinalListWithColumnsAdjust.get(9));
        textView11name.setGravity(FinalListWithColumnsAdjust.get(10));
        textView12name.setGravity(FinalListWithColumnsAdjust.get(11));
        textView13name.setGravity(FinalListWithColumnsAdjust.get(12));
        textView14name.setGravity(FinalListWithColumnsAdjust.get(13));
        textView15name.setGravity(FinalListWithColumnsAdjust.get(14));

        ViewGroup.LayoutParams params1 = textView1name.getLayoutParams();
        ViewGroup.LayoutParams params2 = textView2name.getLayoutParams();
        ViewGroup.LayoutParams params3 = textView3name.getLayoutParams();
        ViewGroup.LayoutParams params4 = textView4name.getLayoutParams();
        ViewGroup.LayoutParams params5 = textView5name.getLayoutParams();
        ViewGroup.LayoutParams params6 = textView6name.getLayoutParams();
        ViewGroup.LayoutParams params7 = textView7name.getLayoutParams();
        ViewGroup.LayoutParams params8 = textView8name.getLayoutParams();
        ViewGroup.LayoutParams params9 = textView9name.getLayoutParams();
        ViewGroup.LayoutParams params10 = textView10name.getLayoutParams();
        ViewGroup.LayoutParams params11 = textView11name.getLayoutParams();
        ViewGroup.LayoutParams params12 = textView12name.getLayoutParams();
        ViewGroup.LayoutParams params13 = textView13name.getLayoutParams();
        ViewGroup.LayoutParams params14 = textView14name.getLayoutParams();
        ViewGroup.LayoutParams params15 = textView15name.getLayoutParams();
        params1.width = FinalListWithColumnsWidth.get(0);
        params2.width = FinalListWithColumnsWidth.get(1);
        params3.width = FinalListWithColumnsWidth.get(2);
        params4.width = FinalListWithColumnsWidth.get(3);
        params5.width = FinalListWithColumnsWidth.get(4);
        params6.width = FinalListWithColumnsWidth.get(5);
        params7.width = FinalListWithColumnsWidth.get(6);
        params8.width = FinalListWithColumnsWidth.get(7);
        params9.width = FinalListWithColumnsWidth.get(8);
        params10.width = FinalListWithColumnsWidth.get(9);
        params11.width = FinalListWithColumnsWidth.get(10);
        params12.width = FinalListWithColumnsWidth.get(11);
        params13.width = FinalListWithColumnsWidth.get(12);
        params14.width = FinalListWithColumnsWidth.get(13);
        params15.width = FinalListWithColumnsWidth.get(14);
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
                columnName = textView1name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_1, Toast.LENGTH_SHORT).show();
            }
        });

        textView2name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView2name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_2, Toast.LENGTH_SHORT).show();
            }
        });

        textView3name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView3name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_3, Toast.LENGTH_SHORT).show();
            }
        });

        textView4name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView4name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_4, Toast.LENGTH_SHORT).show();
            }
        });

        textView5name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView5name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_5, Toast.LENGTH_SHORT).show();
            }
        });

        textView6name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView6name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_6, Toast.LENGTH_SHORT).show();
            }
        });

        textView7name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView7name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_7, Toast.LENGTH_SHORT).show();
            }
        });

        textView8name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView8name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_8, Toast.LENGTH_SHORT).show();
            }
        });

        textView9name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView9name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_9, Toast.LENGTH_SHORT).show();
            }
        });

        textView10name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView10name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_10, Toast.LENGTH_SHORT).show();
            }
        });

        textView11name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView11name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_11, Toast.LENGTH_SHORT).show();
            }
        });

        textView12name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView12name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_12, Toast.LENGTH_SHORT).show();
            }
        });

        textView13name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView13name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_13, Toast.LENGTH_SHORT).show();
            }
        });

        textView14name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView14name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_14, Toast.LENGTH_SHORT).show();
            }
        });

        textView15name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                columnName = textView15name.getText().toString();
                updateView();
                Toast.makeText(getApplicationContext(), "Sorting on: " + SORTEDBY_15, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void updateView() {
        ArrayList<Data> sortedData = dataBaseSQL.getAllDataOrdered(columnName);
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(1).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(2).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(3).getLp());
        dataBaseSQL.deleteAllData();
        Log.i("checking", "databaseSQL ordering columnname: " + columnName);
        for (int i=0; i<sortedData.size(); i++) {
            dataBaseSQL.insertData(sortedData.get(i));
//            Log.i("checking", "databaseSQL ordering: " + i);
//            Log.i("checking", "databaseSQL ordering LP: " + sortedData.get(i).getLp());
//            Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getDataId(i+1).getLp());
        }
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(1).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(2).getLp());
//        Log.i("checking", "databaseSQL ordering ID: " + dataBaseSQL.getAllData().get(3).getLp());

        adapterRecyclerView2.notifyDataSetChanged();
        recyclerView.setAdapter(adapterRecyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public static int positionForDataBaseSQL;
    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
        positionForDataBaseSQL = position;
//        Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycje.takingInformationAboutLocalisation();
        Procedura_Public_PozycjaPartia_HistoriaZycia.takingHistoryPosition();
    }


}