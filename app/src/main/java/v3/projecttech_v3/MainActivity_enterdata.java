package v3.projecttech_v3;

import static v3.projecttech_v3.Activity_User_Login.intentEditdata;
import static v3.projecttech_v3.Activity_User_Login.userLoginCheck;

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
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_enterdata extends AppCompatActivity {

    static String pozycja_input;
    static String status_input;
    static EditText editTextNumber;

    static Intent intent1;
    static Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_enterdata);

        intent1 = new Intent(MainActivity_enterdata.this, MainActivity_Scanner.class);
        intent2 = new Intent(MainActivity_enterdata.this, MainActivity_Table2.class);

        Button button_scan = findViewById(R.id.buttonSearch);
        button_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                openMainActivity_table2();
                Toast.makeText(getApplicationContext(), "Not finished ", Toast.LENGTH_LONG).show();
            }});


        editTextNumber = findViewById(R.id.editTextNumber);
        Button buttonSearch = findViewById(R.id.buttonSearch);


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp_pozycja_input = editTextNumber.getText().toString();

                if (tmp_pozycja_input.isEmpty() || tmp_pozycja_input.length() < 9
                || tmp_pozycja_input.length() > 9) {
                    Toast.makeText(getApplicationContext(), "Pozycja is incorrect, try again", Toast.LENGTH_LONG).show();
                } else {
                    String[] a = tmp_pozycja_input.split("");
                    pozycja_input = "";
                    for (int i = 0; i < 9; i++) {
                        if (i == 4 || i == 7) {
                            pozycja_input = pozycja_input + " " + a[i];
                        } else {
                            pozycja_input = pozycja_input + a[i];
                        }

                    }
                }

                startActivity(intent2.putExtra("pozycjaInput", pozycja_input.toString()));

                Log.i("checking", "pozycjaInput: " + pozycja_input);

            }});

        Button btnScanBarcode = findViewById(R.id.buttonScanBarcode);

        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity_enterdata.this, MainActivity_Scanner.class));
                startActivity(intent1);
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