package v3.projecttech_v3;


import static v3.projecttech_v3.MainActivity_enterdata.intent2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import v3.projecttech_v3.formularze.Formularz1_InformacjeOPozycji_MainActivity_Table2;

public class MainActivity_progressBar extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    static Intent intent3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_progress_bar);

        progressBar = findViewById(R.id.progressbar);

        progressBar.setVisibility(View.VISIBLE);
        while (progressStatus < 100) {
            progressStatus++;
            Log.i("checking", "progressStatus: " + progressStatus);
        }
//        progressBar.setMax(100); // 100 maximum value for the progress value
//        progressBar.setProgress(1); // 50 default progress value for the progress bar


        // Start long running operation in a background thread
//        new Thread(new Runnable() {
//            public void run() {
//                while (progressStatus < 100) {
//                    progressStatus++;
//                    Log.i("checking", "progressStatus: " + progressStatus);
//                    // Update the progress bar and display the
//                    //current value in the text view
//                    handler.post(new Runnable() {
//                        public void run() {
//                            progressBar.setProgress(progressStatus);
//                                                    }
//                    });
//                    try {
//                        // Sleep for 200 milliseconds.
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        String a = intent2.getStringExtra("barcodeInput");
        Log.i("checking", "String a " + a);

        intent3 = new Intent(MainActivity_progressBar.this, Formularz1_InformacjeOPozycji_MainActivity_Table2.class);
        startActivity(intent3.putExtra("barcodeInput2", a));

     }
}