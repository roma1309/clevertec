CREATE TABLE products
(
    id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(30),
    count INTEGER,
    price DOUBLE precision,
    isStock BOOLEAN
);


INSERT INTO products VALUES (1, 'milk', 10, 3, true);
INSERT INTO products VALUES (2, 'sweet', 5, 2.12, true);
INSERT INTO products VALUES (3, 'chips', 7, 4.75, false);

CREATE TABLE discount_card
(
    id SERIAL PRIMARY KEY,
    numberCard bigint UNIQUE,
    stock DOUBLE precision
);


INSERT INTO discount_card VALUES (1,  101, 30);
INSERT INTO discount_card VALUES (2, 52, 2);
INSERT INTO discount_card VALUES (3, 71, 0.3);