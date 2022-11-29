package v3.projecttech_v3.db.entity;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.Date;

public class Data5 {
    // for creating new User


    public static final String TABLE_NAME = "DATABASE_5";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_IMIE = "Imie";
    public static final String COLUMN_NAZWISKO = "Nazwisko";
    public static final String COLUMN_LOKALIZACJAID = "LokalizacjaID";
    public static final String COLUMN_MAIL = "Mail";
    public static final String COLUMN_TELEFON = "Telefon";
    public static final String COLUMN_DZIALID = "DzialID";
    public static final String COLUMN_STANOWISKOID = "StanowiskoID";
    public static final String COLUMN_ADDDATE = "AddDate";
    public static final String COLUMN_STATUSID = "StatusID";


    private int id;
    private String imie;
    private String nazwisko;
    private int lokalizacjaID;
    private String mail;
    private int telefon;
    private int dzialID;
    private int stanowiskoID;
    private DateTime addDate;
    private int statusID;

    public Data5(int id, String imie, String nazwisko, int lokalizacjaID, String mail, int telefon,
                 int dzialID, int stanowiskoID, DateTime addDate, int statusID) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.lokalizacjaID = lokalizacjaID;
        this.mail = mail;
        this.telefon = telefon;
        this.dzialID = dzialID;
        this.stanowiskoID = stanowiskoID;
        this.addDate = addDate;
        this.statusID = statusID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getLokalizacjaID() {
        return lokalizacjaID;
    }

    public void setLokalizacjaID(int lokalizacjaID) {
        this.lokalizacjaID = lokalizacjaID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getDzialID() {
        return dzialID;
    }

    public void setDzialID(int dzialID) {
        this.dzialID = dzialID;
    }

    public int getStanowiskoID() {
        return stanowiskoID;
    }

    public void setStanowiskoID(int stanowiskoID) {
        this.stanowiskoID = stanowiskoID;
    }

    public DateTime getAddDate() {
        return addDate;
    }

    public void setAddDate(DateTime addDate) {
        this.addDate = addDate;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    COLUMN_IMIE + " TEXT NOT NULL, " +
                    COLUMN_NAZWISKO + " TEXT NOT NULL, " +
                    COLUMN_LOKALIZACJAID + " INTEGER, " +
                    COLUMN_MAIL + " TEXT NOT NULL, " +
                    COLUMN_TELEFON + " INTEGER NOT NULL, " +
                    COLUMN_DZIALID + " INTEGER NOT NULL, " +
                    COLUMN_STANOWISKOID + " INTEGER NOT NULL, " +
                    COLUMN_ADDDATE + " DATETIME NOT NULL, " +
                    COLUMN_STATUSID + " INTEGER NOT NULL" +
                    ")";


}
