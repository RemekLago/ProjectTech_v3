package v3.projecttech_v3;

import static v3.projecttech_v3.Activity_User_Login.enterMail;
import static v3.projecttech_v3.Activity_User_Login.intentEditdata;
import static v3.projecttech_v3.Activity_User_Login.userLoginCheck;
import static v3.projecttech_v3.DataBaseChanges2_Formularz1.tmpdata2;
import static v3.projecttech_v3.procedury.Procedura_Pozycja_Informacje2_Formularz1.rKomunikat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Etykieta_Formularz1 extends AppCompatActivity {


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate (Bundle savedInstanceState){

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
        }
        super.onCreate(savedInstanceState);

        setContentView(R.layout.etykieta_formularz1);

//        Procedura_Pozycja_Informacje informacje = new Procedura_Pozycja_Informacje();
//        tmpdata = informacje.takingPositionInformation();


//        Button button1 = findViewById(R.id.button);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openMainActivity_table();
//            }});

        //set data from Result1 into TextViews to show in layout
//        TextView textView_Status = findViewById(R.id.textView_Status);
//        TextView textView_Komunikat = findViewById(R.id.textView_Komunikat);
        TextView textView_NazwaPozycja = findViewById(R.id.textView_NazwaPozycja);
        TextView textView_Pozycja = findViewById(R.id.textView_Pozycja);
//        TextView textView_Barcode = findViewById(R.id.textView_Barcode);

//        textView_Status.setText(tmpdata.get("Status"));
//        textView_Komunikat.setText(tmpdata.get("Komunikat"));
        textView_NazwaPozycja.setText( tmpdata2.get("PozycjaNazwa"));
        textView_Pozycja.setText(tmpdata2.get("Pozycja"));
//        textView_Barcode.setText(Barcode);


        Toast toast_etykieta = Toast.makeText(getApplicationContext(), rKomunikat, Toast.LENGTH_LONG);
        toast_etykieta.show();


    }

    // method with Intend allows to go to the next layout/activity
//    private void openMainActivity_table() {
//        Intent intent = new Intent(this, MainActivity_Table.class);
//        startActivity(intent);
//    }

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
                intentEditdata = new Intent(getApplicationContext(), Activity_User_EditUser.class);
                intentEditdata.putExtra("emailUser", enterMail);
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