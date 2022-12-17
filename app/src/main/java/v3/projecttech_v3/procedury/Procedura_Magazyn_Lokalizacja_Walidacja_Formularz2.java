package v3.projecttech_v3.procedury;

import static v3.projecttech_v3.Formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.searchCode;
import static v3.projecttech_v3.Formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.textViewSearch;
import static v3.projecttech_v3.MainActivity_Scanner.barcodeInput;
import static v3.projecttech_v3.Formularze.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.editTextNumber;

import android.util.Log;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import v3.projecttech_v3.Pass;



public class Procedura_Magazyn_Lokalizacja_Walidacja_Formularz2 {
    public static String Firma;
    public static String rPozycja, rMagazyn, rStatus, rLokalizacja, rKomunikat;
    static HashMap<String, String> tmpHashMap = new HashMap<String, String>();


    public HashMap<String, String> takingLocalizationPosition() {

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
                    "{call MT_Public_Magazyn_Lokalizacja_Walidacja(?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            rPozycja = "MAL120|N0013B"; // barcode from scanner or from textView editTextNumber from Layout

            Log.i("checking", "rPozycja: " + rPozycja);

            callableStatement.setInt("rStatus", Integer.valueOf(Firma));
            callableStatement.setString("Barcode", rPozycja.trim());

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
            tmpHashMap.put("Pozycja", rMagazyn);
            tmpHashMap.put("PozycjaNazwa", rLokalizacja);

            Log.i("checking", "Procedura Informacje rStatus: " + rStatus);
            Log.i("checking", "Procedura Informacje rKomunikat: " + rKomunikat);
            Log.i("checking", "Procedura Informacje rPozycja: " + rMagazyn);
            Log.i("checking", "Procedura Informacje rPozycjaNazwa: " + rLokalizacja);

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingInformationAboutLocalisation()" + e.toString());
        }
        return tmpHashMap;

    }
    public static String gettingrPozycja() {
        Log.i("checking", "rPozycja, inten2: " + pozycja_input);
        Log.i("checking", "rPozycja, inten3: " + barcodeInput);
        Log.i("checking", "rPozycja, inten4: " + searchCode);
//        Log.i("checking", "rPozycja, inten4: " + searchCode);

        rPozycja = "";

        if ( barcodeInput != null) {
//            rPozycja = intent3.getStringExtra("barcodeInput");
            rPozycja = barcodeInput;
        }
        else if ( searchCode != null) {
//            if ( searchCode != null && searchCode.length()>1) {
            // do pobierania POZYCJI z boxu Search w MainActivity_table2
//                rPozycja = "";
//            String tmp_pozycja_input = intent4.getStringExtra("searchPozycja");
            String tmp_pozycja_input = "";
            tmp_pozycja_input = searchCode;
            String[] a = tmp_pozycja_input.split("");
            for (int i = 0; i < 9; i++) {
                if (i == 4 || i == 7) {
                    rPozycja = rPozycja + " " + a[i];
                } else {
                    rPozycja = rPozycja + a[i];
                }
            }
        }
        else {
            rPozycja = "000000000";
        }
        Log.i("checking", "rPozycja gettingrPozycja return: " + rPozycja);

        return rPozycja;
    }

    public static void resetTextView(){
        if (pozycja_input != null) {
            editTextNumber.setText(null);
            pozycja_input = null;
        }
        if (searchCode != null) {
            textViewSearch.setText(null);
            searchCode = null;
        }
        if (barcodeInput != null) {
            searchCode = null;
        }
    }
}

