package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Store {

    @JsonProperty("store_id")
    private int storeId;

    @JsonProperty("store_name")
    private String storeName;

    @JsonProperty("location")
    private String location;

    public Store(int storeId, String storeName, String location) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
    }

    public Store() {}

    // Gettery, settery, toString
}
