package v3.projecttech_v3.Start;

import android.os.AsyncTask;

import java.util.HashMap;

public class DataBaseChanges_Register extends AsyncTask<String, Void, HashMap<String, String>> {
    HashMap<String, String> ArrayListWithFinalData = new HashMap<>();

    @Override
    protected HashMap<String, String> doInBackground(String... strings) {

        Procedura_prcLoginCreate procedura = new Procedura_prcLoginCreate();
        ArrayListWithFinalData = Procedura_prcLoginCreate.creatingProfile();

//        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Startus"));
//        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Komunikat"));

        return ArrayListWithFinalData;
    }
}