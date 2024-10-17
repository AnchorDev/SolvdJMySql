package com.solvd.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customers")
public class Customers {

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    @XmlElement(name = "customer")
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers +
                '}';
    }
}
