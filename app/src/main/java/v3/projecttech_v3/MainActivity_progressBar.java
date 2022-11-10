package v3.projecttech_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity_progressBar extends AppCompatActivity {

    private ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_progress_bar);

        progressbar = findViewById(R.id.progressbar);

    }
}