create database web_shop;
use web_shop;

# MAIN TABLES
create table products (
	id BIGINT AUTO_INCREMENT,
	id_type BIGINT,
	id_image BIGINT,
	name VARCHAR(30) NOT NULL,
  cost DECIMAL NOT NULL,
	producer VARCHAR(20),
	provider VARCHAR(20),
	size INT NOT NULL,
	amount INT,
	PRIMARY KEY(id),
	FOREIGN KEY(id_image) REFERENCES images(id),
  FOREIGN KEY(id_type) REFERENCES types(id));
create table shops (
	id BIGINT AUTO_INCREMENT,
	country VARCHAR(30),
	city VARCHAR(30),
	address VARCHAR(30),
	phone_number VARCHAR(30),
	PRIMARY KEY(id));
create table types (
	id BIGINT AUTO_INCREMENT,
	name VARCHAR(30),
	PRIMARY KEY(id));
create table materials (
	id BIGINT AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	PRIMARY KEY(id));
create table images (
	id BIGINT AUTO_INCREMENT,
	link VARCHAR(200) NOT NULL,
	PRIMARY KEY(id));
create table discounts (
	id BIGINT AUTO_INCREMENT,
	id_product BIGINT,
	discount DECIMAL NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(id_product) REFERENCES products(id));
create table orders (
	id BIGINT AUTO_INCREMENT,
	id_product BIGINT NOT NULL,
	id_consumer BIGINT NOT NULL,
	datetime_order DATETIME NOT NULL,
  paid BIT NOT NULL,
  delivered BIT NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(id_product) REFERENCES products(id),
	FOREIGN KEY(id_consumer) REFERENCES users(id));
create table users (
	id BIGINT AUTO_INCREMENT,
	id_wallet BIGINT NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE,
	login VARCHAR(30) NOT NULL UNIQUE,
	password VARCHAR(30) NOT NULL,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	phone_number VARCHAR(30),
	country VARCHAR(30),
	city VARCHAR(30),
	address VARCHAR(30),
	PRIMARY KEY (id));
CREATE TABLE wallets (
	id BIGINT AUTO_INCREMENT,
	amount BIGINT,
	PRIMARY KEY (id)
);
CREATE TABLE payments (
	id BIGINT AUTO_INCREMENT,
	id_wallet BIGINT NOT NULL,
	time DATETIME NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id_wallet) REFERENCES wallets(id)
);
CREATE TABLE credit_cards (
	id BIGINT AUTO_INCREMENT,
	id_payment BIGINT NOT NULL UNIQUE,
	serial_number VARCHAR(50) NOT NULL UNIQUE,
	cvv VARCHAR(10) NOT NULL,
	expire_date DATE NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id_user) REFERENCES users(id),
	FOREIGN KEY (id_payment) REFERENCES payments(id)
);

# CONNECTORS
create table product_material (
  id_product BIGINT NOT NULL,
  id_material BIGINT NOT NULL,
  PRIMARY KEY(id_product, id_material),
  FOREIGN KEY(id_product) REFERENCES products(id),
  FOREIGN KEY(id_material) REFERENCES materials(id));
create table product_type (
  id_product BIGINT NOT NULL,
  id_type BIGINT NOT NULL,
  PRIMARY KEY(id_product, id_type),
  FOREIGN KEY(id_product) REFERENCES products(id),
  FOREIGN KEY(id_type) REFERENCES types(id));

#DROP DATABASE web_shop;