package me.kamili.rachid.otherapp.manager;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import me.kamili.rachid.otherapp.model.LegendGroup;
import me.kamili.rachid.otherapp.model.LegendGroupContract;

public class LegendGroupManager {

    Context mContext;
    ILegendGroupManager mListener;

    public LegendGroupManager(Context mContext) {
        this.mContext = mContext;
        this.mListener = (ILegendGroupManager) mContext;
    }

    public void getLegendGroups() {
        List<LegendGroup> legendGroups = new ArrayList<>();
        Cursor cursor = null;

        cursor = mContext.getContentResolver().query(
                LegendGroupContract.LEGENDGROUP_URI, null, null, null, null
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                legendGroups.add(new LegendGroup(
                        cursor.getString(cursor.getColumnIndex(LegendGroupContract.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(LegendGroupContract.COLUMN_SLOGAN)),
                        cursor.getString(cursor.getColumnIndex(LegendGroupContract.COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(LegendGroupContract.COLUMN_LOGO)),
                        cursor.getString(cursor.getColumnIndex(LegendGroupContract.COLUMN_IMAGE))
                ));
            }
        }
        mListener.onLegendsReceived(legendGroups);
    }

    public interface ILegendGroupManager{
        void onLegendsReceived(List<LegendGroup> legendGroups);
    }
}
