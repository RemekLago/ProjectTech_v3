package v3.projecttech_v3.db.entity;

public class Data_Operator_formularz5 {

    // Constants for Database
    public static final String TABLE_NAME = "OPERATOR";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAZWA = "Nazwa";
    public static final String COLUMN_TELEFON = "Telefon";

    //Variables
    private int id;
    private String nazwa;
    private String telefon;


    // Constructor

    public Data_Operator_formularz5(int id, String nazwa, String telefon) {
        this.id = id;
        this.nazwa = nazwa;
        this.telefon = telefon;
    }

    public Data_Operator_formularz5(String nazwa, String telefon) {
        this.nazwa = nazwa;
        this.telefon = telefon;
    }

    public Data_Operator_formularz5() {
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    // SQL QUERY: Creating the Table

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAZWA + " VARCHAR, " +
                    COLUMN_TELEFON + " VARCHAR" +
                    ")";

}
