DROP DATABASE IF EXISTS IKnow;
CREATE DATABASE IKnow;
USE IKnow;

CREATE TABLE article (
     id INT NOT NULL AUTO_INCREMENT,
	 title VARCHAR(100),
     body VARCHAR(10000),
     PRIMARY KEY (id)
) ENGINE=innodb;

INSERT INTO article VALUES(1,'Definition von dem Begriff: Example', 'Nicht Vorhanden');
INSERT INTO article VALUES(2,'Example eines Staubsaugers', 'Nicht Vorhanden ... alles aufgesaugt!');
INSERT INTO article VALUES(3,'Hunde die nicht Bellen', 'Wuff, Wuff!');
INSERT INTO article VALUES(4,'Die Antwort','42');
INSERT INTO article VALUES(5,'Die große Suche ...', 'Du hast gefunden was du gesucht hast!');

GRANT ALL PRIVILEGES ON iknow.* TO 'god'@'localhost' identified by 'triangle';