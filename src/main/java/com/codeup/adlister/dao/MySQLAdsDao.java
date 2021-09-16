package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        connection = Connect.makeConnection(config);
    }


    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads ORDER BY id desc");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, postDate) VALUES (?, ?, ?, NOW())";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    // commit
    public List<Ad> search(String searchTerm) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement( "select * from ads where title LIKE ?");
            stmt.setString(1,"%" + searchTerm + "%");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Ad getAd(long id) {
        PreparedStatement stmt = null;
        String selectQuery = "SELECT * FROM ads where id = ?";
        try {
            stmt = connection.prepareStatement(selectQuery);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            // throw new RuntimeException("Error retrieving ad.", e);
            return null;
        }
    }

    public List<Ad> searchAdsByUserID(long userID) {


        try {
            String sql = "SELECT * FROM ads WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, userID);

            ResultSet resultSet = statement.executeQuery();
            return createAdsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error @ searchAdsByUserID", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        Ad ad = new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("postDate")
        );

    ad.setUsername(getUsernameFromID(ad.getUserId()));

        return ad;
}

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }


    public void editAdById(long id, String title, String description) {
        PreparedStatement pstm = null;
        String updateQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try {
            pstm = connection.prepareStatement(updateQuery);
            pstm.setString(1, title);
            pstm.setString(2, description);
            pstm.setLong(3, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdById(long id) {
        PreparedStatement pstm = null;
        String updateQuery = "DELETE FROM ads WHERE id = ?";
        try {
            pstm = connection.prepareStatement(updateQuery);
            pstm.setLong(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUsernameFromID (long idNumber) {
        String sql = "SELECT user_name " +
                "FROM users " +
                "JOIN ads ON users.id = ads.user_id " +
                "WHERE user_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idNumber);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getString("user_name");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error @ getUsernameFromID.", e);
        }


    }
}
