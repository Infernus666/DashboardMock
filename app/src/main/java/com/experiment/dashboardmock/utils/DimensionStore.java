package com.experiment.dashboardmock.utils;

/**
 * Created by Infernus on 09/03/16.
 */
public class DimensionStore {
    public static Dimension screenDimension;

    public static void setScreenDimension(Dimension screenDimension) {
        DimensionStore.screenDimension = screenDimension;
    }

    public static Dimension getScreenDimension() {
        return screenDimension;
    }
}
