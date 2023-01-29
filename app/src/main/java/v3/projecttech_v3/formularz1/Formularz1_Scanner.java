package v3.projecttech_v3.formularz1;

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

public class Formularz1_Scanner extends AppCompatActivity {

    private CodeScanner mCodeScanner;
//    static Result result;
    static Intent intent3;
    public static String barcodeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formularz1_scanner);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
//        intent = new Intent(MainActivity_Scanner.this, MainActivity_Table.class);
//        intent2 = new Intent(MainActivity_Scanner.this, MainActivity_progressBar.class);
        intent3 = new Intent(Formularz1_Scanner.this, Formularz1_InformacjeOPozycji_MainActivity_Table2.class);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull com.google.zxing.Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Formularz1_Scanner.this, result.getText(), Toast.LENGTH_SHORT).show();
                        barcodeInput = result.toString();
                        startActivity(intent3.putExtra("barcodeInput", barcodeInput));
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