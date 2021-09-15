package com.codeup.adlister.dao;


import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        connection = Connect.makeConnection(config);
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE user_name = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public User findUserById(long userId) {
        String query = "SELECT * FROM users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(userId));
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(user_name, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            String hashedPw = Password.hash(user.getPassword());
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, hashedPw);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(

            rs.getLong("id"),
            rs.getString("user_name"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

    @Override
    public void updateUserInfo(String usernameUp, String email, String currentUsername) {
        try {
            PreparedStatement pstm = connection.prepareStatement("UPDATE users SET user_name = ?, email = ? WHERE user_name = ?");
            pstm.setString(1, usernameUp);
            pstm.setString(2, email);
            pstm.setString(3, currentUsername);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserPass(String newPassword, String username) {
        User userToUpdate = DaoFactory.getUsersDao().findByUsername(username);

        try {

            PreparedStatement pstm = connection.prepareStatement("UPDATE users SET password = ? WHERE user_name = ?");
            pstm.setString(1, newPassword);
            pstm.setString(2, username);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUserByIDNumber(long idNumber) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idNumber);

            ResultSet resultSet = statement.executeQuery();

            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error @ findUserByIDNumber", e);
        }
    }
}


