package me.kamili.rachid.otherapp.model;

import android.net.Uri;

public class LegendGroupContract {
    public static final String LEGENDGROUP_TABLE_NAME = "legendgroup";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SLOGAN = "slogan";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_LOGO = "logo";
    public static final String COLUMN_IMAGE = "image";

    public static String AUTHORITY = "me.kamili.rachid.legendscontentprovider";
    public static Uri LEGENDGROUP_URI = Uri.parse("content://" + AUTHORITY + "/" + LEGENDGROUP_TABLE_NAME);
}
