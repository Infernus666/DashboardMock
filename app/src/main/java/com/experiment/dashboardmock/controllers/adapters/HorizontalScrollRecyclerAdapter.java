package com.experiment.dashboardmock.controllers.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.controllers.holders.HorizontalScrollChildHolder;
import com.experiment.dashboardmock.model.Item;

import java.util.List;

/**
 * Created by Infernus on 09/03/16.
 */
public class HorizontalScrollRecyclerAdapter extends RecyclerView.Adapter<HorizontalScrollChildHolder> {
    private List<Item> items;

    public HorizontalScrollRecyclerAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public HorizontalScrollChildHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorizontalScrollChildHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_child_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(HorizontalScrollChildHolder holder, int position) {
        holder.setupForItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
