-- INSERT INTO todo (name, done) VALUES
-- ('The 1st Item', 1),
-- ('The 2nd Item', 1),
-- ('The 3rd Item', 1),
-- ('The 4th Item', 0),
-- ('The 5th Item', 0);

-- Insert test data only if table is empty
CREATE TEMPORARY TABLE temp_todo (
    name VARCHAR(128) NOT NULL, 
    done BIT NOT NULL
);

INSERT INTO temp_todo (name, done) VALUES
('The 1st Item', 1),
('The 2nd Item', 1),
('The 3rd Item', 1),
('The 4th Item', 0),
('The 5th Item', 0);

INSERT INTO todo (name, done)
SELECT t.name, t.done
FROM temp_todo t
LEFT JOIN todo ON 1=1
WHERE todo.id IS NULL;

DROP TABLE IF EXISTS temp_todo;