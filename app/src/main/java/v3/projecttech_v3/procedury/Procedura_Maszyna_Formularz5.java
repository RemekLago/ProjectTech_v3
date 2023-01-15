package v3.projecttech_v3.procedury;

import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import v3.projecttech_v3.Pass;

public class Procedura_Maszyna_Formularz5 {

    static String UserId;
    static String Firma;
    static String FormName;
    static String TextBoxName;
    static String SearchText;
    static String Parameters;
    static ResultSet rs;
    public static ArrayList<String> columnsNames = new ArrayList<>();
    public static int numberOfColumns;
    static ArrayList<ArrayList<String>> Result = new ArrayList<>();


    public static ArrayList<ArrayList<String>> takingMaszyna(String parameters, String searchText) {

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
                    "{call MT_Public_Search(?,?,?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            FormName = "FormularzMaszynaPracownikSkarga";
            TextBoxName = "textViewMaszyna";
            Parameters = parameters;
            SearchText = searchText;

            callableStatement.setInt("Firma", Integer.parseInt(Firma));
            callableStatement.setInt("UserId", Integer.parseInt(UserId));
            callableStatement.setString("FormName", FormName);
            callableStatement.setString("TextBoxName", TextBoxName);
            callableStatement.setString("Parameters", Parameters);
            callableStatement.setString("SearchText", SearchText);

            ResultSet rs;
            rs = callableStatement.executeQuery();


            //taking metadata and checking how many columns is in downloaded data
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            Log.i("checking", "columnCount: " + columnCount);

            columnsNames.clear();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnsNames.add(columnName);
//                Log.i("checking", "columnsNames: " + columnName);
            }
            numberOfColumns = columnsNames.size();

            Result.clear();

            int a = 0;
            while (rs.next()) {
                ArrayList<String> tmpRecord = new ArrayList<>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    tmpRecord.add(rs.getString(i));

                }
                Result.add(tmpRecord); //database-array with all records from SQL
                Log.i("checking", "Result: " + Result.get(a));
                a++;
            }

            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingMaszyna()" + e.toString());
        }

        return Result;
    }

}

