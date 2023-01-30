package v3.projecttech_v3.Start;

import android.os.AsyncTask;
import android.util.Log;

import java.util.HashMap;

import v3.projecttech_v3.formularze.Procedura_prcLogin;

public class DataBaseChanges_Login extends AsyncTask<String, Void, HashMap<String, String> > {
    HashMap<String, String> ArrayListWithFinalData = new HashMap<>();

    @Override
    protected HashMap<String, String> doInBackground(String... strings) {

        Procedura_prcLogin procedura = new Procedura_prcLogin();
        ArrayListWithFinalData = Procedura_prcLogin.checkingUserLogin();

        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Startus"));
        Log.i("checking","ArrayListWithFinalData: " + ArrayListWithFinalData.get("Komunikat"));

        return ArrayListWithFinalData;
    }
}
