package com.solvd.dao;

import com.solvd.BasicConnectionPool;
import com.solvd.dao.ICustomerDao;
import com.solvd.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Customer getEntityById(int index) {
        Customer customer = new Customer();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM phonestore.Customers WHERE customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFullName(resultSet.getString("full_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return customer;
    }

    @Override
    public List<Customer> getEntities() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM phonestore.Customers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFullName(resultSet.getString("full_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return customers;
    }

    @Override
    public void insert(Customer customer) {
        String query = "INSERT INTO phonestore.Customers (full_name, email, phone) VALUES (?, ?, ?)";
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM phonestore.Customers WHERE customer_id = ?";
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int index, Customer customer) {
        String query = "UPDATE phonestore.Customers SET full_name = ?, email = ?, phone = ? WHERE customer_id = ?";
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setInt(4, index);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
