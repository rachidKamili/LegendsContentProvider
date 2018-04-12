package me.kamili.rachid.legendscontentprovider.model;

import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class LegendGroupContract {

    public static final int LegendGroup = 10;
    public static final int LegendGroup_ID = 20;

    public static final String LEGENDGROUP_TABLE_NAME = "legendgroup";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME    = "name";
    public static final String COLUMN_SLOGAN     = "slogan";
    public static final String COLUMN_DESCRIPTION   = "description";
    public static final String COLUMN_LOGO   = "logo";
    public static final String COLUMN_IMAGE = "image";

    public static String AUTHORITY = "me.kamili.rachid.legendscontentprovider";
    public static Uri LEGENDGROUP_URI = Uri.parse("content://" + AUTHORITY + "/" + LEGENDGROUP_TABLE_NAME);
    public static String LEGENDGROUP_TABLE_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + AUTHORITY + "/" + LEGENDGROUP_TABLE_NAME;
    public static String LEGENDGROUP_TABLE_ITEM_CONTENT_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + AUTHORITY + "/" + LEGENDGROUP_TABLE_NAME;

    public static final String CREATE_TABLE = "CREATE TABLE "
            + LEGENDGROUP_TABLE_NAME
            + " (" + COLUMN_ID
            + " INTEGER primary key autoincrement, "
            + COLUMN_NAME + " TEXT not null, "
            + COLUMN_SLOGAN + " INTEGER, "
            + COLUMN_DESCRIPTION + " TEXT, "
            + COLUMN_LOGO + " TEXT, "
            + COLUMN_IMAGE + " TEXT)";

    public static void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
