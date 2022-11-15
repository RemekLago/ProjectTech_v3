package v3.projecttech_v3.db;

import static v3.projecttech_v3.db.entity.Data.CREATE_TABLE;
import static v3.projecttech_v3.db.entity.Data.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import v3.projecttech_v3.db.entity.Data;

public class DataBaseHelper extends SQLiteOpenHelper {


    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data_db";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Data.CREATE_TABLE);
        Log.i("checking", CREATE_TABLE);
        DATABASE_VERSION++;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    // Insert Data into Database

    public boolean insertData(Data data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Data.COLUMN_ID, data.getId());
        values.put(Data.COLUMN_RAWCOLOR, data.getRawColor());
        values.put(Data.COLUMN_LOCK, data.getLock());
        values.put(Data.COLUMN_LP, data.getLp());
        values.put(Data.COLUMN_MAGAZYN, data.getMagazyn());
        values.put(Data.COLUMN_LOKALIZACJA, data.getLokalizacja());
        values.put(Data.COLUMN_PARTIA, data.getPartia());
        values.put(Data.COLUMN_PARTIAZLECENIE, data.getPartiaZlecenie());
        values.put(Data.COLUMN_WARIANT, data.getWariant());
        values.put(Data.COLUMN_WARIANTOPIS, data.getWariantOpis());
        values.put(Data.COLUMN_PARTIAZLECENIE, data.getPartiaZlecenie());
        values.put(Data.COLUMN_KONFEKCJA, data.getKonfekcja());
        values.put(Data.COLUMN_ILWKONF, data.getIlwkonf());
        values.put(Data.COLUMN_IlSZ, data.getIlszt());
        values.put(Data.COLUMN_ILOSCKM, data.getIloscKm());
        values.put(Data.COLUMN_REZ, data.getRez());
        values.put(Data.COLUMN_SOURCE, data.getSource());

