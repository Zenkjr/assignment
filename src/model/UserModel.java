package model;

import entity.UserEntity;

import java.sql.*;

public class UserModel {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?user=root&password=");
        } catch (SQLException ex) {
            System.out.println("SQLEcception: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public boolean insert(UserEntity user) {

        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?user=root&password=");
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO users(username, password) VALUES (?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLEcception: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserEntity getUserByNameAndPassword(UserEntity userEntity) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? and password = ?");
            preparedStatement.setString(1, userEntity.getUsername());
            preparedStatement.setString(2, userEntity.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String exitUsername = resultSet.getString(1);
                String exitPassword = resultSet.getString(2);
                int userId = resultSet.getInt(1);
                UserEntity user = new UserEntity(userId,exitUsername, exitPassword);
                return user;
            }

        } catch (SQLException e) {
            System.out.println("SQLException" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
