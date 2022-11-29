package v3.projecttech_v3.db;

import static v3.projecttech_v3.db.entity.Data4.CREATE_TABLE;
import static v3.projecttech_v3.db.entity.Data4.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import v3.projecttech_v3.db.entity.Data4;

public class DataBaseHelper4 extends SQLiteOpenHelper {

    // for Procedura_Magazyn_Lsv_Magazyn_Lokalizacja_Pozycja

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data_db4";
    public static String SORTEDBY_1 = " ASC";
    public static String SORTEDBY_2 = " ASC";
    public static String SORTEDBY_3 = " ASC";
    public static String SORTEDBY_4 = " ASC";
    public static String SORTEDBY_5 = " ASC";
    public static String SORTEDBY_6 = " ASC";
    public static String SORTEDBY_7 = " ASC";
    public static String SORTEDBY_8 = " ASC";
    public static String SORTEDBY_9 = " ASC";
    public static String SORTEDBY_10 = " ASC";
    public static String SORTEDBY_11 = " ASC";
    public static String SORTEDBY_12 = " ASC";
    public static String SORTEDBY_13 = " ASC";
    public static String SORTEDBY_14 = " ASC";
    public static String SORTEDBY_15 = " ASC";

    public DataBaseHelper4(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DataBaseHelper4(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Data4.CREATE_TABLE);
        Log.i("checking", CREATE_TABLE);
        DATABASE_VERSION++;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    // Insert Data into Database

    public boolean insertData(Data4 data4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Data4.COLUMN_ID, data4.getId());
        values.put(Data4.COLUMN_RAWCOLOR, data4.getRawColor());
        values.put(Data4.COLUMN_LOCK, data4.getLock());
        values.put(Data4.COLUMN_LP, data4.getLp());
        values.put(Data4.COLUMN_POZYCJA, data4.getPozycja());
        values.put(Data4.COLUMN_PARTIA, data4.getPartia());
        values.put(Data4.COLUMN_WARIANT, data4.getWariant());
        values.put(Data4.COLUMN_WARIANTOPIS, data4.getWariantOpis());
        values.put(Data4.COLUMN_PARTIAZLECENIE, data4.getPartiaZlecenie());
        values.put(Data4.COLUMN_KONFEKCJA, data4.getKonfekcja());
        values.put(Data4.COLUMN_ILWKONF, data4.getIlwkonf());
        values.put(Data4.COLUMN_IlSZ, data4.getIlszt());
        values.put(Data4.COLUMN_ILOSCKM, data4.getIloscKm());
        values.put(Data4.COLUMN_REZ, data4.getRez());
        values.put(Data4.COLUMN_SOURCE, data4.getSource());
        
        long insert = db.insert(TABLE_NAME, null, values);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Getting Data from Database
    public Data4 getDataId (long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data4.COLUMN_ID,
                        Data4.COLUMN_RAWCOLOR,
                        Data4.COLUMN_LOCK,
                        Data4.COLUMN_LP,
                        Data4.COLUMN_POZYCJA,
                        Data4.COLUMN_POZYCJANAZWA,
                        Data4.COLUMN_PARTIA,
                        Data4.COLUMN_WARIANT,
                        Data4.COLUMN_WARIANTOPIS,
                        Data4.COLUMN_PARTIAZLECENIE,
                        Data4.COLUMN_KONFEKCJA,
                        Data4.COLUMN_ILWKONF,
                        Data4.COLUMN_IlSZ,
                        Data4.COLUMN_ILOSCKM,
                        Data4.COLUMN_REZ,
                        Data4.COLUMN_SOURCE
                },
                Data4.COLUMN_ID + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data4 dataGetId = new Data4(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data4.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_RAWCOLOR)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_LOCK)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_LP)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_POZYCJA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_POZYCJANAZWA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_PARTIA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_WARIANT)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_WARIANTOPIS)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_PARTIAZLECENIE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_KONFEKCJA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_ILWKONF)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_IlSZ)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_ILOSCKM)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_REZ)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_SOURCE))
        );

        cursor.close();
        return dataGetId;
    }

    // Getting all Data
    public ArrayList<Data4> getAllData() {
        ArrayList<Data4> dataGetAll = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                Data4.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Data4 data4 = new Data4();
                data4.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data4.COLUMN_ID)));
                data4.setRawColor(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_RAWCOLOR)));
                data4.setLock(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_LOCK)));
                data4.setLp(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_LP)));
                data4.setPozycja(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_POZYCJA)));
                data4.setKonfekcja(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_KONFEKCJA)));
                data4.setPozycjanazwa(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_POZYCJANAZWA)));
                data4.setPartia(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_PARTIA)));
                data4.setWariant(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_WARIANT)));
                data4.setWariantOpis(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_WARIANTOPIS)));
                data4.setPartiaZlecenie(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_PARTIAZLECENIE)));
                data4.setKonfekcja(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_KONFEKCJA)));
                data4.setIlwkonf(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_ILWKONF)));
                data4.setIlszt(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_IlSZ)));
                data4.setIloscKm(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_ILOSCKM)));
                data4.setRez(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_REZ)));
                data4.setSource(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_SOURCE)));

                dataGetAll.add(data4);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAll;
    }

    public int updateData(Data4 data4) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Data4.COLUMN_RAWCOLOR, data4.getRawColor());
        values.put(Data4.COLUMN_LOCK, data4.getLock());
        values.put(Data4.COLUMN_LP, data4.getLp());
        values.put(Data4.COLUMN_POZYCJA, data4.getPozycja());
        values.put(Data4.COLUMN_POZYCJANAZWA, data4.getPozycjanazwa());
        values.put(Data4.COLUMN_PARTIA, data4.getPartia());
        values.put(Data4.COLUMN_WARIANT, data4.getWariant());
        values.put(Data4.COLUMN_WARIANTOPIS, data4.getWariantOpis());
        values.put(Data4.COLUMN_PARTIAZLECENIE, data4.getPartiaZlecenie());
        values.put(Data4.COLUMN_KONFEKCJA, data4.getKonfekcja());
        values.put(Data4.COLUMN_ILWKONF, data4.getIlwkonf());
        values.put(Data4.COLUMN_IlSZ, data4.getIlszt());
        values.put(Data4.COLUMN_ILOSCKM, data4.getIloscKm());
        values.put(Data4.COLUMN_REZ, data4.getRez());
        values.put(Data4.COLUMN_SOURCE, data4.getSource());


        return db.update(TABLE_NAME, values, Data4.COLUMN_ID + " = ? ",
                new String[]{String.valueOf(data4.getId())}
        );
    }

    public void deleteDataId (Data4 data4){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, Data4.COLUMN_ID + " = ?",
                new String[]{String.valueOf(data4.getId())}
        );
        db.close();

    }

    public void deleteAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DELETE FROM " + Data4.TABLE_NAME );
