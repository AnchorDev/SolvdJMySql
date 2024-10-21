package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Order {

    @JsonProperty("order_id")
    private int orderId;

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("staff_id")
    private int staffId;

    @JsonProperty("order_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date orderDate;

    @JsonProperty("total_amount")
    private double totalAmount;

    @JsonProperty("status")
    private String status;

    public Order(int orderId, int customerId, int staffId, Date orderDate, double totalAmount, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order() {}

}
