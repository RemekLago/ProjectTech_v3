package v3.projecttech_v3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity_enterdata extends AppCompatActivity {

    static String pozycja_input = "         ";
    static String status_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_enterdata);

//        Button button_scan = findViewById(R.id.button_scan);
//        button_scan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                openMainActivity_table();
//            }});

        Intent intent = new Intent(this, MainActivity_Table.class);

//        EditText editTextNumber = findViewById(R.id.editTextNumber);
//        Button buttonSearch = findViewById(R.id.buttonSearch);


//        buttonSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                pozycja_input = pozycja_input + editTextNumber.getText().toString();
//                status_input = "1";
//                startActivity(intent);
//                Log.i("checking", "pozycjaInput: " + pozycja_input);
//            }});

        Button btnScanBarcode = findViewById(R.id.buttonScanBarcode);

        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_enterdata.this, MainActivity_Scanner.class));
            }
        });

//        Button btnScanBarcode = findViewById(R.id.btnScanBarcode);
//
//        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity_enterdata.this, Activity_scanned_barcode.class));
//            }
//        });

    }
}