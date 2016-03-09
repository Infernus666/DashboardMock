package com.experiment.dashboardmock.controllers;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.experiment.dashboardmock.R;
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
        // TODO: set up the recycler view here to use Elements data
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
