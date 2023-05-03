-- 
--  Author:  vanting
--  Created: 4 Mar 2023
-- 
--  Spring Boot will automatically pick up this file and run it against an embedded 
--  in-memory database, such as our configured H2 instance. 

INSERT INTO courses VALUES
(10001, 'Computer Science 142', 1234),
(10002, 'Computer Science 143', 5678),
(10003, 'Computer Science 190M', 9012),
(10004, 'Informatics 100', 1234);

INSERT INTO grades VALUES
(123, 10001, 'B-'),
(123, 10002, 'C'),
(456, 10001, 'B+'),
(888, 10002, 'A+'),
(888, 10003, 'A+'),
(404, 10004, 'D+'),
(404, 10002, 'B'),
(456, 10002, 'D-');

INSERT INTO students VALUES
(123, 'Bart', 'bart@fox.com', 'bartman'),
(404, 'Ralph', 'ralph@fox.com', 'catfood'),
(456, 'Milhouse', 'milhouse@fox.com', 'fallout'),
(888, 'Lisa', 'lisa@fox.com', 'vegan');

INSERT INTO teachers VALUES
(1234, 'Krabappel'),
(5678, 'Hoover'),
(9012, 'Stepp');

-- debug output to just show the contents of all tables
/*SHOW TABLES;
SELECT * FROM courses;
SELECT * FROM grades;
SELECT * FROM students;
SELECT * FROM teachers;*/