        long insert = db.insert(TABLE_NAME, null, values);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
//    public boolean insertData(String rawColor, String lock, String lp, String magazyn, String lokalizacja,
//                           String partia, String wariant, String wariantOpis, String partiaZlecenie,
//                           String konfekcja, String ilwkonf,
//                           String ilszt, String iloscKm, String rez, String source) {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//
//        values.put(Data.COLUMN_RAWCOLOR, rawColor);
//        values.put(Data.COLUMN_LOCK, lock);
//        values.put(Data.COLUMN_LP, lp);
//        values.put(Data.COLUMN_MAGAZYN, magazyn);
//        values.put(Data.COLUMN_LOKALIZACJA, lokalizacja);
//        values.put(Data.COLUMN_PARTIA, partia);
//        values.put(Data.COLUMN_PARTIAZLECENIE, partiaZlecenie);
//        values.put(Data.COLUMN_WARIANT, wariant);
//        values.put(Data.COLUMN_WARIANTOPIS, wariantOpis);
//        values.put(Data.COLUMN_PARTIAZLECENIE, partiaZlecenie);
//        values.put(Data.COLUMN_KONFEKCJA, konfekcja);
//        values.put(Data.COLUMN_ILWKONF, ilwkonf);
//        values.put(Data.COLUMN_IlSZ, ilszt);
//        values.put(Data.COLUMN_ILOSCKM, iloscKm);
//        values.put(Data.COLUMN_REZ, rez);
//        values.put(Data.COLUMN_SOURCE, source);
//
//        long id = db.insert(Data.TABLE_NAME, null, values);
//        if (id == -1) {
//            return false;
//        } else {
//            return true;
//        }

//        db.close();


//        return id;
    }

    // Getting Data from Database
    public Data getDataId (long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data.COLUMN_ID,
                        Data.COLUMN_RAWCOLOR,
                        Data.COLUMN_LOCK,
                        Data.COLUMN_LP,
                        Data.COLUMN_MAGAZYN,
                        Data.COLUMN_LOKALIZACJA,
                        Data.COLUMN_PARTIA,
                        Data.COLUMN_WARIANT,
                        Data.COLUMN_WARIANTOPIS,
                        Data.COLUMN_PARTIAZLECENIE,
                        Data.COLUMN_KONFEKCJA,
                        Data.COLUMN_ILWKONF,
                        Data.COLUMN_IlSZ,
                        Data.COLUMN_ILOSCKM,
                        Data.COLUMN_REZ,
                        Data.COLUMN_SOURCE},
                Data.COLUMN_ID + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data dataGetId = new Data(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_RAWCOLOR)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LOCK)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LP)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_MAGAZYN)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LOKALIZACJA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_PARTIA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_WARIANT)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_WARIANTOPIS)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_PARTIAZLECENIE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_KONFEKCJA)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_ILWKONF)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_IlSZ)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_ILOSCKM)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_REZ)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_SOURCE)));

        cursor.close();
        return dataGetId;
    }

    // Getting all Data
    public ArrayList<Data> getAllData() {
        ArrayList<Data> dataGetAll = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                Data.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Data data = new Data();
                data.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data.COLUMN_ID)));
                data.setRawColor(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_RAWCOLOR)));
                data.setLock(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LOCK)));
                data.setLp(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LP)));
                data.setMagazyn(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_MAGAZYN)));
                data.setLokalizacja(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LOKALIZACJA)));
                data.setPartia(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_PARTIA)));
                data.setWariant(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_WARIANT)));
                data.setWariantOpis(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_WARIANTOPIS)));
                data.setPartiaZlecenie(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_PARTIAZLECENIE)));
                data.setKonfekcja(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_KONFEKCJA)));
                data.setIlwkonf(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_ILWKONF)));
                data.setIlszt(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_IlSZ)));
                data.setIloscKm(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_ILOSCKM)));
                data.setRez(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_REZ)));
                data.setSource(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_SOURCE)));

                dataGetAll.add(data);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAll;
    }

    public int updateData(Data data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Data.COLUMN_RAWCOLOR, data.getRawColor());
        values.put(Data.COLUMN_LOCK, data.getLock());
        values.put(Data.COLUMN_LP, data.getLp());
        values.put(Data.COLUMN_MAGAZYN, data.getMagazyn());
        values.put(Data.COLUMN_LOKALIZACJA, data.getLokalizacja());
        values.put(Data.COLUMN_PARTIA, data.getPartia());
        values.put(Data.COLUMN_PARTIAZLECENIE, data.getPartiaZlecenie());
        values.put(Data.COLUMN_WARIANT, data.getWariant());
        values.put(Data.COLUMN_WARIANTOPIS, data.getWariantOpis());
        values.put(Data.COLUMN_PARTIAZLECENIE, data.getPartiaZlecenie());
        values.put(Data.COLUMN_KONFEKCJA, data.getKonfekcja());
        values.put(Data.COLUMN_ILWKONF, data.getIlwkonf());
        values.put(Data.COLUMN_IlSZ, data.getIlszt());
        values.put(Data.COLUMN_ILOSCKM, data.getIloscKm());
        values.put(Data.COLUMN_REZ, data.getRez());
        values.put(Data.COLUMN_SOURCE, data.getSource());

        return db.update(TABLE_NAME, values, Data.COLUMN_ID + " = ? ",
                new String[]{String.valueOf(data.getId())}
                );
    }

    public void deleteDataId (Data data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, Data.COLUMN_ID + " = ?",
                new String[]{String.valueOf(data.getId())}
        );
        db.close();

    }

    public void deleteAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DELETE FROM " + Data.TABLE_NAME );
//        db.delete(Data.TABLE_NAME, null, null);
    }

    // Getting all Data and Ordered By Clicked Column by User
    public static String SORTEDBY_3 = " ASC";
    public Data getAllDataOrdered(String columnName) {
        ArrayList<Data> dataGetAllOrdered = new ArrayList<>();
        if (SORTEDBY_3.equals(" DESC")) {
            SORTEDBY_3 = " ASC";
        } else {
            SORTEDBY_3 = " DESC";
        }

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                columnName + SORTEDBY_3;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        Data data = new Data();
        if (cursor.moveToFirst()){
            do {
//                Data data = new Data();
                data.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data.COLUMN_ID)));
                data.setRawColor(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_RAWCOLOR)));
                data.setLock(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LOCK)));
                data.setLp(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LP)));
                data.setMagazyn(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_MAGAZYN)));
                data.setLokalizacja(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_LOKALIZACJA)));
                data.setPartia(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_PARTIA)));
                data.setWariant(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_WARIANT)));
                data.setWariantOpis(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_WARIANTOPIS)));
                data.setPartiaZlecenie(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_PARTIAZLECENIE)));
                data.setKonfekcja(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_KONFEKCJA)));
                data.setIlwkonf(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_ILWKONF)));
                data.setIlszt(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_IlSZ)));
                data.setIloscKm(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_ILOSCKM)));
                data.setRez(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_REZ)));
                data.setSource(cursor.getString(cursor.getColumnIndexOrThrow(Data.COLUMN_SOURCE)));

                dataGetAllOrdered.add(data);
            } while(cursor.moveToNext());

        }
        db.close();
        return data;
    }


}
