CREATE DATABASE web_shop;
USE web_shop;

# MAIN TABLES
CREATE TABLE wallets (
  id     BIGINT AUTO_INCREMENT,
  amount BIGINT,
  PRIMARY KEY (id)
);
CREATE TABLE payments (
  id        BIGINT AUTO_INCREMENT,
  id_wallet BIGINT   NOT NULL,
  time      DATETIME NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_wallet) REFERENCES wallets (id)
);
CREATE TABLE credit_cards (
  id            BIGINT AUTO_INCREMENT,
  id_payment    BIGINT      NOT NULL UNIQUE,
  serial_number VARCHAR(50) NOT NULL UNIQUE,
  cvv           VARCHAR(10) NOT NULL,
  expire_date   DATE        NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_payment) REFERENCES payments (id)
);
CREATE TABLE images (
  id   BIGINT AUTO_INCREMENT,
  link VARCHAR(200) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE types (
  id   BIGINT AUTO_INCREMENT,
  name VARCHAR(30),
  PRIMARY KEY (id)
);
CREATE TABLE products (
  id       BIGINT AUTO_INCREMENT,
  id_type  BIGINT,
  id_image BIGINT,
  name     VARCHAR(30) NOT NULL,
  cost     DECIMAL     NOT NULL,
  producer VARCHAR(20),
  provider VARCHAR(20),
  size     INT         NOT NULL,
  amount   INT,
  PRIMARY KEY (id),
  FOREIGN KEY (id_image) REFERENCES images (id),
  FOREIGN KEY (id_type) REFERENCES types (id)
);
CREATE TABLE discounts (
  id         BIGINT AUTO_INCREMENT,
  id_product BIGINT,
  discount   DECIMAL NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_product) REFERENCES products (id)
);
CREATE TABLE materials (
  id   BIGINT AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE users (
  id           BIGINT AUTO_INCREMENT,
  id_wallet    BIGINT      NOT NULL UNIQUE,
  email        VARCHAR(50) NOT NULL UNIQUE,
  login        VARCHAR(30) NOT NULL UNIQUE,
  password     VARCHAR(30) NOT NULL,
  first_name   VARCHAR(50),
  last_name    VARCHAR(50),
  phone_number VARCHAR(30),
  country      VARCHAR(30),
  city         VARCHAR(30),
  address      VARCHAR(30),
  PRIMARY KEY (id)
);
CREATE TABLE orders (
  id             BIGINT AUTO_INCREMENT,
  id_product     BIGINT   NOT NULL,
  id_consumer    BIGINT   NOT NULL,
  datetime_order DATETIME NOT NULL,
  paid           BIT      NOT NULL,
  delivered      BIT      NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_product) REFERENCES products (id),
  FOREIGN KEY (id_consumer) REFERENCES users (id)
);
CREATE TABLE shops (
  id           BIGINT AUTO_INCREMENT,
  country      VARCHAR(30),
  city         VARCHAR(30),
  address      VARCHAR(30),
  phone_number VARCHAR(30),
  PRIMARY KEY (id)
);

# CONNECTORS
CREATE TABLE product_material (
  id_product  BIGINT NOT NULL,
  id_material BIGINT NOT NULL,
  PRIMARY KEY (id_product, id_material),
  FOREIGN KEY (id_product) REFERENCES products (id),
  FOREIGN KEY (id_material) REFERENCES materials (id)
);
CREATE TABLE product_type (
  id_product BIGINT NOT NULL,
  id_type    BIGINT NOT NULL,
  PRIMARY KEY (id_product, id_type),
  FOREIGN KEY (id_product) REFERENCES products (id),
  FOREIGN KEY (id_type) REFERENCES types (id)
);

# DROP DATABASE web_shop;

INSERT INTO wallets (id, amount) VALUES ('1', '20');

INSERT INTO payments (id, id_wallet, time) VALUES ('1', '1', '2000-11-10 10:20:10');

INSERT INTO credit_cards (id, id_payment, serial_number, cvv, expire_date)
VALUES ('1', '1', '200', '200', '2000-11-10');

INSERT INTO images (id, link) VALUES ('1', 'someLink');

INSERT INTO types (id, name) VALUES ('1', 'someName');

INSERT INTO products (id, id_type, id_image, name, cost, producer, provider, size, amount)
VALUES ('1', '1', '1', 'someName', '10', 'someProducer', 'someProvider', '40', '8');

INSERT INTO discounts (id, id_product, discount) VALUES ('1', '1', '20');

INSERT INTO materials (id, name) VALUES ('1', 'someName');

INSERT INTO users (id, id_wallet, email, login, password, first_name, last_name, phone_number, country, city, address)
VALUES ('1', '1', 'someEmail', 'someLogin', 'somePassword', 'firstName', 'lastName', '103', 'someCountry', 'someCity',
             'someAddress');

INSERT INTO orders (id, id_product, id_consumer, datetime_order, paid, delivered)
VALUES ('1', '1', '1', '2000-11-10 10:20:10', 0, 0);

INSERT INTO product_material (id_product, id_material) VALUES ('1', '1');

INSERT INTO product_type (id_product, id_type) VALUES ('1', '1');

INSERT INTO shops (country, city, address, phone_number) VALUES ('someCountry', 'someCity', 'someAddress', '103');