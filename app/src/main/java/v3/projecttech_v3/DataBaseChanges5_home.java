package v3.projecttech_v3;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBaseChanges5_home extends AsyncTask<String, Void, ArrayList<ArrayList<String>>> {
    public static ArrayList<ArrayList<String>> tmpArray;


    @Override
    protected ArrayList<ArrayList<String>> doInBackground(String... strings) {

        Procedura_Drzewko_Kafelki_prcAccountFormTree procedura = new Procedura_Drzewko_Kafelki_prcAccountFormTree();
        tmpArray = procedura.takingUserSettings();
//
//        Log.i("checking", "tmpArray: " + tmpArray.size());
//        Log.i("checking", "tmpArray: " + tmpArray.get(0));
//        Log.i("checking", "tmpArray: " + tmpArray.get(1));
//        Log.i("checking", "tmpArray: " + tmpArray.get(2));

        return tmpArray;
    }
}