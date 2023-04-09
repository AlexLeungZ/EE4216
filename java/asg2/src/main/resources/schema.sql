-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS todo (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(128) DEFAULT NULL, 
    done BIT NOT NULL DEFAULT FALSE,
    timer INT DEFAULT 0
);
