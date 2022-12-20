package v3.projecttech_v3;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Objects;

import v3.projecttech_v3.db.DataBaseHelper5;
import v3.projecttech_v3.procedury.Procedura_prcLogin;

public class Login_User_activity extends AppCompatActivity {
    public static DataBaseChanges_Login dataBaseChanges_login;
    public static Intent intentEnterData;
    public static Intent intentEditdata;
    public static String enterMail;
    public static String enterPassword;
    public static int userLoginCheck;
    HashMap<String, String> database1;
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
        setContentView(R.layout.activity_login_user);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        TextView textView_ZapiszSie = findViewById(R.id.textView_ZapiszSie);
        TextView textView_NieMaszJeszczeKonta = findViewById(R.id.textView_NieMaszJeszczeKonta);
        TextView textViewRejestracja = findViewById(R.id.textViewRejestracja);
        TextView inputEmail = findViewById(R.id.inputEmail);
        TextView inputHaslo = findViewById(R.id.inputHaslo);
        TextView textViewMaszJuzKonto = findViewById(R.id.textViewMaszJuzKonto);

        CheckBox checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        ImageView imageLogo1 = findViewById(R.id.imageLogo1);

        intentEnterData = new Intent(Login_User_activity.this, Activity_Home_Main.class);

        SharedPreferences preferencesLogin2 = getSharedPreferences("ShearedUserLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = preferencesLogin2.edit();
        editor2.putInt("userLoginCheck", 0);
        editor2.apply();
        userLoginCheck = preferencesLogin2.getInt("userLoginCheck",0);
        Log.i("checking", "statusLogin1: " + userLoginCheck);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(ProgressBar.VISIBLE);

                enterMail = inputEmail.getText().toString();
                enterPassword = inputHaslo.getText().toString();

                Log.i("checking", "enterMail: " + enterMail);
                Log.i("checking", "enterPassword: " + enterPassword);

                dataBaseChanges_login = new DataBaseChanges_Login();
                database1 = dataBaseChanges_login.doInBackground();
                Log.i("checking","database1: " + database1.get("Status"));
                Log.i("checking","database1: " + database1.get("Komunikat"));

                if (Objects.equals(database1.get("Status"), "1")) {

                    SharedPreferences preferencesLogin = getSharedPreferences("ShearedUserLogin", MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferencesLogin.edit();
                    editor2.putInt("userLoginCheck", 1);
                    editor2.apply();
                    userLoginCheck = preferencesLogin.getInt("userLoginCheck",0);
                    Log.i("checking", "statusLogin2: " + userLoginCheck);

                    SharedPreferences preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = preferences.edit();
                    editor3.putInt("UserSettings", -1);
                    editor3.apply();

                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    startActivity(intentEnterData);

                } else {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
//                    Toast.makeText(v.getContext(), database1.get("Komunikat"), Toast.LENGTH_LONG).show();
                    inputEmail.setError("Check Login");
                    inputHaslo.setError("Check Hasło");
                    inputEmail.setText("");
                    inputHaslo.setText("");
                    }
                }
        });

        checkBoxRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(Login_User_activity.this, "Checked", Toast.LENGTH_SHORT).show();

                } else if ( !compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(Login_User_activity.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
                Intent intentLogin = new Intent(getApplicationContext(), Login_User_activity.class);
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

                Intent  intentLogOut = new Intent(getApplicationContext(), Login_User_activity.class);
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