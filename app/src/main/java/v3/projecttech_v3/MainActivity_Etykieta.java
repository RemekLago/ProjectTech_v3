package v3.projecttech_v3;

import static v3.projecttech_v3.DataBaseChanges2.tmpdata2;
import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.Barcode;
import static v3.projecttech_v3.Procedura_Pozycja_Informacje2.rKomunikat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity_Etykieta extends AppCompatActivity {


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

        setContentView(R.layout.activity_main_etykieta);

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

}