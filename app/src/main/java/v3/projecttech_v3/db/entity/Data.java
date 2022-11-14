package v3.projecttech_v3.db.entity;

public class Data {

    // Constants for Database
    public static final String TABLE_NAME = "DATABASE_1";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_RAWCOLOR = "Rawcolor";
    public static final String COLUMN_LOCK = "Lock";
    public static final String COLUMN_LP = "LP";
    public static final String COLUMN_MAGAZYN = "Magazyn";
    public static final String COLUMN_LOKALIZACJA = "Lokalizacja";
    public static final String COLUMN_PARTIA = "Partia";
    public static final String COLUMN_WARIANT = "Wariant";
    public static final String COLUMN_WARIANTOPIS = "WariantOpis";
    public static final String COLUMN_PARTIAZLECENIE = "PartiaZlecenie";
    public static final String COLUMN_KONFEKCJA = "Konfekcja";
    public static final String COLUMN_ILWKONF = "ilwkonf";
    public static final String COLUMN_IlSZ = "ilszt";
    public static final String COLUMN_ILOSCKM = "IloscKm";
    public static final String COLUMN_REZ = "Rez";
    public static final String COLUMN_SOURCE = "Source";


    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY";
    public static final String RAWCOLOR_OPTIONS = "TEXT";
    public static final String LOCK_OPTIONS = "TEXT";
    public static final String LP_OPTIONS = "TEXT";
    public static final String MAGAZYN_OPTIONS = "TEXT";
    public static final String LOKALIZACJA_OPTIONS = "TEXT";
    public static final String PARTIA_OPTIONS = "TEXT";
    public static final String WARIANT_OPTIONS = "TEXT";
    public static final String WARIANTOPIS_OPTIONS = "TEXT";
    public static final String PARTIAZLECENIE_OPTIONS = "TEXT";
    public static final String KONFEKCJA_OPTIONS = "TEXT";
    public static final String ILWKONF_OPTIONS = "TEXT";
    public static final String IlSZ_OPTIONS = "TEXT";
    public static final String ILOSCKM_OPTIONS = "TEXT";
    public static final String REZ_OPTIONS = "TEXT";
    public static final String SOURCE_OPTIONS = "TEXT";


    // Variables
    private int id;
    private String rawColor;
    private String lock;
    private String lp;
    private String magazyn;
    private String lokalizacja;
    private String partia;
    private String wariant;
    private String wariantOpis;
    private String partiaZlecenie;
    private String konfekcja;
    private String ilwkonf;
    private String ilszt;
    private String iloscKm;
    private String rez;
    private String source;

    // Constructor


    public Data(int id, String rawColor, String lock, String lp, String magazyn, String lokalizacja,
                String partia, String wariant, String wariantOpis, String partiaZlecenie,
                String  konfekcja, String ilwkonf, String ilszt, String iloscKm, String rez, String source) {
        this.id = id;
        this.rawColor = rawColor;
        this.lock = lock;
        this.lp = lp;
        this.magazyn = magazyn;
        this.lokalizacja = lokalizacja;
        this.partia = partia;
        this.wariant = wariant;
        this.wariantOpis = wariantOpis;
        this.partiaZlecenie = partiaZlecenie;
        this.konfekcja = konfekcja;
        this.ilwkonf = ilwkonf;
        this.ilszt = ilszt;
        this.iloscKm = iloscKm;
        this.rez = rez;
        this.source = source;
    }

    // Getters and Setters
    public Data(){
    }

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

    public String getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(String magazyn) {
        this.magazyn = magazyn;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public String getPartia() {
        return partia;
    }

    public void setPartia(String partia) {
        this.partia = partia;
    }

    public String getWariant() {
        return wariant;
    }

    public void setWariant(String wariant) {
        this.wariant = wariant;
    }

    public String getWariantOpis() {
        return wariantOpis;
    }

    public void setWariantOpis(String wariantOpis) {
        this.wariantOpis = wariantOpis;
    }

    public String getPartiaZlecenie() {
        return partiaZlecenie;
    }

    public void setPartiaZlecenie(String partiaZlecenie) {
        this.partiaZlecenie = partiaZlecenie;
    }

    public String  getKonfekcja() {
        return konfekcja;
    }

    public void setKonfekcja(String  konfekcja) {
        this.konfekcja = konfekcja;
    }

    public String getIlwkonf() {
        return ilwkonf;
    }

    public void setIlwkonf(String ilwkonf) {
        this.ilwkonf = ilwkonf;
    }

    public String getIlszt() {
        return ilszt;
    }

    public void setIlszt(String ilszt) {
        this.ilszt = ilszt;
    }

    public String getIloscKm() {
        return iloscKm;
    }

    public void setIloscKm(String iloscKm) {
        this.iloscKm = iloscKm;
    }

    public String getRez() {
        return rez;
    }

    public void setRez(String rez) {
        this.rez = rez;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    // SQL QUERY: Creating the Table

    public static final String CREATE_TABLE =
//        "CREATE TABLE " + TABLE_NAME + "(" +
//        COLUMN_ID + " " + ID_OPTIONS + ", " +
//        COLUMN_RAWCOLOR + " " + RAWCOLOR_OPTIONS + ", " +
//        COLUMN_LOCK + " " + LOCK_OPTIONS + ", " +
//        COLUMN_LP + " " + LP_OPTIONS + ", " +
//        COLUMN_MAGAZYN + " " + MAGAZYN_OPTIONS + ", " +
//        COLUMN_LOKALIZACJA + " " + LOKALIZACJA_OPTIONS + ", " +
//        COLUMN_PARTIA + " " + PARTIA_OPTIONS + ", " +
//        COLUMN_WARIANT + " " + WARIANT_OPTIONS + ", " +
//        COLUMN_WARIANTOPIS + " " + WARIANTOPIS_OPTIONS + ", " +
//        COLUMN_PARTIAZLECENIE + " " + PARTIAZLECENIE_OPTIONS + ", " +
//        COLUMN_KONFEKCJA + " " + KONFEKCJA_OPTIONS + ", " +
//        COLUMN_ILWKONF + " " + ILWKONF_OPTIONS + ", " +
//        COLUMN_IlSZ + " " + IlSZ_OPTIONS + ", " +
//        COLUMN_ILOSCKM + " " + ILOSCKM_OPTIONS + ", " +
//        COLUMN_REZ + " " + REZ_OPTIONS + ", " +
//        COLUMN_SOURCE + " " + SOURCE_OPTIONS  +
//        ")";

            "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_RAWCOLOR + " TEXT, " +
            COLUMN_LOCK + " TEXT, " +
            COLUMN_LP + " TEXT, " +
            COLUMN_MAGAZYN + " TEXT, " +
            COLUMN_LOKALIZACJA + " TEXT, " +
            COLUMN_PARTIA + " TEXT, " +
            COLUMN_WARIANT + " TEXT, " +
            COLUMN_WARIANTOPIS + " TEXT, " +
            COLUMN_PARTIAZLECENIE + " TEXT, " +
            COLUMN_KONFEKCJA + " TEXT, " +
            COLUMN_ILWKONF + " TEXT, " +
            COLUMN_IlSZ + " TEXT, " +
            COLUMN_ILOSCKM + " TEXT, " +
            COLUMN_REZ + " TEXT, " +
            COLUMN_SOURCE + " TEXT" +
            ")";
    
}
