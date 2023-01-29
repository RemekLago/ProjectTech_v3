package v3.projecttech_v3.formularz5;

import android.util.Log;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

import v3.projecttech_v3.Pass;

public class ProceduraInsertZdjeciaSkargaFormularz5 {

    static String UserId;
    static String Firma;
    static String KontrolaId;
    static String Base64;

    static String rKomunikat;
    static String rStatus;
    static String rKontrolaZdjecieId;

    static HashMap<String, String> Result = new HashMap<>();


    public static HashMap<String, String> addingPhotosToDatabase
            (String UserId, String Firma, String KontrolaId, String Base64) {

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
                    "{call prcFormularzSkargaInsertZdjecia(?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = Firma;
            UserId = UserId;
            KontrolaId = KontrolaId;
            Base64 = Base64;
            Log.i("checking", "KontrolaId: " + KontrolaId);
            Log.i("checking", "Base64Id: " + Base64);

            callableStatement.setInt("Firma", Integer.parseInt(Firma));
            callableStatement.setInt("UserId", Integer.parseInt(UserId));
            callableStatement.setInt("KontrolaId", Integer.parseInt(KontrolaId));
            callableStatement.setString("Base64", Base64);

            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rKontrolaZdjecieId", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rKontrolaZdjecieId = callableStatement.getString("rKontrolaZdjecieId");

            Result.put("Status", rStatus);
            Result.put("Komunikat", rKomunikat);
            Result.put("KontrolaZjecieId", rKontrolaZdjecieId);
            Log.i("checking", "Result rStatus: " + rStatus);
            Log.i("checking", "Result rKomunikat: " + rKomunikat);
            Log.i("checking", "Result rKontrolaId: " + rKontrolaZdjecieId);

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception addingPhotosToDatabase()" + e.toString());
        }

        return Result;
    }
}
