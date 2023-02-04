package v3.projecttech_v3.Start;

import static v3.projecttech_v3.Start.Login_User_activity.enterPassword;

import android.util.Log;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.HashMap;

import v3.projecttech_v3.Pass;

public class Procedura_prcLoginCreate {

    public static String rStatus, rKomunikat;
    public static String Imie, Nazwisko, Mail, Telefon;
    public static HashMap<String, String> tmpHashMap = new HashMap<String, String>();

    public static HashMap<String, String> creatingProfile() {

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
                    "{call prcLoginCreate(?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());


            Imie = Activity_User_Register.inputImie.getText().toString();
            Nazwisko = Activity_User_Register.inputNazwisko.getText().toString();;
            Mail = Activity_User_Register.inputEmail.getText().toString();;
            Telefon = Activity_User_Register.inputTelefon.getText().toString();;

            Log.i("checking", "Input Imie: " + Imie);
            Log.i("checking", "Input Nazwisko: " + Nazwisko);
            Log.i("checking", "Input Mail: " + Mail);
            Log.i("checking", "Input Telefon: " + Telefon);

            callableStatement.setString("Imie", Imie);
            callableStatement.setString("Nazwisko", Nazwisko);
            callableStatement.setString("eMail", Mail);
            callableStatement.setString("Telefon", Telefon);


            callableStatement.registerOutParameter("rStatus", java.sql.Types.INTEGER);
            callableStatement.registerOutParameter("rKomunikat", java.sql.Types.VARCHAR);

            callableStatement.execute();

            rStatus = callableStatement.getString("rStatus");
            rKomunikat = callableStatement.getString("rKomunikat");

            tmpHashMap.put("Status", rStatus);
            tmpHashMap.put("Komunikat", rKomunikat);

            Log.i("checking", "Status return: " + tmpHashMap.get("Status"));
            Log.i("checking", "Komunikat return: " + tmpHashMap.get("Komunikat"));

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception veryficationLogin()" + e.toString());
        }

        return tmpHashMap;
    }
 }




