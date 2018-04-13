package me.kamili.rachid.legendscontentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.Arrays;

import me.kamili.rachid.legendscontentprovider.helper.LegendGroupDataBaseHelper;
import me.kamili.rachid.legendscontentprovider.model.LegendGroupContract;

public class LegendsContentProvider extends ContentProvider {

    public static final String TAG = LegendsContentProvider.class.getSimpleName();

    public static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    //add the URIs which is going to used by this provider.
    static {
        matcher.addURI(LegendGroupContract.AUTHORITY, LegendGroupContract.LEGENDGROUP_TABLE_NAME, LegendGroupContract.LegendGroup);
        matcher.addURI(LegendGroupContract.AUTHORITY, LegendGroupContract.LEGENDGROUP_TABLE_NAME + "/#", LegendGroupContract.LegendGroup_ID);
    }

    String[] tableColumns = {LegendGroupContract.COLUMN_ID, LegendGroupContract.COLUMN_NAME, LegendGroupContract.COLUMN_SLOGAN, LegendGroupContract.COLUMN_DESCRIPTION, LegendGroupContract.COLUMN_LOGO, LegendGroupContract.COLUMN_IMAGE};
    /*
     * Defines a handle to the database helper object. The MainDatabaseHelper class is defined
     * in a following snippet.
     */
    private LegendGroupDataBaseHelper legendGroupDataBaseHelper;
    // Holds the database object
    private SQLiteDatabase db;

    public LegendsContentProvider() {
    }

    @Override
    public boolean onCreate() {
        legendGroupDataBaseHelper = new LegendGroupDataBaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int matchedUriType = matcher.match(uri);

        if (projection != null && !Arrays.asList(tableColumns).containsAll(Arrays.asList(projection))) {
            throw new IllegalArgumentException("No Column found in Projection.");
        }

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(LegendGroupContract.LEGENDGROUP_TABLE_NAME);
        switch (matchedUriType) {
            case LegendGroupContract.LegendGroup:
                break;
            case LegendGroupContract.LegendGroup_ID:
                queryBuilder.appendWhere(LegendGroupContract.COLUMN_ID + "=" + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        db = legendGroupDataBaseHelper.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        db = legendGroupDataBaseHelper.getWritableDatabase();
        int matchedUriType = matcher.match(uri);
        long newId = 0;

        switch (matchedUriType) {
            case LegendGroupContract.LegendGroup:
                newId = db.insert(LegendGroupContract.LEGENDGROUP_TABLE_NAME, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        // We cn use this as wellUri.parse(LegendGroupContract.LegendGroup_URI.toString() + "/" + newId);

        return ContentUris.withAppendedId(uri, newId);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        int rowDeleted = 0;

        db = legendGroupDataBaseHelper.getWritableDatabase();

        int matchedUriType = matcher.match(uri);

        switch (matchedUriType) {

            case LegendGroupContract.LegendGroup:

                rowDeleted = db.delete(LegendGroupContract.LEGENDGROUP_TABLE_NAME, selection, selectionArgs);
                break;

            case LegendGroupContract.LegendGroup_ID:

                String idTobeDeleted = uri.getLastPathSegment();

                if (selection != null && !selection.isEmpty()) {
                    rowDeleted = db.delete(
                            LegendGroupContract.LEGENDGROUP_TABLE_NAME,
                            LegendGroupContract.COLUMN_ID + "=" + idTobeDeleted + " AND " + selection, selectionArgs);
                } else {
                    rowDeleted = db.delete(
                            LegendGroupContract.LEGENDGROUP_TABLE_NAME, LegendGroupContract.COLUMN_ID + "=" + idTobeDeleted, null);
                }

                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return rowDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs) {
        int rowUpdated = 0;

        db = legendGroupDataBaseHelper.getWritableDatabase();

        int matchedUriType = matcher.match(uri);

        switch (matchedUriType) {
            case LegendGroupContract.LegendGroup:
                rowUpdated = db.update(LegendGroupContract.LEGENDGROUP_TABLE_NAME, contentValues, selection, selectionArgs);
                break;

            case LegendGroupContract.LegendGroup_ID:

                String idTobeUpdated = uri.getLastPathSegment();

                if (selection != null && !selection.isEmpty()) {
                    rowUpdated = db.update(
                            LegendGroupContract.LEGENDGROUP_TABLE_NAME,
                            contentValues,
                            LegendGroupContract.COLUMN_ID + "=" + idTobeUpdated + " and " + selection,
                            selectionArgs);
                } else {
                    rowUpdated = db.update(
                            LegendGroupContract.LEGENDGROUP_TABLE_NAME,
                            contentValues,
                            LegendGroupContract.COLUMN_ID + "=" + idTobeUpdated,
                            null);
                }
                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return rowUpdated;

    }
}
