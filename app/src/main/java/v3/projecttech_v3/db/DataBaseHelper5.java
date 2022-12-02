package v3.projecttech_v3.db;

import static v3.projecttech_v3.db.entity.Data5.CREATE_TABLE;
import static v3.projecttech_v3.db.entity.Data5.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import v3.projecttech_v3.db.entity.Data5;
import v3.projecttech_v3.db.entity.Data5;
import v3.projecttech_v3.db.entity.Data5;
import v3.projecttech_v3.db.entity.Data5;
import v3.projecttech_v3.db.entity.Data5;

public class DataBaseHelper5 extends SQLiteOpenHelper {

    // for creating new User

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data_db5";
    public static String SORTEDBY_5 = " ASC";

    public DataBaseHelper5(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DataBaseHelper5(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Data5.CREATE_TABLE);
        Log.i("checking", CREATE_TABLE);
        DATABASE_VERSION++;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(Data5 data5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

//        values.put(Data5.COLUMN_ID, data5.getId());
        values.put(Data5.COLUMN_IMIE, data5.getImie());
        values.put(Data5.COLUMN_NAZWISKO, data5.getNazwisko());
        values.put(Data5.COLUMN_MAIL, data5.getMail());
        values.put(Data5.COLUMN_TELEFON, data5.getTelefon());
        values.put(Data5.COLUMN_LOKALIZACJAID, data5.getLokalizacjaID());
        values.put(Data5.COLUMN_DZIALID, data5.getDzialID());
        values.put(Data5.COLUMN_STANOWISKOID, data5.getStanowiskoID());
        values.put(Data5.COLUMN_ADDDATE, data5.getAddDate());
        values.put(Data5.COLUMN_STATUSID, data5.getStatusID());
        values.put(Data5.COLUMN_PASSWORD, data5.getPassword());


        long insert = db.insert(TABLE_NAME, null, values);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Data5 getDataId (long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data5.COLUMN_ID,
                        Data5.COLUMN_IMIE,
                        Data5.COLUMN_NAZWISKO,
                        Data5.COLUMN_MAIL,
                        Data5.COLUMN_TELEFON,
                        Data5.COLUMN_LOKALIZACJAID,
                        Data5.COLUMN_DZIALID,
                        Data5.COLUMN_STANOWISKOID,
                        Data5.COLUMN_ADDDATE,
                        Data5.COLUMN_STATUSID,
                        Data5.COLUMN_PASSWORD
                },
                Data5.COLUMN_ID + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data5 dataGetId = new Data5(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data5.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_IMIE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_NAZWISKO)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_MAIL)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_TELEFON)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_LOKALIZACJAID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_DZIALID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STANOWISKOID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_ADDDATE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STATUSID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_PASSWORD))
        );

        cursor.close();
        return dataGetId;
    }

    public ArrayList<Data5> getAllData() {
        ArrayList<Data5> dataGetAll = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                Data5.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Data5 data5 = new Data5();
                data5.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data5.COLUMN_ID)));
                data5.setImie(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_IMIE)));
                data5.setNazwisko(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_NAZWISKO)));
                data5.setMail(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_MAIL)));
                data5.setTelefon(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_TELEFON)));
                data5.setLokalizacjaID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_LOKALIZACJAID)));
                data5.setDzialID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_DZIALID)));
                data5.setStanowiskoID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STANOWISKOID)));
                data5.setAddDate(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_ADDDATE)));
                data5.setStatusID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STATUSID)));
                data5.setStatusID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_PASSWORD)));
          
                dataGetAll.add(data5);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAll;
    }


    public int updateData(Data5 data5) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Data5.COLUMN_IMIE, data5.getImie());
        values.put(Data5.COLUMN_NAZWISKO, data5.getNazwisko());
        values.put(Data5.COLUMN_MAIL, data5.getMail());
        values.put(Data5.COLUMN_TELEFON, data5.getTelefon());
        values.put(Data5.COLUMN_LOKALIZACJAID, data5.getLokalizacjaID());
        values.put(Data5.COLUMN_DZIALID, data5.getDzialID());
        values.put(Data5.COLUMN_STANOWISKOID, data5.getStanowiskoID());
        values.put(Data5.COLUMN_ADDDATE, data5.getAddDate());
        values.put(Data5.COLUMN_STATUSID, data5.getStatusID());
        values.put(Data5.COLUMN_PASSWORD, data5.getPassword());

        return db.update(Data5.TABLE_NAME, values, Data5.COLUMN_ID + " = ? ",
                new String[]{String.valueOf(data5.getId())}
        );
    }

    public int updateDataByMail(Data5 data5) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Data5.COLUMN_IMIE, data5.getImie());
        values.put(Data5.COLUMN_NAZWISKO, data5.getNazwisko());
        values.put(Data5.COLUMN_MAIL, data5.getMail());
        values.put(Data5.COLUMN_TELEFON, data5.getTelefon());
        values.put(Data5.COLUMN_LOKALIZACJAID, data5.getLokalizacjaID());
        values.put(Data5.COLUMN_DZIALID, data5.getDzialID());
        values.put(Data5.COLUMN_STANOWISKOID, data5.getStanowiskoID());
        values.put(Data5.COLUMN_ADDDATE, data5.getAddDate());
        values.put(Data5.COLUMN_STATUSID, data5.getStatusID());
        values.put(Data5.COLUMN_PASSWORD, data5.getPassword());

        return db.update(Data5.TABLE_NAME, values, Data5.COLUMN_MAIL + " = ? ",
                new String[]{String.valueOf(data5.getId())}
        );
    }

    public void deleteDataId (Data5 data5){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Data5.TABLE_NAME, Data5.COLUMN_ID + " = ?",
                new String[]{String.valueOf(data5.getId())}
        );
        db.close();

    }

    public void deleteAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DELETE FROM " + Data5.TABLE_NAME );
