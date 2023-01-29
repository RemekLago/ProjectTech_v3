package v3.projecttech_v3.formularz5;

import static v3.projecttech_v3.formularz5.Formularz5_Maszyna_Pracownik_Skarga.barcodeMaszynaInput;

import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import v3.projecttech_v3.Pass;

public class ProceduraBarcodeScannerWalidacja_Formularz5 {

    static String UserId;
    static String Firma;
    static String Barcode;
    static String rStatus;
    static String rKomunikat;
    static String rMaszynaId;
    static String rMaszynaNazwa;
    static ArrayList<String> result;

    public static ArrayList<String> walidacjaBarcodeMaszyna () {

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
                    "{call prcBarcodeMaszynaWalidacja(?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            Barcode = barcodeMaszynaInput;
            Log.i("checking", "CallableStatement Barcode: " + Barcode);

            callableStatement.setInt("Firma", Integer.parseInt(Firma));
            callableStatement.setInt("UserId", Integer.parseInt(UserId.trim()));
            callableStatement.setString("Barcode", Barcode);


            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rMaszynaId", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rMaszynaNazwa", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rMaszynaId = callableStatement.getString("rMaszynaId");
            rMaszynaNazwa = callableStatement.getString("rMaszynaNazwa");

            Log.i("checking", "CallableStatement rStatus: " + rStatus);
            Log.i("checking", "CallableStatement rKomunikat: " + rKomunikat);
            Log.i("checking", "CallableStatement rMaszynaId: " + rMaszynaId);
            Log.i("checking", "CallableStatement rMaszynaNazwa: " + rMaszynaNazwa);

            result = new ArrayList<>();

            result.add(rStatus);
            result.add(rKomunikat);
            result.add(rMaszynaId);
            result.add(rMaszynaNazwa);


            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingMaszyna()" + e.toString());
        }

        return result;
    }
}
