package v3.projecttech_v3;

public class DBMagazynPozycjaLokalizacjaAdapter {
    private static final String DEBUG_TAG = "SqLiteTodoManager";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME_FILE = "database_MagazynPozycjaLokalizacja.db"; //DB_NAME
    private static final String DB_NAME_TABLE = "db_MagazynPozycjaLokalizacja"; //DB_TODO_TABLE


    public static final String KEY_ID = "id";
    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final int ID_COLUMN = 0;

    public static final String KEY_DESCRIPTION = "description";
    public static final String DESCRIPTION_OPTIONS = "TEXT NOT NULL";
    public static final int DESCRIPTION_COLUMN = 1;

    public static final String KEY_COMPLETED = "completed";
    public static final String COMPLETED_OPTIONS = "INTEGER DEFAULT 0";
    public static final int COMPLETED_COLUMN = 2;



    private static final String DB_CREATE_TABLE_DB_MAGAZYNPOZYCJALAKALIZACJA =
            "CREATE TABLE " + DB_NAME_TABLE + "( " +
                    KEY_ID + " " + ID_OPTIONS + ", " +
                    KEY_DESCRIPTION + " " + DESCRIPTION_OPTIONS + ", " +
                    KEY_COMPLETED + " " + COMPLETED_OPTIONS +
                    ");";
    private static final String DROP_NAME_TABLE =
            "DROP TABLE IF EXISTS " + DB_NAME_TABLE;
}
