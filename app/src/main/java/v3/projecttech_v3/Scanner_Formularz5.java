package v3.projecttech_v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;

import v3.projecttech_v3.formularze.Formularz5_Maszyna_Pracownik_Skarga;


public class Scanner_Formularz5 extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    static Intent intentGoToFormularz5;
    public static String barcodeInput;

    public static final int CAMERA_ACTION_CODE = 1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_formularz5);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);

        intentGoToFormularz5 = new Intent(Scanner_Formularz5.this, Formularz5_Maszyna_Pracownik_Skarga.class);
        mCodeScanner = new CodeScanner(this, scannerView);


        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull com.google.zxing.Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Scanner_Formularz5.this, result.getText(), Toast.LENGTH_SHORT).show();
                        barcodeInput = result.toString();
                        startActivity(intentGoToFormularz5.putExtra("barcodeInput", barcodeInput));
                        Log.i("checking", "barcodeInput " + barcodeInput);
                    }
                });
            }

        });

        // Request for camera runtime permission
        if (ContextCompat.checkSelfPermission(Scanner_Formularz5.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Scanner_Formularz5.this, new String[] {
                    Manifest.permission.CAMERA
            }, CAMERA_ACTION_CODE);
        }

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