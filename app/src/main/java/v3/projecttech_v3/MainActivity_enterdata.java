package v3.projecttech_v3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity_enterdata extends AppCompatActivity {

    static String pozycja_input = "";
    static String status_input;

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
//                openMainActivity_table();
            }});


        EditText editTextNumber = findViewById(R.id.editTextNumber);
        Button buttonSearch = findViewById(R.id.buttonSearch);


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp_pozycja_input = editTextNumber.getText().toString();
                String[] a = tmp_pozycja_input.split("");
                for (int i=0; i < 9; i++){
                    if (i==4 || i==7){
                        pozycja_input = pozycja_input + " " + a[i];
                    } else {
                        pozycja_input = pozycja_input + a[i];
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
}