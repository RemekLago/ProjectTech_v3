package v3.projecttech_v3.formularz2;

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

import v3.projecttech_v3.R;

public class Formularz2_Scanner extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    //    static Result result;
    static Intent intentBarcode;
    public static String barcodeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formularz2_scanner);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        intentBarcode = new Intent(Formularz2_Scanner.this, Procedura_Magazyn_Lokalizacja_Walidacja_Formularz2.class);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull com.google.zxing.Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Formularz2_Scanner.this, result.getText(), Toast.LENGTH_SHORT).show();
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