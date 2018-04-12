package me.kamili.rachid.legendscontentprovider.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.kamili.rachid.legendscontentprovider.model.LegendGroupContract;

public class LegendGroupDataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "legendgroup.db";
    public static final int DATABASE_VERSION = 1;

    public LegendGroupDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            LegendGroupContract.onCreate(sqLiteDatabase);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
