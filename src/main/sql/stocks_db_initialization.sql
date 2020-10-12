/** create the stocks database */

DROP TABLE IF EXISTS stocks.quotes CASCADE;
DROP TABLE IF EXISTS stocks.person CASCADE;
DROP TABLE IF EXISTS stocks.person_quote CASCADE;

CREATE TABLE stocks.quotes(
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

CREATE TABLE stocks.person(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(256) NOT NUll,
    last_name VARCHAR(256) NOT NULL,
    birth_date DATETIME NOT NULL
);

CREATE TABLE stocks.person_quote(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    person_id INT NOT NULL,
    quote_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES stocks.person (ID),
    FOREIGN KEY (quote_id) REFERENCES stocks.quotes (ID)
);

INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:00:01','363.21');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:01:01','363.21');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:02:01','250.21');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:03:01','251.21');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:04:01','253.21');

INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Drew', 'Hope', '1999/10/10');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lang', 'Heckman', '1959/11/11');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lucy', 'Jones', '2010/1/1');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Stew', 'Hammer', '1990/3/28');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Dan', 'Lane', '1986/4/18');

INSERT INTO stocks.person_quote (ID, person_id, quote_id) VALUES (1, 1, 2);
INSERT INTO stocks.person_quote (ID, person_id, quote_id) VALUES (2, 1, 1);
INSERT INTO stocks.person_quote (ID, person_id, quote_id) VALUES (3, 2, 1);
INSERT INTO stocks.person_quote (ID, person_id, quote_id) VALUES (4, 3, 1);
INSERT INTO stocks.person_quote (ID, person_id, quote_id) VALUES (5, 3, 3);
INSERT INTO stocks.person_quote (ID, person_id, quote_id) VALUES (6, 3, 4);
INSERT INTO stocks.person_quote (ID, person_id, quote_id) VALUES (7, 4, 7);
