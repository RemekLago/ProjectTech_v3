package v3.projecttech_v3.formularz5;

import android.os.AsyncTask;

import java.util.HashMap;

import v3.projecttech_v3.Start.Procedura_prcLoginCreate;

public class DataBaseChanges6_PrzewinienieNew_Formularz5 extends AsyncTask<String, Void, HashMap<String, String>> {
    HashMap<String, String> ArrayListWithFinalData = new HashMap<>();

    @Override
    protected HashMap<String, String> doInBackground(String... strings) {

        ProceduraAddNewPrzewinienie procedura = new ProceduraAddNewPrzewinienie();
        ArrayListWithFinalData = ProceduraAddNewPrzewinienie.addingPrzewinienieToDatabase();

//        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Startus"));
//        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Komunikat"));

        return ArrayListWithFinalData;
    }
}