

CREATE DATABASE IF NOT EXISTS adlisterdb;
USE adlisterdb;
CREATE TABLE IF NOT EXISTS ads
(
    id          int UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     int UNSIGNED NOT NULL,
    title       VARCHAR(50)  NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS categories
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ads_categories
(
    ad_id   INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    email     VARCHAR(100) NOT NULL,
    password  VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (user_name)
);