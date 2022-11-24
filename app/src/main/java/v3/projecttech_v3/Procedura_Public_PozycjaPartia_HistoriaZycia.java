package v3.projecttech_v3;

import static v3.projecttech_v3.DataBaseChanges2.tmpdata2;
import static v3.projecttech_v3.MainActivity_Table2.dataBaseSQL;
import static v3.projecttech_v3.MainActivity_Table2.positionForDataBaseSQL;


import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Procedura_Public_PozycjaPartia_HistoriaZycia {
    public static String Firma, Pozycja, Partia;
    static String UserId;
    static int numberOfColumns4;
    static ResultSet rs;
    static ArrayList<String> columnsNames4 = new ArrayList<>();
    static ArrayList<ArrayList<String>> Result4 = new ArrayList<>();

    public static ArrayList<ArrayList<String>> takingHistoryPosition(){
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
                    "{call MT_Public_PozycjaPartia_HistoriaZycia(?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            Pozycja = tmpdata2.get("Pozycja");
            Partia = dataBaseSQL.getDataId(positionForDataBaseSQL + 1).getPartia();
            Log.i("checking", "Pozycja: " + Pozycja);
            Log.i("checking", "Partia: " + Partia);


            callableStatement.setInt("Firma", Integer.valueOf(Firma));
            callableStatement.setInt("UserId", Integer.valueOf(UserId));
            callableStatement.setString("Pozycja", Pozycja);
            callableStatement.setString("Partia", Partia);

            ResultSet rs;
            rs = callableStatement.executeQuery();

            //taking metadata and checking how many columns is in downloaded data
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            Log.i("checking", "columnCount: " + columnCount);

            columnsNames4.clear();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnsNames4.add(columnName);
//                Log.i("checking", "columnsNames: " + columnName);
            }
            numberOfColumns4 = columnsNames4.size();

            Result4.clear();
//            dataBaseSQL.deleteAllData();

            boolean a;
            int b = 1;
            int idNumber = 0;
            while (rs.next()) {
                ArrayList<String> tmpRecord = new ArrayList<>();
//                idNumber++;
//                Data tmpInsertData = new Data( idNumber,
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11),
//                        rs.getString(12),
//                        rs.getString(13),
//                        rs.getString(14),
//                        rs.getString(15)
//                );
//                dataBaseSQL.insertData(tmpInsertData);

                for (int i = 1; i <= numberOfColumns4; i++) {
                    tmpRecord.add(rs.getString(i));
//                    Log.i("checking", "record from ResultSet: " + rs.getString(i));

                }

                Result4.add(tmpRecord); //database with all records for SQL
//                b++;
            }


            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingHistoryPosition()" + e.toString());
        }
        return Result4;

    }
}