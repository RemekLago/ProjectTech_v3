package v3.projecttech_v3.Kafelki;

import static v3.projecttech_v3.Kafelki.Data_Home.COLUMN_PARENTID;
import static v3.projecttech_v3.Kafelki.Data_Home.CREATE_TABLE;
import static v3.projecttech_v3.Kafelki.Data_Home.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper_Home extends SQLiteOpenHelper {

    // for taking data with user settings, permitions for tiles menu

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data_db_home";
    public static String SORTEDBY_5 = " ASC";

    public DataBaseHelper_Home(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DataBaseHelper_Home(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
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

    public boolean insertData(Data_Home data_Home) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

//        values.put(Data_Home.COLUMN_ID, data_Home.getId());
        values.put(COLUMN_PARENTID, data_Home.getParentId());
        values.put(Data_Home.COLUMN_CHILDID, data_Home.getChildId());
        values.put(Data_Home.COLUMN_NAME, data_Home.getName());
        values.put(Data_Home.COLUMN_TYPE, data_Home.getType());
        values.put(Data_Home.COLUMN_BASE64, data_Home.getBase64());
        values.put(Data_Home.COLUMN_NAMEINTHEAPP, data_Home.getNameInTheApp());



        long insert = db.insert(TABLE_NAME, null, values);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Data_Home getDataId (long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data_Home.COLUMN_ID,
                        COLUMN_PARENTID,
                        Data_Home.COLUMN_CHILDID,
                        Data_Home.COLUMN_NAME,
                        Data_Home.COLUMN_TYPE,
                        Data_Home.COLUMN_BASE64,
                        Data_Home.COLUMN_NAMEINTHEAPP
                },
                Data_Home.COLUMN_ID + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data_Home dataGetId = new Data_Home(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PARENTID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_CHILDID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_TYPE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_BASE64)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAMEINTHEAPP))
        );

        cursor.close();
        return dataGetId;
    }

    public ArrayList<Data_Home> getAllData() {
        ArrayList<Data_Home> dataGetAll = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " +
                Data_Home.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Data_Home data_Home = new Data_Home();
                data_Home.setId(cursor.getInt(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_ID)));
                data_Home.setParentId(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PARENTID)));
                data_Home.setChildId(cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_CHILDID)));
                data_Home.setName(cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAME)));
                data_Home.setType(cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_TYPE)));
                data_Home.setBase64(cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_BASE64)));
                data_Home.setNameInTheApp(cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAMEINTHEAPP)));

                dataGetAll.add(data_Home);
            } while(cursor.moveToNext());

        }
        db.close();
        return dataGetAll;
    }


    public int updateData(Data_Home data_Home) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Data_Home.COLUMN_PARENTID, data_Home.getParentId());
        values.put(Data_Home.COLUMN_CHILDID, data_Home.getChildId());
        values.put(Data_Home.COLUMN_NAME, data_Home.getName());
        values.put(Data_Home.COLUMN_TYPE, data_Home.getType());
        values.put(Data_Home.COLUMN_BASE64, data_Home.getBase64());
        values.put(Data_Home.COLUMN_NAMEINTHEAPP, data_Home.getNameInTheApp());

        return db.update(TABLE_NAME, values, Data_Home.COLUMN_ID + " = ? ",
                new String[]{String.valueOf(data_Home.getId())}
        );
    }


    public void deleteDataId (Data_Home data_Home){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, Data_Home.COLUMN_ID + " = ?",
                new String[]{String.valueOf(data_Home.getId())}
        );
        db.close();

    }

    public void deleteAllData (){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DELETE FROM " + TABLE_NAME );
//        db.delete(Data.TABLE_NAME, null, null);
    }


    public Data_Home getDataParentId (String mail) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data_Home.COLUMN_ID,
                        Data_Home.COLUMN_PARENTID,
                        Data_Home.COLUMN_CHILDID,
                        Data_Home.COLUMN_NAME,
                        Data_Home.COLUMN_TYPE,
                        Data_Home.COLUMN_BASE64,
                        Data_Home.COLUMN_NAMEINTHEAPP
                },
                Data_Home.COLUMN_PARENTID + "=?",
                new String[]{
                        String.valueOf(mail)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();



        Data_Home dataGetParentId = new Data_Home(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_PARENTID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_CHILDID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_TYPE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_BASE64)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAMEINTHEAPP))
        );

        cursor.close();
        return dataGetParentId;
    }

    public Data_Home getChildId (String mail) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        Data_Home.COLUMN_ID,
                        Data_Home.COLUMN_PARENTID,
                        Data_Home.COLUMN_CHILDID,
                        Data_Home.COLUMN_NAME,
                        Data_Home.COLUMN_TYPE,
                        Data_Home.COLUMN_BASE64,
                        Data_Home.COLUMN_NAMEINTHEAPP
                },
                Data_Home.COLUMN_CHILDID + "=?",
                new String[]{
                        String.valueOf(mail)
                },
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Data_Home dataGetChildId = new Data_Home(
                cursor.getInt(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_PARENTID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_CHILDID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_TYPE)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_BASE64)),
                cursor.getString(cursor.getColumnIndexOrThrow(Data_Home.COLUMN_NAMEINTHEAPP))
        );

        cursor.close();
        return dataGetChildId;
    }

}
