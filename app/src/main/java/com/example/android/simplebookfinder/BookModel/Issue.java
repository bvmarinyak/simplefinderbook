package com.example.android.simplebookfinder.BookModel;

/**
 * Created by bvmarinyak on 17.05.18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Issue {

    @SerializedName("issueOrderNumber")
    @Expose
    private Integer issueOrderNumber;
    @SerializedName("issueDisplayNumber")
    @Expose
    private String issueDisplayNumber;

    public Integer getIssueOrderNumber() {
        return issueOrderNumber;
    }

    public void setIssueOrderNumber(Integer issueOrderNumber) {
        this.issueOrderNumber = issueOrderNumber;
    }

    public String getIssueDisplayNumber() {
        return issueDisplayNumber;
    }

    public void setIssueDisplayNumber(String issueDisplayNumber) {
        this.issueDisplayNumber = issueDisplayNumber;
    }

}
