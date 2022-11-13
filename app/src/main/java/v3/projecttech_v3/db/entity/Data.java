package v3.projecttech_v3.db.entity;

public class Data {

    // Constants for Database
    public static final String TABLE_NAME = "dataFromProcedure";
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
    public static final String COLUMN_ILWKONF = "il.w.konf";
    public static final String COLUMN_IlSZ = "il.szt";
    public static final String COLUMN_ILOSCKM = "IloscKm";
    public static final String COLUMN_REZ = "Rez";
    public static final String COLUMN_SOURCE = "Source";


    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String RAWCOLOR_OPTIONS = "TEXT";
    public static final String LOCK_OPTIONS = "TEXT";
    public static final String LP_OPTIONS = "INTEGER DEFAULT 0";
    public static final String MAGAZYN_OPTIONS = "INTEGER DEFAULT 0";
    public static final String LOKALIZACJA_OPTIONS = "TEXT";
    public static final String PARTIA_OPTIONS = "TEXT";
    public static final String WARIANT_OPTIONS = "TEXT";
    public static final String WARIANTOPIS_OPTIONS = "TEXT";
    public static final String PARTIAZLECENIE_OPTIONS = "TEXT";
    public static final String KONFEKCJA_OPTIONS = "TEXT";
    public static final String ILWKONF_OPTIONS = "FLOAT DEFAULT 0";
    public static final String IlSZ_OPTIONS = "FLOAT DEFAULT 0";
    public static final String ILOSCKM_OPTIONS = "FLOAT DEFAULT 0";
    public static final String REZ_OPTIONS = "FLOAT DEFAULT 0";
    public static final String SOURCE_OPTIONS = "FLOAT DEFAULT 0";


    // Variables
    private int id;
    private String rawColor;
    private String lock;
    private int lp;
    private String magazyn;
    private int lokalizacja;
    private String partia;
    private String wariant;
    private String wariantOpis;
    private String partiaZlecenie;
    private String  konfekcja;
    private float ilwkonf;
    private float ilszt;
    private float iloscKm;
    private float rez;
    private float source;

    // Constructor


    public Data(int id, String rawColor, String lock, int lp, String magazyn, int lokalizacja,
                String partia, String wariant, String wariantOpis, String partiaZlecenie,
                String  konfekcja, float ilwkonf, float ilszt, float iloscKm, float rez, float source) {
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

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public String getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(String magazyn) {
        this.magazyn = magazyn;
    }

    public int getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(int lokalizacja) {
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

    public float getIlwkonf() {
        return ilwkonf;
    }

    public void setIlwkonf(float ilwkonf) {
        this.ilwkonf = ilwkonf;
    }

    public float getIlszt() {
        return ilszt;
    }

    public void setIlszt(float ilszt) {
        this.ilszt = ilszt;
    }

    public float getIloscKm() {
        return iloscKm;
    }

    public void setIloscKm(float iloscKm) {
        this.iloscKm = iloscKm;
    }

    public float getRez() {
        return rez;
    }

    public void setRez(float rez) {
        this.rez = rez;
    }

    public float getSource() {
        return source;
    }

    public void setSource(float source) {
        this.source = source;
    }

    // SQL QUERY: Creating the Table

    public static final String CREATE_TABLE =
        "CREATE TABLE " + TABLE_NAME + "( " +
        COLUMN_ID + " " + ID_OPTIONS + ", " +
        COLUMN_RAWCOLOR + " " + RAWCOLOR_OPTIONS + ", " +
        COLUMN_LOCK + " " + LOCK_OPTIONS + ", " +
        COLUMN_LP + " " + LP_OPTIONS + ", " +
        COLUMN_MAGAZYN + " " + MAGAZYN_OPTIONS + ", " +
        COLUMN_LOKALIZACJA + " " + LOKALIZACJA_OPTIONS + ", " +
        COLUMN_PARTIA + " " + PARTIA_OPTIONS + ", " +
        COLUMN_WARIANT + " " + WARIANT_OPTIONS + ", " +
        COLUMN_WARIANTOPIS + " " + WARIANTOPIS_OPTIONS + ", " +
        COLUMN_PARTIAZLECENIE + " " + PARTIAZLECENIE_OPTIONS + ", " +
        COLUMN_KONFEKCJA + " " + KONFEKCJA_OPTIONS + ", " +
        COLUMN_ILWKONF + " " + ILWKONF_OPTIONS + ", " +
        COLUMN_IlSZ + " " + IlSZ_OPTIONS + ", " +
        COLUMN_ILOSCKM + " " + ILOSCKM_OPTIONS + ", " +
        COLUMN_REZ + " " + REZ_OPTIONS + ", " +
        COLUMN_SOURCE + " " + SOURCE_OPTIONS + ", " +
        ")";
    
}
