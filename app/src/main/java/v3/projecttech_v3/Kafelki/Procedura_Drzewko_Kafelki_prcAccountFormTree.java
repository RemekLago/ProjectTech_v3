package v3.projecttech_v3.Kafelki;

import static v3.projecttech_v3.Kafelki.Activity_Home_Main.userAccessLevel;

import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import v3.projecttech_v3.Pass;


public class Procedura_Drzewko_Kafelki_prcAccountFormTree {
    public static String Firma;
    public static int TreeNodeId;
    static String UserId;
    static int numberOfColumns;
    static ResultSet rs;
    static ArrayList<String> columnsNames = new ArrayList<>();
    public static ArrayList<ArrayList<String>> tmpListWithUserSettings;


    public static ArrayList<ArrayList<String>> takingUserSettings() {

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


            UserId = "25";
//            TreeNodeId = 0;
            TreeNodeId = userAccessLevel; // user zawsze zaczyna z uprawnieniami 0
            Log.i("checking", "TreeNodeId: " + TreeNodeId);

            callableStatement.setInt("UserId", Integer.valueOf(UserId));
            callableStatement.setInt("TreeNodeId", TreeNodeId);

            ResultSet rs;
            rs = callableStatement.executeQuery();

            //taking metadata and checking how many columns is in downloaded data
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            columnsNames.clear();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnsNames.add(columnName);
                Log.i("checking", "columnsNames: " + columnName);
            }
            numberOfColumns = columnsNames.size();
            Log.i("checking", "numberOfColumns: " + numberOfColumns);
//            Log.i("checking", "ResultSet: " + rs.next());



            tmpListWithUserSettings = new ArrayList<>();

            while (rs.next()) {
                ArrayList<String> tmpRecord = new ArrayList<>();
//                tmpRecord.clear();
                for (int i=1; i <= numberOfColumns; i++) {
                    tmpRecord.add(rs.getString(i));
                }

//                Log.i("checking", "tmpRecord: " + tmpRecord.get(1));
//                Log.i("checking", "tmpRecord: " + tmpRecord);

                tmpListWithUserSettings.add(tmpRecord);
//                Log.i("checking", "tmpListWithUserSettings: " + tmpListWithUserSettings.get(0).get(1));
//                Log.i("checking", "tmpListWithUserSettings: " + tmpListWithUserSettings);

            }
            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception Procedura_Drzewko_Kafelki_prcAccountFormTree" + e.toString());
        }
//        Log.i("checking", "return tmpListWithUserSettings: " + tmpListWithUserSettings.size());
        return tmpListWithUserSettings;

    }
}
