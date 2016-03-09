package com.experiment.dashboardmock.controllers;

import android.app.Activity;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.controllers.adapters.DashboardRecyclerAdapter;
import com.experiment.dashboardmock.model.Element;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Infernus on 07/03/16.
 */
public class DashboardActivity extends Activity {

    private ClickFlowRecyclerView dashboardRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);

        new LoadDataAsyncTask().execute();
    }

    // Load json data from a json file in assets. Then deserialize
    // it into objects. After data load, setup the RecyclerView.
    private class LoadDataAsyncTask extends AsyncTask<Void, Void, ArrayList<Element>> {

        @Override
        protected ArrayList<Element> doInBackground(Void... params) {
            return loadDataFromAssets();
        }

        @Override
        protected void onPostExecute(ArrayList<Element> elements) {
            super.onPostExecute(elements);
            if(elements != null) {
                setUpRecyclerView(elements);
            }
        }
    }

    private void setUpRecyclerView(final ArrayList<Element> elements) {
        dashboardRecyclerView = (ClickFlowRecyclerView) findViewById(R.id.dashboar_recyclerview);
        dashboardRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        dashboardRecyclerView.setAdapter(new DashboardRecyclerAdapter(elements));

        dashboardRecyclerView.setOnItemClickListener(new ClickFlowRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Item Clicks can be handled here
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        final int verticalSpace = (int) getResources().getDimension(R.dimen.recycler_view_vertical_space);

        dashboardRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
                    outRect.bottom = verticalSpace;
                }
            }
        });
    }

    private ArrayList<Element> loadDataFromAssets() {
        try {
            String json = loadJSONFromAsset();
            Type type = new TypeToken<ArrayList<Element>>(){}.getType();
            return new Gson().fromJson(json, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String loadJSONFromAsset() throws IOException {
        InputStream is = getAssets().open("f_one.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        return new String(buffer, "UTF-8");
    }
}
