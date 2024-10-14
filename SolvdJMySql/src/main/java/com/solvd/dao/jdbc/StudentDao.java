package com.solvd.dao.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.dao.IStudentDao;
import com.solvd.model.Student;

import java.sql.*;
import java.util.List;

public class StudentDao implements IStudentDao {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Student getEntityById(int index) {
        Student student = new Student();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM mydb.Students where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setFirstName(resultSet.getString("first_name"));
                student.setCarId(resultSet.getInt("Cars_id"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return student;
    }

    @Override
    public List<Student> getEntities() {
        Connection connection = connectionPool.getConnection();
        System.out.println("Thread");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        connectionPool.releaseConnection(connection);
        return null;
    }

    @Override
    public void insert(Student student) {
        String query ="INSERT INTO `mydb`.`Students`(`first_name`,`Cars_id`) VALUES (?,?)";
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setInt(2, student.getCarId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void update(int index, Student student) {

    }
}
