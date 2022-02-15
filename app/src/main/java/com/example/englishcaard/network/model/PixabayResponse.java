package com.example.englishcaard.network.model;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PixabayResponse {
    @SerializedName("total")
    private Integer total;
    @SerializedName("totalHits")
    private Intent totalHits;
    @SerializedName("hits")
    private List<Hits> hits = null;

    public Integer getTotal() {
        return total;
    }

    public Intent getTotalHits() {
        return totalHits;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTotalHits(Intent totalHits) {
        this.totalHits = totalHits;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }

    public List<Hits> getHits() {
        return hits;
    }


}
