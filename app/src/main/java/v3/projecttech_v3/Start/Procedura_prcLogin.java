package v3.projecttech_v3.Start;

import static v3.projecttech_v3.Start.Login_User_activity.enterMail;
import static v3.projecttech_v3.Start.Login_User_activity.enterPassword;
import android.util.Log;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.HashMap;
import v3.projecttech_v3.Pass;


public class Procedura_prcLogin {
    public static String rStatus, rKomunikat, rUserId, rName;
    public static String Login, Password;
    public static HashMap<String, String> tmpHashMap2 = new HashMap<String, String>();

    public static HashMap<String, String> checkingUserLogin() {

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
            Log.i("checking", "Connected to : " + connection.toString());

            CallableStatement callableStatement = connection.prepareCall(
                    "{call prcLogin(?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());


            Login = enterMail;
            Password = gettingUserPassword(enterPassword);

            Log.i("checking", "enterMail changed: " + Login);
            Log.i("checking", "enterPassword changed: " + Password);

            callableStatement.setString("Login", Login);
            callableStatement.setString("Password", Password);


            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rUserId", java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter("rName", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");
            rUserId = callableStatement.getString("rUserId");
            rName = callableStatement.getString("rName");

            tmpHashMap2.put("Status", rStatus);
            tmpHashMap2.put("Komunikat", rKomunikat);
            tmpHashMap2.put("UserId", rUserId);
            tmpHashMap2.put("Name", rName);

            Log.i("checking", "Procedura Informacje rStatus: " + rStatus);
            Log.i("checking", "Procedura Informacje rKomunikat: " + rKomunikat);
            Log.i("checking", "Procedura Informacje rPozycja: " + rUserId);
            Log.i("checking", "Procedura Informacje rPozycjaNazwa: " + rName);

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception Procedura_prcLogin()" + e.toString());
        }

//        resetTextView();

        Log.i("checking", "Status return: " + tmpHashMap2.get("Status"));
        Log.i("checking", "Komunikat return: " + tmpHashMap2.get("Komunikat"));
        return tmpHashMap2;
    }

    public static String gettingUserPassword(String password) {

        String passwordAsciFinal = "";
        byte[] passwordInput = password.getBytes(StandardCharsets.US_ASCII);

        Log.i("checking", "passwordAsci: " + password);
        Log.i("checking", "passwordAsci: " + Arrays.toString(passwordInput));

        for (int i=0; i < passwordInput.length; i++) {
//            Log.i("checking", "i: " + i);
            passwordAsciFinal = passwordAsciFinal + passwordInput[i];
            Log.i("checking", "passwordAsciFinal: " + passwordAsciFinal);
        }

        return passwordAsciFinal;
    }

}



