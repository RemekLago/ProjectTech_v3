package v3.projecttech_v3.formularz5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import v3.projecttech_v3.BuildConfig;
import v3.projecttech_v3.R;

public class Przewinienie_Activity_InsertNew extends AppCompatActivity {

    public static EditText inputKod;
    public static EditText inputNazwa;
    Button buttonDodaj;
    HashMap<String, String> database;

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
        setContentView(R.layout.activity_przewinienie_insert_new);


        inputKod = findViewById(R.id.inputPrzewinienieKod);
        inputNazwa = findViewById(R.id.inputPrzewinienieNazwa);
        buttonDodaj = findViewById(R.id.buttonDodaj);

        Intent backToFormularz = new Intent(Przewinienie_Activity_InsertNew.this, Formularz5_Maszyna_Pracownik_Skarga.class);

        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckAllFields()) {

                    DataBaseChanges6_PrzewinienieNew_Formularz5 dataFinal = new DataBaseChanges6_PrzewinienieNew_Formularz5();
                    database = dataFinal.doInBackground();

                    if (database.get("Status").equals("1")) {
                        Toast.makeText(getApplicationContext(), database.get("Komunikat"), Toast.LENGTH_LONG).show();
                        startActivity(backToFormularz);
                    } else {
                        Toast.makeText(getApplicationContext(), database.get("Komunikat"), Toast.LENGTH_LONG).show();
                    }
                } else {
                Toast.makeText(getApplicationContext(), "Dodanie nie powiodło się", Toast.LENGTH_LONG).show();
            }
            }
        });

    }

    private boolean CheckAllFields() {

        if (validateKod() && validateNazwa()) {
            // after all validation return true.
            return true;
        } else {
            return false;
        }
    }


    public boolean validateKod() {
        if (inputKod.length() == 0) {
            inputKod.setError("This field is required");
            return false;
        } else {
            return true;
        }}

    public boolean validateNazwa() {
        if (inputNazwa.length() == 0) {
            inputNazwa.setError("This field is required");
            return false;
        } else {
            return true;
        }}
}