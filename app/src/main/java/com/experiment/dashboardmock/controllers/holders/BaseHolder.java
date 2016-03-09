package com.experiment.dashboardmock.controllers.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.experiment.dashboardmock.model.Element;

/**
 * Created by Infernus on 09/03/16.
 */
public abstract class BaseHolder extends RecyclerView.ViewHolder {
    public BaseHolder(View itemView) {
        super(itemView);
    }

    /**
     * Set view state based on Element. Child holders will use
     * Elements in specific manners
     *
     * @param element
     */
    public abstract void setupForElement(Element element);
}
