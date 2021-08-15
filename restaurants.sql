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
   
   
   
DROP TABLE IF EXISTS reservations;
 -- remove table if it already exists and start from scratch

CREATE TABLE reservations (
	username char(64),
    restaurantid char(64),
    reserved boolean,
    productname char(64),
    productprice double(6,2),
    numproducts int(3),
    rejected boolean,
    friendname char(64)
);

INSERT INTO reservations VALUES
	("beqa", "1", true, "try", 3.99, 2, false, "-1");
    
    

DROP TABLE IF EXISTS friends;
 -- remove table if it already exists and start from scratch

CREATE TABLE friends (
	username char(64),
    friendname char(64),
    isfriend boolean
);

INSERT INTO friends VALUES
	("beqa", "xxx", true),
    ("xxx", "beqa", true);    
    

DROP TABLE IF EXISTS chat;
 -- remove table if it already exists and start from scratch

CREATE TABLE chat (
	messagefrom char(64),
    messageto char(64),
    message char(99),
    senttime int(100)  
);

INSERT INTO chat VALUES
	("beqa", "beqa2", "asdasd", 1);
    
    

select * from restaurants;
select * from users;
select * from visits;
select * from reservations;
select * from friends;
select * from chat;

