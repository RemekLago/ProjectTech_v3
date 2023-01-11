package v3.projecttech_v3.procedury;

import android.util.Log;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import v3.projecttech_v3.Pass;
import v3.projecttech_v3.db.entity.Data_Grafik_formularz5;
import v3.projecttech_v3.db.entity.Data_KontrolaZdjecia_formularz5;
import v3.projecttech_v3.db.entity.Data_Kontrola_formularz5;
import v3.projecttech_v3.db.entity.Data_Maszyny_formularz5;
import v3.projecttech_v3.db.entity.Data_Operator_formularz5;
import v3.projecttech_v3.db.entity.Data_Przewinienia_formularz5;
import v3.projecttech_v3.db.entity.Data_SMSy_formularz5;
import v3.projecttech_v3.db.entity.Data_Zmiana_formularz5;

public class Procedura_Maszyna_Pracownik_Skarga_formularz5 {


    public static void createTables() {
        String query1 = Data_Zmiana_formularz5.CREATE_TABLE;
        String TABLE_NAME1 = Data_Zmiana_formularz5.TABLE_NAME;
        String query2 = Data_SMSy_formularz5.CREATE_TABLE;
        String TABLE_NAME2 = Data_SMSy_formularz5.TABLE_NAME;
        String query3 = Data_Przewinienia_formularz5.CREATE_TABLE;
        String TABLE_NAME3 = Data_Przewinienia_formularz5.TABLE_NAME;
        String query4 = Data_Operator_formularz5.CREATE_TABLE;
        String TABLE_NAME4 = Data_Operator_formularz5.TABLE_NAME;
        String query5 = Data_Maszyny_formularz5.CREATE_TABLE;
        String TABLE_NAME5 = Data_Maszyny_formularz5.TABLE_NAME;
        String query6 = Data_KontrolaZdjecia_formularz5.CREATE_TABLE;
        String TABLE_NAME6 = Data_KontrolaZdjecia_formularz5.TABLE_NAME;
        String query7 = Data_Kontrola_formularz5.CREATE_TABLE;
        String TABLE_NAME7 = Data_Kontrola_formularz5.TABLE_NAME;
        String query8 = Data_Grafik_formularz5.CREATE_TABLE;
        String TABLE_NAME8 = Data_Grafik_formularz5.TABLE_NAME;

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

            Statement statement = connection.createStatement();

//            statement.executeUpdate("DROP TABLE ZMIANA");

            if ( !isTableExists(connection, TABLE_NAME1)) {
                statement.executeUpdate(query1);
                Log.i("checking", "Table " + TABLE_NAME1 + " has been created");
            }
            if ( !isTableExists(connection, TABLE_NAME2)) {
                statement.executeUpdate(query2);
                Log.i("checking", "Table " + TABLE_NAME2 + " has been created");
            }
            if ( !isTableExists(connection, TABLE_NAME3)) {
                statement.executeUpdate(query3);
                Log.i("checking", "Table " + TABLE_NAME3 + "has been created");
            }
            if ( !isTableExists(connection, TABLE_NAME4)) {
                statement.executeUpdate(query4);
                Log.i("checking", "Table " + TABLE_NAME4 + " has been created");
            }
            if ( !isTableExists(connection, TABLE_NAME5)) {
                statement.executeUpdate(query5);
                Log.i("checking", "Table " + TABLE_NAME5 + " has been created");
            }
            if ( !isTableExists(connection, TABLE_NAME6)) {
                statement.executeUpdate(query6);
                Log.i("checking", "Table " + TABLE_NAME6 + " has been created");
            }
            if ( !isTableExists(connection, TABLE_NAME7)) {
                statement.executeUpdate(query7);
                Log.i("checking", "Table " + TABLE_NAME7 + " has been created");
            }
            if ( !isTableExists(connection, TABLE_NAME8)) {
                statement.executeUpdate(query8);
                Log.i("checking", "Table " + TABLE_NAME8 + " has been created");
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            Log.i("checking", "exception procedura_Maszyna_Pracownik_Skarga_formularz5()" + e.toString());
        }

    }

    static boolean isTableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }
}
