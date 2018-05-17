package com.example.android.simplebookfinder.BookModel;

/**
 * Created by bvmarinyak on 17.05.18.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumeSeries {

    @SerializedName("seriesId")
    @Expose
    private String seriesId;
    @SerializedName("seriesBookType")
    @Expose
    private String seriesBookType;
    @SerializedName("orderNumber")
    @Expose
    private Integer orderNumber;
    @SerializedName("issue")
    @Expose
    private List<Issue> issue = null;

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesBookType() {
        return seriesBookType;
    }

    public void setSeriesBookType(String seriesBookType) {
        this.seriesBookType = seriesBookType;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issue) {
        this.issue = issue;
    }

}
