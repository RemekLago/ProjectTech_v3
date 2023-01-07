package v3.projecttech_v3.db.entity;

import net.sourceforge.jtds.jdbc.DateTime;

public class Data_Kontrola_formularz5 {

    // Constants for Database
    public static final String TABLE_NAME = "KONTROLA";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_MASZYNAID = "MaszynaId";
    public static final String COLUMN_OPERATORID = "OperatorId";
    public static final String COLUMN_PRZEWINIENIEID = "PrzewinienieId";
    public static final String COLUMN_SMS = "SMS";
    public static final String COLUMN_SMSNUMER = "SMSNumer";
    public static final String COLUMN_SMSTRESC = "SMSTresc";
    public static final String COLUMN_UWAGA = "Uwaga";
    public static final String COLUMN_ADDUSERID = "AddUserId";
    public static final String COLUMN_ADDDATE = "AddDate";

    //Variables
    private int id;
    private int maszynaId;
    private int operatorId;
    private int przewinienieId;
    private String sms;
    private int smsNumer;
    private String smsTresc;
    private String  uwaga;
    private int addUserId;
    private String addDate;


    // Constructor

    public Data_Kontrola_formularz5(int id, int maszynaId, int operatorId, int przewinienieId, String sms, int smsNumer, String smsTresc, String uwaga, int addUserId, String addDate) {
        this.id = id;
        this.maszynaId = maszynaId;
        this.operatorId = operatorId;
        this.przewinienieId = przewinienieId;
        this.sms = sms;
        this.smsNumer = smsNumer;
        this.smsTresc = smsTresc;
        this.uwaga = uwaga;
        this.addUserId = addUserId;
        this.addDate = addDate;
    }

    public Data_Kontrola_formularz5(int maszynaId, int operatorId, int przewinienieId, String sms, int smsNumer, String smsTresc, String uwaga, int addUserId, String addDate) {
        this.maszynaId = maszynaId;
        this.operatorId = operatorId;
        this.przewinienieId = przewinienieId;
        this.sms = sms;
        this.smsNumer = smsNumer;
        this.smsTresc = smsTresc;
        this.uwaga = uwaga;
        this.addUserId = addUserId;
        this.addDate = addDate;
    }

    public Data_Kontrola_formularz5() {
    }

    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPrzewinienieId() {
        return przewinienieId;
    }

    public void setPrzewinienieId(int przewinienieId) {
        this.przewinienieId = przewinienieId;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public int getSmsNumer() {
        return smsNumer;
    }

    public void setSmsNumer(int smsNumer) {
        this.smsNumer = smsNumer;
    }

    public String getSmsTresc() {
        return smsTresc;
    }

    public void setSmsTresc(String smsTresc) {
        this.smsTresc = smsTresc;
    }

    public String getUwaga() {
        return uwaga;
    }

    public void setUwaga(String uwaga) {
        this.uwaga = uwaga;
    }

    public int getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(int addUserId) {
        this.addUserId = addUserId;
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
                    COLUMN_MASZYNAID + " INTEGER FOREIGN KEY REFERENCES " + "MASZYNY" + "(" + Data_Maszyny_formularz5.COLUMN_ID + "), " +
                    COLUMN_OPERATORID + " INTEGER FOREIGN KEY REFERENCES " + "OPERATOR" + "(" + Data_Operator_formularz5.COLUMN_ID + "), " +
                    COLUMN_PRZEWINIENIEID + " INTEGER FOREIGN KEY REFERENCES " + "PRZEWINIENIE" + "(" + Data_Przewinienia_formularz5.COLUMN_ID+ "), " +
                    COLUMN_SMS + " BIT, " +
                    COLUMN_SMSNUMER + " INTEGER, " +
                    COLUMN_SMSTRESC + " VARCHAR, " +
                    COLUMN_UWAGA + " VARCHAR, " +
                    COLUMN_ADDUSERID + " INTEGER, " +
                    COLUMN_ADDDATE + " DATETIME" +
                    ")";

}
