
package com.experiment.dashboardmock.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Element {
    public static final int TYPE_FULL_WIDTH_IMAGE = 1001;
    public static final int TYPE_HORIZONTAL_SCROLL = 1002;
    public static final int TYPE_HORIZONTAL_SLIDER = 1003;

    private String label;

    @SerializedName("image_url")
    private String imageUrl;
    private String template;
    private List<Item> items = new ArrayList<Item>();

    private int stateInfo = 0;

    public int getType() {
        switch (template) {
            case "product-template-1":
                return TYPE_FULL_WIDTH_IMAGE;
            case "product-template-2":
                return TYPE_HORIZONTAL_SCROLL;
            case "product-template-3":
                return TYPE_HORIZONTAL_SLIDER;
            default:return 0;
        }
    }

    /**
     * 
     * @return
     *     The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The image
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * 
     * @param template
     *     The template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * 
     * @return
     *     The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setStateInfo(int stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getStateInfo() {
        return stateInfo;
    }
}
