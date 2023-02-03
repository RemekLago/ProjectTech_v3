package v3.projecttech_v3.formularz5;

import static v3.projecttech_v3.formularz5.Przewinienie_Activity_InsertNew.inputKod;
import static v3.projecttech_v3.formularz5.Przewinienie_Activity_InsertNew.inputNazwa;

import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import v3.projecttech_v3.Pass;

public class ProceduraAddNewPrzewinienie {

    static String UserId;
    static String Firma;
    static String Kod;
    static String Nazwa;
    static String rKomunikat;
    static String rStatus;
    static String rPrzewinienieId;

    static HashMap<String, String> Result = new HashMap<>();

    public static HashMap<String, String> addingPrzewinienieToDatabase () {

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
                    "{call prcFormularzSkargaInsertPrzewinienie(?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());


            Firma = "750";
            UserId = "1";
            Kod = inputKod.getText().toString();
            Nazwa = inputNazwa.getText().toString();

//            Log.i("checking", "Firma: " + Firma);
//            Log.i("checking", "UserId: " + UserId);
//            Log.i("checking", "Kod: " + Kod);
//            Log.i("checking", "Nazwa: " + Nazwa);

            callableStatement.setInt("Firma", Integer.parseInt(Firma));
            callableStatement.setInt("UserId", Integer.parseInt(UserId));
            callableStatement.setString("Kod", Kod);
            callableStatement.setString("Nazwa", Nazwa);

            callableStatement.registerOutParameter("rStatus", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rPrzewinienieId", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rPrzewinienieId = callableStatement.getString("rPrzewinienieId");

            Result.put("Status", rStatus);
            Result.put("Komunikat", rKomunikat);
            Result.put("rPrzewinienieId", rPrzewinienieId);

            Log.i("checking", "Result rStatus: " + rStatus);
            Log.i("checking", "Result rKomunikat: " + rKomunikat);
            Log.i("checking", "Result rPrzewinienieId: " + rPrzewinienieId);

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception addingDataToDatabase()" + e.toString());
        }

        return Result;
    }
}
