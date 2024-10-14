package com.solvd.dao;

import com.solvd.model.Customer;

import java.util.List;

public interface ICustomerDao extends IBaseDao<Customer> {

    @Override
    Customer getEntityById(int index);

    @Override
    List<Customer> getEntities();

    @Override
    void insert(Customer customer);

    @Override
    void delete(int index);

    @Override
    void update(int index, Customer customer);
}
