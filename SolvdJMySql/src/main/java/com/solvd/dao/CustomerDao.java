package com.solvd.dao;

import com.solvd.dao.CustomerMapper;
import com.solvd.model.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerDao implements ICustomerDao {

    private final SqlSessionFactory sqlSessionFactory;


    public CustomerDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Customer getEntityById(int index) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getCustomerById(index);
        }
    }

    @Override
    public List<Customer> getEntities() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            return mapper.getAllCustomers();
        }
    }

    @Override
    public void insert(Customer customer) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            mapper.insertCustomer(customer);
            session.commit();
        }
    }

    @Override
    public void delete(int index) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            mapper.deleteCustomer(index);
            session.commit();
        }
    }

    @Override
    public void update(int index, Customer customer) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CustomerMapper mapper = session.getMapper(CustomerMapper.class);
            customer.setCustomerId(index);
            mapper.updateCustomer(customer);
            session.commit();
        }
    }
}
