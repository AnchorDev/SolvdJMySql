package com.solvd.dao.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.dao.IPhoneDao;
import com.solvd.model.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao implements IPhoneDao {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Phone getEntityById(int index) {
        Phone phone = new Phone();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM phonestore.Phones WHERE phone_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                phone.setPhoneId(resultSet.getInt("phone_id"));
                phone.setName(resultSet.getString("name"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setBrandId(resultSet.getInt("brand_id"));
                phone.setCategoryId(resultSet.getInt("category_id"));
                phone.setSupplierId(resultSet.getInt("supplier_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return phone;
    }

    @Override
    public List<Phone> getEntities() {
        List<Phone> phones = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM phonestore.Phones";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setPhoneId(resultSet.getInt("phone_id"));
                phone.setName(resultSet.getString("name"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setBrandId(resultSet.getInt("brand_id"));
                phone.setCategoryId(resultSet.getInt("category_id"));
                phone.setSupplierId(resultSet.getInt("supplier_id"));
                phones.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return phones;
    }

    @Override
    public void insert(Phone phone) {
        String query = "INSERT INTO phonestore.Phones (name, price, brand_id, category_id, supplier_id) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setDouble(2, phone.getPrice());
            preparedStatement.setInt(3, phone.getBrandId());
            preparedStatement.setInt(4, phone.getCategoryId());
            preparedStatement.setInt(5, phone.getSupplierId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int index) {
        String query = "DELETE FROM phonestore.Phones WHERE phone_id = ?";
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
    public void update(int index, Phone phone) {
        String query = "UPDATE phonestore.Phones SET name = ?, price = ?, brand_id = ?, category_id = ?, supplier_id = ? WHERE phone_id = ?";
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setDouble(2, phone.getPrice());
            preparedStatement.setInt(3, phone.getBrandId());
            preparedStatement.setInt(4, phone.getCategoryId());
            preparedStatement.setInt(5, phone.getSupplierId());
            preparedStatement.setInt(6, index);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
