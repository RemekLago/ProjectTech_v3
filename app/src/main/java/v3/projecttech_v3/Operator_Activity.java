package v3.projecttech_v3;

import static android.graphics.Color.rgb;

import static v3.projecttech_v3.AdapterRecyclerView5_Operator.positionAdapterOperatorTelefon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import v3.projecttech_v3.formularze.Formularz5_Maszyna_Pracownik_Skarga;

public class Operator_Activity extends AppCompatActivity implements RecyclerViewInterface5_Operator {

    public static ArrayList<String> FinalListWithCellColor;
    public static ArrayList<Integer> FinalListWithColumnsAdjust;
    public static ArrayList<Integer> FinalListWithColumnsWidth;
    public static ArrayList<String> FinalListWithColumnsNames;
    public static String columnName;
    public static RecyclerView recyclerView;
    public static AdapterRecyclerView5_Operator adapterRecyclerView;
    public static ArrayList<ArrayList<String>> database_Operator;
    public static ArrayList<ArrayList<String>> database2;
    public static ProgressBar progressBar;
    public static String operator_searchText1;
    public static String operator_searchText2;
    public static String operator_searchText3;
    public static EditText inputOperator2;
    public static String inputOperatorTelefon;


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
        setContentView(R.layout.activity_operator);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);


        inputOperator2 = findViewById(R.id.inputOperator2);

        // Intent from Formularz5_Maszyna_Pracownik_Skarga
        operator_searchText2 = getIntent().getStringExtra("operator");
        // Intent from Procedura_Operator_Formularz5
        operator_searchText1 = getIntent().getStringExtra("operatorFormularz");
        // Intent from refresh Operator_Activity
        operator_searchText3 = getIntent().getStringExtra("searchOperator");


        if (operator_searchText1 != null) {
            inputOperator2.setText(operator_searchText1);
        } else if (operator_searchText2 != null ){
            inputOperator2.setText(operator_searchText2);
        } else if (operator_searchText3 != null) {
            inputOperator2.setText(operator_searchText3);
        } else {
            inputOperator2.setText("");
        }

        DataBaseChanges6_Operator_Formularz5 dataFinal = new DataBaseChanges6_Operator_Formularz5();
        ArrayList<ArrayList<String>> database = dataFinal.doInBackground();
        database_Operator = dataFinal.cleaningDatabase(database);

        FinalListWithColumnsNames = dataFinal.columnsNames();
        FinalListWithCellColor = dataFinal.cellsColor(database_Operator);
        FinalListWithColumnsAdjust = dataFinal.columnsAdjust();
        FinalListWithColumnsWidth = dataFinal.columnsWidth();


        recyclerView = findViewById(R.id.recyclerViewOperator);

        adapterRecyclerView = new AdapterRecyclerView5_Operator(this, database2, this);
        recyclerView.setAdapter(adapterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button button_zatwierdz = findViewById(R.id.button_zatwierdz);
        Button buttonSzukajOperator2 = findViewById(R.id.buttonSzukajOperator2);

        button_zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOperatorBack = new Intent(Operator_Activity.this, Formularz5_Maszyna_Pracownik_Skarga.class);
                startActivity(intentOperatorBack);


                SharedPreferences preferencesOperator = getSharedPreferences("preferencesOperator", MODE_PRIVATE);
                SharedPreferences.Editor editorOperator = preferencesOperator.edit();
                editorOperator.putString("preferencesOperator", inputOperator2.getText().toString());
                editorOperator.apply();

                SharedPreferences preferencesTelefon = getSharedPreferences("preferencesTelefon", MODE_PRIVATE);
                SharedPreferences.Editor editorTelefon = preferencesTelefon.edit();
                editorTelefon.putString("preferencesTelefon", positionAdapterOperatorTelefon);
                editorTelefon.apply();
            }
        });

        buttonSzukajOperator2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRefreshOperator = new Intent(Operator_Activity.this, Operator_Activity.class);
                intentRefreshOperator.putExtra("searchOperator", inputOperator2.getText().toString());
                startActivity(intentRefreshOperator);
            }
        });



        TextView textView1name = findViewById(R.id.textViewName1);
        TextView textView2name = findViewById(R.id.textViewName2);
        TextView textView3name = findViewById(R.id.textViewName3);
        TextView textView4name = findViewById(R.id.textViewName4);
        TextView textView5name = findViewById(R.id.textViewName5);
        TextView textView6name = findViewById(R.id.textViewName6);
        TextView textView7name = findViewById(R.id.textViewName7);
        TextView textView8name = findViewById(R.id.textViewName8);

        textView1name.setText(FinalListWithColumnsNames.get(0));
        textView2name.setText(FinalListWithColumnsNames.get(1));
        textView3name.setText(FinalListWithColumnsNames.get(2));
        textView4name.setText(FinalListWithColumnsNames.get(3));
        textView5name.setText(FinalListWithColumnsNames.get(4));
        textView6name.setText(FinalListWithColumnsNames.get(5));
        textView7name.setText(FinalListWithColumnsNames.get(6));
        textView8name.setText(FinalListWithColumnsNames.get(7));


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

        textView1name.setGravity(FinalListWithColumnsAdjust.get(0));
        textView2name.setGravity(FinalListWithColumnsAdjust.get(1));
        textView3name.setGravity(FinalListWithColumnsAdjust.get(2));
        textView4name.setGravity(FinalListWithColumnsAdjust.get(3));
        textView5name.setGravity(FinalListWithColumnsAdjust.get(4));
        textView6name.setGravity(FinalListWithColumnsAdjust.get(5));
        textView7name.setGravity(FinalListWithColumnsAdjust.get(6));
        textView8name.setGravity(FinalListWithColumnsAdjust.get(7));


        ViewGroup.LayoutParams params1 = textView1name.getLayoutParams();
        ViewGroup.LayoutParams params2 = textView2name.getLayoutParams();
        ViewGroup.LayoutParams params3 = textView3name.getLayoutParams();
        ViewGroup.LayoutParams params4 = textView4name.getLayoutParams();
        ViewGroup.LayoutParams params5 = textView5name.getLayoutParams();
        ViewGroup.LayoutParams params6 = textView6name.getLayoutParams();
        ViewGroup.LayoutParams params7 = textView7name.getLayoutParams();
        ViewGroup.LayoutParams params8 = textView8name.getLayoutParams();

        params1.width = 0;
        params2.width = 0;
        params3.width = 100;
        params4.width = 300;
        params5.width = 400;
        params6.width = 400;
        params7.width = 250;
        params8.width = 0;

        textView1name.setLayoutParams(params1);
        textView2name.setLayoutParams(params2);
        textView3name.setLayoutParams(params3);
        textView4name.setLayoutParams(params4);
        textView5name.setLayoutParams(params5);
        textView6name.setLayoutParams(params6);
        textView7name.setLayoutParams(params7);
        textView8name.setLayoutParams(params8);

    }

    @Override
    public void onItemClick(int position) {

    }
}
