package v3.projecttech_v3;


import static v3.projecttech_v3.DataBaseChanges.ArrayListWithFinalData;
import static v3.projecttech_v3.DataBaseChanges.ListWithColumnsNames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_Table extends AppCompatActivity implements RecyclerViewInterface {

    public static ArrayList<ArrayList<String>> database;
    public static ArrayList<String> FinalListWithCellColor;
    public static ArrayList<Integer> FinalListWithColumnsAdjust;

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

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(), "Position: " + position, Toast.LENGTH_LONG).show();
    }

}