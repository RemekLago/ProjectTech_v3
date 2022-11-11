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
import com.google.zxing.Result;

public class MainActivity_Scanner extends AppCompatActivity {

    private CodeScanner mCodeScanner;
//    static Result result;
    static Intent intent2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scanner);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
//        intent = new Intent(MainActivity_Scanner.this, MainActivity_Table.class);
        intent2 = new Intent(MainActivity_Scanner.this, MainActivity_progressBar.class);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull com.google.zxing.Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity_Scanner.this, result.getText(), Toast.LENGTH_SHORT).show();
                        startActivity(intent2.putExtra("barcodeInput", result.toString()));
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