//        db.delete(Data.TABLE_NAME, null, null);
    }

    public ArrayList<Data5> getAllDataOrdered(String columnName) {
        ArrayList<Data5> dataGetAllOrdered = new ArrayList<>();
        if (SORTEDBY_5.equals(" DESC")) {
            SORTEDBY_5 = " ASC";
        } else {
            SORTEDBY_5 = " DESC";
        }

        String selectQuery = "SELECT * FROM " + Data5.TABLE_NAME + " ORDER BY " +
                columnName + " " + SORTEDBY_5;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int idNumber = 0;
        if (cursor.moveToFirst()){
            do {
                idNumber++;
                Data5 data5 = new Data5();
//                data.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data.COLUMN_ID)));
                data5.setId(idNumber);
                data5.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data5.COLUMN_IMIE)));
                data5.setNazwisko(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_NAZWISKO)));
                data5.setMail(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_MAIL)));
                data5.setTelefon(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_TELEFON)));
                data5.setLokalizacjaID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_LOKALIZACJAID)));
                data5.setDzialID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_DZIALID)));
                data5.setStanowiskoID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STANOWISKOID)));
                data5.setAddDate(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_ADDDATE)));
                data5.setStatusID(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STATUSID)));
                data5.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_PASSWORD)));

                dataGetAllOrdered.add(data5);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAllOrdered;
    }

    public Data5 getDataMail (String mail) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data5.COLUMN_ID,
                        Data5.COLUMN_IMIE,
                        Data5.COLUMN_NAZWISKO,
                        Data5.COLUMN_MAIL,
                        Data5.COLUMN_TELEFON,
                        Data5.COLUMN_LOKALIZACJAID,
                        Data5.COLUMN_DZIALID,
                        Data5.COLUMN_STANOWISKOID,
                        Data5.COLUMN_ADDDATE,
                        Data5.COLUMN_STATUSID,
                        Data5.COLUMN_PASSWORD
                },
                Data5.COLUMN_MAIL + "=?",
                new String[]{
                        String.valueOf(mail)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();



        Data5 dataGetMail = new Data5(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data5.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_IMIE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_NAZWISKO)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_MAIL)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_TELEFON)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_LOKALIZACJAID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_DZIALID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STANOWISKOID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_ADDDATE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STATUSID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_PASSWORD))
        );

        cursor.close();
        return dataGetMail;
    }

    public Data5 getDataPassword (String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data5.COLUMN_ID,
                        Data5.COLUMN_IMIE,
                        Data5.COLUMN_NAZWISKO,
                        Data5.COLUMN_MAIL,
                        Data5.COLUMN_TELEFON,
                        Data5.COLUMN_LOKALIZACJAID,
                        Data5.COLUMN_DZIALID,
                        Data5.COLUMN_STANOWISKOID,
                        Data5.COLUMN_ADDDATE,
                        Data5.COLUMN_STATUSID,
                        Data5.COLUMN_PASSWORD
                },
                Data5.COLUMN_PASSWORD + "=?",
                new String[]{
                        String.valueOf(password)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data5 dataGetPassword = new Data5(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data5.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_IMIE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_NAZWISKO)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_MAIL)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_TELEFON)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_LOKALIZACJAID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_DZIALID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STANOWISKOID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_ADDDATE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_STATUSID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data5.COLUMN_PASSWORD))
        );

        cursor.close();
        return dataGetPassword;
    }
    
}
