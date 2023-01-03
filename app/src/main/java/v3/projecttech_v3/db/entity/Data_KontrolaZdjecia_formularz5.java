package v3.projecttech_v3.db.entity;

import net.sourceforge.jtds.jdbc.DateTime;

public class Data_KontrolaZdjecia_formularz5 {

    // Constants for Database
    public static final String TABLE_NAME = "KONTROLAZDJECIA";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_KONTROLAID = "KontrolaId";
    public static final String COLUMN_BASE64 = "Base64";
    public static final String COLUMN_ADDDATE = "AddDate";

    //Variables
    private int id;
    private int kontrolaId;
    private String base64;
    private DateTime addDate;


    // Constructor

    public Data_KontrolaZdjecia_formularz5(int id, int kontrolaId, String base64, DateTime addDate) {
        this.id = id;
        this.kontrolaId = kontrolaId;
        this.base64 = base64;
        this.addDate = addDate;
    }

    public Data_KontrolaZdjecia_formularz5(int kontrolaId, String base64, DateTime addDate) {
        this.kontrolaId = kontrolaId;
        this.base64 = base64;
        this.addDate = addDate;
    }
    public Data_KontrolaZdjecia_formularz5() {

    }

    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKontrolaId() {
        return kontrolaId;
    }

    public void setKontrolaId(int kontrolaId) {
        this.kontrolaId = kontrolaId;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public DateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(DateTime addDate) {
        this.addDate = addDate;
    }


    // SQL QUERY: Creating the Table
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_KONTROLAID + " INTEGER, " +
                    COLUMN_BASE64 + " VARCHAR, " +
                    COLUMN_ADDDATE + " DATETIME, " +
                    "FOREIGN KEY " + "(" + COLUMN_KONTROLAID + ") " +
                    "REFERENCES " + "KONTROLA" + "(" + COLUMN_KONTROLAID+ ")" +
                    ")";
}
