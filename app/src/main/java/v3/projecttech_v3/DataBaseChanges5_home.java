package v3.projecttech_v3;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBaseChanges5_home extends AsyncTask<String, Void, HashMap<String, ArrayList<String>>> {

    @Override
    protected HashMap<String, ArrayList<String>> doInBackground(String... strings) {

        return Procedura_Drzewko_Kafelki_prcAccountFormTree.takingUserSettings();
    }
}
