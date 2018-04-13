package me.kamili.rachid.otherapp;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.kamili.rachid.otherapp.adapter.LegendGroupAdapter;
import me.kamili.rachid.otherapp.manager.LegendGroupManager;
import me.kamili.rachid.otherapp.model.LegendGroup;

public class MainActivity extends AppCompatActivity implements LegendGroupManager.ILegendGroupManager{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<LegendGroup> mListGroup = new ArrayList<>();

    private LegendGroupManager legendGroupManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        legendGroupManager = new LegendGroupManager(this);
        legendGroupManager.getLegendGroups();
    }

    private void bindViews() {
        mRecyclerView = findViewById(R.id.rvLegendGroup);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new LegendGroupAdapter(mListGroup);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onLegendsReceived(List<LegendGroup> legendGroups) {
        mListGroup.clear();
        mListGroup.addAll(legendGroups);
        mAdapter.notifyDataSetChanged();
    }
}
