package com.example.android.simplebookfinder.BookModel;

/**
 * Created by bvmarinyak on 17.05.18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class ListPrice_ {

    @SerializedName("amountInMicros")
    @Expose
    private Double amountInMicros;
    @SerializedName("currencyCode")
    @Expose
    private String currencyCode;

    public Double getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(Double amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
