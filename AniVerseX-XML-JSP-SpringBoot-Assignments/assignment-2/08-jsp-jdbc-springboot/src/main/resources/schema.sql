SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS anime;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE anime (
    anime_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    episodes INT NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
    short_review VARCHAR(500) NOT NULL,
    CHECK (episodes > 0),
    CHECK (rating >= 0 AND rating <= 10)
);
