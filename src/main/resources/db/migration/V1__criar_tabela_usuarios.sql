
CREATE TABLE users (
 id bigint(20) NOT NULL AUTO_INCREMENT,
 name varchar(100) DEFAULT NULL,
 lastName varchar(100) DEFAULT NULL,
 email varchar(50) DEFAULT NULL,
 phone varchar(10) DEFAULT NULL,
 password varchar(20) DEFAULT NULL,
PRIMARY KEY (id)
);
