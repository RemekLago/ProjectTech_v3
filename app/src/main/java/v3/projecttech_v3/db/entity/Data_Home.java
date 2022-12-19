package v3.projecttech_v3.db.entity;

public class Data_Home {
// for creating User setting, permitions to tiles menu, layout


    public static final String TABLE_NAME = "DATABASE_HOME";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_PARENTID = "ParentId";
    public static final String COLUMN_CHILDID = "ChildId";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_BASE64 = "Base64";
    public static final String COLUMN_NAMEINTHEAPP = "NameInTheApp";




    private int id;
    private String parentId;
    private String childId;
    private String name;
    private String type;
    private String base64;
    private String nameInTheApp;


    public Data_Home() {
    }

    public Data_Home(int id, String parentId, String childId, String name, String type, String base64, String nameInTheApp) {
        this.id = id;
        this.parentId = parentId;
        this.childId = childId;
        this.name = name;
        this.type = type;
        this.base64 = base64;
        this.nameInTheApp = nameInTheApp;
    }

    public Data_Home(String parentId, String childId, String name, String type, String base64, String nameInTheApp) {
        this.parentId = parentId;
        this.childId = childId;
        this.name = name;
        this.type = type;
        this.base64 = base64;
        this.nameInTheApp = nameInTheApp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getNameInTheApp() {
        return nameInTheApp;
    }

    public void setNameInTheApp(String nameInTheApp) {
        this.nameInTheApp = nameInTheApp;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PARENTID + " TEXT, " +
                    COLUMN_CHILDID + " TEXT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_TYPE + " TEXT, " +
                    COLUMN_BASE64 + " TEXT, " +
                    COLUMN_NAMEINTHEAPP + " TEXT" +
                    ")";

}
