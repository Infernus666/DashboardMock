package com.experiment.dashboardmock.utils;

/**
 * Created by Infernus on 09/03/16.
 */
public class Dimension {
    private int height;
    private int width;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
