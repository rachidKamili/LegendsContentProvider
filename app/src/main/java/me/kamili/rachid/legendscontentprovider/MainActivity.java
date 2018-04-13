package me.kamili.rachid.legendscontentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import me.kamili.rachid.legendscontentprovider.data.LegendGroupFactory;
import me.kamili.rachid.legendscontentprovider.model.LegendGroup;
import me.kamili.rachid.legendscontentprovider.model.LegendGroupContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveDataToDb(View view) {

        for (LegendGroup legendGroup : LegendGroupFactory.createLegendGroups()) {
            ContentValues values = new ContentValues();
            values.put(LegendGroupContract.COLUMN_NAME, legendGroup.getName());
            values.put(LegendGroupContract.COLUMN_SLOGAN, legendGroup.getSlogan());
            values.put(LegendGroupContract.COLUMN_DESCRIPTION, legendGroup.getDescription());
            values.put(LegendGroupContract.COLUMN_LOGO, legendGroup.getLogo());
            values.put(LegendGroupContract.COLUMN_IMAGE, legendGroup.getImage());

            Uri newUri = getContentResolver().insert(LegendGroupContract.LEGENDGROUP_URI, values);
        }

    }

    public void count(View view) {
        Cursor cursor = getContentResolver().query(LegendGroupContract.LEGENDGROUP_URI, null, null, null, null);
        Toast.makeText(this, "count in Content Provider : " + cursor.getCount(), Toast.LENGTH_SHORT).show();
    }
}
