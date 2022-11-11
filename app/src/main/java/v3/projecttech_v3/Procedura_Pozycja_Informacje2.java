package v3.projecttech_v3;

import static v3.projecttech_v3.MainActivity_Table2.intent4;
import static v3.projecttech_v3.MainActivity_enterdata.intent2;
import android.util.Log;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.HashMap;

public class Procedura_Pozycja_Informacje2 {

    public static String rStatus, rKomunikat, rPozycja, rPozycjaNazwa;
    public static String Firma, UserId, Barcode;
    static HashMap<String, String> tmpHashMap2 = new HashMap<String, String>();

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
            Log.i("checking", "Connected to: " + connection.toString());

            CallableStatement callableStatement = connection.prepareCall(
                    "{call MT_Public_Pozycja_Informacje(?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            if (! intent2.getStringExtra("pozycjaInput").isEmpty()) {
                rPozycja = intent2.getStringExtra("pozycjaInput");
            } else {
                rPozycja = "";
                String tmp_pozycja_input = intent4.getStringExtra("searchPozycja");
                String[] a = tmp_pozycja_input.split("");
                for (int i=0; i < 9; i++){
                    if (i==4 || i==7){
                        rPozycja = rPozycja + " " + a[i];
                    } else {
                        rPozycja = rPozycja + a[i];
                    }

                }

            }
//            intentScanner.getStringExtra("barcodeInput");
//            Barcode = intentScanner.getStringExtra("barcodeInput");
//            Barcode = "WYGPZ2201681|         1897 013 05|0,300|0|S300-2205||562105_1|749955|NEW|||124/A/05/22||||20.05.22|||||||";
//            Barcode = result.getText();
//            Log.i("checking", "intentScanner " + intentScanner.getExtras());
            Log.i("checking", "rPozycja " + rPozycja);


            callableStatement.setInt("Firma", Integer.valueOf(Firma));
            callableStatement.setInt("UserId", Integer.valueOf(UserId));
            callableStatement.setString("Barcode", rPozycja.trim());
            Log.i("checking", "rPozycja " + rPozycja.trim());

            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", Types.VARCHAR);
            callableStatement.registerOutParameter("rPozycja", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rPozycjaNazwa", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rPozycja = callableStatement.getString("rPozycja");
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
        return tmpHashMap2;
    }
}


