package v3.projecttech_v3.Start;

import android.os.AsyncTask;

import java.util.HashMap;

public class DataBaseChanges_Verification extends AsyncTask<String, Void, HashMap<String, String>> {
    HashMap<String, String> ArrayListWithFinalData = new HashMap<>();

    @Override
    protected HashMap<String, String> doInBackground(String... strings) {

        Procedura_prcLoginVerification procedura = new Procedura_prcLoginVerification();
        ArrayListWithFinalData = Procedura_prcLoginVerification.veryficationLogin();

//        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Startus"));
//        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Komunikat"));

        return ArrayListWithFinalData;
    }
}