package v3.projecttech_v3.db.entity;

public class Data3 {

    // Constants for Database
    public static final String TABLE_NAME = "DATABASE_3";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_RAWCOLOR = "Rawcolor";
    public static final String COLUMN_LOCK = "Lock";
    public static final String COLUMN_LP = "LP";
    public static final String COLUMN_TYPKONFEKCJI = "TypKonfekcji";
    public static final String COLUMN_KONFEKCJA = "Konfekcja";
    public static final String COLUMN_ILOSC = "Ilosc";
    public static final String COLUMN_OPERATOR = "Operator";
    public static final String COLUMN_ADDDATE = "AddDate";


    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY";
    public static final String RAWCOLOR_OPTIONS = "TEXT";
    public static final String LOCK_OPTIONS = "TEXT";
    public static final String LP_OPTIONS = "TEXT";
    public static final String TYPKONFEKCJI_OPTIONS = "TEXT";
    public static final String KONFEKCJA_OPTIONS = "TEXT";
    public static final String ILOSC_OPTIONS = "TEXT";
    public static final String OPERATOR_OPTIONS = "TEXT";
    public static final String ADDDATE_OPTIONS = "TEXT";



    // Variables
    private int id;
    private String rawColor;
    private String lock;
    private String lp;
    private String typkonfekcji;
    private String konfekcja;
    private String ilosc;
    private String operator;
    private String adddate;


    // Constructor

    public Data3(int id, String rawColor, String lock, String lp, String typkonfekcji, String konfekcja, String ilosc, String operator, String adddate) {
        this.id = id;
        this.rawColor = rawColor;
        this.lock = lock;
        this.lp = lp;
        this.typkonfekcji = typkonfekcji;
        this.konfekcja = konfekcja;
        this.ilosc = ilosc;
        this.operator = operator;
        this.adddate = adddate;
    }

    public Data3() {

    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRawColor() {
        return rawColor;
    }

    public void setRawColor(String rawColor) {
        this.rawColor = rawColor;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getLp() {
        return lp;
    }

    public void setLp(String lp) {
        this.lp = lp;
    }

    public String getTypkonfekcji() {
        return typkonfekcji;
    }

    public void setTypkonfekcji(String typkonfekcji) {
        this.typkonfekcji = typkonfekcji;
    }

    public String getKonfekcja() {
        return konfekcja;
    }

    public void setKonfekcja(String konfekcja) {
        this.konfekcja = konfekcja;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }


    // SQL QUERY: Creating the Table

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_RAWCOLOR + " TEXT, " +
                    COLUMN_LOCK + " TEXT, " +
                    COLUMN_LP + " INTEGER, " +
                    COLUMN_TYPKONFEKCJI + " TEXT, " +
                    COLUMN_KONFEKCJA + " TEXT, " +
                    COLUMN_ILOSC + " TEXT, " +
                    COLUMN_OPERATOR + " TEXT, " +
                    COLUMN_ADDDATE + " TEXT, " +
                    ")";

}
