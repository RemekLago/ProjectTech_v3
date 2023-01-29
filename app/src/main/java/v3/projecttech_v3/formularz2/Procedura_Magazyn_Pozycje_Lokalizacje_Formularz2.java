package v3.projecttech_v3.formularz2;

import static v3.projecttech_v3.formularz2.Formularz2_Magazyn_Lsv_Magazyn_lokalizacja_Pozycja.dataBaseSQL4;


import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import v3.projecttech_v3.Pass;
import v3.projecttech_v3.db.entity.Data4;

public class Procedura_Magazyn_Pozycje_Lokalizacje_Formularz2 {

    public static String Firma, Magazyn, Lokalizacja;
    static String UserId;
    public static int numberOfColumns4;
    static ResultSet rs;
    public static ArrayList<String> columnsNames4 = new ArrayList<>();
    static ArrayList<ArrayList<String>> Result4 = new ArrayList<>();


    public ArrayList<ArrayList<String>> takingLocalizationPosition(String MagazynInput, String LokalizacjaInput) {

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
                    "{call MT_Magazyn_lsv_magazyn_lokalizacja_Pozycje(?,?,?,?)}");
            Log.i("checking", "CallableStatement: " + callableStatement.toString());

            Firma = "750";
            UserId = "1";
            Magazyn = MagazynInput;
            Lokalizacja = LokalizacjaInput;
            Log.i("checking", "Magazyn: " + Magazyn);
            Log.i("checking", "Lokalizacja: " + Lokalizacja);

            callableStatement.setInt("Firma", Integer.parseInt(Firma));
            callableStatement.setInt("UserId", Integer.parseInt(UserId));
            callableStatement.setString("Magazyn", Magazyn);
            callableStatement.setString("Lokalizacja", Lokalizacja);

            ResultSet rs;
            rs = callableStatement.executeQuery();

            //taking metadata and checking how many columns is in downloaded data
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            Log.i("checking", "columnCount4: " + columnCount);

            columnsNames4.clear();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnsNames4.add(columnName);
//                Log.i("checking", "columnsNames: " + columnName);
            }
            numberOfColumns4 = columnsNames4.size();

            Result4.clear();
            dataBaseSQL4.deleteAllData();

            boolean a;
            int b = 1;
            int idNumber = 0;
            while (rs.next()) {
                ArrayList<String> tmpRecord = new ArrayList<>();
                idNumber++;
                Data4 tmpInsertData = new Data4( idNumber,
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
                dataBaseSQL4.insertData(tmpInsertData);

                for (int i = 1; i <= numberOfColumns4; i++) {
                    tmpRecord.add(rs.getString(i));
//                    Log.i("checking", "record from ResultSet: " + rs.getString(i));

                }

                Result4.add(tmpRecord); //database with all records for SQL
                b++;
            }


            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception takingLocalizationPosition()" + e.toString());
        }
        return Result4;

    }
}