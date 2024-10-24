package com.solvd.dao;

import com.solvd.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerMapper {

    @Select("SELECT * FROM phonestore.Customers WHERE customer_id = #{id}")
    Customer getCustomerById(int id);

    @Select("SELECT * FROM phonestore.Customers")
    List<Customer> getAllCustomers();

    @Insert("INSERT INTO phonestore.Customers (full_name, email, phone) VALUES (#{fullName}, #{email}, #{phone})")
    void insertCustomer(Customer customer);

    @Update("UPDATE phonestore.Customers SET full_name = #{fullName}, email = #{email}, phone = #{phone} WHERE customer_id = #{customerId}")
    void updateCustomer(Customer customer);

    @Delete("DELETE FROM phonestore.Customers WHERE customer_id = #{id}")
    void deleteCustomer(int id);
}
