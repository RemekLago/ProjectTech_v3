package v3.projecttech_v3.db;

import static v3.projecttech_v3.db.entity.Data_Maszyny_formularz5.CREATE_TABLE;
import static v3.projecttech_v3.db.entity.Data_Maszyny_formularz5.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import v3.projecttech_v3.db.entity.Data_Maszyny_formularz5;


public class DataBaseHelper_Maszyny_formularz5 extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data_db";


    public DataBaseHelper_Maszyny_formularz5(Context context) {
        super(context, null, null, DATABASE_VERSION);

    }

    public DataBaseHelper_Maszyny_formularz5(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.i("checking", CREATE_TABLE);
        DATABASE_VERSION++;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    // Insert Data into Database

    public boolean insertData(Data_Maszyny_formularz5 data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Data_Maszyny_formularz5.COLUMN_ID, data.getId());
        values.put(Data_Maszyny_formularz5.COLUMN_KOD, data.getKod());
        values.put(Data_Maszyny_formularz5.COLUMN_NAZWA, data.getNazwa());


        long insert = db.insert(TABLE_NAME, null, values);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Getting Data from Database
    public Data_Maszyny_formularz5 getDataId(long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data_Maszyny_formularz5.COLUMN_ID,
                        Data_Maszyny_formularz5.COLUMN_KOD,
                        Data_Maszyny_formularz5.COLUMN_NAZWA
                },
                Data_Maszyny_formularz5.COLUMN_ID + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data_Maszyny_formularz5 dataGetId = new Data_Maszyny_formularz5(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data_Maszyny_formularz5.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Maszyny_formularz5.COLUMN_KOD)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Maszyny_formularz5.COLUMN_NAZWA))
        );

        cursor.close();
        return dataGetId;
    }

    // Getting all Data
    public ArrayList<Data_Maszyny_formularz5> getAllData() {
        ArrayList<Data_Maszyny_formularz5> dataGetAll = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                Data_Maszyny_formularz5.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Data_Maszyny_formularz5 data = new Data_Maszyny_formularz5();
                data.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data_Maszyny_formularz5.COLUMN_ID)));
                data.setKod(cursor.getString(cursor.getColumnIndexOrThrow(Data_Maszyny_formularz5.COLUMN_KOD)));
                data.setNazwa(cursor.getString(cursor.getColumnIndexOrThrow(Data_Maszyny_formularz5.COLUMN_NAZWA)));

                dataGetAll.add(data);
            } while (cursor.moveToNext());

        }
        db.close();
        return dataGetAll;
    }

    public int updateData(Data_Maszyny_formularz5 data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Data_Maszyny_formularz5.COLUMN_KOD, data.getKod());
        values.put(Data_Maszyny_formularz5.COLUMN_NAZWA, data.getNazwa());

        return db.update(TABLE_NAME, values, Data_Maszyny_formularz5.COLUMN_ID + " = ? ",
                new String[]{String.valueOf(data.getId())}
        );
    }

    public void deleteDataId(Data_Maszyny_formularz5 data) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, Data_Maszyny_formularz5.COLUMN_ID + " = ?",
                new String[]{String.valueOf(data.getId())}
        );
        db.close();

    }

    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + Data_Maszyny_formularz5.TABLE_NAME);
    }
}