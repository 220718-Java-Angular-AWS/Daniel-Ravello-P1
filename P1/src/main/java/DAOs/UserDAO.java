package DAOs;

import exceptions.AccessDeniedException;
import pojos.User;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserDAO implements CRUD<User> {
    Connection connection;

    public UserDAO() {

        this.connection = ConnectionManager.getConnection();
    }


    @Override
    public void create(User user) {
        String sql = "INSERT INTO employee (first_name , last_name, username, email, password, admin) VALUES (?,?,?,?,?,false)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());

            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(int id) {
        String sql = "SELECT * FROM employee WHERE user_id= ?";
        User user = new User();
        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();


            if (results.next()) {
                user.setUserID(results.getInt("user_id"));
                user.setFirstName(results.getString("first_name"));
                user.setLastName(results.getString("last_name"));
                user.setUsername(results.getString("username"));
                user.setEmail(results.getString("email"));
                user.setPassword(results.getString("password"));
                user.setAdmin(results.getBoolean("admin"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> readAll() {

        List<User> userList = new LinkedList<>();
        String sql = "SELECT * FROM employee";
        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                User user = new User();
                user.setUserID(results.getInt("user_id"));
                user.setFirstName(results.getString("first_name"));
                user.setLastName(results.getString("last_name"));
                user.setUsername(results.getString("username"));
                user.setEmail(results.getString("email"));
                user.setPassword(results.getString("password"));
                user.setAdmin(results.getBoolean("admin"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void update(User user) {

        String sql = "UPDATE employee SET first_name=?, last_name=? username= ?, email= ?, password= ? admin= ?, WHERE user_id= ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setBoolean(6, user.getAdmin());

            pstmt.setInt(7, user.getUserID());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE user_id= ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}