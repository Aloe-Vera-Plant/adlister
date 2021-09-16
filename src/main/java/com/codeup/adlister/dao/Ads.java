package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get individual ad based on passed id
    Ad getAd(long id);
    //edit ad
    public void editAdById(long id, String title, String description);
    public void deleteAdById(long id);

    List<Ad> searchAdsByUserID(long userID);

    // to get the category name by category id
    String getCategoryByID(int catid);

    void insertIntoAdsCats(String selected, long id);

    void getCatNamesByAdId(Ad ad);


    List<Ad> search(String searchTerm);

}
