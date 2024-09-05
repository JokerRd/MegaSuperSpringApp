CREATE TABLE persons
(
    id   INT PRIMARY KEY,
    name TEXT NOT NULL,
    age  INT  NOT NULL
);

INSERT INTO persons
VALUES (1, 'Иван', 50),
       (2, 'Оксана', 40),
       (3, 'Петр', 30),
       (4, 'Мария', 12);