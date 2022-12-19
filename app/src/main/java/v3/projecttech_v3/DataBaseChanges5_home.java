package v3.projecttech_v3;

import static v3.projecttech_v3.Activity_Home_Main.progressBar;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.ArrayList;

import v3.projecttech_v3.procedury.Procedura_Drzewko_Kafelki_prcAccountFormTree;
import v3.projecttech_v3.procedury.Procedura_Drzewko_Kafelki_prcAccountFormTreeAll;

public class DataBaseChanges5_home extends AsyncTask<String, Void, ArrayList<ArrayList<String>>> {
    public static ArrayList<ArrayList<String>> tmpArray;


    @Override
    protected ArrayList<ArrayList<String>> doInBackground(String... strings) {

//        Procedura_Drzewko_Kafelki_prcAccountFormTree procedura = new Procedura_Drzewko_Kafelki_prcAccountFormTree();
//        tmpArray = procedura.takingUserSettings();

        Procedura_Drzewko_Kafelki_prcAccountFormTreeAll procedura = new Procedura_Drzewko_Kafelki_prcAccountFormTreeAll();
        tmpArray = Procedura_Drzewko_Kafelki_prcAccountFormTreeAll.takingUserSettings();


//
//        Log.i("checking", "tmpArray: " + tmpArray.size());
//        Log.i("checking", "tmpArray: " + tmpArray.get(0));
//        Log.i("checking", "tmpArray: " + tmpArray.get(1));
//        Log.i("checking", "tmpArray: " + tmpArray.get(2));


        return tmpArray;
    }

}