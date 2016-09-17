DROP TABLE user IF EXISTS;
CREATE TABLE user (
  user_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  pw VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);

DROP TABLE follower IF EXISTS;
CREATE TABLE follower (
  follower_id INT,
  followee_id INT,
  PRIMARY KEY (follower_id,followee_id)
);

DROP TABLE message IF EXISTS;
CREATE TABLE message (
  message_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  author_id INT NOT NULL,
  text VARCHAR(160) NOT NULL,
  pub_date TIMESTAMP,
  PRIMARY KEY (message_id)
);
