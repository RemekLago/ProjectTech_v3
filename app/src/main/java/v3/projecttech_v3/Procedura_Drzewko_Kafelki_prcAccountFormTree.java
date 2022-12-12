package v3.projecttech_v3;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Procedura_Drzewko_Kafelki_prcAccountFormTree {
    public static String Firma;
    public static String TreeNodeId;
    static String UserId;
    static int numberOfColumns;
    static ResultSet rs;
    static ArrayList<String> columnsNames = new ArrayList<>();
    public static HashMap<String, ArrayList<String>> tmpListWithUserSettings;


    public static HashMap<String, ArrayList<String>> takingUserSettings() {

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
                    "{call prcAccountFormTree(?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());


            UserId = "1";
            TreeNodeId = "9"; // tymczasowo, do pobrania po kliknięciu w kafelek
            Log.i("checking", "TreeNodeId: " + TreeNodeId);

            callableStatement.setInt("UserId", Integer.valueOf(UserId));
            callableStatement.setInt("TreeNodeId", Integer.valueOf(TreeNodeId));

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

            ArrayList<String> tmpRecord = new ArrayList<>();
            tmpListWithUserSettings = new HashMap<>();


            while (rs.next()) {

                for (int i=1; i <= numberOfColumns; i++) {
                    tmpRecord.add(rs.getString(i));
                }

//                Log.i("checking", "tmpRecord: " + tmpRecord.get(1));
//                Log.i("checking", "tmpRecord: " + tmpRecord);
                tmpListWithUserSettings.put(tmpRecord.get(1), tmpRecord);
//                Log.i("checking", "tmpListWithUserSettings: " + tmpListWithUserSettings.get(tmpRecord.get(1)));
                tmpRecord.clear();
            }
            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception Procedura_Drzewko_Kafelki_prcAccountFormTree" + e.toString());
        }
        return tmpListWithUserSettings;

    }
}
