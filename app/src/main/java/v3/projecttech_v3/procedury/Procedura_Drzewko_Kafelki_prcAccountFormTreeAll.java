package v3.projecttech_v3.procedury;

import static v3.projecttech_v3.Activity_Home_Main.dataBaseSQLHome;

import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import v3.projecttech_v3.Pass;
import v3.projecttech_v3.db.entity.Data_Home;

public class Procedura_Drzewko_Kafelki_prcAccountFormTreeAll {
    public static String Firma;
    public static int TreeNodeId;
    static String UserId;
    static int numberOfColumns;
    static ResultSet rs;
    static ArrayList<String> columnsNames = new ArrayList<>();
    public static ArrayList<ArrayList<String>> tmpListWithUserSettings;
    static ArrayList<ArrayList<String>> Result = new ArrayList<>();



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
                    "{call prcAccountFormTreeAll(?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());


            UserId = "22";
            callableStatement.setInt("UserId", Integer.valueOf(UserId));

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

            dataBaseSQLHome.deleteAllData();

            while (rs.next()) {
                ArrayList<String> tmpRecord = new ArrayList<>();

                Data_Home tmpInsertData = new Data_Home(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                dataBaseSQLHome.insertData(tmpInsertData);

                for (int i = 1; i <= numberOfColumns; i++) {
                    tmpRecord.add(rs.getString(i));
                }

                Result.add(tmpRecord); //database with all records for SQL

            }

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception Procedura_Drzewko_Kafelki_prcAccountFormTree" + e.toString());
        }
//        Log.i("checking", "return Result: " + Result.size());

        return Result;
    }



}