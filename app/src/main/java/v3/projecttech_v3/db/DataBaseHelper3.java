package v3.projecttech_v3.db;

import static v3.projecttech_v3.db.entity.Data3.CREATE_TABLE;
import static v3.projecttech_v3.db.entity.Data3.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import v3.projecttech_v3.db.entity.Data3;

// for Procedura_PozycjaPartia_HistoriaZycia

public class DataBaseHelper3 extends SQLiteOpenHelper {


    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data_db3";
    public static String SORTEDBY_1 = " ASC";
    public static String SORTEDBY_2 = " ASC";
    public static String SORTEDBY_3 = " ASC";
    public static String SORTEDBY_4 = " ASC";
    public static String SORTEDBY_5 = " ASC";
    public static String SORTEDBY_6 = " ASC";
    public static String SORTEDBY_7 = " ASC";
    public static String SORTEDBY_8 = " ASC";


    public DataBaseHelper3(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DataBaseHelper3(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Data3.CREATE_TABLE);
        Log.i("checking", CREATE_TABLE);
        DATABASE_VERSION++;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    // Insert Data into Database

    public boolean insertData(Data3 data3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Data3.COLUMN_ID, data3.getId());
        values.put(Data3.COLUMN_RAWCOLOR, data3.getRawColor());
        values.put(Data3.COLUMN_LOCK, data3.getLock());
        values.put(Data3.COLUMN_LP, data3.getLp());
        values.put(Data3.COLUMN_TYPKONFEKCJI, data3.getTypkonfekcji());
        values.put(Data3.COLUMN_KONFEKCJA, data3.getKonfekcja());
        values.put(Data3.COLUMN_ILOSC, data3.getIlosc());
        values.put(Data3.COLUMN_OPERATOR, data3.getOperator());
        values.put(Data3.COLUMN_ADDDATE, data3.getAdddate());

        long insert = db.insert(TABLE_NAME, null, values);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Getting Data from Database
    public Data3 getDataId (long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data3.COLUMN_ID,
                        Data3.COLUMN_RAWCOLOR,
                        Data3.COLUMN_LOCK,
                        Data3.COLUMN_LP,
                        Data3.COLUMN_TYPKONFEKCJI,
                        Data3.COLUMN_KONFEKCJA,
                        Data3.COLUMN_ILOSC,
                        Data3.COLUMN_OPERATOR,
                        Data3.COLUMN_ADDDATE },
                Data3.COLUMN_ID + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data3 dataGetId = new Data3(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data3.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_RAWCOLOR)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_LOCK)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_LP)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_TYPKONFEKCJI)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_KONFEKCJA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_ILOSC)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_OPERATOR)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_ADDDATE)));

        cursor.close();
        return dataGetId;
    }

    // Getting all Data
    public ArrayList<Data3> getAllData() {
        ArrayList<Data3> dataGetAll = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                Data3.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Data3 data3 = new Data3();
                data3.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data3.COLUMN_ID)));
                data3.setRawColor(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_RAWCOLOR)));
                data3.setLock(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_LOCK)));
                data3.setLp(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_LP)));
                data3.setTypkonfekcji(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_TYPKONFEKCJI)));
                data3.setKonfekcja(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_KONFEKCJA)));
                data3.setIlosc(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_ILOSC)));
                data3.setOperator(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_OPERATOR)));
                data3.setAdddate(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_ADDDATE)));

                dataGetAll.add(data3);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAll;
    }

    public int updateData(Data3 data3) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Data3.COLUMN_RAWCOLOR, data3.getRawColor());
        values.put(Data3.COLUMN_LOCK, data3.getLock());
        values.put(Data3.COLUMN_LP, data3.getLp());
        values.put(Data3.COLUMN_TYPKONFEKCJI, data3.getTypkonfekcji());
        values.put(Data3.COLUMN_KONFEKCJA, data3.getKonfekcja());
        values.put(Data3.COLUMN_ILOSC, data3.getIlosc());
        values.put(Data3.COLUMN_OPERATOR, data3.getOperator());
        values.put(Data3.COLUMN_ADDDATE, data3.getAdddate());


        return db.update(TABLE_NAME, values, Data3.COLUMN_ID + " = ? ",
                new String[]{String.valueOf(data3.getId())}
        );
    }

    public void deleteDataId (Data3 data3){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, Data3.COLUMN_ID + " = ?",
                new String[]{String.valueOf(data3.getId())}
        );
        db.close();

    }

    public void deleteAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DELETE FROM " + Data3.TABLE_NAME );
//        db.delete(Data.TABLE_NAME, null, null);
    }

    // Getting all Data and Ordered By Clicked Column by User


    public ArrayList<Data3> getAllDataOrdered(String columnName) {
        ArrayList<Data3> dataGetAllOrdered = new ArrayList<>();
        if (SORTEDBY_3.equals(" DESC")) {
            SORTEDBY_3 = " ASC";
        } else {
            SORTEDBY_3 = " DESC";
        }

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                columnName + " " + SORTEDBY_3;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int idNumber = 0;
        if (cursor.moveToFirst()){
            do {
                idNumber++;
                Data3 data3 = new Data3();
//                data.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data.COLUMN_ID)));
                data3.setId(idNumber);
                data3.setRawColor(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_RAWCOLOR)));
                data3.setLock(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_LOCK)));
                data3.setLp(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_LP)));
                data3.setTypkonfekcji(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_TYPKONFEKCJI)));
                data3.setKonfekcja(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_KONFEKCJA)));
                data3.setIlosc(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_ILOSC)));
                data3.setOperator(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_OPERATOR)));
                data3.setAdddate(cursor.getString(cursor.getColumnIndexOrThrow(Data3.COLUMN_ADDDATE)));


                dataGetAllOrdered.add(data3);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAllOrdered;
    }
}
