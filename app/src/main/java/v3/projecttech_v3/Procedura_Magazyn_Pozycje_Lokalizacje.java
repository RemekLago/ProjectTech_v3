package v3.projecttech_v3;

import static v3.projecttech_v3.DataBaseChanges.tmpdata;
import static v3.projecttech_v3.MainActivity_enterdata.pozycja_input;

import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseArray;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Procedura_Magazyn_Pozycje_Lokalizacje {

    static ArrayList<ArrayList<String>> Result = new ArrayList<>();
    public static String Firma, Pozycja;
    static String UserId;
    static int numberOfColumns;
    ResultSet rs;
    static ArrayList<String> columnsNames = new ArrayList<>();

    public ArrayList<ArrayList<String>> takingLocalizationPosition() {

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
                    "{call MT_Magazyn_lsv_pozycja_magazyny_lokalizacje(?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            Pozycja = tmpdata.get("Pozycja");

//            if (pozycja_input.isEmpty()) {
//                Pozycja = tmpdata.get("Pozycja");
//            } else {
//                Pozycja = pozycja_input;
//            }

            callableStatement.setInt("Firma", Integer.valueOf(Firma));
            callableStatement.setInt("UserId", Integer.valueOf(UserId));
            callableStatement.setString("Pozycja", Pozycja);

//            Log.i("checking", "Pozycja: " + Pozycja);

            ResultSet rs;
            rs = callableStatement.executeQuery();

            //taking metadata and checking how many columns is in downloaded data
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            columnsNames.clear();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnsNames.add(columnName);
//                Log.i("checking", "columnsNames: " + columnName);
            }
            numberOfColumns = columnsNames.size();
//            Log.i("checking", "numberOfColumns: " + numberOfColumns);
//            Log.i("checking", "ResultSet: " + rs.next());

            Result.clear();
            while (rs.next()) {
                ArrayList<String> tmpRecord = new ArrayList<>();
                for (int i = 1; i <= numberOfColumns; i++) {
                    tmpRecord.add(rs.getString(i));
//                    Log.i("checking", "record from ResultSet: " + rs.getString(i));
                }

                Result.add(tmpRecord); //database with all records for SQL
            }
            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingLocalizationPosition()" + e.toString());
        }
        return Result;
    }
}
