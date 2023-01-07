package v3.projecttech_v3.db.entity;

import net.sourceforge.jtds.jdbc.DateTime;

import java.util.Date;

public class Data_Grafik_formularz5 {

    // Constants for Database
    public static final String TABLE_NAME = "GRAFIK";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_DATAPRACY = "DataPracy";
    public static final String COLUMN_ZMIANAID = "ZmianaId";
    public static final String COLUMN_MASZYNAID = "MaszynaId";
    public static final String COLUMN_OPERATORID = "OperatorId";
    public static final String COLUMN_ADDDATE = "AddDate";

    //Variables
    private int id;
    private int kontrolaId;
    private String dataPracy;
    private int zmianaId;
    private int maszynaId;
    private int operatorId;
    private String addDate;

    // Constructor

    public Data_Grafik_formularz5(int id, int kontrolaId, String dataPracy, int zmianaId, int maszynaId, int operatorId, String addDate) {
        this.id = id;
        this.kontrolaId = kontrolaId;
        this.dataPracy = dataPracy;
        this.zmianaId = zmianaId;
        this.maszynaId = maszynaId;
        this.operatorId = operatorId;
        this.addDate = addDate;
    }

    public Data_Grafik_formularz5(int kontrolaId, String dataPracy, int zmianaId, int maszynaId, int operatorId, String addDate) {
        this.kontrolaId = kontrolaId;
        this.dataPracy = dataPracy;
        this.zmianaId = zmianaId;
        this.maszynaId = maszynaId;
        this.operatorId = operatorId;
        this.addDate = addDate;
    }

    public Data_Grafik_formularz5() {
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

    public String getDataPracy() {
        return dataPracy;
    }

    public void setDataPracy(String dataPracy) {
        this.dataPracy = dataPracy;
    }

    public int getZmianaId() {
        return zmianaId;
    }

    public void setZmianaId(int zmianaId) {
        this.zmianaId = zmianaId;
    }

    public int getMaszynaId() {
        return maszynaId;
    }

    public void setMaszynaId(int maszynaId) {
        this.maszynaId = maszynaId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
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
                    COLUMN_DATAPRACY + " DATE, " +
                    COLUMN_ZMIANAID + " INTEGER, " +
                    COLUMN_MASZYNAID + " INTEGER, " +
                    COLUMN_OPERATORID + " INTEGER, " +
                    COLUMN_ADDDATE + " DATETIME, " +
                    "FOREIGN KEY " + "(" + Data_Zmiana_formularz5.COLUMN_ID + ") " +
                    "REFERENCES " + "ZMIANA" + "(" + Data_Zmiana_formularz5.COLUMN_ID + ")," +
                    "FOREIGN KEY " + "(" + Data_Maszyny_formularz5.COLUMN_ID + ") " +
                    "REFERENCES " + "MASZYNY" + "(" + Data_Maszyny_formularz5.COLUMN_ID  + ")," +
                    "FOREIGN KEY " + "(" + Data_Operator_formularz5.COLUMN_ID + ") " +
                    "REFERENCES " + "OPERATOR" + "(" + Data_Operator_formularz5.COLUMN_ID + ")" +
                    ")";
}
