/* Moment Catcher Database */
DROP TABLE IF EXISTS photographer;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS skillset;
DROP TABLE IF EXISTS services;
/* Photographer Table */
CREATE TABLE photographer (
	pid VARCHAR(64) NOT NULL PRIMARY KEY,
	fname VARCHAR(64) NOT NULL,
	lname VARCHAR(64) NOT NULL,
	age INT(11) NOT NULL,
	sex VARCHAR(11) NOT NULL,
	address VARCHAR(64) NOT NULL,
);
INSERT INTO photographer (pid, fname, lname, age, sex, address) VALUES ("2018-01-001", "Ghene Anthony", "Cruz", 27, "male", "Quezon City");
INSERT INTO photographer (pid, fname, lname, age, sex, address) VALUES ("2018-01-002", "Mark Angelo", "Montemayor", 24, "male", "Caloocan City");
INSERT INTO photographer (pid, fname, lname, age, sex, address) VALUES ("2018-01-003", "Enchong", "Go", 23, "male", "Laguna");
/* Client Table */
CREATE TABLE clients (
	cid INT(11) NOT NULL PRIMARY KEY,
	fname VARCHAR(64) NOT NULL,
	lname VARCHAR(64) NOT NULL,
	age INT(11) NOT NULL,
	sex VARCHAR(11) NOT NULL,
	address VARCHAR(64) NOT NULL,
	contact INT(11) NOT NULL
);
INSERT INTO clients (cid, fname, lname, age, sex, address, contact) VALUES (1, "Jhon Renan", "Nuevo", 24, "male", "Caloocan City", 09456585651);
INSERT INTO clients (cid, fname, lname, age, sex, address, contact) VALUES (2, "Merry Christian", "Gomez", 29, "female", "Davao" 09216321214);
INSERT INTO clients (cid, fname, lname, age, sex, address, contact) VALUES (3, "Jonathan", "Araneta", 34, "male", "Cavite", 09058655667);
/* Skills Table */
CREATE TABLE skills (
	sid INT(11) NOT NULL,
	skills VARHCAR(64) NOT NULL,
);
INSERT INTO skills (sid, skills) VALUES (1, "Photography");
INSERT INTO skills (sid, skills) VALUES (2, "Videography");
INSERT INTO skills (sid, skills) VALUES (3, "PhotoEditor")
/* SkillSet Table */
CREATE TABLE skillset (
	ssid INT(11) NOT NULL PRIMARY KEY,
	photoinfo VARCHAR(64) NOT NULL,
	skillinfo VARCHAR(64) NOT NULL,
	FOREIGN KEY (photoinfo) REFERENCES photographer(pid),
	FOREIGN KEY (skillinfo) REFERENCES skills(sid)
);
INSERT INTO skillset (ssid, photoinfo, skillinfo) VALUES (1, "2018-01-001", 1);
INSERT INTO skillset (ssid, photoinfo, skillinfo) VALUES (2, "2018-01-002", 2);
INSERT INTO skillset (ssid, photoinfo, skillinfo) VALUES (3, "2018-01-003", 3);
/* Services Table */
CREATE TABLE services (
	srvid INT(11) NOT NULL PRIMARY KEY,
	service VARCHAR(64) NOT NULL,
);
INSERT INTO services (srvid, service) VALUES (1, "Photo Booth");
INSERT INTO services (srvid, service) VALUES (2, "Photo Man");
INSERT INTO services (srvid, service) VALUES (3, "Photo Project");
