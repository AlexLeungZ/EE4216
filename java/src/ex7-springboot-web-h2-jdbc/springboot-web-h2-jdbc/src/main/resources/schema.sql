-- 
--  Author:  vanting
--  Created: 4 Mar 2023
-- 
--  Spring Boot will automatically pick up this file and run it against an embedded 
--  in-memory database, such as our configured H2 instance. 

CREATE TABLE courses (
    id INT NOT NULL PRIMARY KEY, 
    name VARCHAR(32) DEFAULT NULL, 
    teacher_id INT NOT NULL
);

CREATE TABLE grades (
    student_id INT NOT NULL, 
    course_id INT NOT NULL, 
    grade varchar(2) DEFAULT NULL
);

CREATE TABLE students (
    id INT NOT NULL PRIMARY KEY, 
    name VARCHAR(32) DEFAULT NULL, 
    email VARCHAR(32) DEFAULT NULL,
    password VARCHAR(16) DEFAULT NULL
);

CREATE TABLE teachers (
    id INT NOT NULL PRIMARY KEY, 
    name VARCHAR(32) DEFAULT NULL
);

