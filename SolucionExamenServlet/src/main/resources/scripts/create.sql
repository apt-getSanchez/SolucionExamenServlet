create table IF NOT EXISTS CONSOLE(
	name varchar(40) PRIMARY KEY,
	companyId int
);
create table IF NOT EXISTS VIDEOGAME(
	name varchar(40) PRIMARY KEY,
	age varchar(40),
	releaseDate date ,
	companyId int
);
create table IF NOT EXISTS COMPANY(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name varchar(40) ,
	creationDate date
);