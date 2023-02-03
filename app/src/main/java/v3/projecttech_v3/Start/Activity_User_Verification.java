package v3.projecttech_v3.Start;

import static v3.projecttech_v3.Start.Activity_User_Login_oldversion.intentEditdata;
import static v3.projecttech_v3.Start.Activity_User_Login_oldversion.userLoginCheck;
import static v3.projecttech_v3.Start.Activity_User_Register.dataBaseChanges_register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import v3.projecttech_v3.BuildConfig;
import v3.projecttech_v3.Kafelki.Activity_Home_Main;
import v3.projecttech_v3.MainActivity_enterdata;
import v3.projecttech_v3.R;

public class Activity_User_Verification extends AppCompatActivity {

    public static TextView inputLogin;
    public static TextView inputPassword1;
    public static TextView inputPassword2;
    public static TextView inputVerificationCode;
    public static DataBaseChanges_Verification dataBaseChanges_verification;
    public static ProgressBar progressBar;
    HashMap<String, String> database;
    public static int userLoginCheck;

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
        setContentView(R.layout.start_activity_login_user);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        ImageView imageLogo = findViewById(R.id.imageLogo);
        inputLogin  = findViewById(R.id.inputEmail);
        inputPassword1  = findViewById(R.id.inputHaslo1);
        inputPassword2  = findViewById(R.id.inputHaslo2);
        inputVerificationCode  = findViewById(R.id.inputKodWeryfikacja);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        dataBaseChanges_verification = new DataBaseChanges_Verification();
        Intent intentLogin = new Intent(Activity_User_Verification.this, Login_User_activity.class);


        SharedPreferences preferencesLogin = getSharedPreferences("ShearedUserLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencesLogin.edit();
        editor.putInt("userLoginCheck", 0);
        editor.apply();
        userLoginCheck = preferencesLogin.getInt("userLoginCheck",0);
        Log.i("checking", "statusLogin1: " + userLoginCheck);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (CheckAllFields()) {
                    database = dataBaseChanges_verification.doInBackground();
                    Log.i("checking","database1: " + database.get("Status"));
                    Log.i("checking","database1: " + database.get("Komunikat"));

                    if (database.get("Status").equals("1")) {
                        Toast.makeText(getApplicationContext(), database.get("Komunikat"), Toast.LENGTH_LONG).show();
                        startActivity(intentLogin);
                    } else {
                        Toast.makeText(getApplicationContext(), database.get("Komunikat"), Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Rejestracja nie powiodła się", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private boolean CheckAllFields() {

        if (validateLogin() && validatePassword1() && validatePassword2() && validateVerificationCode()) {
            // after all validation return true.
            return true;
        } else {
            return false;
        }
    }

    public boolean validateLogin() {
        if (inputLogin.length() == 0) {
            inputLogin.setError("This field is required");
            return false;
        } else {
            return true;
        }}

    public boolean validateVerificationCode() {
        if (inputLogin.length() == 0) {
            inputLogin.setError("This field is required");
            return false;
        } else {
            return true;
        }}


    public boolean validatePassword1 () {
        Pattern patternPassword = Pattern.compile(
//                    "^" +
//                    "(?=.*[0-9])" +         //at least 1 digit
//                    "(?=.*[a-z])" +         //at least 1 lower case letter
//                    "(?=.*[A-Z])" +         //at least 1 upper case letter
//                    "(?=.*[a-zA-Z])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                    "(?=S+$)" +           //no white spaces
//                    ".{4,}" +               //at least 4 characters
//                    "$"
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"
        );
        Matcher matcherPassword = patternPassword.matcher(inputPassword1.getText().toString());

        if (inputPassword1.length() == 0) {
            inputPassword1.setError("Password is required");
            return false;
        } else if (!matcherPassword.matches()) {
            inputPassword1.setError("Password should contain minimum 8 characters, 1 digit, " +
                    "1 lower case letter, 1 upper case letter, 1 special character");
            return false;
        }
        Log.i("checking", inputPassword1.toString());
        return true;
    }

    public boolean validatePassword2 () {
        Pattern patternPassword = Pattern.compile(
//                    "^" +
//                    "(?=.*[0-9])" +         //at least 1 digit
//                    "(?=.*[a-z])" +         //at least 1 lower case letter
//                    "(?=.*[A-Z])" +         //at least 1 upper case letter
//                    "(?=.*[a-zA-Z])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                    "(?=S+$)" +           //no white spaces
//                    ".{4,}" +               //at least 4 characters
//                    "$"
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"
        );
        Matcher matcherPassword = patternPassword.matcher(inputPassword2.getText().toString());

        if (inputPassword2.length() == 0) {
            inputPassword2.setError("Password is required");
            return false;
        } else if (!matcherPassword.matches()) {
            inputPassword2.setError("Password should contain minimum 8 characters, 1 digit, " +
                    "1 lower case letter, 1 upper case letter, 1 special character");
            return false;
        }
        Log.i("checking", inputPassword2.toString());
        return true;
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

//
//    public boolean inputHaslo() {
//        Pattern patternPassword = Pattern.compile(
////                    "^" +
////                    "(?=.*[0-9])" +         //at least 1 digit
////                    "(?=.*[a-z])" +         //at least 1 lower case letter
////                    "(?=.*[A-Z])" +         //at least 1 upper case letter
////                    "(?=.*[a-zA-Z])" +      //any letter
////                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
////                    "(?=S+$)" +           //no white spaces
////                    ".{4,}" +               //at least 4 characters
////                    "$"
//                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"
//        );
//        Matcher matcherPassword = patternPassword.matcher(tmpInsertData.getPassword().trim());
//
//        if (inputHaslo.length() == 0) {
//            inputHaslo.setError("Password is required");
//            return false;
//        } else if (!matcherPassword.matches()) {
//            inputHaslo.setError("Password should contain minimum 8 characters, 1 digit, " +
//                    "1 lower case letter, 1 upper case letter, 1 special character");
//            return false;
//        }
//        Log.i("checking", inputHaslo.toString());
//        return true;
//    }
//
//    public boolean inputHasloPotwierdz() {
//        Pattern patternPassword = Pattern.compile(
////                    "^" +
////                    "(?=.*[0-9])" +         //at least 1 digit
////                    "(?=.*[a-z])" +         //at least 1 lower case letter
////                    "(?=.*[A-Z])" +         //at least 1 upper case letter
////                    "(?=.*[a-zA-Z])" +      //any letter
////                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
////                    "(?=S+$)" +           //no white spaces
////                    ".{4,}" +               //at least 4 characters
////                    "$"
//
//                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"
//        );
//        Matcher matcherPassword = patternPassword.matcher(tmpInsertData.getPasswordConfirm());
//        if (inputHasloPotwierdz.length() == 0) {
//            inputHasloPotwierdz.setError("Password is required");
//            return false;
//        } else if (!matcherPassword.matches()) {
//            inputHasloPotwierdz.setError("Password should contain minimum 4 characters");
//            return false; }
////            } else if (!inputHasloPotwierdz.toString().equals(inputHaslo.toString())) {
////                inputHasloPotwierdz.setError("Check password, it must be the same");
////                return false;
////            }
//        Log.i("checking", inputHasloPotwierdz.toString());
//        return true;
//    }