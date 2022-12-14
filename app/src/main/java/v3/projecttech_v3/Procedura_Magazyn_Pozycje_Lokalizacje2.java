package v3.projecttech_v3;

import static v3.projecttech_v3.DataBaseChanges2.tmpdata2;
import static v3.projecttech_v3.Formularz1_InformacjeOPozycji_MainActivity_Table2.dataBaseSQL;

import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import v3.projecttech_v3.db.entity.Data;

public class Procedura_Magazyn_Pozycje_Lokalizacje2 {

    static ArrayList<ArrayList<String>> Result2 = new ArrayList<>();
    public static String Firma, Pozycja;
    static String UserId;
    static int numberOfColumns2;
    static ResultSet rs;
    static ArrayList<String> columnsNames2 = new ArrayList<>();


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
            Pozycja = tmpdata2.get("Pozycja");
            Log.i("checking", "Pozycja: " + tmpdata2.get("Pozycja"));
            Log.i("checking", "Pozycja: " + tmpdata2.get("Pozycja"));

            callableStatement.setInt("Firma", Integer.valueOf(Firma));
            callableStatement.setInt("UserId", Integer.valueOf(UserId));
            callableStatement.setString("Pozycja", Pozycja);


            Log.i("checking", "Pozycja: " + Pozycja);

            ResultSet rs;
            rs = callableStatement.executeQuery();

            //taking metadata and checking how many columns is in downloaded data
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            columnsNames2.clear();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnsNames2.add(columnName);
//                Log.i("checking", "columnsNames: " + columnName);
            }
            numberOfColumns2 = columnsNames2.size();
//            Log.i("checking", "numberOfColumns: " + numberOfColumns);
//            Log.i("checking", "ResultSet: " + rs.next());

            Result2.clear();
            dataBaseSQL.deleteAllData();
//            dataBaseSQL.deleteAllData();
            boolean a;
            int b = 1;
            int idNumber = 0;
            while (rs.next()) {
                ArrayList<String> tmpRecord = new ArrayList<>();
                idNumber++;
               Data tmpInsertData = new Data( idNumber,
                       rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15)
                       );
               dataBaseSQL.insertData(tmpInsertData);

//                Log.i("checking", "record from dataBaseSQL: " + dataBaseSQL.getDataId(b).getIlszt());
//                Log.i("checking", "record from dataBaseSQL: " + rs.getString(1));
//                Log.i("checking", "record from dataBaseSQL: " + rs.getString(2));
//                Log.i("checking", "record from dataBaseSQL: " + rs.getString(3));
//                Log.i("checking", "record from dataBaseSQL: " + rs.getString(4));
//                Log.i("checking", "record from dataBaseSQL: " + rs.getString(5));
                for (int i = 1; i <= numberOfColumns2; i++) {
                    tmpRecord.add(rs.getString(i));
//                    Log.i("checking", "record from ResultSet: " + rs.getString(i));

                }

                Result2.add(tmpRecord); //database with all records for SQL
            b++;
            }
            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingLocalizationPosition()" + e.toString());
        }
        return Result2;
//        return dataBaseSQL;
    }


}
