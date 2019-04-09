package model;

import entity.FeedbackEntity;
import entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;

public class FeedbackModel {
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

    public boolean insert(FeedbackEntity feedbackEntity) {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?user=root&password=");
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO users(quality, likeProduct ,money, version , id) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, feedbackEntity.getQuality());
            preparedStatement.setString(2, feedbackEntity.getLikeProduct());
            preparedStatement.setString(3, feedbackEntity.getMoney());
            preparedStatement.setString(4, feedbackEntity.getVersion());
            preparedStatement.setInt(5, feedbackEntity.getId());

            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLEcception: " + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<FeedbackEntity> getFeedbackById() {
        ArrayList<FeedbackEntity> arrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT quality,likeProduct,money,version FROM feedback INNER JOIN users USING (id)");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String quality = resultSet.getString(1);
                String likeProduct = resultSet.getString(2);
                String money = resultSet.getString(3);
                String version = resultSet.getString(4);
                int id = resultSet.getInt(1);
                FeedbackEntity fb = new FeedbackEntity(id, quality, likeProduct, money, version);
                arrayList.add(fb);

            }
            return arrayList;

        } catch (SQLException e) {
            System.out.println("SQLException" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
