/* Moment Catcher Database */
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS photographer;
DROP TABLE IF EXISTS client;
/* Photographer Table */
CREATE TABLE photographer (
	pid VARCHAR(255) NOT NULL PRIMARY KEY,
	fname VARCHAR(255) NOT NULL,
	lname VARCHAR(255) NOT NULL,
	age INT(11) NOT NULL,
	sex VARCHAR(11) NOT NULL, 
	city VARCHAR(255) NOT NULL
);
INSERT INTO photographer (pid, fname, lname, age, sex, city) VALUES ("2018-01-001", "Ghene Anthony", "Cruz", 27, "male", "Quezon City");
INSERT INTO photographer (pid, fname, lname, age, sex, city) VALUES ("2018-01-002", "Mark Angelo", "Montemayor", 24, "male", "Caloocan");
INSERT INTO photographer (pid, fname, lname, age, sex, city) VALUES ("2018-01-003", "Enchong", "Go", 23, "male", "Laguna");
/* Client Table */
CREATE TABLE client (
	cid INT(11) NOT NULL PRIMARY KEY,
	fname VARCHAR(255) NOT NULL,
	lname VARCHAR(255) NOT NULL,
	age INT(11) NOT NULL,
	sex VARCHAR(11) NOT NULL,
	city VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL
);
INSERT INTO client (cid, fname, lname, age, sex, city, email) VALUES ("Jhon Renan", "Nuevo", 24, "male", "Caloocan", "renannuevo@gmail.com");
INSERT INTO client (cid, fname, lname, age, sex, city, email) VALUES ("Merry Christian", "Gomez", 29, "female", "Davao", "mcgomez@yahoo.com");
INSERT INTO client (cid, fname, lname, age, sex, city, email) VALUES ("Jonathan", "Araneta", 34, "male", "Cavite", "jonathanaraneta@gmail.com");
/* users */
CREATE TABLE users (
	uid INT(11) NOT NULL PRIMARY KEY,
	pass VARCHAR(64) NOT NULL,
	role VARCHAR(64) NOT NULL
);
INSERT INTO users (uid, pass, role) VALUES (001, "admin1234", "admin");
INSERT INTO users (uid, pass, role) VALUES (002, "client5678", "client");
