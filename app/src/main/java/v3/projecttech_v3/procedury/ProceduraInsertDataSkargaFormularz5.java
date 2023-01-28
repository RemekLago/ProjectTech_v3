package v3.projecttech_v3.procedury;


import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import v3.projecttech_v3.Pass;

public class ProceduraInsertDataSkargaFormularz5 {

    static String UserId;
    static String Firma;
    static String MaszynaId;
    static String OperatorId;
    static String PrzewinienieId;
    static String Telefon;
    static String SmsStatus;
    static String SmsTresc;
    static String Uwaga;

    static String rKomunikat;
    static String rStatus;
    static String rKontrolaId;

    static HashMap<String, String> Result = new HashMap<>();

    public static HashMap<String, String> addingDataToDatabase (
            String userId, String firma, String maszynaId, String operatorId, String przewinienieId,
             String telefon, String smsStatus, String smsTresc, String uwaga) {

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
                    "{call prcFormularzSkargaInsertData(?,?,?,?,?,?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());


            Firma = firma;
            UserId = userId;
            MaszynaId = maszynaId;
            OperatorId = operatorId;
            PrzewinienieId = przewinienieId;
            Telefon = telefon;
            SmsStatus = smsStatus;
            SmsTresc = smsTresc;
            Uwaga = uwaga;
            Log.i("checking", "MaszynaId: " + MaszynaId);
            Log.i("checking", "OperatorId: " + OperatorId);
            Log.i("checking", "PrzewinienieId: " + PrzewinienieId);
            Log.i("checking", "SmsTresc: " + SmsTresc);
            Log.i("checking", "Uwaga: " + Uwaga);

            callableStatement.setInt("Firma", Integer.parseInt(Firma));
            callableStatement.setInt("UserId", Integer.parseInt(UserId));
            callableStatement.setString("MaszynaId", MaszynaId);
            callableStatement.setString("OperatorId", OperatorId);
            callableStatement.setString("PrzewinienieId", PrzewinienieId);
            callableStatement.setString("Telefon", Telefon);
            callableStatement.setString("SmsStatus", SmsStatus);
            callableStatement.setString("SmsTresc", SmsTresc);
            callableStatement.setString("Uwaga", Uwaga);

            callableStatement.registerOutParameter("rStatus", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rKontrolaId", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rKontrolaId = callableStatement.getString("rKontrolaId");

            Result.put("Status", rStatus);
            Result.put("Komunikat", rKomunikat);
            Result.put("KontrolaId", rKontrolaId);
            Log.i("checking", "Result rStatus: " + rStatus);
            Log.i("checking", "Result rKomunikat: " + rKomunikat);
            Log.i("checking", "Result rKontrolaId: " + rKontrolaId);

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception addingDataToDatabase()" + e.toString());
        }

        return Result;
    }
}

