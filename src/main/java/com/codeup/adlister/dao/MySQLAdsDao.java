package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import javax.swing.plaf.nimbus.State;
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
            String insertQuery = "INSERT INTO ads(user_id, title, description, image, postDate) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getImage());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public void insertIntoAdsCats(String selectedCat, long id) {

            try {
                Statement stm = connection.createStatement();
                stm.executeUpdate("INSERT INTO ads_categories(ad_id, category_id) VALUES (" + id + ", " + Integer.valueOf(selectedCat) + " )");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ad category insertion failed!");
            }

    }

    @Override
    public void getCatNamesByAdId(Ad ad) {
        try {
            Statement stm = connection.createStatement();
            List<String> catIds = new ArrayList<>();

            ResultSet rs1 = stm.executeQuery("SELECT * FROM ads_categories WHERE ad_id = " + ad.getId());
            while (rs1.next()) {
                catIds.add(rs1.getString("category_id"));
            }
            for (String catId : catIds) {
                ResultSet rs = stm.executeQuery("SELECT * FROM categories WHERE id = " + catId);
                while (rs.next()) {
                    ad.categories.add(rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

    @Override
    public String getCategoryByID(int catid) {
        String catName = "";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM categories WHERE id = '" + catid + "'");
            catName = rs.getString("name");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return catName;
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        Ad ad = new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("image"),
                rs.getString("postDate")
        );

        DaoFactory.getAdsDao().getCatNamesByAdId(ad);

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


    public void editAdById(long id, String title, String description, String image) {
        PreparedStatement pstm = null;
        String updateQuery = "UPDATE ads SET title = ?, description = ?, image = ? WHERE id = ?";
        try {
            pstm = connection.prepareStatement(updateQuery);
            pstm.setString(1, title);
            pstm.setString(2, description);
            pstm.setString(3, image);
            pstm.setLong(4, id);

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

    public String getUsernameFromID (long idNumber) throws SQLException {
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
