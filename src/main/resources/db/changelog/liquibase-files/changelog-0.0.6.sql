CREATE TABLE user_auth_entity (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  name VARCHAR(255) NOT NULL ,
                                  email VARCHAR(255) NOT NULL ,
                                  password VARCHAR(255) NOT NULL ,
                                  age INT NOT NULL ,
                                  type VARCHAR(255) NOT NULL
);