package v3.projecttech_v3;

import static v3.projecttech_v3.MainActivity_Scanner.barcodeInput;
import static v3.projecttech_v3.Formularz1_InformacjeOPozycji_MainActivity_Table2.searchCode;
import static v3.projecttech_v3.Formularz1_InformacjeOPozycji_MainActivity_Table2.textViewSearch;
import static v3.projecttech_v3.MainActivity_enterdata.editTextNumber;
import static v3.projecttech_v3.MainActivity_enterdata.pozycja_input;

import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.HashMap;

public class Procedura_Pozycja_Informacje2 {

    public static String rStatus, rKomunikat, rPozycjaNazwa;
    public static String Firma, UserId, Barcode;
    static HashMap<String, String> tmpHashMap2 = new HashMap<String, String>();
    static String rPozycja;

    public static HashMap<String, String> takingPositionInformation() {

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
            Log.i("checking", "Connected2 to : " + connection.toString());

            CallableStatement callableStatement = connection.prepareCall(
                    "{call MT_Public_Pozycja_Informacje(?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            rPozycja = gettingrPozycja();

            Log.i("checking", "rPozycja gettingrPozycja() " + gettingrPozycja());
//            intentScanner.getStringExtra("barcodeInput");
//            Barcode = intentScanner.getStringExtra("barcodeInput");
//            Barcode = "WYGPZ2201681|         1897 013 05|0,300|0|S300-2205||562105_1|749955|NEW|||124/A/05/22||||20.05.22|||||||";
//            Barcode = result.getText();
//            Log.i("checking", "intentScanner " + intentScanner.getExtras());
//            Log.i("checking", "rPozycja " + rPozycja);


            callableStatement.setInt("Firma", Integer.valueOf(Firma));
            callableStatement.setInt("UserId", Integer.valueOf(UserId));
            callableStatement.setString("Barcode", rPozycja.trim());
            Log.i("checking", "rPozycja Barcode " + rPozycja.trim());

            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", Types.VARCHAR);
            callableStatement.registerOutParameter("rPozycja", java.sql.Types.VARCHAR);
            Log.i("checking", "rPozycja callableStatement.registerOutParameter " + rPozycja.trim());
            callableStatement.registerOutParameter("rPozycjaNazwa", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rPozycja = callableStatement.getString("rPozycja");
            Log.i("checking", "rPozycja callablestatement.getString " + rPozycja);
            rPozycjaNazwa = callableStatement.getString("rPozycjaNazwa");


            tmpHashMap2.put("Status", rStatus);
            tmpHashMap2.put("Komunikat", rKomunikat);
            tmpHashMap2.put("Pozycja", rPozycja);
            tmpHashMap2.put("PozycjaNazwa", rPozycjaNazwa);



            Log.i("checking", "Procedura Informacje rStatus: " + rStatus);
            Log.i("checking", "Procedura Informacje rKomunikat: " + rKomunikat);
            Log.i("checking", "Procedura Informacje rPozycja: " + rPozycja);
            Log.i("checking", "Procedura Informacje rPozycjaNazwa: " + rPozycjaNazwa);
//            Log.i("checking", "rStatus: " + tmpHashMap.get("rStatus"));
//            Log.i("checking", "rKomunikat: " + tmpHashMap.get("rKomunikat"));
//            Log.i("checking", "rPozycja: " + tmpHashMap.get("rPozycja"));
//            Log.i("checking", "rPozycjaNazwa: " + tmpHashMap.get("rPozycjaNazwa"));


            callableStatement.close();
            connection.close();



        } catch (Exception e) {
//            e.printStackTrace();
            Log.i("checking", "exception takingPositionInformation()" + e.toString());
        }

        resetTextView();

        Log.i("checking", "Pozycja return tmpHashMap: " + tmpHashMap2.get("Pozycja"));
        return tmpHashMap2;
    }

    public static String gettingrPozycja() {
        Log.i("checking", "rPozycja, inten2: " + pozycja_input);
        Log.i("checking", "rPozycja, inten3: " + barcodeInput);
        Log.i("checking", "rPozycja, inten4: " + searchCode);
//        Log.i("checking", "rPozycja, inten4: " + searchCode);

        rPozycja = "";

        if (pozycja_input != null) {
//            rPozycja = intent2.getStringExtra("pozycjaInput");
            rPozycja = pozycja_input;
        }
        else if ( barcodeInput != null) {
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


