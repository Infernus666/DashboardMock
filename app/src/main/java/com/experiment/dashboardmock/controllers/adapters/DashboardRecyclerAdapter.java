package com.experiment.dashboardmock.controllers.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.controllers.holders.BaseHolder;
import com.experiment.dashboardmock.controllers.holders.FullWidthImageHolder;
import com.experiment.dashboardmock.controllers.holders.HorizontalScrollHolder;
import com.experiment.dashboardmock.controllers.holders.SlideShowHolder;
import com.experiment.dashboardmock.model.Element;

import java.util.ArrayList;

/**
 * Created by Infernus on 08/03/16.
 */
public class DashboardRecyclerAdapter extends RecyclerView.Adapter<BaseHolder> {

    private ArrayList<Element> elements;

    public DashboardRecyclerAdapter(ArrayList<Element> elements) {
        this.elements = elements;
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    @Override
    public int getItemViewType(int position) {
        return elements.get(position).getType();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case Element.TYPE_FULL_WIDTH_IMAGE:
                return new FullWidthImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.full_width_image_holder, parent, false));
            case Element.TYPE_HORIZONTAL_SCROLL:
                return new HorizontalScrollHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_holder, parent, false));
            case Element.TYPE_HORIZONTAL_SLIDER:
                return new SlideShowHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_show_holder, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        // As setupForElement is a abstract method and will be implemented
        // in child views, no need to switch down to specific holders.
        holder.setupForElement(elements.get(position));
    }
}
