package me.kamili.rachid.otherapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.kamili.rachid.otherapp.R;
import me.kamili.rachid.otherapp.model.LegendGroup;

public class LegendGroupAdapter extends RecyclerView.Adapter<LegendGroupAdapter.ViewHolder> {
    private final int ITEM_ON_LEFT = 0;
    private final int ITEM_ON_RIGHT = 1;
    private final List<LegendGroup> legendGroup;

    public LegendGroupAdapter(@NonNull List<LegendGroup> objects) {
        this.legendGroup = objects;
    }

    @NonNull
    @Override
    public LegendGroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        switch (viewType) {
            case ITEM_ON_LEFT:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.legend_group_item_left, parent, false);
                break;
            case ITEM_ON_RIGHT:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.legend_group_item_right, parent, false);
                break;
        }
        return new LegendGroupAdapter.ViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_ON_LEFT : ITEM_ON_RIGHT;
    }

    @Override
    public void onBindViewHolder(@NonNull LegendGroupAdapter.ViewHolder holder, int position) {
        LegendGroup item = legendGroup.get(position);

        Picasso.get().load(item.getLogo()).into(holder.ivGroupLogo);
        Picasso.get().load(item.getImage()).into(holder.ivGoupBackground);
        holder.groupName.setText(item.getName().toUpperCase());
        holder.groupSlogo.setText(item.getSlogan().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return legendGroup.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGoupBackground;
        ImageView ivGroupLogo;
        TextView groupName;
        TextView groupSlogo;

        public ViewHolder(View itemView) {
            super(itemView);
            ivGoupBackground = itemView.findViewById(R.id.ivGoupBackground);
            ivGroupLogo = itemView.findViewById(R.id.ivGroupLogo);
            groupName = itemView.findViewById(R.id.groupName);
            groupSlogo = itemView.findViewById(R.id.groupSlogo);
        }
    }
}