//        db.delete(Data.TABLE_NAME, null, null);
    }

    // Getting all Data and Ordered By Clicked Column by User


    public ArrayList<Data4> getAllDataOrdered(String columnName) {
        ArrayList<Data4> dataGetAllOrdered = new ArrayList<>();
        if (SORTEDBY_4.equals(" DESC")) {
            SORTEDBY_4 = " ASC";
        } else {
            SORTEDBY_4 = " DESC";
        }

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                columnName + " " + SORTEDBY_4;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int idNumber = 0;
        if (cursor.moveToFirst()){
            do {
                idNumber++;
                Data4 data4 = new Data4();
//                data.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data.COLUMN_ID)));
                data4.setId(idNumber);
                data4.setRawColor(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_RAWCOLOR)));
                data4.setLock(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_LOCK)));
                data4.setLp(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_LP)));
                data4.setPozycja(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_POZYCJA)));
                data4.setPozycjanazwa(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_POZYCJANAZWA)));
                data4.setPartia(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_PARTIA)));
                data4.setWariant(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_WARIANT)));
                data4.setWariantOpis(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_WARIANTOPIS)));
                data4.setPartiaZlecenie(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_PARTIAZLECENIE)));
                data4.setKonfekcja(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_KONFEKCJA)));
                data4.setIlwkonf(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_ILWKONF)));
                data4.setIlszt(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_IlSZ)));
                data4.setIloscKm(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_ILOSCKM)));
                data4.setRez(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_REZ)));
                data4.setSource(cursor.getString(cursor.getColumnIndexOrThrow(Data4.COLUMN_SOURCE)));



                dataGetAllOrdered.add(data4);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAllOrdered;
    }
}
