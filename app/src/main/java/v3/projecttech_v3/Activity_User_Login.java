package v3.projecttech_v3;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import v3.projecttech_v3.db.DataBaseHelper5;

public class Activity_User_Login extends AppCompatActivity {
    public static DataBaseHelper5 dataBaseSQLUser;
    public static Intent intentEnterData;
    public static Intent intentEditdata;
    public static String enterMail;
    public static String enterPassword;
    public static int userLoginCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);



        TextView textView_ZapiszSie = findViewById(R.id.textView_ZapiszSie);
        TextView textView_NieMaszJeszczeKonta = findViewById(R.id.textView_NieMaszJeszczeKonta);
        TextView textViewRejestracja = findViewById(R.id.textViewRejestracja);
        TextView inputEmail = findViewById(R.id.inputEmail);
        TextView inputHaslo = findViewById(R.id.inputHaslo);
        TextView textViewMaszJuzKonto = findViewById(R.id.textViewMaszJuzKonto);

        CheckBox checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        ImageView imageLogo1 = findViewById(R.id.imageLogo1);

        dataBaseSQLUser = new DataBaseHelper5(Activity_User_Login.this);
        AddingUsersToDatabase.addingUser();

        intentEnterData = new Intent(Activity_User_Login.this, MainActivity_enterdata.class);

        SharedPreferences preferencesLogin2 = getSharedPreferences("ShearedUserLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = preferencesLogin2.edit();
        editor2.putInt("userLoginCheck", 0);
        editor2.apply();
        userLoginCheck = preferencesLogin2.getInt("userLoginCheck",0);
        Log.i("checking", "statusLogin1: " + userLoginCheck);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                enterMail = inputEmail.getText().toString();
                enterPassword = inputHaslo.getText().toString();
                String mailDatabase = "";
                String passwordDatabase = "";

                Log.i("checking", "EnteredEmail: " + enterMail);
                Log.i("checking", "EnteredPassword: " + enterPassword);

                intentEditdata = new Intent(getApplicationContext(), Activity_User_EditUser.class);
                intentEditdata.putExtra("emailUser", enterMail);
                Log.i("checking", "enterMail : " + enterMail);


                try {
                    mailDatabase = dataBaseSQLUser.getDataMail(enterMail.trim()).getMail();
                } catch(Exception e){
                    Log.i("checking", "exception mailDatabase" + e.toString());
                }
                try {
                    passwordDatabase = dataBaseSQLUser.getDataPassword(enterPassword).getPassword();
                } catch(Exception e){
                    Log.i("checking", "exception passwordDatabase" + e.toString());
                }

                Log.i("checking", "EmailfromDataBase: " + mailDatabase);
                Log.i("checking", "PasswordfromDatabase: " + passwordDatabase);

                if ( enterMail.equals(mailDatabase) && enterPassword.equals(passwordDatabase)) {
                    Toast.makeText(getApplicationContext(), "Logowanie przebiegło pomyślnie", Toast.LENGTH_LONG).show();
                    inputEmail.setText("");
                    inputHaslo.setText("");

                    startActivity(intentEnterData);

                } else {
                    try {
                        if (!dataBaseSQLUser.getDataMail(enterMail).getMail().equals(enterMail)) {
                            inputEmail.setError("Check Email");
                            inputEmail.setText("");
                            inputHaslo.setText("");
                        }
                    } catch (Exception e) {
                        inputEmail.setError("Check Email");
                        inputEmail.setText("");
                        inputHaslo.setText("");
                        Log.i("checking", "exception checkingMailWhenLogin" + e.toString()); }
                    try {
                        if ( !dataBaseSQLUser.getDataMail(enterMail).getPassword().equals(enterPassword)) {
                            inputHaslo.setError("Check Hasło");
                            inputHaslo.setText("");
                        }
                    } catch (Exception e) {
                        inputHaslo.setError("Check Hasło");
                        inputHaslo.setText("");
                        Log.i("checking", "exception checkingPassWhenLogin" + e.toString());
                    }
                        Toast.makeText(getApplicationContext(), "Wprowadzone dane są niepoprawne", Toast.LENGTH_LONG).show();
                    }



                SharedPreferences preferencesLogin = getSharedPreferences("ShearedUserLogin", MODE_PRIVATE);
                SharedPreferences.Editor editor2 = preferencesLogin.edit();
                editor2.putInt("userLoginCheck", 1);
                editor2.apply();
                userLoginCheck = preferencesLogin.getInt("userLoginCheck",0);
                Log.i("checking", "statusLogin2: " + userLoginCheck);


            }
        });

        textView_ZapiszSie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIdzDoRejestracja = new Intent(Activity_User_Login.this, Activity_User_Register.class);
                startActivity(intentIdzDoRejestracja);
            }
        });

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if(checkbox.equals("true")){
            Intent intentGoToEnterData = new Intent(Activity_User_Login.this, MainActivity_enterdata.class);
            startActivity(intentGoToEnterData);
        } else if (checkbox.equals("false")){
            Toast.makeText(Activity_User_Login.this, "Proszę zaloguj się", Toast.LENGTH_SHORT).show();
        }


        checkBoxRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(Activity_User_Login.this, "Checked", Toast.LENGTH_SHORT).show();

                } else if ( !compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(Activity_User_Login.this, "Unchecked", Toast.LENGTH_SHORT).show();
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
                Intent intentLogin = new Intent(getApplicationContext(), Activity_User_Login.class);
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

                Intent  intentLogOut = new Intent(getApplicationContext(), Activity_User_Login.class);
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