package v3.projecttech_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.widget.ListView;
import v3.projecttech_v3.procedury.Procedura_Przewinienie_Formularz5;

public class Przewinienie_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przewinienie);


    SearchView searchView_przewinienie = findViewById(R.id.searchView_przewinienie);
    ListView listView_przewinienie = findViewById(R.id.listView_przewinienie);

    Procedura_Przewinienie_Formularz5.takingPrzewinienie();

    }
}