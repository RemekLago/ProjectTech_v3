package v3.projecttech_v3.formularz2;

import static v3.projecttech_v3.formularz2.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.searchCode;
import static v3.projecttech_v3.formularz2.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.textViewSearch;
import static v3.projecttech_v3.formularz2.Formularz2_Scanner.barcodeInput;


import android.util.Log;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import v3.projecttech_v3.Pass;



public class Procedura_Magazyn_Lokalizacja_Walidacja_Formularz2 {
    public static String Firma, UserId;
    public static String rPozycja, rMagazyn, rStatus, rLokalizacja, rKomunikat;
    static HashMap<String, String> tmpHashMap = new HashMap<String, String>();
    static String PozycjaAndrMagazynInput;
    static String tmp_pozycja_input;




    public HashMap<String, String> takingMagazynLokalzacja() {

        //connecting to database
        try {
            String user = Pass.user;
            String pass = Pass.pass;
            String db = Pass.db;
            String ip = Pass.ip;
            String port = Pass.port;
            String URL = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + db;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection connection = DriverManager.getConnection(URL, user, pass);
            Log.i("checking", "Connected to: " + connection.toString());

            CallableStatement callableStatement = connection.prepareCall(
                    "{call MT_Public_Magazyn_Lokalizacja_Walidacja(?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            PozycjaAndrMagazynInput = gettingMagazynLokalzacja(); // example "MAL120|N0013B" barcode from scanner or from textView editTextNumber from Layout

            Log.i("checking", "PozycjaAndrMagazynInput: " + PozycjaAndrMagazynInput);

            callableStatement.setInt("Firma", Integer.parseInt(Firma));
            callableStatement.setString("UserId", UserId.trim());
            callableStatement.setString("Barcode", PozycjaAndrMagazynInput);

            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rMagazyn", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rLokalizacja", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rMagazyn = callableStatement.getString("rMagazyn");
            rLokalizacja = callableStatement.getString("rLokalizacja");

            tmpHashMap.put("Status", rStatus);
            tmpHashMap.put("Komunikat", rKomunikat);
            tmpHashMap.put("Magazyn", rMagazyn);
            tmpHashMap.put("Lokalizacja", rLokalizacja);

            Log.i("checking", "Procedura Informacje rStatus: " + tmpHashMap.get("Status"));
            Log.i("checking", "Procedura Informacje rKomunikat: " + tmpHashMap.get("Komunikat"));
            Log.i("checking", "Procedura Informacje rPozycja: " + tmpHashMap.get("Magazyn"));
            Log.i("checking", "Procedura Informacje rPozycjaNazwa: " + tmpHashMap.get("Lokalizacja"));

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingMagazynLokalzacja()" + e.toString());
        }
        return tmpHashMap;

    }
    public static String gettingMagazynLokalzacja() {
        Log.i("checking", "tmp_pozycja_input, intentBarcode: " + barcodeInput);
        Log.i("checking", "tmp_pozycja_input, inten4: " + searchCode);
//        Log.i("checking", "rPozycja, inten4: " + searchCode);

        rMagazyn = "";
        rLokalizacja = "";

        if ( barcodeInput != null) {
            tmp_pozycja_input = barcodeInput.trim();
        }
        else if ( searchCode != null) {
            tmp_pozycja_input = searchCode;
        }
        else {
            tmp_pozycja_input = "000000000";
        }
        Log.i("checking", "tmp_pozycja_input return: " + tmp_pozycja_input);


        return tmp_pozycja_input;
    }

    public static void resetTextView(){
        if (searchCode != null) {
            textViewSearch.setText(null);
            searchCode = null;
        }
        if (barcodeInput != null) {
            searchCode = null;
        }
    }
}

