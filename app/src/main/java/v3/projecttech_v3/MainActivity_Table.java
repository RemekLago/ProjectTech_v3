package v3.projecttech_v3;


import static android.graphics.Color.rgb;
import static v3.projecttech_v3.DataBaseChanges.ArrayListWithFinalData;
import static v3.projecttech_v3.DataBaseChanges.ListWithColumnsNames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_Table extends AppCompatActivity implements RecyclerViewInterface {

    public static ArrayList<ArrayList<String>> database;
    public static ArrayList<String> FinalListWithCellColor;
    public static ArrayList<Integer> FinalListWithColumnsAdjust;
    public static ArrayList<Integer> FinalListWithColumnsWidth;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_table);


        DataBaseChanges dataFinal = new DataBaseChanges();
        ArrayList<ArrayList<String>> database1 = dataFinal.doInBackground();
        database = dataFinal.cleaningDatabase(database1);
        dataFinal.columnsNames();
        FinalListWithCellColor = dataFinal.cellsColor(database);
        FinalListWithColumnsAdjust = dataFinal.columnsAdjust();
        FinalListWithColumnsWidth = dataFinal.columnsWidth();

        Log.i("checking", "database size: " + database.size());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(this, database, this);
        recyclerView.setAdapter(adapterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_LONG).show();
    }

}