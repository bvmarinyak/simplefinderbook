package com.example.android.simplebookfinder.BookModel;

/**
 * Created by bvmarinyak on 17.05.18.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeriesInfo {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("shortSeriesBookTitle")
    @Expose
    private String shortSeriesBookTitle;
    @SerializedName("bookDisplayNumber")
    @Expose
    private String bookDisplayNumber;
    @SerializedName("volumeSeries")
    @Expose
    private List<VolumeSeries> volumeSeries = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getShortSeriesBookTitle() {
        return shortSeriesBookTitle;
    }

    public void setShortSeriesBookTitle(String shortSeriesBookTitle) {
        this.shortSeriesBookTitle = shortSeriesBookTitle;
    }

    public String getBookDisplayNumber() {
        return bookDisplayNumber;
    }

    public void setBookDisplayNumber(String bookDisplayNumber) {
        this.bookDisplayNumber = bookDisplayNumber;
    }

    public List<VolumeSeries> getVolumeSeries() {
        return volumeSeries;
    }

    public void setVolumeSeries(List<VolumeSeries> volumeSeries) {
        this.volumeSeries = volumeSeries;
    }

}
