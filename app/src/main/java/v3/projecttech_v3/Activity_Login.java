package v3.projecttech_v3;

import static v3.projecttech_v3.Activity_Register.dataBaseSQLUser;
import static v3.projecttech_v3.MainActivity_Table2.intent10;
import static v3.projecttech_v3.MainActivity_Table2.intent11;

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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;

import v3.projecttech_v3.db.entity.Data5;

public class Activity_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView_ZapiszSie = findViewById(R.id.textView_ZapiszSie);
        TextView textView_NieMaszJeszczeKonta = findViewById(R.id.textView_NieMaszJeszczeKonta);
        TextView textViewRejestracja = findViewById(R.id.textViewRejestracja);
        TextView inputEmail = findViewById(R.id.inputEmail);
        TextView inputHaslo = findViewById(R.id.inputHaslo);
        TextView textViewMaszJuzKonto = findViewById(R.id.textViewMaszJuzKonto);

        CheckBox checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        ImageView imageLogo1 = findViewById(R.id.imageLogo1);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEnterData = new Intent(Activity_Login.this, MainActivity_enterdata.class);
                String enterMail = inputEmail.getText().toString();
                String enterPassword = inputHaslo.getText().toString();
                String mailDatabase = "";
                String passwordDatabase = "";

                Log.i("checking", "EnteredEmail: " + enterMail);
                Log.i("checking", "EnteredPassword: " + enterPassword);

                try {
                    mailDatabase = dataBaseSQLUser.getDataMail(enterMail).getMail();
                } catch(Exception e){
                    Log.i("checking", "exception mainDatabase" + e.toString());
                }
                try {
                    passwordDatabase = dataBaseSQLUser.getDataPassword(enterPassword).getPassword();
                } catch(Exception e){
                    Log.i("checking", "exception passwordDatabase" + e.toString());
                }

                Log.i("checking", "EmailfromDataBase: " + mailDatabase);
                Log.i("checking", "PasswordfromDatabase: " + passwordDatabase);

                if (enterMail.equals(mailDatabase) && enterPassword.equals(passwordDatabase)) {
                    Toast.makeText(getApplicationContext(), "Logowanie przebiegło pomyślnie", Toast.LENGTH_LONG).show();
                    //                startActivity(intentEnterData);
                } else {
                    Toast.makeText(getApplicationContext(), "Wprowadzone dane są niepoprawne", Toast.LENGTH_LONG).show();
                }


            }
        });

        textView_ZapiszSie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIdzDoRejestracja = new Intent(Activity_Login.this, Activity_Register.class);
                startActivity(intentIdzDoRejestracja);
            }
        });

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if(checkbox.equals("true")){
            Intent intentGoToEnterData = new Intent(Activity_Login.this, MainActivity_enterdata.class);
            startActivity(intentGoToEnterData);
        } else if (checkbox.equals("false")){
            Toast.makeText(Activity_Login.this, "Proszę zarejestruj się", Toast.LENGTH_SHORT).show();
        }


        checkBoxRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(Activity_Login.this, "Checked", Toast.LENGTH_SHORT).show();

                } else if ( !compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(Activity_Login.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_login:
                Intent intentLogin = new Intent(getApplicationContext(), Activity_Login.class);
                startActivity(intentLogin);
                return true;

            case R.id.menu_logout:
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();

                finish();

                Intent  intentLogOut = new Intent(getApplicationContext(), Activity_Login.class);
                startActivity(intentLogOut);
                return true;

            case R.id.menu_editdata:
//               Intent  intentEditdata = new Intent(getApplicationContext(), MainActivity_Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycja.class);
//                startActivity(intentEditdata);
                return true;

            case R.id.menu_enterdata:
                Intent intentEnterdata = new Intent(getApplicationContext(), MainActivity_enterdata.class);
                startActivity(intentEnterdata);
                return true;

            default:
                return false;

        }
    }
}