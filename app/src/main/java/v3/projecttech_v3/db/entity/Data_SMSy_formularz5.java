package v3.projecttech_v3.db.entity;

import net.sourceforge.jtds.jdbc.DateTime;

public class Data_SMSy_formularz5 {

    // Constants for Database
    public static final String TABLE_NAME = "SMSY";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NUMER = "Numer";
    public static final String COLUMN_TRESC = "Tresc";
    public static final String COLUMN_CZYWYSLANO = "CzyWyslano";
    public static final String COLUMN_ADDDATE = "AddDate";

    //Variables
    private int id;
    private int numer;
    private String tresc;
    private String czyWyslano;
    private String addDate;

    // Constructor

    public Data_SMSy_formularz5(int id, int numer, String tresc, String czyWyslano, String addDate) {
        this.id = id;
        this.numer = numer;
        this.tresc = tresc;
        this.czyWyslano = czyWyslano;
        this.addDate = addDate;
    }

    public Data_SMSy_formularz5(int numer, String tresc, String czyWyslano, String addDate) {
        this.numer = numer;
        this.tresc = tresc;
        this.czyWyslano = czyWyslano;
        this.addDate = addDate;
    }

    public Data_SMSy_formularz5() {
    }


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String getCzyWyslano() {
        return czyWyslano;
    }

    public void setCzyWyslano(String czyWyslano) {
        this.czyWyslano = czyWyslano;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }


    // SQL QUERY: Creating the Table
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NUMER + " INTEGER, " +
                    COLUMN_TRESC + " VARCHAR, " +
                    COLUMN_CZYWYSLANO + " BIT, " +
                    COLUMN_ADDDATE + " DATETIME" +
                    ")";

}
