package v3.projecttech_v3.Start;

import static v3.projecttech_v3.Start.Activity_User_Verification.inputPassword2;
import static v3.projecttech_v3.Start.Activity_User_Verification.inputVerificationCode;
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

public class Procedura_prcLoginVerification {

    public static String rStatus, rKomunikat;
    public static String VerificationCode, Password;
    public static HashMap<String, String> tmpHashMap = new HashMap<String, String>();

    public static HashMap<String, String> veryficationLogin() {

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
                    "{call prcLoginVerification(?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());


            VerificationCode = inputVerificationCode.getText().toString(); // pobrany z formularza kod przepisany z otrzymanego maila
            Password = gettingUserPassword(inputPassword2.getText().toString());

            callableStatement.setString("VerificationCode", VerificationCode);
            callableStatement.setString("Password", Password);


            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");

            tmpHashMap.put("Status", rStatus);
            tmpHashMap.put("Komunikat", rKomunikat);

            Log.i("checking", "Status return tmpHashMap: " + tmpHashMap.get("Status"));
            Log.i("checking", "Komunikat return tmpHashMap: " + tmpHashMap.get("Komunikat"));

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception veryficationLogin()" + e.toString());
        }

        return tmpHashMap;
    }

    public static String gettingUserPassword(String password) {

        String passwordAsciFinal = "";
        byte[] passwordInput = password.getBytes(StandardCharsets.US_ASCII);

        Log.i("checking", "passwordAsci: " + password);
        Log.i("checking", "passwordAsci: " + Arrays.toString(passwordInput));

        for (int i=0; i < passwordInput.length; i++) {
            Log.i("checking", "i: " + i);
            passwordAsciFinal = passwordAsciFinal + passwordInput[i];
            Log.i("checking", "passwordAsciFinal: " + passwordAsciFinal);
        }

        return passwordAsciFinal;
    }

}
