package com.codeup.adlister.models;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ad {
    private long id;
    private long userId;
    private String username;
    private String title;
    private String description;
    private String image;
    private String date;
    public List<String> categories;


    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Ad(long id, long userId, String title, String description, String image, String date) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.image = image;
        this.description = description;
        this.date = date;
        this.categories = new ArrayList<>();
    }

    public Ad(long userId, String title, String description, String image) {
        this.userId = userId;
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
