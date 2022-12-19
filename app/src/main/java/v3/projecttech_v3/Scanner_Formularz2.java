package v3.projecttech_v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;

import v3.projecttech_v3.Formularze.Formularz1_InformacjeOPozycji_MainActivity_Table2;
import v3.projecttech_v3.procedury.Procedura_Magazyn_Lokalizacja_Walidacja_Formularz2;

public class Scanner_Formularz2 extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    //    static Result result;
    static Intent intentBarcode;
    public static String barcodeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_formularz2);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        intentBarcode = new Intent(Scanner_Formularz2.this, Procedura_Magazyn_Lokalizacja_Walidacja_Formularz2.class);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull com.google.zxing.Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Scanner_Formularz2.this, result.getText(), Toast.LENGTH_SHORT).show();
                        barcodeInput = result.toString();
                        startActivity(intentBarcode.putExtra("barcodeInput", barcodeInput));
                        Log.i("checking", "barcodeInput " + result.getText());
                    }
                });
            }




        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
}