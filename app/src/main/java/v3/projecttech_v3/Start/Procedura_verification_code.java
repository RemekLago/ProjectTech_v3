package v3.projecttech_v3.Start;

import android.graphics.Bitmap;
import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import v3.projecttech_v3.Pass;

public class Procedura_verification_code {

    static String imie;
    static String nazwisko;
    static String email;
    static String telefon;
    static String isActive;

    static String rKod;
    static String rKomunikat;
    static String rStatus;

    static HashMap<String, String> Result = new HashMap<>();



    public static HashMap<String, String> sendingVerificationCode() {

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
                    "{call prcGenerowanieKoduWeryfikacyjnego(?,?,?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            imie = "";
            nazwisko = "r.lagodzki@technokabel.com.p";
            email = "12345678";
            telefon = "123456789";
            isActive = "0";

            Log.i("checking", "imie: " + imie);
            Log.i("checking", "email: " + email);

            callableStatement.setInt("Imie", Integer.parseInt(imie));
            callableStatement.setInt("Nazwisko", Integer.parseInt(nazwisko));
            callableStatement.setInt("Email", Integer.parseInt(email));
            callableStatement.setString("Telefon", String.valueOf(telefon));
            callableStatement.setString("IsActive", String.valueOf(isActive));

            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rKod", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rKod = callableStatement.getString("rKod");

            Result.put("Status", rStatus);
            Result.put("Komunikat", rKomunikat);
            Result.put("KontrolaZjecieId", rKod);
            Log.i("checking", "Result rStatus: " + rStatus);
            Log.i("checking", "Result rKomunikat: " + rKomunikat);
            Log.i("checking", "Result rKontrolaId: " + rKod);

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception addingPhotosToDatabase()" + e.toString());
        }

        return Result;
    }
}
