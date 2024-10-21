package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phone {
    @JsonProperty("phone_id")
    private int phoneId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private double price;

    @JsonProperty("brand_id")
    private int brandId;

    @JsonProperty("category_id")
    private int categoryId;

    @JsonProperty("supplier_id")
    private int supplierId;

    public Phone() {}

    public Phone(int phoneId, String name, double price, int brandId, int categoryId, int supplierId) {
        this.phoneId = phoneId;
        this.name = name;
        this.price = price;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }


    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
