//package v3.projecttech_v3;
//
//import static v3.projecttech_v3.MainActivity_enterdata.intent2;
//import static v3.projecttech_v3.MainActivity_progressBar.intent3;
//import android.util.Log;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Types;
//import java.util.HashMap;
//
//public class Procedura_Pozycja_Informacje {
//
//    public static String rStatus, rKomunikat, rPozycja, rPozycjaNazwa;
//    public static String Firma, UserId, Barcode;
//    static HashMap<String, String> tmpHashMap = new HashMap<String, String>();
//
//    public static HashMap<String, String> takingPositionInformation() {
//
//        //connecting to database
//        try {
//            String user = Pass.user;
//            String pass = Pass.pass;
//            String db = Pass.db;
//            String ip = Pass.ip;
//            String port = Pass.port;
//            String URL = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + db;
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//            Connection connection = DriverManager.getConnection(URL, user, pass);
//            Log.i("checking", "Connected to: " + connection.toString());
//
//            CallableStatement callableStatement = connection.prepareCall(
//                    "{call MT_Public_Pozycja_Informacje(?,?,?,?,?,?,?)}");
//            Log.i("checking", "CallableStatement: " + callableStatement.toString());
//
//            Firma = "750";
//            UserId = "1";
//            Barcode = intent3.getStringExtra("barcodeInput");
////            intentScanner.getStringExtra("barcodeInput");
////            Barcode = intentScanner.getStringExtra("barcodeInput");
////            Barcode = 1|         1897 013 05|0,300|0|S300-2205||562105_1|749955|NEW|||124/A/05/22||||20.05.22|||||||""WYGPZ220168;
////            Barcode = result.getText();
////            Log.i("checking", "intentScanner " + intentScanner.getExtras());
//            Log.i("checking", "Barcode " + Barcode);
//
//
//            callableStatement.setInt("Firma", Integer.valueOf(Firma));
//            callableStatement.setInt("UserId", Integer.valueOf(UserId));
//            callableStatement.setString("Barcode", Barcode);
//
//            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
//            callableStatement.registerOutParameter("rKomunikat", Types.VARCHAR);
//            callableStatement.registerOutParameter("rPozycja", java.sql.Types.VARCHAR);
//            callableStatement.registerOutParameter("rPozycjaNazwa", java.sql.Types.VARCHAR);
//
//            callableStatement.execute();
//
//            rStatus = callableStatement.getString("rStatus").trim();
//            rKomunikat = callableStatement.getString("rKomunikat").trim();
//            rPozycja = callableStatement.getString("rPozycja");
//            rPozycjaNazwa = callableStatement.getString("rPozycjaNazwa").trim();
//
//            tmpHashMap.put("Status", rStatus);
//            tmpHashMap.put("Komunikat", rKomunikat);
//            tmpHashMap.put("Pozycja", rPozycja);
//            tmpHashMap.put("PozycjaNazwa", rPozycjaNazwa);
//
//            Log.i("checking", "rStatus: " + rStatus);
//            Log.i("checking", "rKomunikat: " + rKomunikat);
//            Log.i("checking", "rPozycja: " + rPozycja);
//            Log.i("checking", "rPozycjaNazwa: " + rPozycjaNazwa);
//
//            callableStatement.close();
//            connection.close();
//
//
//        } catch (Exception e) {
////            e.printStackTrace();
//            Log.i("checking", "exception takingPositionInformation()" + e.toString());
//        }
//        return tmpHashMap;
//    }
//}
//
