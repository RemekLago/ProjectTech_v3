package v3.projecttech_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import v3.projecttech_v3.procedury.Procedura_Przewinienie_Formularz5;

public class Przewinienie_Activity_v2 extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter_przewinienie;
    SearchView searchView_przewinienie;
    ListView listView_przewinienie;
    String clickedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przewinienie_v2);

        SearchView searchView_przewinienie = findViewById(R.id.searchView_przewinienie);
        ListView listView_przewinienie = findViewById(R.id.listView_przewinienie);

        Procedura_Przewinienie_Formularz5.takingPrzewinienie();

        String[] list_przewinienie = {"przewinienie", "uwaga", "skarga", "donos",
                "zaniedbanie", "pracownika", "reklamacja", "brak", "dom", "chatka", "mieszkanie"};


        // set adapter for list
        arrayAdapter_przewinienie = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list_przewinienie);
        listView_przewinienie.setAdapter(arrayAdapter_przewinienie);


        listView_przewinienie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedPosition = ((TextView) view).getText().toString();
                searchView_przewinienie.setQuery(clickedPosition, true);
//
            }
        });

        // searchView set filter
        searchView_przewinienie.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Przewinienie_Activity_v2.this.arrayAdapter_przewinienie.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Przewinienie_Activity_v2.this.arrayAdapter_przewinienie.getFilter().filter(newText);
                return false;
            }
        });

    }
}