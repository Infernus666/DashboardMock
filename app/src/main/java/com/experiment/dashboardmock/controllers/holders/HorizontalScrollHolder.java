package com.experiment.dashboardmock.controllers.holders;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.controllers.ClickFlowRecyclerView;
import com.experiment.dashboardmock.controllers.adapters.HorizontalScrollRecyclerAdapter;
import com.experiment.dashboardmock.model.Element;

/**
 * Created by Infernus on 09/03/16.
 */
public class HorizontalScrollHolder extends BaseHolder {

    private TextView headerLabel;
    private ClickFlowRecyclerView recyclerView;
    private int scrollX = 0;

    public HorizontalScrollHolder(View view) {
        super(view);
        headerLabel = (TextView) view.findViewById(R.id.horizontal_scroll_header);
        recyclerView = (ClickFlowRecyclerView) view.findViewById(R.id.horizontal_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void setupForElement(final Element element) {
        headerLabel.setText(element.getLabel());

        recyclerView.setAdapter(new HorizontalScrollRecyclerAdapter(element.getItems()));

        // Custom item click listener provided by ClickFlowRecyclerView.
        recyclerView.setOnItemClickListener(new ClickFlowRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(element.getItems().get(position).getWebUrl()));
                view.getContext().startActivity(browserIntent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        // Restoring scroll position using stateInfo
        scrollX = element.getStateInfo();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            linearLayoutManager.scrollToPositionWithOffset(0, scrollX);
        }

        // Recording scrollX as stateInfo whenever any scrolling happens
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollX += dx;
                element.setStateInfo(scrollX);
            }
        });
    }
}
