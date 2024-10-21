package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Staff {

    @JsonProperty("staff_id")
    private int staffId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private String position;

    @JsonProperty("store_id")
    private int storeId;

    @JsonProperty("hire_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date hireDate;

    @JsonProperty("salary")
    private double salary;

    public Staff(int staffId, String name, String position, int storeId, Date hireDate, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.position = position;
        this.storeId = storeId;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Staff() {}

}
