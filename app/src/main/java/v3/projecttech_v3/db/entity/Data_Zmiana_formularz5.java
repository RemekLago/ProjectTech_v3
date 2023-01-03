package v3.projecttech_v3.db.entity;

public class Data_Zmiana_formularz5 {

    // Constants for Database
    public static final String TABLE_NAME = "ZMIANA";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAZWA = "Nazwa";

    //Variables
    private int id;
    private String nazwa;

    // Constructor


    public Data_Zmiana_formularz5(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public Data_Zmiana_formularz5( String nazwa) {
        this.nazwa = nazwa;
    }

    public Data_Zmiana_formularz5() {
    }

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    // SQL QUERY: Creating the Table

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAZWA + " VARCHAR" +
                    ")";
}
