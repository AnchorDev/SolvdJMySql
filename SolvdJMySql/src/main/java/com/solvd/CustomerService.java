package com.solvd;

import com.solvd.dao.CustomerDao;
import com.solvd.model.Customer;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(SqlSessionFactory sqlSessionFactory) {
        this.customerDao = new CustomerDao(sqlSessionFactory);
    }

    public Customer getCustomerById(int id) {
        return customerDao.getEntityById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getEntities();
    }

    public void addCustomer(Customer customer) {
        customerDao.insert(customer);
    }

    public void updateCustomer(int id, Customer customer) {
        customerDao.update(id, customer);
    }

    public void deleteCustomer(int id) {
        customerDao.delete(id);
    }
}
