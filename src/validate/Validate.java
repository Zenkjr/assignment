package validate;

import entity.UserEntity;

import java.sql.*;

import static java.lang.System.out;

public class Validate {
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
    public static boolean checkUser(UserEntity userEntity) {
        boolean st = false;
        UserEntity us = new UserEntity();
        try{

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?user=root&password=");
            PreparedStatement ps =connection.prepareStatement
                    ("select * from users where username=? and password=?");
            ps.setString(1, userEntity.getUsername());
            ps.setString(2, userEntity.getPassword());
            ResultSet rs =ps.executeQuery();

            st = rs.next();

            out.println(st);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }
}
