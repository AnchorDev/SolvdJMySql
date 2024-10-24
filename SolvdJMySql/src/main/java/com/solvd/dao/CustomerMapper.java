package com.solvd.dao;

import com.solvd.model.Customer;
import java.util.List;

public interface CustomerMapper {
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
