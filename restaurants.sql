USE DB_restaurants;

DROP TABLE IF EXISTS restaurants;
 -- remove table if it already exists and start from scratch

CREATE TABLE restaurants (
	restaurantid char(64),
    name CHAR(64),
    menufile CHAR(64),
    numtables int(3)
);

INSERT INTO restaurants VALUES
	("1","Domino","domino.txt", 10),
	("2", "KFC","kfc.txt",20);
 

DROP TABLE IF EXISTS users;
 -- remove table if it already exists and start from scratch

CREATE TABLE users (
	username char(64),
    password CHAR(64),
    type boolean,
    restaurantid char(64)
);

INSERT INTO users VALUES
	("saba","saba",true, "1"),
	("beqa", "beqa",false,"-1"),
    ("levani", "levani", true, "2");


DROP TABLE IF EXISTS visits;
 -- remove table if it already exists and start from scratch

CREATE TABLE visits (
	username char(64),
    restaurantid char(64),
	numvisits int(3),
    rating decimal(6,2)
);

INSERT INTO visits VALUES
	("beqa", "1", 1, 9.5),
    ("beqa", "2", 1, 8);

select * from restaurants;
select * from users;
select * from visits;
