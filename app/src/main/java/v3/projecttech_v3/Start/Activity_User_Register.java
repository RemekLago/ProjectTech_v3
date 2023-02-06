package v3.projecttech_v3.Start;

import static v3.projecttech_v3.Start.Activity_User_Login_oldversion.dataBaseSQLUser;
import static v3.projecttech_v3.Start.Activity_User_Login_oldversion.intentEditdata;
import static v3.projecttech_v3.Start.Activity_User_Login_oldversion.userLoginCheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import v3.projecttech_v3.MainActivity_enterdata;
import v3.projecttech_v3.R;
import v3.projecttech_v3.db.entity.Data5;

public class Activity_User_Register extends AppCompatActivity {
    public static TextView inputImie;
    public static TextView inputNazwisko;
    public static TextView inputEmail;
    public static TextView inputTelefon;
    TextView textViewRejestracja;
    TextView textViewMaszJuzKonto;
    public static Data5 tmpInsertData;
    public static String tmpstatusID;
    public static DataBaseChanges_Register dataBaseChanges_register;
    HashMap<String, String> database;
    public static int userLoginCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_user_register);

        inputImie = findViewById(R.id.inputImie);
        inputNazwisko = findViewById(R.id.inputNazwisko);
        inputEmail = findViewById(R.id.inputEmail);
        inputTelefon = findViewById(R.id.inputTelefon);

        textViewRejestracja = findViewById(R.id.textViewRejestracja);
        textViewMaszJuzKonto = findViewById(R.id.textViewMaszJuzKonto);

        ImageView imageLogo = findViewById(R.id.imageLogo);
        Button buttonRejestracja = findViewById(R.id.buttonRejestracja);

        dataBaseChanges_register = new DataBaseChanges_Register();
        Intent intentVerification = new Intent(Activity_User_Register.this, Activity_User_Verification.class);

        SharedPreferences preferencesLogin = getSharedPreferences("ShearedUserLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencesLogin.edit();
        editor.putInt("userLoginCheck", 0);
        editor.apply();
        userLoginCheck = preferencesLogin.getInt("userLoginCheck",0);
        Log.i("checking", "statusLogin1: " + userLoginCheck);

        buttonRejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Boolean isAllFieldsValidateTrue = CheckAllFields();
//                takingValuesFromInputTextView();

                if (CheckAllFields()) {
                    database = dataBaseChanges_register.doInBackground();
                    Log.i("checking","database1: " + database.get("Status"));
                    Log.i("checking","database1: " + database.get("Komunikat"));

                    if (database.get("Status").equals("1")) {
                        Toast.makeText(getApplicationContext(), database.get("Komunikat"), Toast.LENGTH_LONG).show();
                        startActivity(intentVerification);
                    } else {
                        Toast.makeText(getApplicationContext(), database.get("Komunikat"), Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Rejestracja nie powiodła się", Toast.LENGTH_LONG).show();
                }
            }
        });

        textViewMaszJuzKonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMamJuzKonto = new Intent(Activity_User_Register.this, Login_User_activity.class);
                startActivity(intentMamJuzKonto);
            }
        });
    }

    private boolean CheckAllFields() {

        if (validateImie() && validateNazwisko() && inputEmail() && inputTelefon()) {
            // after all validation return true.
            return true;
        } else {
            return false;
        }
    }


    public boolean validateImie() {
        if (inputImie.length() == 0) {
            inputImie.setError("This field is required");
            return false;
        } else {
            return true;
        }}

    public boolean validateNazwisko() {
        if (inputNazwisko.length() == 0) {
            inputNazwisko.setError("This field is required");
            return false;
        } else {
            return true;
        }}

    public boolean inputEmail() {
//            Pattern patternEmail = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
//            Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        Pattern patternEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

        Matcher matcherEmail = patternEmail.matcher(inputEmail.getText().toString());

        String mailDatabaseInput = null;
        if (inputEmail.length() == 0) {
            inputEmail.setError("This field is required");
            return false;
        } else if (!matcherEmail.matches()) {
            inputEmail.setError("Email is incorrect");
            Log.i("checkingEmail", inputEmail.toString());
            return false;

//            } else if ( !dataBaseSQLUser.ifMailExists(inputEmail.getText().toString())) {
//                inputEmail.setError("This email already exists in database");
//                Log.i("checkingEmail", inputEmail.toString());
//                return false;
        } else {
            Log.i("checkingEmail", inputEmail.toString());
            return true;
        }
    }

    public boolean inputTelefon() {
        if (inputTelefon.length() == 0) {
            inputTelefon.setError("This field is required");
            return false;
        } else {
            return true;
        }}



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
                Intent intentLogin = new Intent(getApplicationContext(), Activity_User_Login_oldversion.class);
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

                Intent  intentLogOut = new Intent(getApplicationContext(), Activity_User_Login_oldversion.class);
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