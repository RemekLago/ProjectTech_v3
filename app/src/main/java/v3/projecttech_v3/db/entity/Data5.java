package v3.projecttech_v3.db.entity;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.Date;
import java.time.LocalDateTime;

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
    public static final String COLUMN_PASSWORD = "Password";



    private int id;
    private String imie;
    private String nazwisko;
    private String mail;
    private String telefon;
    private String lokalizacjaID;
    private String dzialID;
    private String stanowiskoID;
    private String addDate;
    private String statusID;
    private String password;
    private String passwordConfirm;

    public Data5() {

    }

    public Data5(int id, String imie, String nazwisko, String mail, String telefon,
                 String lokalizacjaID, String dzialID, String stanowiskoID,
                 String addDate, String statusID, String password) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.telefon = telefon;
        this.lokalizacjaID = lokalizacjaID;
        this.dzialID = dzialID;
        this.stanowiskoID = stanowiskoID;
        this.addDate = addDate;
        this.statusID = statusID;
        this.password = password;
    }

    public Data5(String imie, String nazwisko, String mail, String telefon,
                 String lokalizacjaID, String dzialID, String stanowiskoID,
                 String addDate, String statusID, String password) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.telefon = telefon;
        this.lokalizacjaID = lokalizacjaID;
        this.dzialID = dzialID;
        this.stanowiskoID = stanowiskoID;
        this.addDate = addDate;
        this.statusID = statusID;
        this.password = password;
    }

    public Data5(String imie, String nazwisko, String mail, String telefon,
                 String lokalizacjaID, String dzialID, String stanowiskoID,
                 String addDate, String statusID, String password, String passwordConfirm) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.telefon = telefon;
        this.lokalizacjaID = lokalizacjaID;
        this.dzialID = dzialID;
        this.stanowiskoID = stanowiskoID;
        this.addDate = addDate;
        this.statusID = statusID;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getLokalizacjaID() {
        return lokalizacjaID;
    }

    public void setLokalizacjaID(String lokalizacjaID) {
        this.lokalizacjaID = lokalizacjaID;
    }

    public String getDzialID() {
        return dzialID;
    }

    public void setDzialID(String dzialID) {
        this.dzialID = dzialID;
    }

    public String getStanowiskoID() {
        return stanowiskoID;
    }

    public void setStanowiskoID(String stanowiskoID) {
        this.stanowiskoID = stanowiskoID;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String password) {
        this.passwordConfirm = passwordConfirm;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_IMIE + " TEXT, " +
                    COLUMN_NAZWISKO + " TEXT, " +
                    COLUMN_MAIL + " TEXT, " +
                    COLUMN_TELEFON + " INTEGER, " +
                    COLUMN_LOKALIZACJAID + " INTEGER, " +
                    COLUMN_DZIALID + " INTEGER, " +
                    COLUMN_STANOWISKOID + " INTEGER, " +
                    COLUMN_ADDDATE + " DATETIME, " +
                    COLUMN_STATUSID + " INTEGER, " +
                    COLUMN_PASSWORD + " TEXT" +
                    ")";


}
