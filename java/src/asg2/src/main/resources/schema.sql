CREATE TABLE todo (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(128) DEFAULT NULL, 
    done BIT NOT NULL DEFAULT FALSE
);
