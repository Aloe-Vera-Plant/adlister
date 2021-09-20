drop database adlisterdb;

CREATE DATABASE IF NOT EXISTS adlisterdb;
USE adlisterdb;
CREATE TABLE IF NOT EXISTS users
(
    id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    email     VARCHAR(100) NOT NULL,
    password  VARCHAR(100) NOT NULL,
    pfp varchar(250) default 'https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg',
    PRIMARY KEY (id),
    UNIQUE (user_name)
);
CREATE TABLE IF NOT EXISTS ads
(
    id          int UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     int UNSIGNED NOT NULL,
    title       VARCHAR(50)  NOT NULL,
    image         varchar(255),
    description text NOT NULL,
    postDate datetime not null DEFAULT CURRENT_TIMESTAMP,
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
    ad_id       INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);


INSERT INTO categories set name = 'Goods';
INSERT INTO categories set name = 'Services';
INSERT INTO categories set name = 'Jobs';
INSERT INTO categories set name = 'Personals';
