-- Create database manually once before running this script.
-- CREATE DATABASE aniversex_db;
-- USE aniversex_db;

DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS anime;

CREATE TABLE anime (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    episodes INT NOT NULL,
    rating DOUBLE NOT NULL,
    synopsis VARCHAR(1000)
);

CREATE TABLE review (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    comment VARCHAR(1000) NOT NULL,
    score INT NOT NULL,
    anime_id BIGINT,
    CONSTRAINT fk_review_anime
        FOREIGN KEY (anime_id)
        REFERENCES anime(id)
        ON DELETE SET NULL
);
